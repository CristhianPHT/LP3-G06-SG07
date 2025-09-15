package Experiencia04;

public class LimiteCreditoExcedidoException extends RuntimeException {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}
