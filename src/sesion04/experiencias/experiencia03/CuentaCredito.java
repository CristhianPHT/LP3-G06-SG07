package Experiencia03;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double cantidad) throws Excepciones, LimiteCreditoExcedidoException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva");
        }

        if (cantidad > getSaldo() + limiteCredito) {
            throw new LimiteCreditoExcedidoException("El monto excede el límite de crédito disponible.");
        }

        setSaldo(getSaldo() - cantidad);
        System.out.println("Retiro con crédito exitoso: -" + cantidad);
    }

    public void transferir(CuentaBancaria destino, double cantidad)
            throws Excepciones, LimiteCreditoExcedidoException {
        this.retirar(cantidad);
        destino.depositar(cantidad);
        System.out.println("Transferencia realizada: -" + cantidad + " a " + destino.getTitular());
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Límite de crédito: $" + limiteCredito);
    }
}