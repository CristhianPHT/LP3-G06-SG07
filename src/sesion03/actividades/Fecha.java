package sesion03.actividades;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Fecha {
  private int dia;
  private int mes;
  private int anio;
  private LocalDate fecha;

  public Fecha() { this.dia = 1; this.mes = 1; this.anio = 2000; }
  public Fecha(int anio, int mes, int dia) {    // Dia, mes, año
    try {
      this.fecha = LocalDate.of(anio, mes, dia);
      this.dia = dia;
      this.mes = mes;
      this.anio = anio;
    } catch (DateTimeException e) {
      System.out.println("Fecha inválida, se asignará la fecha por defecto 01/01/2000.");
      this.dia = 1; this.mes = 1; this.anio = 2000;
      this.fecha = LocalDate.of(this.anio, this.mes, this.dia);
    }
  }
  public Fecha(LocalDate fecha) {
    this.fecha = fecha;
    this.dia = fecha.getDayOfMonth();
    this.mes = fecha.getMonthValue();
    this.anio = fecha.getYear();
  }
  public LocalDate getFecha() { return fecha; }
  public void setFecha(LocalDate fecha) { this.fecha = fecha; }
  public int getDia() { return dia; }
  public void setDia(int dia) { this.dia = dia; }
  public int getMes() { return mes; }
  public void setMes(int mes) { this.mes = mes; }
  public int getAnio() { return anio; }
  public void setAnio(int anio) { this.anio = anio; }

  public void agregarFecha(int tipo) { // 1: inicio (check in) , 2: fin (check out)
    Scanner sc = new Scanner(System.in);
    LocalDate fecha = null;
    while (fecha == null) {
      try {
        System.out.print("Ingrese un año: "); // LocalDate no valida años (ni bisietos)
        int anio = sc.nextInt();
        if (anio < 1900 || anio > 2100) {
          System.out.println("Año inválido, superiores a 1900 e inferiores a 2100, intente de nuevo.");
          continue;
        }
        System.out.print("Ingrese un mes: ");
        int mes = sc.nextInt();
        if (mes < 1 || mes > 12) {
          System.out.println("Mes inválido, ingrese la fecha nuevamente.");
          continue;
        }
        System.out.print("Ingrese un día: ");
        int dia = sc.nextInt();
        if (dia < 1 || dia > 31) {
          System.out.println("Día inválido, ingrese la fecha nuevamente.");
          continue;
        }
        fecha = LocalDate.of(anio, mes, dia);
      } catch (DateTimeException e) {
        System.out.println("Fecha inválida, intente de nuevo.");
        sc.nextLine(); // Limpiar buffer (sc)
      }
    }
    sc.close();
  }

  @Override
  public String toString() {
    return dia + "/" + mes + "/" + anio;
  }
}
