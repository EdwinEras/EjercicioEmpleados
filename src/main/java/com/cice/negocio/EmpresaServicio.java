package com.cice.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cice.modelo.Departamento;
import com.cice.modelo.Empleado;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */

public class EmpresaServicio {
	
	private ArrayList <Empleado> listaEmpleados= new ArrayList <>();
	private ArrayList <Departamento> listaDepartamentos= new ArrayList <>();
	
	public void showMenu() {
		Scanner sc = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("Bienvenido a tu gestion de empresa");
			System.out.println("Esto es lo que puedo hacer por ti:");
			System.out.println("1. Crear Empleado");
			System.out.println("2. Crear Departamento");
			System.out.println("3. Asignar Director a Departamento");
			System.out.println("4. Asignar Empleado a Departamento");
			System.out.println("5. Mostrar todos los Empleados");
			System.out.println("6. Mostrar todos los Departamentos");
			System.out.println("0. salir");
			opcion = sc.nextInt();
			
			controles (opcion);
		
			
			
		}while (opcion!=0);
		sc.close();
	}
	
	private void controles (int opcion) {
		switch (opcion){
			case 0:
				break;
			case 1:
				//Crear Empleado
				crearEmpleado();
				break;
			case 2:
				//Crear Departamento
				crearDepartamento();
				break;
			case 3:
				//Asignar Director a Departamento
				asignarDirector();
				break;
			case 4:
				asignarEmpleado();
				break;
				//Asignar Empleado a Departamento
			case 5:
				//Mostrar todos los Empleados
				mostrarEmpleado();
				break;
			case 6:
				//Mostrar todos los Departamentos
				mostrarDepartamentos();
				break;
			default:
				System.out.println("la opcion seleccionada no es valida");
				
				
		}
	}
	
	/**
	 * Metodo crearEmpleado
	 */
	private void crearEmpleado() {
		Scanner sc = new Scanner (System.in);		
		Empleado empleado = new Empleado();
		
		System.out.println("Introduce un nombre");
		empleado.setNombre(sc.next());
		System.out.println("Introduce un apellido");
		empleado.setApellido(sc.next());
		System.out.println("Introduce un DNI");
		empleado.setDni(sc.next());		
		sc.nextLine();		
		while(comprobarEmpleado(empleado.getDni())) {
			System.out.println("Ya existe un empleado con ese DNI");
			System.out.println("Introduce un DNI");
			empleado.setDni(sc.next());		
			sc.nextLine();					
		}	
		System.out.println("Introduce un direccion");
		empleado.setDireccion(sc.nextLine());
		System.out.println("Introduce un e-mail");
		empleado.setMail(sc.next());		
		listaEmpleados.add(empleado);
		System.out.println(empleado.toString());
	}
	/**
	 * Metodo mostrarEmpleado
	 */
	private void mostrarEmpleado() {
		System.out.println("-------------");
		listaEmpleados.forEach((k)->System.out.println(k.toString()));
		System.out.println("-------------");
	}
	/**
	 * Metodo mostrarDepartamentos
	 */
	private void mostrarDepartamentos() {
		System.out.println("-------------");
		listaDepartamentos.forEach((k)->System.out.println(k.toString()));
		System.out.println("-------------");
	}
	/**
	 * Metodo crearDepartamento
	 */
	private void crearDepartamento() {
		Scanner sc = new Scanner (System.in);
		String respuesta = "";
		Departamento departamento; 
		
		do {
			departamento = new Departamento ();
			System.out.println("Introduce un nombre");
			departamento.setNombre(sc.next());
			sc.nextLine();
			System.out.println("Introduce una ubicacion");			
			departamento.setUbicacion(sc.nextLine());
			System.out.println("Introduce una telefono");
			departamento.setTelefono(sc.next());
			System.out.println("-------------");
			System.out.println("¿Quieres crear otro Departamento (s/n)");
			System.out.println("-------------");
			listaDepartamentos.add(departamento);
			respuesta = sc.next();			
		}while(respuesta.equals("s"));
	}
	/**
	 * Metodo asignarEmpleado
	 */
	private void asignarEmpleado() {
		int i = 0;
		Scanner sc = new Scanner (System.in);
		boolean bandera =false;
		
		int opcion1 = 0;
		int opcion2 =  0;
		
		if (listaEmpleados.size()>0) {
			System.out.println("----------------------");
			System.out.println("Seleccione un empleado");
		
			for (Empleado empleado : listaEmpleados) {
				System.out.println(i +1+") " +empleado.toString());
				i++;				
			}
			System.out.println("----------------------");
			opcion1 = sc.nextInt();
		}
		i= 0;
		if (listaDepartamentos.size()>0) {
			System.out.println("----------------------");
			System.out.println("Seleccione un Departamento en el que agregar al Empleado");
		
			for (Departamento departamento : listaDepartamentos) {
				System.out.println(i +1+") " +departamento.toString());
				i++;				
			}
			System.out.println("----------------------");
			opcion2 = sc.nextInt();
										
			}
			
			if (comprobarEmpleadoDepartamento(listaEmpleados.get(opcion1-1), listaDepartamentos.get(opcion2-1))) {			
				listaEmpleados.get(opcion1-1).setDepartamento(listaDepartamentos.get(opcion2-1));			
				listaDepartamentos.get(opcion2-1).getListaEmpleados().add(listaEmpleados.get(opcion1-1));
			}
			else {
				System.out.println("El Empleado esta en mas de un Departamento");
			}
			
			
		}
		
	
	/**
	 * Metodo asignarDirector
	 */
	private void asignarDirector() {
		
		int i = 0;
		Scanner sc = new Scanner (System.in);
		boolean bandera = false;
		
		int opcion1 = 0;
		int opcion2 = 0;
		
		if (listaEmpleados.size()>0) {
			System.out.println("----------------------");
			System.out.println("Seleccione un empleado");
		
			for (Empleado empleado : listaEmpleados) {
				System.out.println(i +1+") " +empleado.toString());
				i++;				
			}
			System.out.println("----------------------");
			opcion1 = sc.nextInt();
		}
		i = 0;
		if (listaDepartamentos.size()>0) {
			System.out.println("----------------------");
			System.out.println("Seleccione un Departamento en el que agregar al Empleado");
		
			for (Departamento departamento : listaDepartamentos) {
				System.out.println(i +1+") " +departamento.toString());
				i++;				
			}
			System.out.println("----------------------");
			opcion2 = sc.nextInt();
			
		
			if  (comprobarDirectorDepartamento(listaEmpleados.get(opcion1-1), listaDepartamentos.get(opcion2-1))) {
				System.out.println("Es Empleado seleccionado es Director de mas de un departamento");				
			}
			else {
				//Agregamos el Empleado como Director al Departamento
				listaDepartamentos.get(opcion2-1).setDirector(listaEmpleados.get(opcion1-1));
			}
			
			
		}
		
		
		
	}
	
	/**
	 * 
	 * @param emp Empleado a comprobar
	 * @param dept Departamento al que pertenece
	 * @return true o false
	 */
	
	
	private boolean comprobarEmpleadoDepartamento(Empleado emp, Departamento dept) {
		boolean bandera = false;
		
		for (Departamento departamento : listaDepartamentos) {
			if(departamento.getListaEmpleados().size()>0) {
			for(Empleado empleado : departamento.getListaEmpleados()) {
				String aux = empleado.getDni();
				if(aux.equals(emp.getDni()) && !dept.getNombre().equals(dept.getNombre()))
					bandera = true;//Existe Empleado en otro Departamento
			}
			}
		}
		return bandera;
		
	}
	
	/**
	 * 
	 * @param emp Empleado a comprobar
	 * @param dept Departamento al que pertenece
	 * @return true o false
	 */
	private boolean comprobarDirectorDepartamento(Empleado emp, Departamento dept) {
		boolean bandera = false;
		
		for (Departamento departamento : listaDepartamentos) {
			if(departamento.getDirector()!= null) {				
				String aux = departamento.getDirector().getDni();
				if(aux.equals(emp.getDni()) && !departamento.getNombre().equals(dept.getNombre())){					
					bandera = true;//Existe Empleado como Director de otro Departamento
				}
			
			}
		}
		
		return bandera;
		
	}
	/**
	 * 
	 * @param dni a comprobar que no existe
	 * @return true o false
	 */
	private boolean comprobarEmpleado (String dni) {
		
		boolean bandera = false;
		
		for(Empleado empleado : listaEmpleados) {
			
			if(empleado.getDni().equals(dni)) {
				bandera = true;
			}
			
		}
		return bandera;
		
	}

}
