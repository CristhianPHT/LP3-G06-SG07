package Experiencia02;

public class ExcepcionesPersonalizadas {
    
    // Excepción para saldo insuficiente
    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
        
        public SaldoInsuficienteException() {
            super("Saldo insuficiente para realizar la operación");
        }
    }
    
}
