package com.cice.negocio;

import java.util.ArrayList;
import java.util.Scanner;

import com.cice.modelo.Departamento;
import com.cice.modelo.Empleado;


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
			case 4:
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
	
	private void crearEmpleado() {
		Scanner sc = new Scanner (System.in);		
		Empleado empleado = new Empleado();
		
		System.out.println("Introduce un nombre");
		empleado.setNombre(sc.next());
		System.out.println("Introduce un apellido");
		empleado.setApellido(sc.next());
		listaEmpleados.add(empleado);
		System.out.println(empleado.toString());
	}
	
	private void mostrarEmpleado() {
		System.out.println("-------------");
		listaEmpleados.forEach((k)->System.out.println(k.toString()));
		System.out.println("-------------");
	}
	
	private void mostrarDepartamentos() {
		System.out.println("-------------");
		listaDepartamentos.forEach((k)->System.out.println(k.toString()));
		System.out.println("-------------");
	}
	
	private void crearDepartamento() {
		Scanner sc = new Scanner (System.in);
		String respuesta = "";
		Departamento departamento; 
		
		do {
			departamento = new Departamento ();
			System.out.println("Introduce un nombre");
			departamento.setNombre(sc.next());
			System.out.println("Introduce una ubicacion");
			departamento.setUbicacion(sc.next());
			System.out.println("-------------");
			System.out.println("¿Quieres crear otro Departamento (s/n)");
			System.out.println("-------------");
			listaDepartamentos.add(departamento);
			respuesta = sc.next();			
		}while(respuesta.equals("s"));
	}

}
