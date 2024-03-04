import java.util.HashMap;
import java.util.Map;

public class InterfazGrafica {

    private Mazo mazo;

    public InterfazGrafica(Mazo mazo) {
        this.mazo = mazo;
    }

    public void mostrarMenu(Map<String, String> cartasSistema) {
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
                    agregarCarta(cartasSistema);
                    break;
                case 2:
                    mostrarTipoCarta(cartasSistema);
                    break;
                case 3:
                    mazo.mostrarTodasLasCartas();
                    break;
                case 4:
                    mazo.mostrarCartasPorTipo();
                    break;
                case 5:
                    mostrarTodasLasCartasDisponibles(cartasSistema);
                    break;
                case 6:
                    mostrarTodasLasCartasDisponiblesOrdenadasPorTipo(cartasSistema);
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

    private void agregarCarta(Map<String, String> cartasSistema) {
        System.out.print("\nIngrese el nombre de la carta que desea agregar: ");
        String nombreCarta = Utilidades.leerEntrada();
        System.out.println("\nIngrese el tipo de la carta (Monstruo, Trampa, Hechizo): ");
        String tipoCarta = Utilidades.leerEntrada();

        if (cartasSistema.containsKey(nombreCarta)) {
            Carta carta = new Carta(nombreCarta, tipoCarta, 1);
            mazo.agregarCarta(carta);
            System.out.println("\n\n¡Carta agregada a la colección!");
        } else {
            System.out.println("\nLa carta " + nombreCarta + " no se encuentra en el sistema.");
        }
    }

    private void mostrarTipoCarta(Map<String, String> cartasSistema) {
        System.out.print("\nIngrese el nombre de la carta: ");
        String nombreCarta = Utilidades.leerEntrada();
       
        if (cartasSistema.containsKey(nombreCarta)) {
            System.out.println("\nLa carta '" + nombreCarta + "' es de tipo: " + cartasSistema.get(nombreCarta));
        } else {
            System.out.println("\nLa carta '" + nombreCarta + "' no se encuentra en las cartas del sistema.");
        }
    }

    private void mostrarTodasLasCartasDisponibles(Map<String, String> cartasSistema) {
        for (Map.Entry<String, String> entry : cartasSistema.entrySet()) {
            System.out.println("\nNombre de la carta: " + entry.getKey() + ", Tipo: " + entry.getValue());
        }
    }

    private void mostrarTodasLasCartasDisponiblesOrdenadasPorTipo(Map<String, String> cartasSistema) {
        Map<String, Integer> cartasPorTipo = new HashMap<>();
        for (Map.Entry<String, String> entry : cartasSistema.entrySet()) {;
            cartasPorTipo.put(entry.getValue(), cartasPorTipo.getOrDefault(entry.getValue(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : cartasPorTipo.entrySet()) {
            String tipoCarta = entry.getKey();
            
            System.out.println("Tipo de carta: " + tipoCarta);
            System.out.println("Cantidad total: " + entry.getValue());
            
            System.out.println("Nombres de las cartas correspondientes:");
            for (Map.Entry<String, String> carta : cartasSistema.entrySet()) {
                if (carta.getValue().equals(tipoCarta)) {
                    System.out.println("- " + carta.getKey());
                }
            }
            System.out.println(); 
        }
    }

}
