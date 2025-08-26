package ejercicio03;

interface Vehiculo {
	void acelerar();
}

interface VehiculoConMotor extends Vehiculo {
	void encenderMotor();
}

class Coche implements VehiculoConMotor {
	@Override
	public void acelerar() {
		System.out.println("Coche acelera usando el motor...");
	}
	
	@Override
	public void encenderMotor() {
		System.out.println("Motor encendido.");
	}
}

class Bicicleta implements Vehiculo {
	@Override
	public void acelerar() {
		System.out.println("Bicicleta acelera pedaleando...");
	}
}
