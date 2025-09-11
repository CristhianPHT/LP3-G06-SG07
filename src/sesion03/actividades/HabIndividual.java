package sesion03.actividades;

public class HabIndividual extends Habitacion {
  // private boolean camaSencilla;
  private static int contador = 0;
  
  public HabIndividual(String numero, String disponible) {
    super(numero, 80, disponible);
    // this.camaSencilla = camaSencilla;
  }

  public static int getContador() { return contador; }
  public static void agregarHabitacion() { contador++; }
  public static void eliminarHabitacion() { contador--; }
  
  @Override
  public boolean disponibilidad() {
    // "HabIndividual: " + super.toString() + "disponibilidad: " + "Disponible";
    return false;
  }

  public String toString() {
    return "Habitación individual: " + /* camaSencilla + */ super.toString() + "";
  }
}
