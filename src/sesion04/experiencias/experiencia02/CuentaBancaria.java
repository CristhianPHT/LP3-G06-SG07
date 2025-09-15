package Experiencia02;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso: +" + cantidad);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser positiva");
        }
    }
    
    public void retirar(double cantidad) throws ExcepcionesPersonalizadas.SaldoInsuficienteException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva");
        }
        
        if (cantidad > saldo) {
            throw new ExcepcionesPersonalizadas.SaldoInsuficienteException(
                "Saldo insuficiente. Saldo actual: " + saldo + ", intento de retiro: " + cantidad
            );
        }
        
        saldo -= cantidad;
        System.out.println("Retiro exitoso: -" + cantidad);
    }
    
    public double consultarSaldo() {
        return saldo;
    }
    
    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public String getTitular() {
        return titular;
    }
    
    // Setter para titular (el número de cuenta no debería cambiarse)
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    // Método para mostrar información de la cuenta
    public void mostrarInformacion() {
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: $" + saldo);
    }
}
