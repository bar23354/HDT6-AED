/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
  */

import java.util.HashMap;
import java.util.Map;

public class Mazo extends HashMap<String, Carta> {

    public Mazo() {
        super();
    }
    
    /** 
     * @param carta
     */
    public void agregarCarta(Carta carta) {
        if (containsKey(carta.getNombre())) {
            Carta cartaExistente = get(carta.getNombre());
            cartaExistente.setCantidad(cartaExistente.getCantidad() + 1);
        } else {
            put(carta.getNombre(), carta);
        }
    }
    
    /** 
     * @param nombreCarta
     */
    public void eliminarCarta(String nombreCarta) {
        if (containsKey(nombreCarta)) {
            remove(nombreCarta);
        } else {
            System.out.println("La carta " + nombreCarta + " no se encuentra en el mazo.");
        }
    }

    
    /** 
     * @param nombreCarta
     * @return Carta
     */
    public Carta buscarCarta(String nombreCarta) {
        if (containsKey(nombreCarta)) {
            return get(nombreCarta);
        } else {
            return null;
        }
    }

    public void mostrarTodasLasCartas() {
        for (Carta carta : values()) {
            System.out.println(carta);
        }
    }

    public void mostrarCartasPorTipo() {
        Map<String, Integer> cartasPorTipo = new HashMap<>();
        for (Carta carta : values()) {
            cartasPorTipo.put(carta.getTipo(), cartasPorTipo.getOrDefault(carta.getTipo(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : cartasPorTipo.entrySet()) {
            System.out.println("Tipo: " + entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }

}