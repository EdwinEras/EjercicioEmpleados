package com.cice.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cice.modelo.Departamento;
import com.cice.modelo.Empleado;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */

public class EmpresaServicio  {
	
	private ArrayList <Empleado> listaEmpleados= new ArrayList <>();
	private ArrayList <Departamento> listaDepartamentos= new ArrayList <>();
	
	/**
	 * Método showMenu muestra el menú del programa
	 */
	
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
			System.out.println("5. Asignar varios Empleados a un Departamento");
			System.out.println("6. Mostrar todos los Empleados");
			System.out.println("7. Mostrar todos los Departamentos");
			System.out.println("8. Mostrar Organigrama de la Empresa");
			System.out.println("0. Salir");
			opcion = sc.nextInt();			
			controles (opcion);			
		}while (opcion!=0);
		sc.close();
	}
	
	/**
	 * Método controles llama a los distintos métodos de la clase
	 * @param opcion seleccionada
	 */	
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
				asignarDirector();
				break;
			case 4:
				//Asignar Empleado a Departamento
				asignarEmpleado();
				break;		
			case 5:
				//Asignar uno o varios Empleados a un mismo Departamento
				asignarVariosEmpleadosDepartamento();
				break;
			case 6:
				//Mostrar todos los Empleados
				mostrarEmpleado();
				break;
			case 7:
				//Mostrar todos los Departamentos
				mostrarDepartamentos();
				break;
			case 8: 
				//Mostrar Organigrama
				mostrarOrganigram();
				break;
			default:
				System.out.println("la opcion seleccionada no es valida");				
		}
	}
	
	/**
	 * Método crearEmpleado crea un Empleado con comprobaciones para que no existan DNI duplicados
	 */
	private void crearEmpleado() {
		Scanner sc = new Scanner (System.in);		
		Empleado empleado = new Empleado();
		
		System.out.println("Introduce un nombre");
		empleado.setNombre(sc.next());
		System.out.println("Introduce un apellido");
		empleado.setApellido(sc.next());
		System.out.println("Introduce un DNI");
		empleado.setDni(sc.next());		
		sc.nextLine();		
		while(comprobarEmpleado(empleado.getDni())) {
			System.out.println("Ya existe un empleado con ese DNI");
			System.out.println("Introduce un DNI");
			empleado.setDni(sc.next());		
			sc.nextLine();					
		}	
		System.out.println("Introduce un direccion");
		empleado.setDireccion(sc.nextLine());
		System.out.println("Introduce un e-mail");
		empleado.setMail(sc.next());		
		listaEmpleados.add(empleado);		
	}
	
	/**
	 * Método mostrarEmpleado muestra la lista de Empleados
	 */
	private void mostrarEmpleado() {
		int i = 0;
		
		System.out.println("-------------");		
		for (Empleado empleado : listaEmpleados) {			
			System.out.println(i+1 + ") " + empleado.toString());	
			i++;
		}		
		System.out.println("-------------");
	}
	
	/**
	 * Método mostrarDepartamentos muestra la lista de Departamentos
	 */
	private void mostrarDepartamentos() {
		int i = 0;
		
		for (Departamento departamento : listaDepartamentos) {			
			System.out.println(i+1 + ") " + departamento.toString());		
			i++;
		}	
	}
	
	/**
	 * Método crearDepartamento con comprobaciones para que el Departamento no se cree varias veces
	 */
	private void crearDepartamento() {
		Scanner sc = new Scanner (System.in);
		String respuesta = "";
		Departamento departamento; 
		
		do {
			departamento = new Departamento ();
			System.out.println("Introduce un nombre");
			departamento.setNombre(sc.next());
			sc.nextLine();
			while(comprobarDepartamento(departamento.getNombre())) {
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
			listaDepartamentos.add(departamento);
			respuesta = sc.next();			
		}while(respuesta.equals("s"));
	}
	
	/**
	 * Método comprobarDepartamento comprueba que el Departamento no esté creado aún
	 * @param nombre del departamento a comprobar
	 * @return true o false
	 */
	
	private boolean comprobarDepartamento (String nombre) {
		
		boolean bandera = false;
		
		for(Departamento departamento : listaDepartamentos) {
			
			if(departamento.getNombre().equals(nombre)) {
				bandera = true;
			}
			
		}
		return bandera;
		
	}
	
	/**
	 * Método asignarEmpleado con comprobaciones para no agregar varias veces el mismo Empleado a un Departamento o un Empleado a distintos Departamentos
	 */
	private void asignarEmpleado() {
		Scanner sc = new Scanner (System.in);		
		int opcion1 = 0;
		int opcion2 =  0;
		Empleado auxemp;
		Departamento auxdept;
		
		if (listaEmpleados.size()>0 && listaDepartamentos.size()>0) {
			do {
				if(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0)
					System.out.println("Opccion Erronea");
				System.out.println("Seleccione un empleado");	
				mostrarEmpleado();						
				opcion1 = sc.nextInt();				
			}while(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0);			
			do {
				if(opcion2-1>listaEmpleados.size()-1 || opcion2-1 <0)
					System.out.println("Opccion Erronea");
				System.out.println("Seleccione un Departamento");				
				mostrarDepartamentos();
				opcion2 = sc.nextInt();
			}while(opcion2-1>listaDepartamentos.size()-1 || opcion2-1 <0);						
			comprobarAgregarEmpleadoDepartamento(listaEmpleados.get(opcion1-1),listaDepartamentos.get(opcion2-1));				
		}
		else if (listaEmpleados.size()==0)
			System.out.println("Debe crear antes un Empleado");
		
		else
			System.out.println("Debe crear antes un Departamento");
	}
	
	/**
	 * Méotodo asignarVariosEmpleadosDepartamento asigna uno o varios Empleados a un Departamento con comprobaciones
	 */
		
	private void asignarVariosEmpleadosDepartamento() {
		Scanner sc = new Scanner (System.in);
		int [] empleadosSeleccionados;
		int departamentoSeleccionado = 1;
		boolean bandera = false;
		
		if (listaEmpleados.size()>0 && listaDepartamentos.size()>0) {
			do{
				if(departamentoSeleccionado-1>listaDepartamentos.size()-1 || departamentoSeleccionado-1 <0)
					System.out.println("Opcion erronea");				
			System.out.println("Seleccione un Departamento");	
			mostrarDepartamentos();
			departamentoSeleccionado=Integer.parseInt(sc.nextLine());
			}while(departamentoSeleccionado-1>listaDepartamentos.size()-1 || departamentoSeleccionado-1 <0);
			do {
				if(bandera)
					System.out.println("Opcion erronea");	
			System.out.println("Empleados Disponibles");
			mostrarEmpleado();
			System.out.print("Seleccione 1 o varios empleados (Separados por coma ej: 1,2,4): ");
			String aux[] =validarCadenaUsuario(sc.nextLine());
			empleadosSeleccionados=new int[aux.length];
			bandera = ComprobarEmpleadosDesdeCadena(aux, empleadosSeleccionados);
			}while(bandera);			
			for (int i = 0; i < empleadosSeleccionados.length; i++) 
				comprobarAgregarEmpleadoDepartamento(listaEmpleados.get(empleadosSeleccionados[i]-1),listaDepartamentos.get(departamentoSeleccionado-1));			
		}
		else if (listaEmpleados.size()<0) 
			System.out.println("Debe agregar un Empleado antes");	
		else
			System.out.println("Debe agregar un Departamento antes");
	}
	
	/**
	 * Método validarCadenaUsuario valida que la cadena se ajuste a lo que se le pide al usuario (número, número)
	 * @param auxiliar cadena a validar0
	 * @return cadena dividida a partir de la coma en subcadenas
	 */
	private String[] validarCadenaUsuario(String auxiliar){
		Scanner sc = new Scanner(System.in);
		do{
		if(!auxiliar.matches("\\d+(,\\d+)?")) { //
			System.out.println("Opcion erronea");		
			System.out.println("Seleccione 1 o varios empleados (Separados por coma ej: 1,2,4): ");
			mostrarEmpleado();		
			auxiliar = sc.nextLine();
		}
		}while(!auxiliar.matches("\\d+(,\\d+)?"));
			return auxiliar.split(",");
		}
	
	/**
	 * Méotodo ComprobarEmpleadosDesdeCadena copia los empleados seleccionados desde el array de String y comprueba que sean válidas sus posiciones
	 * @param cadena array de String en el que se encuentra la cadena después de procesarla con el método split
	 * @param empleados seleccionados
	 * @return true o false si los empleados son válidos
	 */

	private boolean ComprobarEmpleadosDesdeCadena(String [] cadena, int[] empleados) {		
		for(int i = 0; i < cadena.length; i++){				
			empleados[i] = Integer.parseInt(cadena[i]);
			if (empleados[i]-1 >listaEmpleados.size()-1 ||empleados[i]-1 <0 )
				return true;
			if(i == cadena.length-1 && !(empleados[i]-1 >listaEmpleados.size()-1 ||empleados[i]-1 <0 ))
				return false;
		}
		return false;
		
	}
	/**
	 * Metodo asignarDirector con comprobaciones para que el Empleado no sea Director de más de un Departamento
	 */
	private void asignarDirector() {
		
		Scanner sc = new Scanner (System.in);
		int opcion1 = 0;
		int opcion2 = 0;
		
		if (listaEmpleados.size()>0 && listaDepartamentos.size()>0) {
			do {
				if(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0)
					System.out.println("Opccion Erronea");
				System.out.println("Seleccione un empleado");	
				mostrarEmpleado();						
				opcion1 = sc.nextInt();
				System.out.println(listaEmpleados.size());
			}while(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0);		
		do {		
			if(opcion2-1>listaEmpleados.size()-1 || opcion2-1 <0)
				System.out.println("Opccion Erronea");
			System.out.println("Seleccione un Departamento en el que agregar al Empleado");		
			mostrarDepartamentos();			
			opcion2 = sc.nextInt();
			System.out.println(opcion2);
		}while(opcion2-1>listaDepartamentos.size() -1|| opcion2-1 <0);	
		comprobarAgregarDirector(listaEmpleados.get(opcion1-1), listaDepartamentos.get(opcion2-1));					
		}
		else if (listaEmpleados.size()==0)
			System.out.println("Debe crear antes un Empleado");
		
		else
			System.out.println("Debe crear antes un Departamento");
	}
	
	/**
	 * Método comprobacionesAgregarDirector llama a las distintas comprobaciones a la hora de agregar un Director a un Departamento
	 * @param empleado empleado a comprobar
	 * @param departamento departamento a comprobar
	 */
	
	private void comprobarAgregarDirector(Empleado empleado, Departamento departamento) {
		if  (comprobarDirectorDepartamento(empleado, departamento))
			System.out.println("Es Empleado seleccionado es Director de mas de un departamento");			
		else departamento.setDirector(empleado);	
		
	}
	/**
	 * Método comprobacionesAgregarEmpleadoDepartamento llama a las distintas comprobaciones a la hora de agregar un Empleado a un Departamento
	 * @param empleado empleado a comprobar
	 * @param departamento departamento a comprobar
	 */
	
	private void comprobarAgregarEmpleadoDepartamento(Empleado empleado, Departamento departamento) {
		
		if (comprobarEmpleadoDepartamentos(empleado, departamento)== false) {
			if(comprobarDepartamento(departamento,empleado)==false) {
				empleado.setDepartamento(departamento);			
				departamento.getListaEmpleados().add(empleado);
			}
			else  System.out.println("El Empleado ya está en este Departamento");				
		}
		else System.out.println("El Empleado esta en mas de un Departamento");	
		
	}
	
	/**
	 * Método comprobarDepartamento comprueba que el Empleado dado no se encuentre aún en el Departamento
	 * @param dept departamento a comprobar
	 * @param emp empleado a comprobar
	 * @return true o false si el empleado ya se encuentra en el departamento
	 */
	private boolean comprobarDepartamento (Departamento dept, Empleado emp) {
	
		boolean bandera = false;
		
		if(dept.getListaEmpleados().size()>0) {
		for (Empleado empleado : dept.getListaEmpleados()) {
			if (empleado.getDni().equals(emp.getDni()))
				bandera = true;
		}
		}		
		return bandera;	
	}
	
	
	/**
	 * Método comprobarEmpleadoDepartamentos comprueba que el Empleado no se encuentre en otros Departamentos
	 * @param emp Empleado a comprobar
	 * @param dept Departamento al que pertenece
	 * @return true o false
	 */
	
	private boolean comprobarEmpleadoDepartamentos(Empleado emp, Departamento dept) {
		boolean bandera = false;
		String auxemp = emp.getDni();
		String auxdept = dept.getNombre();
		
		for (Departamento departamento : listaDepartamentos) {
			if(departamento.getListaEmpleados().size()>0) {
			for(Empleado empleado : departamento.getListaEmpleados()) {
				if(empleado.getDni().equals(auxemp) && !empleado.getDepartamento().getNombre().equals(auxdept)) {				
					bandera = true;//Existe Empleado en otro Departamento
				}
			}
			}
		}
		return bandera;
		
	}
	
	/**
	 * Método comprobarDirectorDepartamento comprueba que el Empleado no sea Director de otro Departamento
	 * @param emp Empleado a comprobar
	 * @param dept Departamento al que pertenece
	 * @return true o false
	 */
	private boolean comprobarDirectorDepartamento(Empleado emp, Departamento dept) {
		boolean bandera = false;
		String auxemp = emp.getDni();
		String auxdept = dept.getNombre();
		
		for (Departamento departamento : listaDepartamentos) {
			if(departamento.getDirector()!= null) {				
				if(departamento.getDirector().getDni().equals(auxemp) && !departamento.getNombre().equals(auxdept)){					
					bandera = true;//Existe Empleado como Director de otro Departamento
				}
			
			}
		}
		return bandera;
		
	}
	/**
	 * Método comprobarEmpleado comprueba que el empleado no se encuentre aún en la listaEmpleados
	 * @param dni a comprobar que no existe en la Lista de Empleados
	 * @return true o false
	 */
	private boolean comprobarEmpleado (String dni) {
		
		boolean bandera = false;
		
		for(Empleado empleado : listaEmpleados) {
			
			if(empleado.getDni().equals(dni)) {
				bandera = true;
			}
			
		}
		return bandera;		
	}
	
	/**
	 * Método mostrarOganigrama muestra el Organigrama de la Empresa
	 */
	private void mostrarOrganigram() {
		
		if (listaDepartamentos.size()>0) {
			System.out.println("-------------");
			System.out.println("Departamentos");
			System.out.println("-------------");
		}
		int j = 0;
		for (Departamento departamento : listaDepartamentos) {
			
			System.out.println(j+1 + ") " +departamento.toString());
			j++;
			if(departamento.getListaEmpleados().size()>0) {
				System.out.println("Empleados en el Departamento");
				System.out.println("-------------");
				int i = 0;
				for (Empleado empleado : departamento.getListaEmpleados()) {
					System.out.println(i+1 + ") " + empleado.toString());
					i++;
				}
				System.out.println("-------------");
			}
			if(departamento.getDirector()!=null) {
			System.out.println("El director del Departamento es--> " + departamento.getDirector().toString());
			}	
		}
		if(listaEmpleados.size() > 0) {
			System.out.println("-------------");
			System.out.println("Empleados");
			System.out.println("-------------");	
		}
		mostrarEmpleado();
	}

}
