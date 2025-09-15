package ejercicio01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LeerEntrada le = new LeerEntrada();


        while (true) {
            System.out.println("Ingrese caracteres (s para salir):");
            char c = sc.next().charAt(0);
            try {
                le.procesar(c);
                System.out.println("Caracter leído correctamente: " + c);
            } catch (SalidaException e) {
                System.out.println(e.getMessage());
                break;
            } catch (Exception e) {
                System.out.println("Excepción: " + e.getMessage());
            }
        }
        sc.close();
    }
}