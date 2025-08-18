import java.util.Scanner;

public class AnalisisArreglo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el tamaño del arreglo: ");
        int n = scanner.nextInt();
        int[] arreglo = new int[n];
        System.out.println("Introduce los elementos del arreglo:");
        leerArreglo(scanner, arreglo);
        double promedio = calcularPromedio(arreglo);
        System.out.println("El promedio de los elementos es: " + promedio);
    }

    // Función para leer los elementos del arreglo
    public static void leerArreglo(Scanner scanner, int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = scanner.nextInt();
        }
    }

    // Función para calcular el promedio de los elementos del arreglo
    public static double calcularPromedio(int[] arreglo) {
        int suma = 0;
        for (int num : arreglo) {
            suma += num;
        }
        return (double) suma / arreglo.length;
    }
}