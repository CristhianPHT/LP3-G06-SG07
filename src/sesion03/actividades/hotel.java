package sesion03.actividades;

import java.time.LocalDate;
import java.util.HashMap;

public class hotel {
  public static void main(String[] args) {
    Habitacion habitacion1 = new HabDoble("101", "si");
    Habitacion habitacion2 = new HabIndividual("102", "Individual");
    System.out.println(habitacion1.toString());
    System.out.println(habitacion2.toString());

    Persona p1 = new Cliente("Ana", 963852741, "Ana@gmail.com", 987654321);
    Persona p2 = new Cliente("Luis", 987654321, "Luis@gmail.com", 123456789);

    // main todo arriba

    HashMap<Integer, Persona> clientes = new HashMap<>();
    clientes.put(p1.getId(), p1);
    clientes.put(p2.getId(), p2);
    GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion();
    LocalDate fechaInicio = LocalDate.of(2025, 10, 1);
    LocalDate fechaFin = LocalDate.of(2025, 10, 5);
    gestor.agregarHabitacion(habitacion1);
    gestor.agregarHabitacion(habitacion2);
    gestor.agregarReserva(new Fecha(fechaInicio), new Fecha(fechaFin), (Cliente) p1, HabDoble.class);
    gestor.agregarReserva(new Fecha(fechaInicio), new Fecha(fechaFin), (Cliente) p2, HabIndividual.class);
    gestor.printReservas();
    


    // System.out.println(gestor.verificarDisponibilidad(null, fechaInicio, fechaFin));
    // HashMap<LocalDate, Habitacion> reservas = new HashMap<>();
  }
}
/*
CONTEXTO DEL PROBLEMA: SISTEMA DE GESTIÓN DE RESERVAS DE HOTEL
Un hotel necesita un sistema de gestión, que permita a los clientes realizar reservas en línea,
gestionar las habitaciones disponibles, asignar personal de limpieza y generar informes de ocupación.
El sistema debe ser flexible para adaptarse a diferentes tipos de habitaciones,
políticas de cancelación y promociones especiales.
Además, se espera que el hotel crezca en el futuro,
por lo que el sistema debe ser escalable y fácil de mantener.

Requisitos Funcionales:
Gestión de Habitaciones:
• Registrar diferentes tipos de habitaciones (individual, doble, etc.) con características y precios.
• Consultar la disponibilidad de habitaciones en fechas específicas.
• Realizar reservas de habitaciones para clientes.
• Cancelar reservas.
• Asignar habitaciones a clientes al momento del check-in. (reservar -> check-in)
• Liberar habitaciones al momento del check-out (liberar -> check-out)

Gestión de Clientes:
• Registrar información de los clientes (nombre, datos de contacto, etc.).
• Asociar reservas a clientes.
• Consultar el historial de reservas de un cliente.

Gestión de Personal:
• Registrar información del personal de limpieza.
• Asignar personal de limpieza a habitaciones para su limpieza.
• Consultar la carga de trabajo del personal de limpieza.

Generación de Informes:
• Generar informes de ocupación por tipo de habitación y por periodo de tiempo.
• Generar informes de ingresos por periodo de tiempo.

Flexibilidad:
• Permitir configurar diferentes políticas de cancelación para cada tipo de habitación.
• Permitir crear promociones especiales con descuentos en determinadas fechas o para ciertos
tipos de clientes

Escalabilidad:
• El sistema debe ser capaz de manejar un aumento en el número de habitaciones, clientes
y personal sin comprometer el rendimiento.

Mantenibilidad:
• El código debe ser fácil de entender, modificar y extender para adaptarse a futuros cambios en
los requisitos del hotel.
*/


