package com.cice.negocio;

import java.util.*;
import com.cice.modelo.*;

public abstract class Servicio {

	
    private ArrayList <Departamento> listaDepartamentos= new ArrayList <>();
    private ArrayList <Empleado> listaEmpleados= new ArrayList <>();
	
	public abstract void crear();
	public abstract void asignarDepartamento();
	
	public ArrayList<Empleado> getListaEmpleados(){
		return this.listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmp){
		this.listaEmpleados = listaEmp;
	}
	
	public ArrayList<Departamento> getListaDepartamentos(){
		return this.listaDepartamentos;
	}

	public void setListaDepartamentos(ArrayList<Departamento> listaDept){
		this.listaDepartamentos = listaDept;
	}
	
	
}
