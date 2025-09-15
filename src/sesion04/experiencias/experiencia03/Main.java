package Experiencia03;

public class Main {
    public static void main(String[] args) {
        // Crear cuentas
        CuentaBancaria cuentaNormal = new CuentaBancaria("123456", "Juan Pérez", 1000.0);
        CuentaCredito cuentaCredito = new CuentaCredito("789012", "María López", 500.0, 300.0);

        System.out.println("=== ESTADO INICIAL ===");
        cuentaNormal.mostrarInformacion();
        System.out.println("----------------------------");
        cuentaCredito.mostrarInformacion();

        System.out.println("\n=== PRUEBAS ===");

        try {
            // Retiro exitoso en cuenta normal
            cuentaNormal.retirar(200.0);
            System.out.println("Saldo cuenta normal: $" + cuentaNormal.consultarSaldo());

            // Retiro exitoso en cuenta crédito (usando parte del límite)
            cuentaCredito.retirar(700.0);
            System.out.println("Saldo cuenta crédito: $" + cuentaCredito.consultarSaldo());

            // Transferencia entre cuentas
            cuentaCredito.transferir(cuentaNormal, 50.0);
            System.out.println("Saldo cuenta normal: $" + cuentaNormal.consultarSaldo());
            System.out.println("Saldo cuenta crédito: $" + cuentaCredito.consultarSaldo());

            // Intento de exceder el límite de crédito
            cuentaCredito.retirar(200.0);

        } catch (Excepciones e) {
            System.out.println(" Error de fondos insuficientes: " + e.getMessage());
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println(" Error de límite de crédito: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(" Error de argumento: " + e.getMessage());
        }

        System.out.println("\n=== ESTADO FINAL ===");
        cuentaNormal.mostrarInformacion();
        System.out.println("----------------------------");
        cuentaCredito.mostrarInformacion();
    }
}
