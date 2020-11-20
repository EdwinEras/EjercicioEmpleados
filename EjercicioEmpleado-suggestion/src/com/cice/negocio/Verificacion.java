package com.cice.negocio;

import java.util.*;
import com.cice.modelo.*;

public class Verificacion {
    
    public static String[] validarCadenaUsuario(String auxiliar, ArrayList<Empleado> listaEmpleados){
            Scanner sc = new Scanner(System.in);
            do{
            if(!auxiliar.matches("\\d+(,\\d+)?")) { //
                    System.out.println("Opcion erronea");		
                    System.out.println("Seleccione 1 o varios empleados (Separados por coma ej: 1,2,4): ");
                    MostrarInformacion.mostrarEmpleado(listaEmpleados);
                    auxiliar = sc.nextLine();
            }
            }while(!auxiliar.matches("\\d+(,\\d+)?"));
            sc.close();
            return auxiliar.split(",");
    }
    
    
    public static boolean ComprobarEmpleadosDesdeCadena(String [] cadena, int[] empleados, ArrayList<Empleado> listaEmpleados) {		
            for(int i = 0; i < cadena.length; i++){				
                    empleados[i] = Integer.parseInt(cadena[i]);
                    if (empleados[i]-1 >listaEmpleados.size()-1 ||empleados[i]-1 <0 )
                            return true;
                    if(i == cadena.length-1 && !(empleados[i]-1 >listaEmpleados.size()-1 ||empleados[i]-1 <0 ))
                            return false;
            }
            return false;

    }
    
    public static boolean comprobarDepartamento (String nombre, ArrayList<Departamento> listaDepartamentos) {
    	for(Departamento departamento : listaDepartamentos) 
    		if(departamento.getNombre().equals(nombre)) return true;
        return false;
    }

    public static boolean comprobarEmpleadoDepartamentos(Empleado emp, Departamento dept,ArrayList<Departamento> listaDepartamentos) {
        for (Departamento departamento : listaDepartamentos) {
                if(departamento.getListaEmpleados().size()>0) {
                	for(Empleado empleado : departamento.getListaEmpleados()) 
                		if(empleado.getDni().equals(emp.getDni()) && !empleado.getDepartamento().getNombre().equals(dept.getNombre()))
                				return true;//Existe Empleado en otro Departamento
                }
        }
        return false;

    }

    public static boolean comprobarDirectorDepartamento(Empleado emp, Departamento dept, ArrayList<Departamento> listaDepartamentos) {
        for (Departamento departamento :	listaDepartamentos) {
                if(departamento.getDirector()!= null) {
                	if(departamento.getDirector().getDni().equals(emp.getDni()) && !departamento.getNombre().equals(dept.getNombre()))				
                        	return true;//Existe Empleado como Director de otro Departamento
                }
        }
        return false;

    }

    public static boolean comprobarEmpleado (String dni, ArrayList<Empleado> listaEmpleados) {
        for(Empleado empleado : listaEmpleados)
        	if(empleado.getDni().equals(dni)) return true;
        return false;		
    }

}
