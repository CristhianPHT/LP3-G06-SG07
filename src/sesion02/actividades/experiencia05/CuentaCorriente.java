package sesion02.actividades.experiencia05;

public class CuentaCorriente extends Cuenta {
  private double retiros;
  private final double TARIFA_TRANSACCION = 3.5; // 3.00...

  public CuentaCorriente(double s) {
    super(s);
    retiros = 0;
  }

  @Override
  public void retirar(double monto) {
    final int LIBRE_RETIROS = 3;
    if ((monto + TARIFA_TRANSACCION) > getSaldo()) {
      System.out.println("Saldo insuficiente");
      return;
    } else {
      super.retirar(monto);
      retiros++;
      if (retiros > LIBRE_RETIROS) {
        super.retirar(TARIFA_TRANSACCION);
      }
    }
  }

  @Override
  public void consultar() {
    retiros = 0;
  }
  
}
/*
paso 5
La clase CuentaCorriente necesita contar los retiros,
para que el cargo pueda ser aplicado
después de que el límite de retiro libre sea alcanzado.

paso 6
El método retirar de la clase CuentaCorriente necesita comprobar el contador de retiros. Si
ha habido demasiados retiros, se aplica el cargo respectivo. De nuevo, observe cómo el método
invoca al método de la superclase.
El método consultar para una cuenta de tipo CuentaCorriente simplemente restablece el
recuento de retiros.
*/