package sesion03.actividades;

import java.util.HashMap;

public class Reserva {
  private int id;
  private static int nextId = 100;
  private Fecha fechaInicio;  // check-in
  private Fecha fechaFin;   // check-out
  private String estado; // reservada, cancelada, finalizada, proceso
  private Habitacion habitacion;
  private Cliente cliente;

  public Reserva(Fecha fechaInicio, Fecha fechaFin, Cliente cliente) {
    this.id = nextId;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.estado = "disponible";
    this.cliente = cliente;
    nextId++;
  }

  public void cancelar() {
    this.estado = "cancelada";
  }
  // checkIn: reserva habitacion, check-in, habitacion ocupada
  public void checkIn(HashMap<String, Habitacion> habitacionesPorNumero, Class<? extends Habitacion> tipo) {
    this.estado = "proceso";
    for (Habitacion habitacion : habitacionesPorNumero.values()) {
      if (tipo.isInstance(habitacion) && "disponible".equals(habitacion.getDisponible())) {    
        this.habitacion = habitacion;
        habitacion.setDisponible("ocupada");
        break;
      }
    }
  }
  public void checkOut(HashMap<String, Habitacion> habitacionesPorNumero, String id) {
    this.estado = "finalizada";
    for (Habitacion habitacion : habitacionesPorNumero.values()) {
      if (id.equals(habitacion.getNumero())) {
        habitacion.setDisponible("limpieza");
        break;
      }
    }
  }

  public int getId() { return id; }
  public Fecha getFechaInicio() { return fechaInicio; }
  public void setFechaInicio(Fecha fechaInicio) { this.fechaInicio = fechaInicio; }
  public Fecha getFechaFin() { return fechaFin; }
  public void setFechaFin(Fecha fechaFin) { this.fechaFin = fechaFin; }
  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }
  public Habitacion getHabitacion() { return habitacion; }
  public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }
  public Cliente getCliente() { return cliente; }
  public void setCliente(Cliente cliente) { this.cliente = cliente; }
  
  @Override
  public String toString() {
    return "Reserva " + fechaInicio + ", -" + fechaFin + " estado: " + estado +
            "\nHabitación: " + habitacion.getNumero() + "\nCliente: " + cliente.getNombre();
  }
}
