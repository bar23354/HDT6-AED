/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
 * 
 * Clase que ejecuta instrucciones básicas en consola
*/

import java.util.Scanner;

public class Utilidades {

    private static Scanner scanner = new Scanner(System.in);

    /** 
     * @param mensaje
     * metodo para mostrar un mensaje en consola
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    /** 
     * @return String
     * leer input del usuario
     */
    public static String leerEntrada() {
        return scanner.nextLine();
    }
    
    /** 
     * @return int
     * leer input entero del usuario
     */
    public static int leerEntero() throws NumberFormatException {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("\nError, ingrese un número válido");
        }
    }

    /** 
     * @param entrada
     * @return boolean
     * validar input booleano
     */
    public static boolean validarEntradaSiNo(String entrada) {
        return entrada.equalsIgnoreCase("si") || entrada.equalsIgnoreCase("no");
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J"); //ANSI "escape code" de acuerdo con Google
        System.out.flush();
    }

}