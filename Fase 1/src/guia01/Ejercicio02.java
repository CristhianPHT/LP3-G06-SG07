package guia01;
import java.util.Scanner;

/*
El usuario ingresará números en un arreglo unidimensional de 10,
cada número que ingrese el usuario debe ser mayor al anterior. Guarde estos números en el arreglo.
*/
public class Ejercicio02 {
  public static void main(String[] args) {
    int[] arreglo = new int[10];
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el primer número: ");
    arreglo[0] = scanner.nextInt();
    for (int i = 1; i < arreglo.length; i++) {        
      int num;
      do {
        System.out.print("Ingrese un número mayor que " + arreglo[i - 1] + ": ");
        num = scanner.nextInt();
      } while (num <= arreglo[i - 1]);
      arreglo[i] = num; 
    }
    System.out.println("Números en el arreglo:");
    for (int num : arreglo) {
      System.out.println(num+" ");
    }
    scanner.close();
  }
}
