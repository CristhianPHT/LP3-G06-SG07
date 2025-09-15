package ejercicio01;

//Excepción de vocal
class VocalException extends Exception {
    public VocalException(String ex){ super(ex); }
}

//Excepción de número
class NumeroException extends Exception {
    public NumeroException(String ex){ super(ex); }
}

//Excepción de blanco
class BlancoException extends Exception {
    public BlancoException(String ex){ super(ex); }
}

//Excepción de salida
class SalidaException extends Exception {
    public SalidaException(String ex){ super(ex); }
}
