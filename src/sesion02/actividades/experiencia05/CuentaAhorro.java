package sesion02.actividades.experiencia05;

public class CuentaAhorro extends Cuenta {
  private double tasaInteres;
  private double minSaldo;
  public CuentaAhorro(double s, double tasa, double min) {
    super(s);
    tasaInteres = tasa;
    minSaldo = min;
  }

  public void setTasaInteres(double tasa) {
    tasaInteres = tasa;
  }

  @Override
  public void retirar(double monto) {
    if (monto > getSaldo()) {
      System.out.println("Saldo insuficiente");
      return;
    } else {
      setSaldo(getSaldo() - monto);
      if (getSaldo() < minSaldo) {
        minSaldo = getSaldo();
      }
    }
    double saldo = getSaldo();
    if (saldo < minSaldo) {
      minSaldo = saldo;
    }
  }

  @Override
  public void consultar() { // Genera intereses
    double interes = minSaldo * tasaInteres / 100.0;
    despositar(interes);
    minSaldo = getSaldo();
  }
  
}
/*
paso 5
La clase CuentaAhorro necesita almacenar la tasa de interés.
También necesita almacenar el saldo mínimo mensual,
que debe ser actualizado por todos los retiros.

paso 6
En el método retirar de la clase CuentaAhorro, se actualiza el saldo mínimo.
Observe la llamada al método de la superclase.
Así mismo, en el método consultar de esta cuenta, se depositan los intereses en la cuenta,
y se invoca al método depositar porque no se tiene acceso directo a la variable de instancia saldo.
El saldo mínimo se restablece para el mes siguiente.
*/