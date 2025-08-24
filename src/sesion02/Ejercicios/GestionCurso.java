package sesion02.Ejercicios;

import java.util.HashMap;   // Para almacenar cursos y personas por el id que poseen
import java.util.Scanner;   // Para entrada de datos
  /*
1. Clases y Objetos:
• Crear clases que representen entidades como Estudiante, Profesor, Curso, SistemaGestion, entre otras.
• Cada clase debe tener atributos y métodos específicos.
• Identifique cuales de los atributos son de instancia para cada clase y cuales son de clase.
Así mismo, los métodos de instancia y de clase para cada clase.
• Identificar la posibilidad de utilizar constantes para valores que no cambian durante la ejecución del programa.
• Identifique las relaciones de agregación y composición entre las clases.
• Instanciar objetos de las clases para representar los elementos del sistema (por ejemplo, crear objetos que representen estudiantes y cursos específicos).
2. Herencia:
• Definir por lo menos una jeraquía de clases, en la cual se pueda definir clases abstractas con métodos abstractos.
3. Polimorfismo:
• Identificar cuales de los métodos son polimórfico
*/
public class GestionCurso {    // Clase principal para gestionar cursos, estudiantes y profesores
  HashMap<Integer, Curso> cursos;   // Almacena cursos con su ID como clave
  HashMap<Integer, Persona> personas;   // Almacena personas (estudiantes y profesores) con su ID como clave

  public GestionCurso() {   // Constructor que inicializa los HashMaps para cursos y personas
    cursos = new HashMap<>();
    personas = new HashMap<>();
  }

  public void mostrarPersonas(int tipo) {   // Muestra datos clave por el tipo: 1-Docentes, 2-Estudiantes, 3-Personas
    if (tipo == 1) {
      System.out.println("----- Lista de Docentes -----");
      for (Persona p : personas.values()) {
        if (p instanceof Profesor) {
          p.listarDatos();
        }
      }
    } else if (tipo == 2) {
      System.out.println("----- Lista de Estudiantes -----");
      for (Persona p : personas.values()) {
        if (p instanceof Estudiante) {
          p.listarDatos();
        }
      }
    } else if (tipo == 3) {
      System.out.println("----- Lista de Personas -----");
      for (Persona p : personas.values()) {
        p.listarDatos();
      }
    }
  }

