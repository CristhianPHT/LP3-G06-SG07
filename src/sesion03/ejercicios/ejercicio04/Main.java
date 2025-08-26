package ejercicio04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ImpresoraBasica impresoraSimple = new Impresora();
        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();

        System.out.println("=== Sistema de Impresoras ===");
        System.out.println("1. Usar Impresora Básica");
        System.out.println("2. Usar Impresora Multifuncional");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                impresoraSimple.imprimir();
                break;
            case 2:
                System.out.println("1. Imprimir");
                System.out.println("2. Escanear");
                int opcion2 = sc.nextInt();
                if (opcion2 == 1) {
                    multifuncional.imprimir();
                } else if (opcion2 == 2) {
                    multifuncional.escanear();
                } else {
                    System.out.println("Opción no válida.");
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }

        sc.close();
    }
}
