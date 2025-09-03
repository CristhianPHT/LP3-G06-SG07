package sesion03.actividades;

public class HabIndividual extends Habitacion {
  // private boolean camaSencilla;
  
  public HabIndividual(String numero, String disponible, boolean camaSencilla) {
    super(numero, 80, disponible);
    // this.camaSencilla = camaSencilla;
  }
  @Override
  public boolean disponibilidad() {
    // "HabIndividual: " + super.toString() + "disponibilidad: " + "Disponible";
    return false;
  }

  public String toString() {
    return "HabIndividual [camaSencilla=" + /* camaSencilla + */ super.toString() + "]";
  }
}
