package experiencia03;

public class TestAgregacion {
	public static void main(String[] args) {
		Motor m1 = new Motor(1001, 6000);
		Motor m2 = new Motor(1002, 7500);
		
		Automovil a1 = new Automovil("DREAM19", 4, "Toyota", "Corolla");
		Automovil a2 = new Automovil("P1NK808", 2, "Mazda", "RX7");
		
		a1.setMotor(m1);
		a2.setMotor(m2);
		
		System.out.println(a1);
		System.out.println(a2);
	}
}
