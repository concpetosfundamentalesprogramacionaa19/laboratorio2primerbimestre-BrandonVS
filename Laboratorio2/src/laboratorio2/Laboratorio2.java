/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;
import java.util.Scanner;
/**
 *
 * @author BrandonVS
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        // Se crean las variables
        String reporte;// Variable que acumulara todos los datos del reporte
        int cont1 = 1;// Contador para controlar el numero de reportes
        int cont2 = 1;// Contador para el numero de hijos de cada padre
        int cont3 = 1;// Contador para controlar el numero en "Fin reporte N"
        boolean bandera = true;// Bandera para el primer while
        boolean bandera2 = true;// Bandera para el segundo while
        double tpasaje = 0;// Total del costo de pasajes
        double apasaje = 0;// Auxiliar para sumar el costo de pasajes
        double tbar = 0;// Total del costo de bares
        double abar = 0;// Auxiliar para sumar el costo de bares
        double tsalida = 0;// Total del costo de salidas
        double asalida = 0;// Auxiliar para sumar el costo de salidas
        
        // Se acumila el titulo del reporte
        reporte = String.format("Reporte gastos de padres de familia");
        System.out.print("Reporte de gastos de los padres de familia: ");
        
        // Ciclo while para el ingreso de datos
        while(bandera==true){
            
            //Se le piden los datos al usuario
            System.out.println("\nIngrese su nombre y apellido: ");
            String nom = scan.nextLine();
            
            System.out.println("Ingrese su sueldo semanal: ");
            double sueldo = scan.nextDouble();
            
            System.out.println("Ingrese cuantos hijos tiene: ");
            int hijos = scan.nextInt();
            scan.nextLine();
            
            // Se acumulan los datos previamente ingresados
            reporte = String.format("%s\n\nReporte N%d\n\nNombre: %s\nSueldo: "
                    + "%.2f\nHijos: %d\n\nPersonas   Pasajes\tBares\tSalidas\n"
                    , reporte, cont1, nom, sueldo, hijos);
            
            // Ciclo while para el ingreso de los costos por hijo
            while(bandera2==true){
                
                // Se le piden los datos al usuario
                System.out.printf("Ingrese el gasto en pasajes del hijo %d: ",
                        cont2);
                double pasaje = scan.nextInt();
                
                // Se calcula el costo total de pasajes
                tpasaje = apasaje + pasaje;
                apasaje = pasaje;
                
                System.out.printf("Ingrese el gasto en bares del hijo %d: ", 
                        cont2);
                double bar = scan.nextInt();
                
                // Se calcula el costo total de bares
                tbar = abar + bar;
                abar = bar;
                
                System.out.printf("Ingrese el gasto en salidas del hijo %d: ", 
                        cont2);
                double salida = scan.nextInt();
                scan.nextLine();
                
                // Se calcula el costo total de salidas
                tsalida = asalida + salida;
                asalida = salida;
                
                // Se acumulan los datos previamente ingresados
                reporte = String.format("%sHijo %d\t    %.2f\t%.2f\t%.2f\n", 
                        reporte, cont2, pasaje, bar, salida);
                
                // Operacion para controlar las repeticiones del ciclo
                bandera2 = cont2 < hijos;
                cont2 = cont2 + 1;
            }
            
            // Se acumulan los totales en los costos
            reporte = String.format("%sTotal\t    %.2f\t%.2f\t%.2f\n", reporte, 
                    tpasaje, tbar, tsalida);
            
            // Se le pregunta al usuario si desea seguir ingresando datos
            System.out.print("Si quiere ingresar los datos de otro padre presi"
                    + "one 's', caso contrario presione 'n'");
            String opcion = scan.nextLine();
            
            // Operacion para controlar la repeticiones del primer ciclo while
            if(opcion.equals("s")){
                cont1 = cont1 + 1;
                cont2 = 1;
                bandera = true;
                bandera2 = true;
                tpasaje = 0;
                tbar = 0;
                tsalida = 0;
                apasaje = 0;
                abar = 0;
                asalida = 0;
                
            }else{
                bandera = false;
            }
            
            /* Operacion para comprobar si el sueldo semanar de cada padre es
            suficiente para costear los gastos de sus hijos
            */ 
            if(sueldo >= tpasaje + tbar + tsalida){
                
                // Datos que se acumulan en caso de que si alcance
                reporte = String.format("%sAl padre de familia %s le alcanza el"
                        + " dinero semanal para sus gastos.\n\nFin reporte %d\n"
                        + "\n", reporte, nom, cont3);
                cont3 = cont3 + 1;
            }else{
                
                // Datos que se acumulan en caso de que no alcance
                reporte = String.format("%sAl padre de familia %s le falta el "
                        + "dinero semanal para sus gastos.\n\nFin reporte %d\n"
                        + "\n", reporte, nom, cont3);
                cont3 = cont3 + 1;
            }
        }
        
        // Impresion final de todos los reportes
        System.out.printf("%s", reporte);
    }
    
    
}
