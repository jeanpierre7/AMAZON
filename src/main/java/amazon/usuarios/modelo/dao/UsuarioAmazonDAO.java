package amazon.usuarios.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amazon.usuarios.modelo.UsuarioAmazon;

@Repository
public interface UsuarioAmazonDAO extends JpaRepository<UsuarioAmazon, String>{
	
}
