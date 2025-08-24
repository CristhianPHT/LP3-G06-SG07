package experiencia04;

public class TestComposicion {
	public static void main(String[] args) {
		Persona p1 = new Persona(2507, "Jennifer", "Romero", 808);
		Persona p2  = new Persona(2508, "Daniela", "Suarez", 809);
		
		p1.getCuenta().setSaldo(2500.50);
		p2.getCuenta().setSaldo(1500.75);
		
		System.out.println(p1);
		System.out.println(p2);
	}
}
