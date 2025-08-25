package sesion02.actividades.experiencia05;

import java.util.Scanner;

public class AppBanco {
  public static void main(String[] args) {
    Cuenta[] cuentas = new Cuenta[5]; // 5 cuentas
    cuentas[0] = new CuentaCorriente(1000);
    cuentas[1] = new CuentaCorriente(2000);
    cuentas[2] = new CuentaCorriente(3000);
    cuentas[3] = new CuentaAhorro(2000, 0.5, 500);
    cuentas[4] = new CuentaAhorro(4000, 0.5, 500);
    Scanner sc = new Scanner(System.in);
    boolean done = false;
    while (!done) {
      System.out.println("D)epositar");
      System.out.println("R)etirar");
      System.out.println("C)onsultar saldo");
      System.out.println("S)alir");
      System.out.print("Ingrese una opción: ");
      String op = sc.next().toUpperCase();
      if (op.equals("D") || op.equals("R")) {// Depositar o Retirar
        System.out.println("Ingrese un número(indice) de la cuenta: ");
        int num = sc.nextInt(); sc.nextLine();
        System.out.println("Ingrese el monto: ");
        double monto = sc.nextDouble(); sc.nextLine();
        if (op.equals("D")){
          cuentas[num].despositar(monto);
        } else {
          cuentas[num].retirar(monto);
        }
        System.out.println("Saldo: " + cuentas[num].getSaldo());
      } else if (op.equals("C")) { // Consultar
        for (int i = 0; i < cuentas.length; i++) {
          cuentas[i].consultar();
          System.out.println( i + ": " + cuentas[i].getSaldo());
        }
      } else if (op.equals("S")) { // Salir
        done = true;
      }
    }
    sc.close();
  }
}
