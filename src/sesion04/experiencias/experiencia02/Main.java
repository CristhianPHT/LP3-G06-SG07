package Experiencia02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear una cuenta bancaria con saldo inicial de $1000
        CuentaBancaria cuenta = new CuentaBancaria("123456789", "Juan Pérez", 1000.0);

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Mostrar información de la cuenta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" Saldo actual: $" + cuenta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double deposito = sc.nextDouble();
                    try {
                        cuenta.depositar(deposito);
                        System.out.println(" Depósito exitoso. Saldo actual: $" + cuenta.consultarSaldo());
                    } catch (IllegalArgumentException e) {
                        System.out.println(" Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double retiro = sc.nextDouble();
                    try {
                        cuenta.retirar(retiro);
                        System.out.println(" Retiro exitoso. Saldo actual: $" + cuenta.consultarSaldo());
                    } catch (ExcepcionesPersonalizadas.SaldoInsuficienteException e) {
                        System.out.println(" Error: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println(" Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    cuenta.mostrarInformacion();
                    break;
                case 5:
                    System.out.println(" Saliendo del sistema...");
                    break;
                default:
                    System.out.println("⚠ Opción no válida, intente de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
