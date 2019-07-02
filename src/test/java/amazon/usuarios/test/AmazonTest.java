package amazon.usuarios.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import amazon.usuarios.modelo.DireccionEnvio;
import amazon.usuarios.modelo.UsuarioAmazon;
import amazon.usuarios.modelo.dao.UsuarioAmazonDAO;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AmazonTest {
	
	@Autowired
	TestEntityManager manager;
	@Autowired
	UsuarioAmazonDAO dao;
	
	
	@Before
	public void setUp() throws Exception {
		ArrayList<DireccionEnvio> lista = new ArrayList<DireccionEnvio>();
		lista.add(new DireccionEnvio("pepito", "san jose 2526", "Chile"));
		lista.add(new DireccionEnvio("pepito", "el rosal 25, cartagena", "Chile"));
		lista.add(new DireccionEnvio("pepito", "Av. chillan8954, temuco", "Chile"));
		UsuarioAmazon user = new UsuarioAmazon("pepito", "misterjose123", lista);
		this.manager.persist(user);
		ArrayList<DireccionEnvio> lista2 = new ArrayList<DireccionEnvio>();
		lista2.add(new DireccionEnvio("kalule", "san jose 2526", "Chile"));
		lista2.add(new DireccionEnvio("kalule", "el rosal 25, cartagena", "Chile"));
		lista2.add(new DireccionEnvio("kalule", "Av. chillan8954, temuco", "Chile"));
		UsuarioAmazon user2 = new UsuarioAmazon("kalule", "melendez28", lista2);
		this.manager.persist(user2);
		ArrayList<DireccionEnvio> lista3 = new ArrayList<DireccionEnvio>();
		lista3.add(new DireccionEnvio("paulina", "san jose 2526", "Chile"));
		lista3.add(new DireccionEnvio("paulina", "el rosal 25, cartagena", "Chile"));
		lista3.add(new DireccionEnvio("paulina", "Av. chillan8954, temuco", "Chile"));
		UsuarioAmazon user3 = new UsuarioAmazon("paulina", "polinpolin", lista3);
		this.manager.persist(user3);
	}
	
	@Test
	public void test() {
		System.out.println(this.dao.findById("pepito").get());
		assertTrue(true);
	}
	@Test
	public void cantidadDeRegistrosDebeSerIgualA3() {
		int cuantos = this.dao.findAll().size();
		assertTrue("SON " + cuantos + " PERO DEBERÍAN SER 3", cuantos == 3);
	}

	
	@Test
	public void buscarPepitoSeaUnRegistroConTodosLosDatosYRegitros() {
		UsuarioAmazon pepito = this.dao.findById("pepito").get();
		assertTrue("ES " + pepito.toString(), pepito != null && pepito.getNombre_usuario().equals("pepito") && pepito.getPassword().equals("misterjose123") && pepito.getListaDirecciones().size() == 3);
		
	}
	
	@Test
	public void alEliminarAPepitoSObtengaNULLyAlObtnerTodosLosRegistrosSeObtenga2() {
		int cuantos = this.dao.findAll().size();
		System.out.println("**************************************************************");
		System.out.println("HAY " + cuantos);
		System.out.println("**************************************************************");
		this.dao.deleteById("pepito");
		UsuarioAmazon pepito = this.dao.findById("pepito").orElse(null);
		int despues = this.dao.findAll().size();
		assertTrue("SON " + despues + " PERO DEBERIA SER 2", pepito == null && despues == 2);
		
	}
	
	@Test
	public void alImsertarUnNuevoRegistroYAlObtenerLosRegistrosResulte4() {
		ArrayList<DireccionEnvio> listaProvisoria = new ArrayList<DireccionEnvio>();
		listaProvisoria.add(new DireccionEnvio("Jean", "san jose 2526", "Chile"));
		listaProvisoria.add(new DireccionEnvio("Jean", "el rosal 25, cartagena", "Chile"));
		listaProvisoria.add(new DireccionEnvio("Jean", "Av. chillan8954, temuco", "Chile"));
		this.dao.save(new UsuarioAmazon("Jean", "Miguel Claro", listaProvisoria));
		int largo = this.dao.findAll().size();
		assertTrue("SON " + largo + " PERO DEBERÍAN SER 4", largo == 4);
		
	}

	@Test
	public void modificarAPepitoAJosesitoNoSeaNullySeObtieneElRegistro() {
		ArrayList<DireccionEnvio> lista = new ArrayList<DireccionEnvio>();
		lista.add(new DireccionEnvio("pepito", "san jose 2526", "Chile"));
		lista.add(new DireccionEnvio("pepito", "el rosal 25, cartagena", "Chile"));
		lista.add(new DireccionEnvio("pepito", "Av. chillan8954, temuco", "Chile"));
		this.dao.save(new UsuarioAmazon("pepito", "josesito123", lista));
		UsuarioAmazon pepito = this.dao.findById("pepito").get();
		assertNotNull(pepito);
		assertTrue("ES " + pepito.getPassword() + " PERO DEBERÍA SER josesito123", pepito.getPassword().equals("josesito123"));
		
	}

}
