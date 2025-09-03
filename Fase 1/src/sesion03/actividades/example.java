package sesion03.actividades;

import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.Scanner;

public class example {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    LocalDate fecha = null;
    while (fecha == null) {
      try {
        System.out.print("Ingrese un año: "); // LocalDate no valida años (ni bisietos)
        int anio = sc.nextInt();
        if (anio < 1900 || anio > 2100) {
          System.out.println("Año inválido, superiores a 1900 e inferiores a 2100, intente de nuevo.");
          continue;
        }
        System.out.print("Ingrese un mes: ");
        int mes = sc.nextInt();
        if (mes < 1 || mes > 12) {
          System.out.println("Mes inválido, ingrese la fecha nuevamente.");
          continue;
        }
        System.out.print("Ingrese un día: ");
        int dia = sc.nextInt();
        if (dia < 1 || dia > 31) {
          System.out.println("Día inválido, ingrese la fecha nuevamente.");
          continue;
        }
        fecha = LocalDate.of(anio, mes, dia);
        
      } catch (DateTimeException e) {
        System.out.println("Fecha inválida, intente de nuevo.");
        sc.nextLine(); // Limpiar buffer (sc)
      }
    }
    sc.close();
    System.out.println("Fecha válida: " + fecha);
  }
}
