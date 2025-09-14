package ejercicio04;
import java.util.NoSuchElementException;

class RegistroEstudiantes {
	private String[] estudiantes;
	private int contador;
	
	public RegistroEstudiantes(int capacidad) {
		estudiantes = new String[capacidad];
		contador = 0;
	}
	
	public void agregarEstudiante(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo o vacío.");
		}
		if (contador >= estudiantes.length) {
			throw new IllegalArgumentException("No se puede agregar más estudiantes.");
		}
		estudiantes[contador++] = nombre;
	}
	
	public String buscarEstudiante(String nombre) {
		for (int i = 0; i < contador; i++) {
			if (estudiantes[i].equalsIgnoreCase(nombre)) {
				return estudiantes[i];
			}
		}
		throw new NoSuchElementException("Estudiante '" + nombre + "' no encontrado.");
	}
	
	public void listarEstudiantes() {
		if (contador == 0) {
			System.out.println("No hay estudiantes registrados.");
			return;
		}
		System.out.println("Lista de estudiantes registrados:");
		for (int i = 0; i < contador; i++) {
			System.out.println((i + 1) + ". " + estudiantes[i]);
		}
	}
}
