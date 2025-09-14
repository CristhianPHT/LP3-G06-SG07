package ejercicio03;
import java.util.Scanner;

public class MainNumero {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		try {
			System.out.print("Ingrese un número: ");
			double num = sc.nextDouble();
			
			Numero n = new Numero(num);
			System.out.println("Número almacenado correctamente: " + n.getValor());
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
