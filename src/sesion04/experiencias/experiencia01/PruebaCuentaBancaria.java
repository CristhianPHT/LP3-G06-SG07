package Experiencia01;
import java.util.Scanner;

public class PruebaCuentaBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("----- SISTEMA BANCARIO - PRUEBA DE EXCEPCIONES-----");
            System.out.println();

            // PRUEBA 1: Crear cuenta con saldo negativo
            System.out.println("1. PRUEBA: Crear cuenta con saldo negativo");
            try {
                CuentaBancaria cuentaInvalida = new CuentaBancaria("001", "Jennifer Romero", -1000);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
            System.out.println();

            // PRUEBA 2: Crear cuenta con datos vacíos
            System.out.println("2. PRUEBA: Crear cuenta con datos vacíos");
            try {
                CuentaBancaria cuentaVacia = new CuentaBancaria("", "Nicol Gutierrez", 500);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
            System.out.println();

            // PRUEBA 3: Crear cuenta válida
            System.out.println("3. PRUEBA: Crear cuenta válida");
            CuentaBancaria cuentaValida = new CuentaBancaria("001", "Miguel Romero", 1000);
            System.out.println();

            // PRUEBA 4: Depósito con monto negativo
            System.out.println("4. PRUEBA: Depósito con monto negativo");
            try {
                cuentaValida.depositar(-500);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
            System.out.println();

            // PRUEBA 5: Depósito válido
            System.out.println("5. PRUEBA: Depósito válido");
            cuentaValida.depositar(500);
            System.out.println();

            // PRUEBA 6: Retiro con monto negativo
            System.out.println("6. PRUEBA: Retiro con monto negativo");
            try {
                cuentaValida.retirar(-200);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
            System.out.println();

            // PRUEBA 7: Retiro con saldo insuficiente
            System.out.println("7. PRUEBA: Retiro con saldo insuficiente");
            try {
                cuentaValida.retirar(2000);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
            System.out.println();

            // PRUEBA 8: Retiro válido
            System.out.println("8. PRUEBA: Retiro válido");
            cuentaValida.retirar(300);
            System.out.println();

            // PRUEBA 9: Consulta de saldo
            System.out.println("9. PRUEBA: Consulta de saldo");
            System.out.println("Saldo actual: " + cuentaValida.consultarSaldo());
            System.out.println();

            // PRUEBA 10: Interacción con el usuario
            System.out.println("10. PRUEBA: Interacción con el usuario");
            interaccionUsuario();

        } finally {
            scanner.close();
            System.out.println();
            System.out.println("=== PRUEBAS FINALIZADAS ===");
        }
    }

    // Método para interacción con el usuario
    private static void interaccionUsuario() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese número de cuenta: ");
            String numero = scanner.nextLine();
            
            System.out.print("Ingrese nombre del titular: ");
            String titular = scanner.nextLine();
            
            System.out.print("Ingrese saldo inicial: ");
            double saldoInicial = scanner.nextDouble();
            
            // Crear cuenta
            CuentaBancaria cuentaUsuario = new CuentaBancaria(numero, titular, saldoInicial);
            
            // Operaciones
            boolean continuar = true;
            while (continuar) {
                System.out.println();
                System.out.println("Operaciones disponibles:");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Consultar saldo");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                int opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese monto a depositar: ");
                        double montoDeposito = scanner.nextDouble();
                        try {
                            cuentaUsuario.depositar(montoDeposito);
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ " + e.getMessage());
                        }
                        break;
                        
                    case 2:
                        System.out.print("Ingrese monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        try {
                            cuentaUsuario.retirar(montoRetiro);
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ " + e.getMessage());
                        }
                        break;
                        
                    case 3:
                        System.out.println("Saldo actual: " + cuentaUsuario.consultarSaldo());
                        break;
                        
                    case 4:
                        continuar = false;
                        System.out.println("Saliendo del programa...");
                        break;
                        
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