  public void mostrarCursos() {     // Muestra datos clave de los cursos
    System.out.println("----- Lista de Cursos -----");
    for (Curso c : cursos.values()) {
      System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre());
    }
  }

  public static void mostrarMenu() {    // Muestra el menú de opciones
    System.out.println("----- Gestión de Cursos -----");
    System.out.println("1. Crear Curso");
    System.out.println("2. Crear Docente");
    System.out.println("3. Crear Estudiante");
    System.out.println("4. Asignar Docente a Curso");
    System.out.println("5. Agregar Estudiante a Curso");
    System.out.println("6. Mostrar Información de Curso");
    System.out.println("7. Mostrar Cantidad de Estudiantes Matriculados en un Curso");
    System.out.println("0. Salir");
    System.out.print("Seleccione una opción: ");
  }

  public void menu() {    // Lógica del menú para gestionar cursos, docentes y estudiantes
    Scanner sc = new Scanner(System.in);
    int opcion;
    do {
      mostrarMenu();
      opcion = sc.nextInt(); sc.nextLine();     // 'sc.nextInt()' pide el dato y 'sc.nextLine()' limpia Scanner de entrada
      switch (opcion) {
        case 1: // Crear Curso
          System.out.print("Ingrese el nombre del curso: ");
          String nombreCurso = sc.nextLine();
          Curso nuevoCurso = new Curso(nombreCurso);
          cursos.put(nuevoCurso.getId(), nuevoCurso);   // Agregamos el curso al HashMap
          System.out.println("Curso " + nuevoCurso.getNombre() + " creado con ID: " + nuevoCurso.getId()+"\n");
          break;
        case 2: // Crear Docente
          System.out.print("Ingrese el nombre del docente: ");
          String nombreDocente = sc.nextLine();
          System.out.print("Ingrese la fecha de nacimiento del docente (dd/mm/yyyy): ");  // sin validación de formato
          String fechaDocente = sc.nextLine();
          Profesor nuevoDocente = new Profesor(nombreDocente, fechaDocente);
          personas.put(nuevoDocente.getId(), nuevoDocente);   // Agregamos el docente al HashMap
          System.out.println("Docente " + nuevoDocente.getNombre() + " creado con ID: " + nuevoDocente.getId() +"\n");
          break;
        case 3: // Crear Estudiante
          System.out.print("Ingrese el nombre del estudiante: ");
          String nombreEstudiante = sc.nextLine();
          System.out.print("Ingrese la fecha de nacimiento del estudiante (dd/mm/yyyy): "); // sin validación de formato
          String fechaEstudiante = sc.nextLine();
          Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, fechaEstudiante);
          personas.put(nuevoEstudiante.getId(), nuevoEstudiante);   // Agregamos el estudiante al HashMap
          System.out.println("Estudiante " + nuevoEstudiante.getNombre() + " creado con ID: " + nuevoEstudiante.getId()+"\n");
          break;
        case 4: // Asignar Docente a Curso
          if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles. Cree un curso primero.");
          } else {
            System.out.println("Cursos disponibles:");
            mostrarCursos();
            System.out.print("Ingrese el ID del curso: ");
            int idCurso = sc.nextInt(); sc.nextLine();
            if (cursos.get(idCurso).getDocente() != null) { // Ya tiene docente = no hay cambios de docente
              System.out.println("El curso ya tiene un docente asignado.");
            } else {
              mostrarPersonas(1); // Mostrar docentes
              System.out.print("Ingrese el ID del docente: ");
              int idDocente = sc.nextInt(); sc.nextLine();
              cursos.get(idCurso).asignarDocente((Profesor) personas.get(idDocente));   // Asignamos el docente al curso, casting a Profesor
              System.out.println("Docente asignado al curso.\n");
            }
          }
          break;
        case 5: // Agregar Estudiante a Curso
          if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles. Cree un curso primero.\n");
          } else {
            System.out.println("Cursos disponibles:");
            mostrarCursos();
            System.out.print("Ingrese el ID del curso: ");
            int idCurso = sc.nextInt(); sc.nextLine();
            if (cursos.get(idCurso).getDocente() == null) {
              System.out.println("El curso no tiene un docente asignado. Asigne un docente primero.\n");
            } else {
              mostrarPersonas(2); // Mostrar estudiantes
              System.out.print("Ingrese el ID del estudiante: ");
              int idEstudiante = sc.nextInt(); sc.nextLine();
              cursos.get(idCurso).agregarEstudiante((Estudiante) personas.get(idEstudiante));  // Agregamos el estudiante al curso, casting a Estudiante
              System.out.println("Estudiante agregado al curso.\n");
            }
          }
          break;
        case 6: // Mostrar Información de Curso
          if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles.");
          } else {
            mostrarCursos();
            int idCurso = sc.nextInt(); sc.nextLine();
            System.out.println(cursos.get(idCurso).toString());   // Obtenemos el curso, obtenemos String con información e imprime
          }
          break;
        case 7: // Mostrar Cantidad de Estudiantes Matriculados en un Curso
          if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles.");
          } else {
            mostrarCursos();
            int idCurso = sc.nextInt(); sc.nextLine();
            cursos.get(idCurso).cantidadMatriculados();   // imprime N° de estudiantes matriculados
          }
          break;
        case 0:
          System.out.println("Saliendo del sistema...");
          break;
        default:
          System.out.println("Opción no válida. Intente de nuevo.");
      }
    } while (opcion != 0);
    sc.close();
  }
}
