package ejercicio02;
import java.io.IOException;
import java.util.Scanner;

public class MainCalculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculadora calc = new Calculadora();
		
		try {
			System.out.print("Ingrese el primer número: ");
			double num1 = sc.nextDouble();
			
			System.out.print("Ingrese el segundo número: ");
			double num2 = sc.nextDouble();
			
			System.out.println("\n----------CALCULADORA--------");
			System.out.println("1. Suma");
			System.out.println("2. Resta");
			System.out.println("3. Multiplicación");
			System.out.println("4. Divisón");
			System.out.println("\nSeleccione una operación:");
			int opc = sc.nextInt(); 
			
			double resultado = 0;
			switch (opc) {
			  case 1:
				  resultado = calc.sumar(num1, num2);
				  System.out.println("Resultado de la suma: " + resultado);
				  break;
			  case 2:
				  resultado = calc.restar(num1, num2);
				  System.out.println("Resultado de la resta: " + resultado);
				  break;
			  case 3:
				  resultado = calc.multiplicar(num1, num2);
				  System.out.println("Resultado de la multiplicación: " + resultado);
				  break;
			  case 4:
				  resultado = calc.dividir(num1, num2);
				  System.out.println("Resultado de la división: " + resultado);
				  break;
			  default:
				  throw new IllegalArgumentException("Opción inválida. Debe ser entre 1 y 4.");	  
			}
		} catch (DivisionPorCeroException e) {
			System.out.println("Excepción personalizada capturada: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Excepción de argumento ilegal: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("Excepción aritmética: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado: " + e.getMessage());
		}
	}
}
