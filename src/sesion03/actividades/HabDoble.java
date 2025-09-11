package sesion03.actividades;

public class HabDoble extends Habitacion {
  // private boolean camasMatrimoniales;
  
  public HabDoble(String numero, String disponible) {
    super(numero, 100, disponible);
    // this.camasMatrimoniales = camasMatrimoniales;
  }
  
  @Override
  public boolean disponibilidad() {
    return true;
  }

  public String toString() {
    return "Habitación Doble: " + /* camasMatrimoniales + */ super.toString() + "";
  }
  
}
