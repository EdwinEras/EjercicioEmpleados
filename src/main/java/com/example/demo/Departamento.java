package com.example.demo;
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class Departamento {

	private String nombre;
	private String ubicacion;
	private String telefono;
	private Empleado director;
/**
 * Constructor 	
 */
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param nombre del departamento
 * @param ubicacion del departamento
 * @param telefono del departamento
 */
	public Departamento(String nombre, String ubicacion, String telefono) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.telefono = telefono;		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * 
	 * @param nombre del director
	 * @param apellido del director 
	 * @param direccion del director
	 * @param dni del director
	 * @param mail del director
	 */
	public void setDirector (String nombre, String apellido, String direccion, String dni, String mail) {
		this.director = new Empleado(nombre, apellido, direccion, dni, mail);
	}
	
	public Empleado getDirector() {
		return this.director;
		
	}
	
	
	
	
	
	
	
}
