package Experiencia01;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor con validación de saldo inicial
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        // Validar que el saldo inicial no sea negativo
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("ERROR: El saldo inicial no puede ser negativo. Valor recibido: " + saldoInicial);
        }
        
        // Validar que el número de cuenta no sea nulo o vacío
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: El número de cuenta no puede estar vacío");
        }
        
        // Validar que el titular no sea nulo o vacío
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: El titular de la cuenta no puede estar vacío");
        }
        
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        
        System.out.println("Cuenta creada exitosamente: " + this);
    }

    // Método para depositar dinero
    public void depositar(double monto) {
        // Validar que el monto sea positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR: El monto a depositar debe ser positivo. Valor recibido: " + monto);
        }
        
        this.saldo += monto;
        System.out.println("Depósito exitoso: +" + monto + ". Nuevo saldo: " + this.saldo);
    }

    // Método para retirar dinero
    public void retirar(double monto) {
        // Validar que el monto sea positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR: El monto a retirar debe ser positivo. Valor recibido: " + monto);
        }
        
        // Validar que haya saldo suficiente
        if (monto > this.saldo) {
            throw new IllegalArgumentException("ERROR: Saldo insuficiente. Saldo actual: " + this.saldo + ", Monto solicitado: " + monto);
        }
        
        this.saldo -= monto;
        System.out.println("Retiro exitoso: -" + monto + ". Nuevo saldo: " + this.saldo);
    }

    // Método para consultar saldo
    public double consultarSaldo() {
        return this.saldo;
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
