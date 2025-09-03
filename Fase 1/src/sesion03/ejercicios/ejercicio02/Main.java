package ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Forma> formas = new ArrayList<>();
		formas.add(new Circulo());
		formas.add(new Rectangulo());
		formas.add(new Triangulo());
		
		for (Forma f : formas) {
			f.dibujar();
		}
	}
}
