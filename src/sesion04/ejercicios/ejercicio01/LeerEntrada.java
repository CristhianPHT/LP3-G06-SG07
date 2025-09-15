package ejercicio01;
	
public class LeerEntrada {
    public void procesar(char c) throws VocalException, NumeroException, BlancoException, SalidaException {
        char cha = Character.toLowerCase(c);
        if (cha == 's') throw new SalidaException("Saliendo del programa...");
        if (Character.isDigit(cha)) throw new NumeroException("Sé ingresó un número: " + cha);
        if (Character.isWhitespace(cha)) throw new BlancoException("Se ingresó un espacio");
        if ("aeiou".indexOf(cha) >= 0) throw new VocalException("Se ingresó una vocal: " + cha);
    }
}
