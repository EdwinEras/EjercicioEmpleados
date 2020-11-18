
import java.util.Scanner;

public class MostrarInformacion {
    
    public static void showMenu() {
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
    
    public static void controles (int opcion) {
        switch (opcion){
            case 0:
                break;
            case 1:
                    //Crear Empleado
                EmpresaServicio.crearEmpleado();
                break;
            case 2:
                    //Crear Departamento
                EmpresaServicio.crearDepartamento();
                break;
            case 3:
                    //Asignar Director a Departamento
                EmpresaServicio.asignarDirector();
                break;
            case 4:
                    //Asignar Empleado a Departamento
                EmpresaServicio.asignarEmpleado();
                break;		
            case 5:
                    //Asignar uno o varios Empleados a un mismo Departamento
                EmpresaServicio.asignarVariosEmpleadosDepartamento();
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
    
    public static void mostrarEmpleado() {
        int i = 0;

        System.out.println("-------------");		
        for (Empleado empleado : EmpresaServicio.listaEmpleados) {			
                System.out.println(i+1 + ") " + empleado.toString());	
                i++;
        }		
        System.out.println("-------------");
    }
    
    public static void mostrarDepartamentos() {
            int i = 0;

            for (Departamento departamento : EmpresaServicio.listaDepartamentos) {			
                    System.out.println(i+1 + ") " + departamento.toString());		
                    i++;
            }	
    }
    
    public static void mostrarOrganigram() {

            if (EmpresaServicio.listaDepartamentos.size()>0) {
                    System.out.println("-------------");
                    System.out.println("Departamentos");
                    System.out.println("-------------");
            }
            int j = 0;
            for (Departamento departamento : EmpresaServicio.listaDepartamentos) {

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
            if(EmpresaServicio.listaEmpleados.size() > 0) {
                    System.out.println("-------------");
                    System.out.println("Empleados");
                    System.out.println("-------------");	
            }
            mostrarEmpleado();
    }
    
}
