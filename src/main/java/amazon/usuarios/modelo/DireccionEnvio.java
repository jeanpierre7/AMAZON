package amazon.usuarios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="direccion_envio")
public class DireccionEnvio {
	/***************ATRIBUTOS********************/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="nombre_usuario")
	private String nombre_usuario;
	@Column(name="direccion")
	private String direccion;
	@Column(name="pais")
	private String pais;
	
	
	
	
	public DireccionEnvio() {
		
	}
	public DireccionEnvio(String nombre_usuario, String direccion, String pais) {
		
		this.nombre_usuario = nombre_usuario;
		this.direccion = direccion;
		this.pais = pais;
	}
	/***************GETTERS Y SETTERS********************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "DireccionEnvio [id=" + id + ", nombre_usuario=" + nombre_usuario + ", direccion=" + direccion
				+ ", pais=" + pais + "]";
	}
}
