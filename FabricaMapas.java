/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
 * 
 * Esta clase se encarga de devolver la implementación hija de Map que escoja el usuario
 * es decir, devuelve una instancia de HashMap, TreeMap o LinkedHashMap
 */

import java.util.HashMap;
import java.util.*;

public class FabricaMapas {

    
    /** 
     * @param tipoMapa
     * @return Map<String, Carta>
     * Función que devuelve la implementación que desee utilizar el usuario
     */
    
     public static Map<String, Carta> crearMapa(String tipoMapa) {
        switch (tipoMapa) {
            case "HashMap":
                return new HashMap<>();
            case "TreeMap":
                return new TreeMap<>();
            case "LinkedHashMap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido: " + tipoMapa);
        }
    }

}
