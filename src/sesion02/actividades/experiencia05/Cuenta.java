package sesion02.actividades.experiencia05;

public abstract class Cuenta {
  private double saldo;
  public Cuenta(double s) {
    saldo = s;
  }
  public void despositar(double monto) {
    saldo = saldo + monto;
  }
  public void retirar(double monto) { //sobrescribir
    saldo = saldo - monto;
  }
  public abstract void consultar(); // redefinirán

  public double getSaldo() {
    return saldo;
  }
  public void setSaldo(double s) {
    saldo = s;
  }
}


/*
Herencia Diseñe e implemente un programa que administre un conjunto de cuetas de una banco.
- Cuenta de ahorros que genera intereses.
Los intereses se capitalizan mensualmente y se calculan sobre el saldo omensual mínimo.
- Cuenta corriente que no tiene intereses, le brinda tres retiros gratuitos al mes,
y cobra una tarifa de transacción de S/.3.00 por cada retiro adicional.

El programa incialemente debe gestionar estos dos tipos de cuentas, sin embargo, más adelante es posible
que sean muchos otros tipos más. Por lo tanto, la solución planteadad debe perimitir expandir
los tipos de cuentas sin afectar el ciclo de procesamiento principal.
Se debe proporcionar un menú con las siguietes opciones:
D)epositar
R)etirar
C)onsultar saldo
S)alir

Al seleccionar las opciones de retiro y deposito, se debe especificar el número de cuenta y el importe.
Además, se debe imrpimir el salod de la cuenta despúes de cada transacción.
En la opcion consultar, se debe acumular intereses o borrar el contador de transacciones, según el tipo
de cuenta bancaria.
Y a imprimir el saldo de todas las cuentas.

Clases que son parte de la solución: Cuenta, CuentaAhorros, CuentaCorriente

De acuerdo a lo que se solicita, las clases CuentaAhorro y CuentaCorriente redefinirán el
método consultar.
La clase CuentaAhorro debe sobrescribir el método retirar para realizar un seguimiento del saldo mínimo.
La clase CuentaCorriente debe actualizar el contador de retiros en el método retirar.


*/