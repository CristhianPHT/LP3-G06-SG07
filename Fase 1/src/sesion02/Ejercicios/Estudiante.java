package sesion02.Ejercicios;

public class Estudiante extends Persona implements Inscripcion{
  
  public Estudiante(String nombre, String nacimiento){    // constructor propio de Estudiante
    super(nombre, nacimiento, "Estudiante");    // Llama al constructor de la clase abstracta base (Persona)
  }

  @Override   // Polimorfismo: implementación del método de interfaz Inscripcion
  public void inscribir(Curso c) {  // inteface para inscribir estudiante a un curso
    if (c.getDocente() != null) {   // verifica si el curso tiene un docente asignado
      c.getEstudiantes().add(this);   // agrega el estudiante a la lista de estudiantes del curso
      c.masUnoEstudiante();   // Agregamos un estudiante al contador del curso
    } else {    // docente no asignado, no se puede inscribir
      System.out.println("El curso no tiene un docente asignado");    
      return;
    }
  }
} 
