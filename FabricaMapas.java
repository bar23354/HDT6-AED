/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
  */

import java.util.HashMap;
import java.util.*;

public class FabricaMapas {

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
