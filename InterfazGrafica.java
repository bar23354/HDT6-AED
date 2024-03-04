import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InterfazGrafica {

    private Mazo mazo;

    public InterfazGrafica(Mazo mazo) {
        this.mazo = mazo;
    }

    public void mostrarMenu() {
        int option = 0;

        while (option != 7) {
            System.out.println("\n\n--- Menú Principal ---");
            System.out.println("\n1. Agregar una carta a la colección");
            System.out.println("\n2. Mostrar el tipo de una carta específica");
            System.out.println("\n3. Mostrar todas las cartas en la colección");
            System.out.println("\n4. Mostrar todas las cartas en la colección ordenadas por tipo");
            System.out.println("\n5. Mostrar todas las cartas existentes");
            System.out.println("\n6. Mostrar todas las cartas existentes ordenadas por tipo");
            System.out.println("\n7. Salir del programa");
            System.out.print("\n\nSeleccione una opción: ");

            try {
                option = Utilidades.leerEntero();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            switch (option) {
                case 1:
                    agregarCarta();
                    break;
                case 2:
                    mostrarTipoCarta();
                    break;
                case 3:
                    mazo.mostrarTodasLasCartas();
                    break;
                case 4:
                    mazo.mostrarCartasPorTipo();
                    break;
                case 5:
                    mostrarTodasLasCartasDisponibles();
                    break;
                case 6:
                    mostrarTodasLasCartasDisponiblesOrdenadasPorTipo();
                    break;
                case 7:
                    System.out.println("\n¡Hasta luego!");
                    // break;
                    return;// ver si cambiar por break
                default:
                    System.out.println("\nOpción no válida. Por favor, seleccione una opción del menú.");
            }
        }
    }

    private void agregarCarta() {
        System.out.print("\nIngrese el nombre de la carta que desea agregar: ");
        String nombreCarta = Utilidades.leerEntrada();
        System.out.println("\nIngrese el tipo de la carta (monstruo, trampa, hechizo): ");
        String tipoCarta = Utilidades.leerEntrada();
        Carta carta = new Carta(nombreCarta, tipoCarta, 1);
        mazo.agregarCarta(carta);
        System.out.println("\n\n¡Carta agregada a la colección!");
    }

    private void mostrarTipoCarta() {
        System.out.print("\nIngrese el nombre de la carta: ");
        String nombreCarta = Utilidades.leerEntrada();
        Carta carta = mazo.buscarCarta(nombreCarta);
        if (carta != null) {
            System.out.println("\nLa carta '" + nombreCarta + "' es de tipo: " + carta.getTipo());
        } else {
            System.out.println("\nLa carta '" + nombreCarta + "' no se encuentra en la colección.");
        }
    }

    private void mostrarTodasLasCartasDisponibles() {
        System.out.println("\nTodas las cartas de la colección");
        for (Map.Entry<String, String> entry : cartas.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
        }
    }

    private void mostrarTodasLasCartasDisponiblesOrdenadasPorTipo() {
        System.out.println("--- Todas las cartas disponibles ordenadas por tipo ---");

        Map<String, List<String>> cartasPorTipo = new HashMap<>();
        for (Map.Entry<String, String> entry : cartas.entrySet()) {
            String tipo = entry.getValue();
            String nombre = entry.getKey();
            cartasPorTipo.putIfAbsent(tipo, new ArrayList<>());
            cartasPorTipo.get(tipo).add(nombre);
        }

        // Ordenar las listas por tipo
        cartasPorTipo.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e -> {
                    System.out.println("Tipo: " + e.getKey());
                    for (String nombre : e.getValue()) {
                        System.out.println("- " + nombre);
                    }
                });
    }

}
