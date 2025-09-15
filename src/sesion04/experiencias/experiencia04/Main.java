package Experiencia04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaCredito cuenta = new CuentaCredito("789012", "María López", 500.0, 300.0);
        List<String> historial = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Generar reporte de transacciones");
            System.out.println("4. Leer reporte desde archivo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto a depositar: ");
                    double deposito = sc.nextDouble();
                    try {
                        cuenta.depositar(deposito);
                        historial.add("Depósito: +" + deposito);
                    } catch (Exception e) {
                        System.out.println(" Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = sc.nextDouble();
                    try {
                        cuenta.retirar(retiro);
                        historial.add("Retiro: -" + retiro);
                    } catch (FondosInsuficientesException | LimiteCreditoExcedidoException e) {
                        System.out.println(" " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println(" Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese nombre del archivo para guardar el reporte: ");
                    String archivo = sc.next();
                    try {
                        ReporteTransacciones.generarReporte(archivo, cuenta, historial);
                    } catch (HistorialVacioException e) {
                        System.out.println(" " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println(" Error de escritura: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese nombre del archivo a leer: ");
                    String archivoLeer = sc.next();
                    ReporteTransacciones.leerReporte(archivoLeer);
                    break;

                case 5:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
