package ejercicio02;

interface Forma {
	void dibujar();
}

class Circulo implements Forma {
	@Override
	public void dibujar() {
		System.out.println("Dibujar círculo");
	}
}

class Rectangulo implements Forma {
	@Override
	public void dibujar() {
		System.out.println("Dibujar rectángulo");
	}
}

class Triangulo implements Forma {
	@Override
	public void dibujar() {
		System.out.println("Dibujar trAIngulo");
	}
}
