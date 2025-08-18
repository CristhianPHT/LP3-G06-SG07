package guia01;
/*
El usuario ingresará un número de horas, de minutos y segundos y nos devuelva el equivalente en segundos.
*/
import java.util.Scanner;

public class Ejercicio06 {
  public static int convertir_Segundos(int horas, int minutos, int segundos) {
    return horas * 3600 + minutos * 60 + segundos;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese las horas: ");
    int horas = scanner.nextInt();
    System.out.print("Ingrese los minutos: ");
    int minutos = scanner.nextInt();
    System.out.print("Ingrese los segundos: ");
    int segundos = scanner.nextInt();

    int totalSegundos = convertir_Segundos(horas, minutos, segundos);
    System.out.println("El equivalente en segundos es: " + totalSegundos);
    
    scanner.close();
  }
}