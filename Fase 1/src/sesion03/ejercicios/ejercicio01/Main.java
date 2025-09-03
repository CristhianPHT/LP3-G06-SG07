package ejercicio01;

public class Main {
	public static void main(String[] args) {
		Empleado emp = new Empleado("Juan", 48000, "Finanzas");
		CalculaPagoEmpleado calculadora = new CalculaPagoEmpleado();
		
		double pago = calculadora.calcularPagoMensual(emp);
		System.out.println("El pago mensual de " + emp.getNombre() + "(" + emp.getDepartamento() + ")" + " es: " + pago);
	}
}
