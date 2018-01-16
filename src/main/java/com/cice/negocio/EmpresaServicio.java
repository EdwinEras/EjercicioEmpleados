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
	
	/**
	 * Método showMenu
	 */
	
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
			System.out.println("7. Mostrar Organigrama de la Empresa");
			System.out.println("0. salir");
			opcion = sc.nextInt();
			
			controles (opcion);
		
			
			
		}while (opcion!=0);
		sc.close();
	}
	
	/**
	 * Método controles
	 * @param opcion seleccionada
	 */	
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
			case 7: 
				//Mostrar Organigrama
				mostrarOrganigram();
				break;
			default:
				System.out.println("la opcion seleccionada no es valida");
				
				
		}
	}
	
	/**
	 * Método crearEmpleado
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
	 * Método mostrarEmpleado
	 */
	private void mostrarEmpleado() {
		System.out.println("-------------");
		listaEmpleados.forEach((k)->System.out.println(k.toString()));
		System.out.println("-------------");
	}
	
	/**
	 * Método mostrarDepartamentos
	 */
	private void mostrarDepartamentos() {
		System.out.println("-------------");
		listaDepartamentos.forEach((k)->System.out.println(k.toString()));
		System.out.println("-------------");
	}
	
	/**
	 * Método crearDepartamento
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
			while(comprobarDepartamento(departamento.getNombre())) {
				System.out.println("Ya existe un departamento con ese nombre");
				System.out.println("Introduce otro nombre");
				departamento.setNombre(sc.next());		
				sc.nextLine();					
			}	
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
	 * Método comprobarDepartamento
	 * @param nombre del departamento a comprobar
	 * @return true o false
	 */
	
	private boolean comprobarDepartamento (String nombre) {
		
		boolean bandera = false;
		
		for(Departamento departamento : listaDepartamentos) {
			
			if(departamento.getNombre().equals(nombre)) {
				bandera = true;
			}
			
		}
		return bandera;
		
	}
	
	/**
	 * Método asignarEmpleado
	 */
	private void asignarEmpleado() {
		final int i[] = new int[] {0};
		Scanner sc = new Scanner (System.in);		
		int opcion1 = 0;
		int opcion2 =  0;
		
		if (listaEmpleados.size()>0) {
			do {
				i[0]= 0;
				System.out.println("Seleccione un empleado");		
				listaEmpleados.forEach(k->{System.out.println(i[0]+1 +") " +k.toString());i[0]++;});		
				opcion1 = sc.nextInt();
			}while(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0);	
		}	
		if (listaDepartamentos.size()>0) {
			do {
				i[0]= 0;
				System.out.println("Seleccione un Departamento");
				listaDepartamentos.forEach(k->{System.out.println(i[0]+1 +") " +k.toString());i[0]++;});
				opcion2 = sc.nextInt();
			}while(opcion2-1>listaDepartamentos.size()-1 || opcion2-1 <0);						
				
			if (comprobarEmpleadoDepartamentos(listaEmpleados.get(opcion1-1), listaDepartamentos.get(opcion2-1))== false) {
				if(comprobarDepartamento(listaDepartamentos.get(opcion2-1),listaEmpleados.get(opcion1-1))==false) {
					listaEmpleados.get(opcion1-1).setDepartamento(listaDepartamentos.get(opcion2-1));			
					listaDepartamentos.get(opcion2-1).getListaEmpleados().add(listaEmpleados.get(opcion1-1));
				}
				else System.out.println("El Empleado ya está en este Departamento");				
			}
			else System.out.println("El Empleado esta en mas de un Departamento");		
		}
	}
		
	
	/**
	 * Metodo asignarDirector
	 */
	private void asignarDirector() {
		
		final int i[] = new int[] {0};
		Scanner sc = new Scanner (System.in);
		int opcion1 = 0;
		int opcion2 = 0;
		

		if (listaEmpleados.size()>0) {
			do {
				i[0]= 0;
				System.out.println("Seleccione un empleado");		
				listaEmpleados.forEach(k->{System.out.println(i[0]+1 +") " +k.toString());i[0]++;});		
				opcion1 = sc.nextInt();
				System.out.println(listaEmpleados.size());
			}while(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0);	
		}
		if (listaDepartamentos.size()>0) {
		do {		
			i[0] = 0;
			System.out.println("Seleccione un Departamento en el que agregar al Empleado");		
			listaDepartamentos.forEach(k->{System.out.println(i[0]+1 +") " +k.toString());i[0]++;});			
			opcion2 = sc.nextInt();
			System.out.println(opcion2);
		}while(opcion2-1>listaDepartamentos.size() -1|| opcion2-1 <0);	
			if  (comprobarDirectorDepartamento(listaEmpleados.get(opcion1-1), listaDepartamentos.get(opcion2-1)))
				System.out.println("Es Empleado seleccionado es Director de mas de un departamento");				
			
			else listaDepartamentos.get(opcion2-1).setDirector(listaEmpleados.get(opcion1-1));			
		}		
	}
	
	/**
	 * Método comprobarDepartamento
	 * @param dept departamento a comprobar
	 * @param emp empleado a comprobar
	 * @return true o false si el empleado ya se encuentra en el departamento
	 */
	private boolean comprobarDepartamento (Departamento dept, Empleado emp) {
	
		boolean bandera = false;
		
		if(dept.getListaEmpleados().size()>0) {
		for (Empleado empleado : dept.getListaEmpleados()) {
			if (empleado.getDni().equals(emp.getDni()))
				bandera = true;
		}
		}		
		return bandera;	
	}
	
	
	/**
	 * Método comprobarEmpleadoDepartamentos
	 * @param emp Empleado a comprobar
	 * @param dept Departamento al que pertenece
	 * @return true o false
	 */
	
	private boolean comprobarEmpleadoDepartamentos(Empleado emp, Departamento dept) {
		boolean bandera = false;
		String auxemp = emp.getDni();
		String auxdept = dept.getNombre();
		
		for (Departamento departamento : listaDepartamentos) {
			if(departamento.getListaEmpleados().size()>0) {
			for(Empleado empleado : departamento.getListaEmpleados()) {
				if(empleado.getDni().equals(auxemp) && !empleado.getDepartamento().getNombre().equals(auxdept)) {				
					bandera = true;//Existe Empleado en otro Departamento
				}
			}
			}
		}
		return bandera;
		
	}
	
	/**
	 * Método comprobarDirectorDepartamento
	 * @param emp Empleado a comprobar
	 * @param dept Departamento al que pertenece
	 * @return true o false
	 */
	private boolean comprobarDirectorDepartamento(Empleado emp, Departamento dept) {
		boolean bandera = false;
		String auxemp = emp.getDni();
		String auxdept = dept.getNombre();
		
		for (Departamento departamento : listaDepartamentos) {
			if(departamento.getDirector()!= null) {				
				if(departamento.getDirector().getDni().equals(auxemp) && !departamento.getNombre().equals(auxdept)){					
					bandera = true;//Existe Empleado como Director de otro Departamento
				}
			
			}
		}
		
		return bandera;
		
	}
	/**
	 * Método comprobarEmpleado
	 * @param dni a comprobar que no existe en la Lista de Empleados
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
	
	/**
	 * Método mostrarOganigrama
	 */
	private void mostrarOrganigram() {
		
		if (listaDepartamentos.size()>0) {
			System.out.println("-------------");
			System.out.println("Departamentos");
			System.out.println("-------------");
		}
		for (Departamento departamento : listaDepartamentos) {
			System.out.println(departamento.toString());
			if(departamento.getListaEmpleados().size()>0) {
			departamento.getListaEmpleados().forEach((k)->System.out.println(k.toString()));
			}
			if(departamento.getDirector()!=null) {
			System.out.println("El director del Departamento es--> " + departamento.getDirector().toString());
			}			
			System.out.println("-------------");	
			
		}
		if(listaEmpleados.size() > 0) {
			System.out.println("-------------");
			System.out.println("Empleados");
			System.out.println("-------------");	
		}
		for (Empleado empleado : listaEmpleados) {
				
			System.out.println(empleado.toString());
			System.out.println("-------------");			
		}		
	}

}
