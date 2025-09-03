package sesion03.actividades;

public class Cliente extends Persona {
  public Cliente( String nombre, int telefono, String email, int identificacion) {
    super(nombre, telefono, email, identificacion);
  }

  public String toString() {
    return "Cliente->" + super.toString();
  }
}