/*
------------------------------------------------------------------------------------------------
1. PRÁCTICA N° 01: PRINCIPIO DE RESPONSABILIDAD ÚNICA (SRP) EN EL SISTEMA DE GESTIÓN DE RESERVAS
a) IDENTIFICAR LOS MÉTODOS EN LA CLASE HABITACION QUE SE ENCARGAN DE:
• Verificar la disponibilidad de la habitación en un rango de fechas.
• Marcar la habitación como reservada o disponible.
• Calcular el precio de la habitación según la temporada o promociones.
• Generar informes de ocupación de la habitación.
• Observar cómo estos métodos interactúan con los atributos de la clase Habitacion y otras clases
relacionadas (ej: Reserva, Cliente).

b) CREACIÓN DE UNA NUEVA CLASE GESTORDISPONIBILIDADHABITACION:
• Crear una nueva clase llamada GestorDisponibilidadHabitacion.
• Mover los métodos relacionados con disponibilidad de la habitación desde Habitacion a GestorDisponibilidadHabitacion.
• Asegurarse de que GestorDisponibilidadHabitacion tenga acceso a los datos necesarios para
realizar las verificaciones de disponibilidad (ej: lista de reservas, calendario de promociones).

c) ADAPTACIÓN DE LA CLASE HABITACION:
• Eliminar los métodos relacionados con la disponibilidad de Habitacion.
• Añadir un atributo de tipo GestorDisponibilidadHabitacion a la clase Habitacion.
• Modificar los métodos de Habitacion que necesiten verificar la disponibilidad para que utilicen
el GestorDisponibilidadHabitacion.

d) INTEGRACIÓN EN EL CONTROLADOR:
• Adaptar el controlador para utilizar el GestorDisponibilidadHabitacion al realizar operaciones
relacionadas con la disponibilidad de las habitaciones (ej: al crear una nueva reserva, al consultar
la disponibilidad).
*/

/*
------------------------------------------------------------------------------------------------
2. EXPERIENCIA DE PRÁCTICA N° 02: APLICACIÓN DEL PRINCIPIO
ABIERTO/CERRADO (OCP) EN EL SISTEMA DE GESTIÓN DE
RESERVAS
a) ANÁLISIS DEL CÓDIGO EXISTENTE:
Identificar cómo la clase Reserva maneja actualmente las cancelaciones.
Observar si la lógica de cancelación está estrechamente acoplada a la clase Reserva y si sería
difícil añadir nuevas políticas de cancelación sin modificarla.

b) CREACIÓN DE UNA INTERFAZ POLITICACANCELACION:
Crear una interfaz PoliticaCancelacion con un método puedeCancelar(Reserva reserva).
Este método determinará si una reserva puede ser cancelada según la política específica.

c) IMPLEMENTACIÓN DE POLÍTICAS DE CANCELACIÓN CONCRETAS:
Crear clases que implementen la interfaz PoliticaCancelacion para representar diferentes políticas:
PoliticaCancelacionFlexible: Permite cancelar hasta 24 horas antes del check-in sin penalización.
PoliticaCancelacionModerada: Permite cancelar hasta 72 horas antes del check-in con una
penalización del 50%.
PoliticaCancelacionEstricta: No permite cancelaciones después de realizar la reserva.

Clases necesarias:
SRP:
• Habitacion (hijas: HabitacionIndividual, HabitacionDoble, más...)
• Reserva (Relacionada con Cliente y Habitacion)
• Cliente (Padre: Persona)
• Empleado (Padre: Persona)
• GestorDisponibilidadHabitacion
• GestionHabitaciones
• GeneradorInformes
• GestionClientes
• GestionPersonal
OCP:
• PoliticaCancelacion (interfaz)
• PoliticaCancelacionFlexible
• PoliticaCancelacionModerada
• PoliticaCancelacionEstricta
LSP: -
ISP:
• ServicioHabitacion (interfaz-> servicio de limpieza, servicio de comida, lavandería, etc. no todas las habitaciones tienen) (dividir)
• ServicioLimpieza (implementa ServicioHabitacion)
• ServicioComida (implementa ServicioHabitacion)
• ServicioLavanderia (implementa ServicioHabitacion)
DIP
• NotificadorReserva (interfaz-> notificar al cliente por email, sms, app, etc.)
• EnviadorCorreo (implementa NotificadorReserva~)
• CanalNotificacion (interfaz-> método enviarNotificacion)
• EnviadorCorreo (implementa CanalNotificacion)
• EnviadorSMS (implementa CanalNotificacion)
• EnviadorSlack (implementa CanalNotificacion)
• NotificadorReserva
*/