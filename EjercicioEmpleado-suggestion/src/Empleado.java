/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Empleado {
	
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String mail;
    private Departamento dept;

    public Empleado() {
        // TODO Auto-generated constructor stub
    }

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

    public void setDepartamento(Departamento dept) {
            this.dept = dept;
    }

    public Departamento getDepartamento() {

            return this.dept;
    }	

    @Override
    public String toString() {
            return this.nombre + " " + this.apellido;
    }

}
