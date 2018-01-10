package com.example.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class MapaDepartamentos {
	
	private Map<String, Departamento> mapDeDepartamentos;

	public MapaDepartamentos() {
		this.mapDeDepartamentos = new HashMap<>();
	}
	
	public void aniadeDepartamento(Departamento dept) {
		this.mapDeDepartamentos.put(dept.getNombre(), dept);
	}
	
	public boolean eliminarDepartamento(String key) {
		if(this.mapDeDepartamentos.size()>0 && this.mapDeDepartamentos.containsKey(key)) {
			this.mapDeDepartamentos.remove(key);
			return true;		
		
		}
		else
		return false;
	}
	
	public Map<String, Departamento> getMapa () {
		
		return mapDeDepartamentos;
		
	}
	
	

}
