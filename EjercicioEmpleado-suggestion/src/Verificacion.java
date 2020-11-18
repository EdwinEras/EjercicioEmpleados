
import java.util.Scanner;

public class Verificacion {
    
    public static String[] validarCadenaUsuario(String auxiliar){
            Scanner sc = new Scanner(System.in);
            do{
            if(!auxiliar.matches("\\d+(,\\d+)?")) { //
                    System.out.println("Opcion erronea");		
                    System.out.println("Seleccione 1 o varios empleados (Separados por coma ej: 1,2,4): ");
                    MostrarInformacion.mostrarEmpleado();
                    auxiliar = sc.nextLine();
            }
            }while(!auxiliar.matches("\\d+(,\\d+)?"));
                    return auxiliar.split(",");
            }
    
    
    public static boolean ComprobarEmpleadosDesdeCadena(String [] cadena, int[] empleados) {		
            for(int i = 0; i < cadena.length; i++){				
                    empleados[i] = Integer.parseInt(cadena[i]);
                    if (empleados[i]-1 >EmpresaServicio.listaEmpleados.size()-1 ||empleados[i]-1 <0 )
                            return true;
                    if(i == cadena.length-1 && !(empleados[i]-1 >EmpresaServicio.listaEmpleados.size()-1 ||empleados[i]-1 <0 ))
                            return false;
            }
            return false;

    }
    
    public static void comprobarAgregarEmpleadoDepartamento(Empleado empleado, Departamento departamento) {

            if (comprobarEmpleadoDepartamentos(empleado, departamento)== false) {
                    if(comprobarDepartamento(departamento,empleado)==false) {
                            empleado.setDepartamento(departamento);			
                            departamento.getListaEmpleados().add(empleado);
                    }
                    else  System.out.println("El Empleado ya está en este Departamento");				
            }
            else System.out.println("El Empleado esta en mas de un Departamento");	

    }
    
    public static void comprobarAgregarDirector(Empleado empleado, Departamento departamento) {
            if  (comprobarDirectorDepartamento(empleado, departamento))
                    System.out.println("Es Empleado seleccionado es Director de mas de un departamento");			
            else departamento.setDirector(empleado);	

    }

    public static boolean comprobarDepartamento (Departamento dept, Empleado emp) {

            boolean bandera = false;

            if(dept.getListaEmpleados().size()>0) {
            for (Empleado empleado : dept.getListaEmpleados()) {
                    if (empleado.getDni().equals(emp.getDni()))
                            bandera = true;
            }
            }		
            return bandera;	
    }

    public static boolean comprobarEmpleadoDepartamentos(Empleado emp, Departamento dept) {
        boolean bandera = false;
        String auxemp = emp.getDni();
        String auxdept = dept.getNombre();

        for (Departamento departamento : EmpresaServicio.listaDepartamentos) {
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

    public static boolean comprobarDirectorDepartamento(Empleado emp, Departamento dept) {
        boolean bandera = false;
        String auxemp = emp.getDni();
        String auxdept = dept.getNombre();

        for (Departamento departamento : EmpresaServicio.listaDepartamentos) {
                if(departamento.getDirector()!= null) {				
                        if(departamento.getDirector().getDni().equals(auxemp) && !departamento.getNombre().equals(auxdept)){					
                                bandera = true;//Existe Empleado como Director de otro Departamento
                        }

                }
        }
        return bandera;

    }

    public static boolean comprobarEmpleado (String dni) {
        boolean bandera = false;

        for(Empleado empleado : EmpresaServicio.listaEmpleados) {

                if(empleado.getDni().equals(dni)) {
                        bandera = true;
                }

        }
        return bandera;		
    }

}
