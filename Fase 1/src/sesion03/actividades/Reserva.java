package sesion03.actividades;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Reserva implements AgregarFecha {
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private String estado; // reservada, cancelada, check-in, check-out
  private Habitacion habitacion;
  private Cliente cliente;

  public Reserva(LocalDate fechaInicio, LocalDate fechaFin, String estado, Habitacion habitacion, Cliente cliente) {
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.estado = estado;
    this.habitacion = habitacion;
    this.cliente = cliente;
  }
  
  public LocalDate getFechaInicio() { return fechaInicio; }
  public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
  public LocalDate getFechaFin() { return fechaFin; }
  public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }
  public Habitacion getHabitacion() { return habitacion; }
  public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }
  public Cliente getCliente() { return cliente; }
  public void setCliente(Cliente cliente) { this.cliente = cliente; }

  @Override
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
    if (tipo == 1) {
      this.fechaInicio = fecha;
    } else if (tipo == 2) {
      this.fechaFin = fecha;
    }
    sc.close();
  }
  
  @Override
  public String toString() {
    return "Reserva " + fechaInicio + ", -" + fechaFin + " estado: " + estado +
            "\nHabitación: " + habitacion.getNumero() + "\nCliente: " + cliente.getNombre();
  }
}
