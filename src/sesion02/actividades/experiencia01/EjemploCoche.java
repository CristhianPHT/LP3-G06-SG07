package experiencia01;

public class EjemploCoche {
	public static void main(String[] args) {
		Coche cocheDeportivo = new Coche("Ferrari", "F8", 2009, 150000);
		Coche cocheTodoTerreno = new Coche("Toyota", "Land Cruiser", 2015, 80000);
		
		System.out.println(" --- Información inicial --- ");
		cocheDeportivo.mostrarInfo();
		cocheTodoTerreno.mostrarInfo();
		
		cocheDeportivo.encender();
		cocheTodoTerreno.encender();
		
		cocheDeportivo.acelerar();
		cocheTodoTerreno.acelerar();
		
		cocheDeportivo.frenar();
		cocheTodoTerreno.frenar();
		
		System.out.println(" --- Aplicando descuentos --- ");
		if (cocheDeportivo.aplicarDescuento(0.10)) {
            System.out.println("Descuento aplicado al deportivo. Nuevo precio: $" + cocheDeportivo.getPrecio());
        } else {
            System.out.println("No se aplicó descuento al deportivo.");
        }

        if (cocheTodoTerreno.aplicarDescuento(0.10)) {
            System.out.println("Descuento aplicado al todo terreno. Nuevo precio: $" + cocheTodoTerreno.getPrecio());
        } else {
            System.out.println("No se aplicó descuento al todo terreno.");
        }
        
        cocheDeportivo.apagar();
        cocheTodoTerreno.apagar();
		
	}
}
