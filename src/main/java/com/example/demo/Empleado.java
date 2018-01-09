package com.example.demo;
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class Empleado {
	
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	private String mail;
	private Departamento dept;
	
		public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param nombre del empleado
 * @param apellido del empleado
 * @param direccion del empleado
 * @param dni del empleado
 * @param mail del empleado
 */
		public Empleado(String nombre, String apellido, String direccion, String dni, String mail) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.direccion = direccion;
			this.dni = dni;
			this.mail = mail;
			this.dept = new Departamento();
			
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}
		/**
		 * 
		 * @param nombre del departamento
		 * @param ubicacion del departamento
		 * @param telefono del departamento
		 */
		public void setDepartamento(Departamento dept) {
			this.dept = dept;
		}
		
		public Departamento getDepartamento() {
			
			return this.dept;
		}
		
		public boolean esDirector() {
			System.out.println(dept.getDirector().getDni());
			if (dept.getDirector().getDni().equals(this.dni)) {
				return true;
			}
			else {
				return false;
			}
		}
	
		
	

}
