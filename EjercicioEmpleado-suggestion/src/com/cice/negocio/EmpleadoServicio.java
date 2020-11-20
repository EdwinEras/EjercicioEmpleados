package com.cice.negocio;

import java.util.*;
import com.cice.modelo.*;

public class EmpleadoServicio extends Servicio{
	
	@Override
	public void crear() {
		Scanner sc = new Scanner (System.in);		
        Empleado empleado = new Empleado();

        System.out.println("Introduce un nombre");
        empleado.setNombre(sc.next());
        System.out.println("Introduce un apellido");
        empleado.setApellido(sc.next());
        System.out.println("Introduce un DNI");
        empleado.setDni(sc.next());		
        sc.nextLine();		
        while(Verificacion.comprobarEmpleado(empleado.getDni(),getListaEmpleados())) {
                System.out.println("Ya existe un empleado con ese DNI");
                System.out.println("Introduce un DNI");
                empleado.setDni(sc.next());		
                sc.nextLine();					
        }	
        System.out.println("Introduce un direccion");
        empleado.setDireccion(sc.nextLine());
        System.out.println("Introduce un e-mail");
        empleado.setMail(sc.next());		
        getListaEmpleados().add(empleado);	
        sc.close();
	}
	
	@Override
	public void asignarDepartamento() {
		Scanner sc = new Scanner (System.in);		
        int opcion1 = 0;
        int opcion2 =  0;

        if (getListaEmpleados().size()>0 && getListaDepartamentos().size()>0) {
                do {
                        if(opcion1-1>getListaEmpleados().size()-1 || opcion1-1 <0)
                                System.out.println("Opccion Erronea");
                        System.out.println("Seleccione un empleado");	
                        MostrarInformacion.mostrarEmpleado(getListaEmpleados());						
                        opcion1 = sc.nextInt();				
                }while(opcion1-1>getListaEmpleados().size()-1 || opcion1-1 <0);			
                do {
                        if(opcion2-1>getListaDepartamentos().size()-1 || opcion2-1 <0)
                                System.out.println("Opccion Erronea");
                        System.out.println("Seleccione un Departamento");				
                        MostrarInformacion.mostrarDepartamentos(getListaDepartamentos());
                        opcion2 = sc.nextInt();
                }while(opcion2-1>getListaDepartamentos().size()-1 || opcion2-1 <0);						
                Agregacion.agregarEmpleadoDepartamento(getListaEmpleados().get(opcion1-1),(Departamento) getListaDepartamentos().get(opcion2-1),getListaDepartamentos());				
        }
        else if (getListaEmpleados().size()==0)
                System.out.println("Debe crear antes un Empleado");

        else
                System.out.println("Debe crear antes un Departamento");
	}
	
	public void asignarDirector() {

        Scanner sc = new Scanner (System.in);
        int opcion1 = 0;
        int opcion2 = 0;

        if (getListaEmpleados().size()>0 && getListaDepartamentos().size()>0) {
        	do {
        		System.out.println("Seleccione un empleado");	
        		MostrarInformacion.mostrarEmpleado(getListaEmpleados());						
        		opcion1 = sc.nextInt();
        		System.out.println(getListaEmpleados().size());
        		if(opcion1-1>getListaEmpleados().size()-1 || opcion1-1 <0) System.out.println("Opccion Erronea");
        	}while(opcion1-1>getListaEmpleados().size()-1 || opcion1-1 <0);
        	
	        do {		
	        	
	        	System.out.println("Seleccione un Departamento en el que agregar al Empleado");		
	        	MostrarInformacion.mostrarDepartamentos(getListaDepartamentos());			
	        	opcion2 = sc.nextInt();
	        	System.out.println(opcion2);
	        	if(opcion2-1>getListaEmpleados().size()-1 || opcion2-1 <0) System.out.println("Opccion Erronea");
	        }while(opcion2-1>getListaDepartamentos().size() -1|| opcion2-1 <0);	
	        Agregacion.agregarDirector(getListaEmpleados().get(opcion1-1), getListaDepartamentos().get(opcion2-1), getListaDepartamentos());
        }
        else if (getListaEmpleados().size()==0)
                System.out.println("Debe crear antes un Empleado");

        else
                System.out.println("Debe crear antes un Departamento");
	}
	
}
