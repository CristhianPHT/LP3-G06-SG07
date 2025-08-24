package experiencia02;
public class ContadorTest {
	
	public static void main(String[] args) {
		Contador c1, c2, c3;
		
		System.out.println(Contador.acumulador());
		c1 = new Contador(3);
		c1.inc();
		c1.inc();
		System.out.println("valor de c1: " + c1.getValor());
		System.out.println("Num de contadores: " + Contador.getNContadores());
		System.out.println("Ultimo contador creado: " + Contador.getUltimoContador());
		System.out.println("Acumulador: " + Contador.getAcumulador());
		c2 =  new Contador(10);
		c2.inc();
		System.out.println("valor de c2: " + c2.getValor());
		System.out.println("Num de contadores: " + Contador.getNContadores());
		System.out.println("Ultimo contador creado: " + Contador.getUltimoContador());
		System.out.println("Acumulador: " + Contador.getAcumulador());
		c3 = new Contador();
		System.out.println("valor de c3: " + c3.getValor());
		System.out.println("Num de contadores: " + Contador.getNContadores());
		System.out.println("Ultimo contador creado: " + Contador.getUltimoContador());
		System.out.println("Acumulador: " + Contador.getAcumulador());
		System.out.println(Contador.acumulador);
	}
}
