package sesion03.actividades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class GestorDisponibilidadHabitacion {
    private HashMap<Integer, Reserva> reservasPorId;     // Mapa principal: id -> Reserva   // Entidad...?
    private HashMap<String, Habitacion> habitacionesPorId;     // Mapa principal: id -> Habitacion   // Entidad...?
    private HashMap<Integer, Cliente> clientesPorId;     // Mapa principal: id -> Cliente   // Entidad

    private HashMap<LocalDate, Set<Integer>> reservasPorFecha;     // key: fecha, value: conjunto de IDs de reservas
    // private HashMap<LocalDate, Set<String>> habitacionesOcupadasPorFecha; // key: fecha, value: N° de Habitacion (ocupada...)
    // private HashMap<String, List<Reserva>> historialPorHabitacion;  // key: número ID de habitación, value: lista de reservas
    // private HashMap<String, List<Reserva>> reservasPorCliente;    // key: ID cliente, value: lista de reservas
    
    public GestorDisponibilidadHabitacion() {
        this.reservasPorId = new HashMap<>();
        this.habitacionesPorId = new HashMap<>();
        this.clientesPorId = new HashMap<>();

        this.reservasPorFecha = new HashMap<>();
        // this.habitacionesOcupadasPorFecha = new HashMap<>();
        // this.historialPorHabitacion = new HashMap<>();
        // this.reservasPorCliente = new HashMap<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        if (habitacion != null) {
            habitacionesPorId.put(habitacion.getNumero(), habitacion);
        }
    }

    public void agregarReserva(Fecha fechaInicio, Fecha fechaFin, Cliente cliente, Class<? extends Habitacion> tipo) {
        // Verificar si la habitación está disponible
        if (!verificarDisponible(tipo, fechaInicio.getFecha(), fechaFin.getFecha())) {
            return;
        }
        // Crear la reserva
        Reserva reserva = new Reserva(fechaInicio, fechaFin, cliente);
        reserva.checkIn(habitacionesPorId, tipo);   //(HashMap<Habitacion>, Habitacion)
        reservasPorId.put(reserva.getId(), reserva);
        // Indexar por cada día del rango [check-in, check-out)
        LocalDate inicio = reserva.getFechaInicio().getFecha();
        LocalDate fin = reserva.getFechaFin().getFecha();
        for (LocalDate fecha = inicio; fecha.isBefore(fin); fecha = fecha.plusDays(1)) {
            if (!reservasPorFecha.containsKey(fecha)) { // ver si no existe un conjunto de reservas para esa fecha
                reservasPorFecha.put(fecha, new HashSet<>());   // crear un nuevo conjunto de reservas para esa fecha
            }
            reservasPorFecha.get(fecha).add(reserva.getId()); // añadir la reserva al conjunto de reservas para esa fecha
        }
    }
    // ¿Existe alguna habitación del tipo dado disponible en todo el rango?
    public boolean verificarDisponible(Class<? extends Habitacion> tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Habitacion habitacion : habitacionesPorId.values()) {
            if (tipo.isInstance(habitacion) && "disponible".equals(habitacion.getDisponible())) {   //  Queremos una habitacion "disponible"
                if (estaLibreEnRango(habitacion.getNumero(), fechaInicio, fechaFin)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Encuentra el número de habitación disponible para todo el rango según tipo (o null)
    public String encontrarHabitacionDisponible(Class<? extends Habitacion> tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Habitacion habitacion : habitacionesPorId.values()) {
            if (tipo.isInstance(habitacion) && "disponible".equals(habitacion.getDisponible())) {
                if (estaLibreEnRango(habitacion.getNumero(), fechaInicio, fechaFin)) {
                    return habitacion.getNumero();
                }
            }
        }
        return null;
    }

    private boolean estaLibreEnRango(String numeroHabitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        for (LocalDate fecha = fechaInicio; fecha.isBefore(fechaFin); fecha = fecha.plusDays(1)) {
            if (reservasPorFecha.get(fecha) != null) {
                for (Integer idReserva : reservasPorFecha.get(fecha)) {
                    Habitacion verificacion = reservasPorId.get(idReserva).getHabitacion();
                    if (verificacion.disponibilidad()!= true){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void cancelarReserva(int id) {
        reservasPorId.get(id).cancelar();
    }


    // Mapa principal: alta y consulta por ID
    public void putReserva(Reserva reserva) {
        if (reserva != null) {
            reservasPorId.put(reserva.getId(), reserva);
        }
    }

    public Reserva getReservaPorId(int id) {
        return reservasPorId.get(id);
    }

    // Consulta: IDs de reservas asociadas a una fecha específica
    public Set<Integer> getReservaIdsPorFecha(LocalDate fecha) {
        Set<Integer> ids = reservasPorFecha.get(fecha);
        return ids != null ? new HashSet<>(ids) : new HashSet<>();
    }

    // Consulta: Reservas (objetos) asociadas a una fecha específica usando el mapa principal
    public List<Reserva> getReservasPorFecha(LocalDate fecha) {
        Set<Integer> ids = reservasPorFecha.get(fecha);
        List<Reserva> reservas = new ArrayList<>();
        if (ids != null) {
            for (Integer id : ids) {
                Reserva r = reservasPorId.get(id);
                if (r != null) reservas.add(r);
            }
        }
        return reservas;
    }
    public void printReservas() {
        System.out.println("Listado de Reservas:");
        for (Reserva reserva : reservasPorId.values()) {
            System.out.println(reserva.toString());
        }
    }
}

/*
 * GestorDisponibilidadHabitacion (SERVICIO)
├── reservasPorFecha: HashMap<LocalDate, List<Reserva>>
├── historialPorHabitacion: HashMap<String, List<Reserva>>  // key: número de habitación
├── verificarDisponibilidad()
├── agregarReserva()
└── cancelarReserva()
 */