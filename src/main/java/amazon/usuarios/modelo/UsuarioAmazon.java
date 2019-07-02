package amazon.usuarios.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario_amazon")
public class UsuarioAmazon implements Serializable{
	
	/***************ATRIBUTOS********************/
	@Id
	private String nombre_usuario;
	@Column(name="password")
	private String password;
	@OneToMany(mappedBy="nombre_usuario", cascade=CascadeType.ALL)
	private List<DireccionEnvio> listaDirecciones;
	
	
	
	
	public UsuarioAmazon() {
		
	}
	public UsuarioAmazon(String nombre_usuario, String password, List<DireccionEnvio> listaDirecciones) {
		
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.listaDirecciones = listaDirecciones;
	}
	/***************GETTERS Y SETTERS********************/
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<DireccionEnvio> getListaDirecciones() {
		return listaDirecciones;
	}
	public void setListaDirecciones(List<DireccionEnvio> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}
	@Override
	public String toString() {
		return "UsuarioAmazon [nombre_usuario=" + nombre_usuario + ", password=" + password + ", listaDirecciones="
				+ listaDirecciones + "]";
	}
}
