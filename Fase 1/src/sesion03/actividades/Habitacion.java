package sesion03.actividades;

public abstract class Habitacion {
  private String numero;
  // private double tamanio; por ahora no pide
  private double precio;
  private String disponible; // disponible, reservada, ocupada, limpieza
  
  public Habitacion(String numero, double precio, String disponible) {
    this.numero = numero;
    this.precio = precio;
    this.disponible = disponible;
  }
  public String getNumero() { return numero; }
  public void setNumero(String numero) { this.numero = numero; }
  public double getPrecio() { return precio; }
  public void setPrecio(double precio) { this.precio = precio; }
  public String getDisponible() { return disponible; }
  public void setDisponible(String disponible) { this.disponible = disponible; }
  
  public abstract boolean disponibilidad();
  // limpiar()
  // calcularPrecio()
  public String toString() {
    return "Habitacion numero=" + numero + " + " + precio + " + precio + " + disponible + " + disponible +";
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