package guia01;
/*
4. Programe una función menor que reciba 3 números decimales y devuelva el menor de los 3
*/
public class Ejercicio04 {
  public static double menor(double num1, double num2, double num3) {
    double menor = num1; // Asumimos que el primer número es el menor
    if (num2 < menor) {
      menor = num2; // Si el segundo es menor
    }
    if (num3 < menor) {
      menor = num3; // Si el tercer es menor
    }
    return menor;
  }
  public static void main(String[] args) {
    double a = 5.4;
    double b = 2.3;
    double c = 3.8;
    double resultado = menor(a, b, c);
    System.out.println("El menor de " + a + ", " + b + " y " + c + " es: " + resultado);
  }
}
