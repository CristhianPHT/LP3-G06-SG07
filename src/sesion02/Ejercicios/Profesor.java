package sesion02.Ejercicios;

public class Profesor extends Persona implements Inscripcion{   // Clase herada de Persona e implementa la interface Inscripcion
  public Profesor(String n, String fecha) {   // constructor propio de Profesor
    super(n,fecha, "Profesor");   // Llama al constructor de la clase abstracta base (Persona)
  }
  @Override   // Polimorfismo: implementación del método de interfaz Inscripcion
  public void inscribir(Curso c) {    // inteface para inscribir docente a un curso
    if (c.getDocente() != null) {   // verifica si el curso ya tiene un docente asignado
      System.out.println("El curso ya tiene un docente asignado");
    } else {
      c.setDocente(this);   // asigna el docente al curso
    }
  }
}
