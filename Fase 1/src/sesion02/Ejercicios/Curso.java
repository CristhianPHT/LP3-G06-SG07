package sesion02.Ejercicios;

import java.util.Vector;

public class Curso {
  private static int cont = 100;    // Atributo de clase (para generar IDs únicos)
  private int id;    // Atributo de instancia (único para cada curso)
  private String nombre;    // Atributo de instancia  (nombre del curso)
  private Profesor docente;    // Atributo de instancia (docente  del curso, relación de agregación)
  private Vector<Estudiante> estudiantes;    // Atributo de instancia (lista de estudiantes, relación de agregación)
  private int numEstudiantes = 0;    // Atributo de instancia (contador de estudiantes matriculados)
  private static final int MAX_ESTUDIANTES = 25;    // Constante (límite máximo de estudiantes por curso)
  public Curso(String nombre){  // Constructor
    this.id = cont;
    this.nombre = nombre;
    this.estudiantes = new Vector<>();
    cont++;
  }
  // Métodos de acceso (getters y setters)
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public Profesor getDocente() { return docente; }
  public void setDocente(Profesor docente) { this.docente = docente; }

  public Vector<Estudiante> getEstudiantes() { return estudiantes; }    // Obtenemos una lista de estudiantes del curso

  public int getNumEstudiantes() { return numEstudiantes; }   // Obtenemos el número de estudiantes matriculados

  public void asignarDocente(Profesor persona) {  persona.inscribir(this); }  // Uso interface Inscripcion.incribir() para agregar al curso

  public void agregarEstudiante(Estudiante estu) { 
    if (numEstudiantes >= MAX_ESTUDIANTES) {    // contador supera al máximo permitido por curso
      System.out.println("No se pueden agregar más estudiantes, cupo lleno.\n");
    } else {
      estu.inscribir(this);
    }
  }
  public void masUnoEstudiante() { numEstudiantes++; }  // set(numEstudiantes), más 1 estudiante al curso

  public void cantidadMatriculados() {
    if (numEstudiantes != 0) {    // verfica si hay estudiantes matriculados
      System.out.println("Curso: " + nombre + "\n" + "N° de estudiantes matriculados: " + numEstudiantes + "\n");
    } else {
      System.out.println("Curso: " + nombre + "\n" + "No hay estudiantes matriculados."  + "\n");
    }
   }
  
  @Override
  public String toString() {   // Muestra la información del curso
    String cursoInfo = "Nombre: " + nombre + "\n";
    String docenteInfo = (docente != null) ? "Docente: " + docente.getNombre() + "\n" : "Docente: No asignado\n"; // Operador ternario
    String estudianteInfo = "Estudiantes:\n";
    if (estudiantes.isEmpty()) {
        estudianteInfo += "- Ninguno\n";
    } else {
        for (Estudiante estu : estudiantes) {
            estudianteInfo += "- " + estu.getNombre() + "\n";
        }
    }
    return cursoInfo + docenteInfo + estudianteInfo;
}
}
