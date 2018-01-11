package com.cice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cice.modelo.Departamento;
import com.cice.modelo.Empleado;
import com.cice.negocio.EmpresaServicio;

@SpringBootApplication
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class EjercicioEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioEmpleadosApplication.class, args);
		
		EmpresaServicio servicio = new EmpresaServicio();
		servicio.showMenu();
	}
}
