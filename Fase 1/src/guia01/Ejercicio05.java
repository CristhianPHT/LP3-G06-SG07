package guia01;
/*
 * Un estacionamiento cobra S/3.00 por la primera hora, luego S/0.50 por cada hora siguiente. El
cargo máximo por día es de S/12.00. Programe una función para que al ingresar el número de
horas se imprima el cargo.
*/
import java.util.Scanner;
public class Ejercicio05 {
  public static double calcularCargo(int horas) {
    double cargo = 0.0;
    if (horas <= 1) {
      cargo = 3.00;
    } else if (horas <= 24) {
      cargo = 3.00 + (horas - 1) * 0.50;
      if (cargo > 12.00) {
        cargo = 12.00;
      }
    } else {
      int dias = horas / 24;
      int horasRestantes = horas % 24;
      cargo = dias * 12.00;
      if (horasRestantes > 0) {
        double cargoRestante;
        if (horasRestantes == 1) {
          cargoRestante = 3.00;
        } else {
          cargoRestante = 3.00 + (horasRestantes - 1) * 0.50;
          if (cargoRestante > 12.00) {
            cargoRestante = 12.00;
          }
        }
        cargo += cargoRestante;
      }
    }
    return cargo;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int horas;
    do {
      System.out.print("Ingrese el número de horas estacionado: ");
      horas = s.nextInt();
    } while (horas <= 0);
    double cargo = calcularCargo(horas);
    System.out.println("El cargo por "+ horas + " horas es: " + cargo);
    s.close();
  }  
}
