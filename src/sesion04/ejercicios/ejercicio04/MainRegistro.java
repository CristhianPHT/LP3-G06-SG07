package ejercicio04;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class MainRegistro {
	public static void main(String[] args) {
		RegistroEstudiantes registro = new RegistroEstudiantes(5);
		Scanner sc = new Scanner (System.in);
		
		boolean salir = false;
		
		while (!salir) {
			System.out.println("\n MENÚ DE REGISTRO DE ESTUDIANTES");
			System.out.println("1. Agregar estudiante");
			System.out.println("2. Buscar estudiante");
			System.out.println("3. Listar estudiantes");
			System.out.println("4. Salir");
			System.out.println("Seleccione una opción: ");
			
			try {
				int opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
				case 1:
					System.out.print("Ingrese el nombre del estudiante: ");
					String nombre = sc.nextLine();
					
					if (nombre.trim().isEmpty()) {
						System.out.print("Error de datos: El nombre no puede estar vacío.");
						break;
					}
					
					try {
						registro.agregarEstudiante(nombre);
						System.out.println("Estudiante agregado correctamente.");
					} catch (IllegalArgumentException e) {
						System.out.println("Error de datos: " + e.getMessage());
					}
					break;
					
				case 2:
					System.out.print("Ingrese el nombre del estudiante a buscar: ");
					String buscar = sc.nextLine();
					
					try {
						String encontrado = registro.buscarEstudiante(buscar);
						System.out.println("Estudiante encontrado: " + encontrado);
					} catch (NoSuchElementException e) {
						System.out.println("Búsqueda fallida: " + e.getMessage());
					}
					break;
					
				case 3:
					registro.listarEstudiantes();
					break;
					
				case 4:
					System.out.println("Saliendo del programa...");
					salir = true;
					break;
					
				default:
					System.out.println("Opción no válida. Intente de nuevo.");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Error de datos: " + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Búsqueda fallida: " + e.getMessage());
			}
		}
	}
}
