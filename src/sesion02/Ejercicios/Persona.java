package sesion02.Ejercicios;

public abstract class Persona {   // Clase abstracta Persona
  private static int codigo = 1000;  // Atributo de clase (para generar IDs únicos)
  private int id;   // Atributo de instancia (único para cada persona)
  private String nombre;  // Atributo de instancia (nombre de la persona)
  private String nacimiento;  // Atributo de instancia (fecha de nacimiento)
  private String ocupacion; // Atributo de instancia (ocupación: Estudiante o Profesor u otro)
  public Persona(String nombre, String nacimiento, String ocupacion){   // Constructor
    this.id = codigo;
    this.nombre = nombre;
    this.nacimiento = nacimiento;   // formato dd/mm/yyyy
    this.ocupacion = ocupacion;
    codigo++; // Incrementa el código para el siguiente ID
  }
  // Métodos de acceso (getters y setters)
  public int getId() { return id;}
  public String getNombre(){return nombre;}
  public String getNacimiento() { return nacimiento;}
  public String getOcupacion() { return ocupacion;}
  public void setId(int newId) { id = newId;}
  public void setNombre(String n) {nombre = n;}
  public void setNacimiento(String na) { nacimiento = na;}
  public void setOcupacion(String o) { ocupacion = o;}

  public void listarDatos(){  // Muestra el ID y nombre de la persona
    System.out.println("ID: " + id + " : " + nombre);
  }

  public String toString(){   // Muestra toda la información de persona
    return ("Id: " + id + " - Nombre: "+nombre + " - Fecha de Nacimiento: " + nacimiento + " - Ocupación: "+ocupacion);
  }
}
