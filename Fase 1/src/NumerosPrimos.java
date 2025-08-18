import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = scanner.nextInt();
        imprimirNumerosPrimos(n);
        scanner.close();
    }

    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void imprimirNumerosPrimos(int n) {
        for (int num = 2; num <= n; num++) {
            if (esPrimo(num)) {
                System.out.println(num + " es primo.");
            }
        }
    }
}