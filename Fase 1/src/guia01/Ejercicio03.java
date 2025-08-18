package guia01;
/*
Lanza un dado 20000 veces y guarda la frecuencia de cada una de las 6 caras en un arreglo.
*/
public class Ejercicio03 {
  public static void main(String[] args) {
    int[] frecuencias = new int[6];
    for (int i = 0; i < 20000; i++) {
      int cara = (int) (Math.random() * 6); // random() = [0.0, 1.0), * 6 = [0.0, 6.0) y casteamos a entero (int)
      frecuencias[cara]++;  // sumamos 1 a la cara obtenida
    }

    System.out.println("Frecuencia de cada cara del dado:");
    for (int i = 0; i < frecuencias.length; i++) {
      System.out.println("Cara " + (i + 1) + ": " + frecuencias[i]);
    }
  }  
}
