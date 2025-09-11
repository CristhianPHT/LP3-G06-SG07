package sesion03.actividades;

import java.util.HashMap;

public abstract class Habitacion {
    private static HashMap<Class<?>, Integer> contadorPorTipo = new HashMap<>();
    private String numero;
    private double precio;
    private String disponible; // disponible, reservada, ocupada, limpieza
    
    public Habitacion(String numero, double precio, String disponible) {
      this.numero = numero;
      this.precio = precio;
      this.disponible = disponible;
      Class<?> tipo = getClass();
      contadorPorTipo.put(tipo, contadorPorTipo.getOrDefault(tipo, 0) + 1);
    }

    public static int getContador(Class<?> tipo) {
        return contadorPorTipo.getOrDefault(tipo, 0);
    }
    public static void agregarHabitacion(Class<?> tipo) {
        contadorPorTipo.put(tipo, contadorPorTipo.get(tipo) + 1);
    }
    public static void eliminarHabitacion(Class<?> tipo) {
      int contadorActual = contadorPorTipo.getOrDefault(tipo, 0);
      if (contadorActual > 0) {
        contadorPorTipo.put(tipo, contadorActual - 1);
      }
    }
    
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getDisponible() { return disponible; }
    public void setDisponible(String disponible) { this.disponible = disponible; }
    
    public boolean disponibilidad(){
      return "disponible".equals(this.disponible);  // true si está disponible
    }
    // limpiar()
    // calcularPrecio()
    public String toString() {
      return "numero: " + numero + ", precio: "  + precio +  ", disponible: " + disponible;
    } 
}

// fechas:
/* example: 
Check-in: 10 de septiembre

Check-out: 11 de septiembre

Cantidad de noches: 1
*/

// Individual	S/ 80 – S/ 120
// Doble	S/ 100 – S/ 150
// Triple	S/ 150 – S/ 200
// Familiar	S/ 200 – S/ 300

// Número de camas / capacidad
// Servicios adicionales (wifi, desayuno, etc.)