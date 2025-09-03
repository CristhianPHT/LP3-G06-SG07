package sesion03.actividades;

public class Persona {
  private String nombre;
  private int telefono;
  private String email;
  private int identificacion; // dni, pasaporte, ruc...
  public Persona(String nombre, int telefono, String email, int identificacion) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
    this.identificacion = identificacion;
  }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public int getTelefono() { return telefono; }
  public void setTelefono(int telefono) { this.telefono = telefono; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public int getIdentificacion() { return identificacion; }
  public void setIdentificacion(int identificacion) { this.identificacion = identificacion; }
  @Override
  public String toString() {
    return "nombre: " + nombre + ", telefono: " + telefono + "\nemail: " + email + ", identificacion: " + identificacion;
  }
}
/*
Gestión de Clientes:
• Registrar información de los clientes (nombre, datos de contacto, etc.).
• Asociar reservas a clientes.
• Consultar el historial de reservas de un cliente.
*/