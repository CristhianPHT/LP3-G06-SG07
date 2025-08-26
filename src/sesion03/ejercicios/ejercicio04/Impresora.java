package ejercicio04;

interface ImpresoraBasica {
	void imprimir();
}

interface Escanear {
	void escanear();
}

class Impresora implements ImpresoraBasica {
	@Override
	public void imprimir() {
		System.out.println("Imprimiendo documento...");
	}
}

class ImpresoraMultifuncional implements ImpresoraBasica, Escaner {
	@Override
	public void imprimir() {
		System.out.println("Imprimiendo documento multifuncional...");
	}
	
	@Override
	public void escanear() {
		System.out.println("Escaneando documento multifuncional...");
	}
}