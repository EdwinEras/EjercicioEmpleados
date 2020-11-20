package com.cice.negocio;

import java.util.*;
import com.cice.modelo.*;

public class EmpresaServicio extends Servicio{
	
    @Override
	public void crear() {
		Scanner sc = new Scanner (System.in);
        String respuesta = "";
        Departamento departamento; 

        do {
                departamento = new Departamento ();
                System.out.println("Introduce un nombre");
                departamento.setNombre(sc.next());
                sc.nextLine();
                while(Verificacion.comprobarDepartamento(departamento.getNombre(),getListaDepartamentos())) {
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
                getListaDepartamentos().add(departamento);
                respuesta = sc.next();			
        }while(respuesta.equals("s"));
	}

	@Override
	public void asignarDepartamento() {
		Scanner sc = new Scanner (System.in);
        	int [] empleadosSeleccionados;
        	int departamentoSeleccionado = 1;
        	boolean bandera = false;
        	if (getListaEmpleados().size()>0 && getListaDepartamentos().size()>0) {
                	do{
                    	System.out.println("Seleccione un Departamento");	
                    	MostrarInformacion.mostrarDepartamentos(getListaDepartamentos());
                    	departamentoSeleccionado=Integer.parseInt(sc.nextLine());
                    	if(departamentoSeleccionado-1>getListaDepartamentos().size()-1 || departamentoSeleccionado-1 <0)
                        	System.out.println("Opcion erronea");	
                	}while(departamentoSeleccionado-1>getListaDepartamentos().size()-1 || departamentoSeleccionado-1 <0);
                	do { 
                   	 System.out.println("Empleados Disponibles");
                    	MostrarInformacion.mostrarEmpleado(getListaEmpleados());
                    	System.out.print("Seleccione 1 o varios empleados (Separados por coma ej: 1,2,4): ");
                    	String aux[] = Verificacion.validarCadenaUsuario(sc.nextLine(), getListaEmpleados());
                    	empleadosSeleccionados=new int[aux.length];
                    	bandera = Verificacion.ComprobarEmpleadosDesdeCadena(aux, empleadosSeleccionados,(ArrayList<Empleado>) getListaEmpleados());
                    	if(bandera)	System.out.println("Opcion erronea");	
                	}while(bandera);			
                	for (int i = 0; i < empleadosSeleccionados.length; i++) 
                		Agregacion.agregarEmpleadoDepartamento(getListaEmpleados().get(empleadosSeleccionados[i]-1),getListaDepartamentos().get(departamentoSeleccionado-1),getListaDepartamentos());
        	}
        	else if (getListaEmpleados().size()<0) System.out.println("Debe agregar un Empleado antes");	
        	else	System.out.println("Debe agregar un Departamento antes");
        	sc.close();
	}

}
