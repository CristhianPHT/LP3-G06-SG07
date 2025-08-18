package guia01;
/*
1. Crea una función en Python, C++ y Java que reciba un arreglo como parámetro y devuelva la suma de todos los elementos del arreglo.
¿Cuáles son las diferencias entre los tres lenguajes respecto al envío de arreglos como parámetro?
*/
public class Ejercicio01 {
  public static void main(String[] args) {
    int[] arreglo = {1, 2, 3, 4, 5};
    int suma = sumarArreglo(arreglo);
    System.out.println("La suma de los elementos del arreglo es: " + suma);
  }

  public static int sumarArreglo(int[] arreglo) {
    int sum = 0;
    for (int i = 0; i < arreglo.length; i++) {
      sum += arreglo[i];
    }
    return sum;
  }
}
