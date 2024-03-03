/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
  */

import java.util.Scanner;

public class Utilidades {

    private static Scanner scanner = new Scanner(System.in);

    /** 
     * @param mensaje
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    /** 
     * @return String
     */
    public static String leerEntrada() {
        return scanner.nextLine();
    }
    
    /** 
     * @return int
     */
    public static int leerEntero() {
        return Integer.parseInt(scanner.nextLine());
    }

    /** 
     * @param entrada
     * @return boolean
     */
    public static boolean validarEntradaSiNo(String entrada) {
        return entrada.equalsIgnoreCase("si") || entrada.equalsIgnoreCase("no");
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J"); //ANSI "escape code" de acuerdo con Google
        System.out.flush();
    }

}