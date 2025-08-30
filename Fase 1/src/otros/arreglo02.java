import java.util.Scanner;

public class arreglo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del arreglo: ");
        int numero = scanner.nextInt();
        int[] arreglo = new int[numero];
        System.out.println("Ingrese los elementos del arreglo:");
        agregarElementos(scanner, arreglo);
        double promedios = promedio(arreglo);
        System.out.println("El promedio de los elementos es: " + promedios);
        scanner.close();
    }
    public static void agregarElementos(Scanner s, int[] arr) {
      for (int i = 0; i<arr.length; i++){
        arr[i] = s.nextInt();
      }
    }
    public static double promedio(int[] arr) {
      int sum = 0;
      int tamanio = arr.length;
      for (int i = 0; i < tamanio; i++) {
        sum += arr[i];
      }
      return (double) sum / tamanio;
    }
}
