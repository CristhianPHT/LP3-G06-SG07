package sesion03.actividades;

public class Empleado extends Persona { // personal de limpieza, recepcionista, etc
    private String puesto;
    private String horario; // "turno mañana", "turno tarde"

    public Empleado(String nombre, int telefono, String email, int identificacion, String puesto, String horario) {
        super(nombre, telefono, email, identificacion);
        this.puesto = puesto;
        this.horario = horario;
    }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    @Override
    public String toString() {
        return "Empleado: " + super.toString() + "\npuesto: "+ puesto + "horario: " + horario;
    }
}

/*
Gestión de Personal:
• Registrar información del personal de limpieza.
• Asignar personal de limpieza a habitaciones para su limpieza.
• Consultar la carga de trabajo del personal de limpieza.
• Generación de Informes:
• Generar informes de ocupación por tipo de habitación y por periodo de tiempo.
• Generar informes de ingresos por periodo de tiempo.

*/