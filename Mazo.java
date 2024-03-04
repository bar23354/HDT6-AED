/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
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
        if(c == 0){
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

    //por si acaso
    // public void mostrarTodasLasCartasDisponibles() {
    //     System.out.println("\nTodas las cartas de la colección:");
    //     for (Carta carta : cartas.values()) {
    //         System.out.println("Nombre: " + carta.getNombre() + ", Tipo: " + carta.getTipo());
    //     }
    // }

    // public void mostrarTodasLasCartasDisponiblesOrdenadasPorTipo() {
    //     Map<String, List<String>> cartasPorTipo = new HashMap<>();

    //     // Agrupar cartas por tipo
    //     for (Carta carta : cartas.values()) {
    //         String tipo = carta.getTipo();
    //         String nombre = carta.getNombre();
    //         cartasPorTipo.putIfAbsent(tipo, new ArrayList<>());
    //         cartasPorTipo.get(tipo).add(nombre);
    //     }

    //     // Ordenar las listas de cartas por tipo
    //     for (List<String> lista : cartasPorTipo.values()) {
    //         Collections.sort(lista);
    //     }

    //     // Mostrar cartas ordenadas por tipo
    //     System.out.println("\nTodas las cartas disponibles ordenadas por tipo:");
    //     for (Map.Entry<String, List<String>> entry : cartasPorTipo.entrySet()) {
    //         String tipo = entry.getKey();
    //         List<String> lista = entry.getValue();
    //         System.out.println("Tipo: " + tipo);
    //         for (String nombre : lista) {
    //             System.out.println("- " + nombre);
    //         }
    //     }
    // }
}