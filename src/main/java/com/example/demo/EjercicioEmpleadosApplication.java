package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */
public class EjercicioEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioEmpleadosApplication.class, args);
		
		Departamento dept = new Departamento("Informatica", "Gran Via Parque 2", "954232124");
		Departamento dept2 = new Departamento("Informatica2", "Gran Via Parque 2", "954232124");
		Empleado emp = new Empleado("Antonio", "Rodriguez", "Calle Olmo 2", "33001753Z", "arodriguez@gmail.com");
		MapaDepartamentos mapa = new MapaDepartamentos();
		
		emp.setDepartamento(dept);
		dept2.setDirector(emp);
		dept.setDirector(emp);
		mapa.aniadeDepartamento(dept);
		mapa.aniadeDepartamento(dept2);
		
		System.out.println("El director del departamento" + dept.getNombre() +" es " + dept.getDirector().getNombre() +" "+ dept.getDirector().getApellido());
		System.out.println("El director del departamento" + dept2.getNombre() +" es " + dept2.getDirector().getNombre() +" "+ dept2.getDirector().getApellido());
		System.out.println("El departamento del empleado  es " + emp.getDepartamento().getNombre());
	
		if(emp.esDirector())
			System.out.println("El empleado es el Director del departamento " + emp.getDepartamento().getNombre());
	}
}
