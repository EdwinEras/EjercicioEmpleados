package com.cice.negocio;

import java.util.ArrayList;
import com.cice.modelo.*;

public class Agregacion {
	
	public static void agregarEmpleadoDepartamento(Empleado empleado, Departamento departamento, ArrayList<Departamento> listaDept) {
		if (!Verificacion.comprobarEmpleadoDepartamentos(empleado, departamento,listaDept)) {
			if(!Verificacion.comprobarEmpleado(empleado.getDni(),departamento.getListaEmpleados())) {
				empleado.setDepartamento(departamento);			
				departamento.getListaEmpleados().add(empleado);
          		}
			else  System.out.println("El Empleado ya está en este Departamento");				
        }
        else System.out.println("El Empleado esta en mas de un Departamento");
	}
	
	public static void agregarDirector(Empleado empleado, Departamento departamento, ArrayList<Departamento> listaDept) {
        if  (Verificacion.comprobarDirectorDepartamento(empleado, departamento,listaDept))
                System.out.println("Es Empleado seleccionado es Director de mas de un departamento");			
        else departamento.setDirector(empleado);
	}
	
	
}
