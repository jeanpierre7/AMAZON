package amazon.usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import amazon.usuarios.modelo.UsuarioAmazon;
import amazon.usuarios.modelo.dao.UsuarioAmazonDAO;

@RestController
public class RESTControladorAmazon {
	
	@Autowired
	UsuarioAmazonDAO dao;
	
	@GetMapping("/amazon/user/{nombre}")
	public UsuarioAmazon getUser(@PathVariable String nombre) {
		return this.dao.findById(nombre).get();
	}
	
	@GetMapping("/amazon/users")
	public List<UsuarioAmazon> getUsers() {
		return this.dao.findAll();
	}
	
	@DeleteMapping("/amazon/user/delete/{nombre}")
	public boolean deleteUsers(@PathVariable String nombre) {
		if(this.dao.existsById(nombre)) {
			this.dao.deleteById(nombre);
		}
		return !this.dao.existsById(nombre);
	}
	
	@PutMapping("/amazon/user/modify")
	public boolean modifyUser(@RequestBody UsuarioAmazon user) {
		if(this.dao.existsById(user.getNombre_usuario())){
			this.dao.save(user);
			return true;
		}
		return false;
	}
	
	@PostMapping("/amazon/user/add")
	public boolean addUser(@RequestBody UsuarioAmazon nuevo) {
		if(!this.dao.existsById(nuevo.getNombre_usuario())) {
			this.dao.save(nuevo);
			return true;
		}
		return false;
	}
}
