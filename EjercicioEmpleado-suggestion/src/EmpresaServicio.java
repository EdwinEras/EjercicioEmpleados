
import java.util.ArrayList;
import java.util.Scanner;

public class EmpresaServicio  {
	
    public static ArrayList <Empleado> listaEmpleados= new ArrayList <>();
    public static ArrayList <Departamento> listaDepartamentos= new ArrayList <>();

    public static void crearEmpleado() {
            Scanner sc = new Scanner (System.in);		
            Empleado empleado = new Empleado();

            System.out.println("Introduce un nombre");
            empleado.setNombre(sc.next());
            System.out.println("Introduce un apellido");
            empleado.setApellido(sc.next());
            System.out.println("Introduce un DNI");
            empleado.setDni(sc.next());		
            sc.nextLine();		
            while(Verificacion.comprobarEmpleado(empleado.getDni())) {
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
    
    public static void crearDepartamento() {
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
                    EmpresaServicio.listaDepartamentos.add(departamento);
                    respuesta = sc.next();			
            }while(respuesta.equals("s"));
    }

    public static boolean comprobarDepartamento (String nombre) {

            boolean bandera = false;

            for(Departamento departamento : listaDepartamentos) {

                    if(departamento.getNombre().equals(nombre)) {
                            bandera = true;
                    }

            }
            return bandera;

    }

    public static void asignarEmpleado() {
            Scanner sc = new Scanner (System.in);		
            int opcion1 = 0;
            int opcion2 =  0;

            if (listaEmpleados.size()>0 && listaDepartamentos.size()>0) {
                    do {
                            if(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0)
                                    System.out.println("Opccion Erronea");
                            System.out.println("Seleccione un empleado");	
                            MostrarInformacion.mostrarEmpleado();						
                            opcion1 = sc.nextInt();				
                    }while(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0);			
                    do {
                            if(opcion2-1>listaDepartamentos.size()-1 || opcion2-1 <0)
                                    System.out.println("Opccion Erronea");
                            System.out.println("Seleccione un Departamento");				
                            MostrarInformacion.mostrarDepartamentos();
                            opcion2 = sc.nextInt();
                    }while(opcion2-1>listaDepartamentos.size()-1 || opcion2-1 <0);						
                    Verificacion.comprobarAgregarEmpleadoDepartamento(listaEmpleados.get(opcion1-1),listaDepartamentos.get(opcion2-1));				
            }
            else if (listaEmpleados.size()==0)
                    System.out.println("Debe crear antes un Empleado");

            else
                    System.out.println("Debe crear antes un Departamento");
    }

    public static void asignarVariosEmpleadosDepartamento() {
            Scanner sc = new Scanner (System.in);
            int [] empleadosSeleccionados;
            int departamentoSeleccionado = 1;
            boolean bandera = false;

            if (listaEmpleados.size()>0 && listaDepartamentos.size()>0) {
                    do{
                            if(departamentoSeleccionado-1>listaDepartamentos.size()-1 || departamentoSeleccionado-1 <0)
                                    System.out.println("Opcion erronea");				
                    System.out.println("Seleccione un Departamento");	
                    MostrarInformacion.mostrarDepartamentos();
                    departamentoSeleccionado=Integer.parseInt(sc.nextLine());
                    }while(departamentoSeleccionado-1>listaDepartamentos.size()-1 || departamentoSeleccionado-1 <0);
                    do {
                            if(bandera)
                                    System.out.println("Opcion erronea");	
                    System.out.println("Empleados Disponibles");
                    MostrarInformacion.mostrarEmpleado();
                    System.out.print("Seleccione 1 o varios empleados (Separados por coma ej: 1,2,4): ");
                    String aux[] = Verificacion.validarCadenaUsuario(sc.nextLine());
                    empleadosSeleccionados=new int[aux.length];
                    bandera = Verificacion.ComprobarEmpleadosDesdeCadena(aux, empleadosSeleccionados);
                    }while(bandera);			
                    for (int i = 0; i < empleadosSeleccionados.length; i++) 
                            Verificacion.comprobarAgregarEmpleadoDepartamento(listaEmpleados.get(empleadosSeleccionados[i]-1),listaDepartamentos.get(departamentoSeleccionado-1));			
            }
            else if (listaEmpleados.size()<0) 
                    System.out.println("Debe agregar un Empleado antes");	
            else
                    System.out.println("Debe agregar un Departamento antes");
    }

    public static void asignarDirector() {

            Scanner sc = new Scanner (System.in);
            int opcion1 = 0;
            int opcion2 = 0;

            if (listaEmpleados.size()>0 && listaDepartamentos.size()>0) {
                    do {
                            if(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0)
                                    System.out.println("Opccion Erronea");
                            System.out.println("Seleccione un empleado");	
                            MostrarInformacion.mostrarEmpleado();						
                            opcion1 = sc.nextInt();
                            System.out.println(listaEmpleados.size());
                    }while(opcion1-1>listaEmpleados.size()-1 || opcion1-1 <0);		
            do {		
                    if(opcion2-1>listaEmpleados.size()-1 || opcion2-1 <0)
                            System.out.println("Opccion Erronea");
                    System.out.println("Seleccione un Departamento en el que agregar al Empleado");		
                    MostrarInformacion.mostrarDepartamentos();			
                    opcion2 = sc.nextInt();
                    System.out.println(opcion2);
            }while(opcion2-1>listaDepartamentos.size() -1|| opcion2-1 <0);	
            Verificacion.comprobarAgregarDirector(listaEmpleados.get(opcion1-1), listaDepartamentos.get(opcion2-1));					
            }
            else if (listaEmpleados.size()==0)
                    System.out.println("Debe crear antes un Empleado");

            else
                    System.out.println("Debe crear antes un Departamento");
    }

}
