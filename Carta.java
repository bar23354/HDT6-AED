/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
  */

/**
 * La clase Carta representa una carta individual.
 * Cada carta tiene un nombre, un tipo y una cantidad.
 */
public class Carta {

    private String nombre;
    private String tipo;
    private int cantidad;

    /**
     * Construye una nueva Carta con el nombre, tipo y cantidad dados.
     * @param nombre el nombre de la carta
     * @param tipo el tipo de la carta
     * @param cantidad la cantidad de la carta
     */
    public Carta(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el nombre de esta carta.
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de esta carta.
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo de esta carta.
     * @return el tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de esta carta.
     * @param tipo el nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la cantidad de esta carta.
     * @return la cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de esta carta.
     * @param cantidad la nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve una representación en cadena de esta carta.
     * @return una cadena que representa esta carta
     */
    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
