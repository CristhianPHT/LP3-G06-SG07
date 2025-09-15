package Experiencia03;

public class LimiteCreditoExcedidoException extends RuntimeException {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}
