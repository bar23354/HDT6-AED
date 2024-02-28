/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
  */

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    LectorArchivo lector = new LectorArchivo();
    HashMap<String, String> cartas = lector.leerArchivo("nombre_del_archivo.txt");
    seleccionaImplementacionMap();
    muestraMenu(cartas);

  }

  public static void seleccionaImplementacionMap() {
    InterfazGrafica inter = new InterfazGrafica();
    inter.mostrarMenu();
  }

  public static void muestraMenu(HashMap<String, String> cartas) {

  }

}
