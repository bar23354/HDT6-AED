/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - seccion 40
 * Nadissa Vela 23764 | Roberto Barreda 23354
 * 
 * Clase que lee el txt cards_desc para cargas las cartas al sistema 
 */
  
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LectorArchivo {

    
    /** 
     * @param fileName
     * @return HashMap<String, String>
     * función que se encarga de leer el txt con las cartas y devolver un HashMap llenado con ellas
     */
    public HashMap<String, String> leerArchivo(String fileName){
        HashMap<String, String> cartas = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while((linea = br.readLine())!= null){
                String[] carta = linea.split("\\|");
                //agregar el nombre de la carta como key y en su contenido el tipo de carta
                cartas.put(carta[0], carta[1]);
            }
            
            System.out.println("Cartas cargadas al sistema!");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return cartas;
    }
}
