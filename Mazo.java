/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
 * 
 * Clase que funciona como modelo de un mazo de cartas
*/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mazo extends HashMap<String, Carta> {
    private Map<String, Carta> cartas;

    public Mazo(Map<String, Carta> cartas) {
        this.cartas = cartas;
    }

    /**
     * @param carta
     */
    public void agregarCarta(Carta carta) {
        if (cartas.containsKey(carta.getNombre())) {
            Carta cartaExistente = cartas.get(carta.getNombre());
            cartaExistente.setCantidad(cartaExistente.getCantidad() + 1);
        } else {
            cartas.put(carta.getNombre(), carta);
        }
    }

    /**
     * @param nombreCarta
     */
    public void eliminarCarta(String nombreCarta) {
        if (cartas.containsKey(nombreCarta)) {
            cartas.remove(nombreCarta);
        } else {
            System.out.println("La carta " + nombreCarta + " no se encuentra en el mazo.");
        }
    }

    /**
     * @param nombreCarta
     * @return Carta
     */
    public Carta buscarCarta(String nombreCarta) {
        return cartas.get(nombreCarta);
    }

    public void mostrarTodasLasCartas() {
        int c = 0;
        for (Carta carta : cartas.values()) {
            c++;
            System.out.println(carta);
        }
        if (c == 0) {
            System.out.println("\nAún no hay cartas en la colección");
        }
    }

    public void mostrarCartasPorTipo() {
        Map<String, Integer> cartasPorTipo = new TreeMap<>();
        for (Carta carta : cartas.values()) {
            cartasPorTipo.put(carta.getTipo(), cartasPorTipo.getOrDefault(carta.getTipo(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : cartasPorTipo.entrySet()) {
            System.out.println("Tipo: " + entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }

}