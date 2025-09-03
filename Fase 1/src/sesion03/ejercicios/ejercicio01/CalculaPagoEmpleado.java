package ejercicio01;

public class CalculaPagoEmpleado {
	public double calcularPagoMensual(Empleado empleado) {
		return empleado.getSalario()/12;
	}
}
