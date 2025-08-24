package experiencia01;
public class Coche {
	private String marca;
	private String modelo;
	private int aniodeFab;
	private double precio;
	private boolean enMarcha;
	
	public Coche() {
		this.marca = "Desconocida";
		this.modelo = "genérico";
		this.aniodeFab = 2000;
		this.precio = 0.0;
		this.enMarcha = false;
	}
	
	public Coche(String marca, String modelo, int aniodeFab, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.aniodeFab = aniodeFab;
		this.precio = precio;
		this.enMarcha = false;
	}
	
	public String getMarca() { return marca; }
	public void setMarca(String marca) { this.marca = marca; }
	
	public String getModelo() { return modelo; }
	public void setModelo(String modelo) { this.modelo = modelo; }
	
	public int getAniodeFab() { return aniodeFab; }
	public void setAniodeFab(int aniodeFab) { this.aniodeFab = aniodeFab; }
	
	public double getPrecio() { return precio; }
	public void setPrecio(double precio) { this.precio = precio; }
	
	public boolean isEnMarcha() { return enMarcha; }
	
	public boolean aplicarDescuento(double descuento) {
		if(aniodeFab < 2010) {
			this.precio -= this.precio * descuento;
			return true;
		} else {
			return false;
		}
	}
	
	public void encender() {
		enMarcha = true;
		System.out.println("El coche " + modelo + " se ha encendido.");
	}
	
	public void acelerar() {
		if (enMarcha) {
			System.out.println("El coche " + modelo + " está acelerando.");
		} else {
			System.out.println("Primero enciende el coche.");
		}
	}
	
	public void frenar() {
		if(enMarcha) {
			System.out.println("El coche " + modelo + " está frenando.");
		} else {
			System.out.println("El coche está apagado, no se puede frenar.");
		}
	}
	
	public void apagar() {
		enMarcha = false;
		System.out.println("El coche " + modelo + " se ha apagado.");
	}
	
	public void mostrarInfo() {
		System.out.println("Marca: " + marca + " | Modelo: " + modelo + " | Año: " + aniodeFab + " | Precio: $" + precio);
	}
}
