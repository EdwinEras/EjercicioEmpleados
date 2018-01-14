package com.cice.modelo;

import java.util.ArrayList;

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
	private ArrayList<Empleado> listaEmpleados;
	
/**
 * Constructor 	
 */
	public Departamento() {
		this.listaEmpleados = new ArrayList <>();
		// TODO Auto-generated constructor stub
	}

/**
 * 
 * @param nombre del departamento
 * @param ubicacion del departamento
 * @param telefono del departamento
 * 
 */
	public Departamento(String nombre, String ubicacion, String telefono) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.director = new Empleado();
		this.listaEmpleados = new ArrayList<>();
		
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
	
	public void setDirector (Empleado emp) {
		
		this.director= emp;
		
	}
	
	public Empleado getDirector() {
		
		return this.director;
		
	}
	
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "El Departamento es " + this.nombre + " " + this.ubicacion + " " + this.telefono;
	}
	
	
	
	
	
	
	
}
