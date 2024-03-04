/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
  */

  import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Seleccionar la implementación del mapa
        System.out.print("\nIngrese el tipo de mapa a utilizar (HashMap, TreeMap, LinkedHashMap): ");
        String tipoMapa = Utilidades.leerEntrada();; 
        Map<String, Carta> mapa = FabricaMapas.crearMapa(tipoMapa);

        // Leer el archivo y crear el mazo
        LectorArchivo lector = new LectorArchivo();
        Map<String, String> cartas = lector.leerArchivo("cards_desc.txt");
        Mazo mazo = new Mazo(mapa);
        for (Map.Entry<String, String> entry : cartas.entrySet()) {
            mazo.agregarCarta(new Carta(entry.getKey(), entry.getValue(), 1));
        }

        // Crear una instancia de InterfazGrafica y pasar el mazo
        InterfazGrafica interfaz = new InterfazGrafica(mazo);
        interfaz.mostrarMenu();
    }
}
