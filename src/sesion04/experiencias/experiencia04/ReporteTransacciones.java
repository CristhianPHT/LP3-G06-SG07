package Experiencia04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ReporteTransacciones {

    // Generar reporte en archivo
    public static void generarReporte(String nombreArchivo, CuentaBancaria cuenta, List<String> transacciones)
            throws HistorialVacioException, IOException {

        if (transacciones == null || transacciones.isEmpty()) {
            throw new HistorialVacioException("No se puede generar el reporte: historial vacío.");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("=== REPORTE DE TRANSACCIONES ===");
            writer.println("Cuenta: " + cuenta.getNumeroCuenta());
            writer.println("Titular: " + cuenta.getTitular());
            writer.println("Saldo final: $" + cuenta.getSaldo());
            writer.println("----------------------------");
            writer.println("Transacciones:");
            for (String t : transacciones) {
                writer.println("- " + t);
            }
            System.out.println("✅ Reporte generado en: " + nombreArchivo);
        }
    }

    // Leer datos desde archivo
    public static void leerReporte(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try (Scanner scanner = new Scanner(archivo)) {
            System.out.println("\n=== LEYENDO REPORTE DESDE ARCHIVO ===");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(" Error: archivo no encontrado -> " + nombreArchivo);
        }
    }
}
