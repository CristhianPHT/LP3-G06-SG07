package ejercicio03;

public class Main {
    public static void main(String[] args) {
    	java.util.List<Vehiculo> vehiculos = new java.util.ArrayList<>();

        vehiculos.add(new Coche());
        vehiculos.add(new Bicicleta());

        for (Vehiculo v : vehiculos) {
            v.acelerar(); 
        }

        VehiculoConMotor coche = new Coche();
        coche.encenderMotor();
        coche.acelerar();
    }
}
