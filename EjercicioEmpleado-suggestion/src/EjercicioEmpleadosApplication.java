/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class EjercicioEmpleadosApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(EjercicioEmpleadosApplication.class, args);
		
		EmpresaServicio servicio = new EmpresaServicio();
		servicio.showMenu();
	}
    
}
