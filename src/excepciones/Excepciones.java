package excepciones;

/**
 *
 * @author Sara Muñoz Henao
 */
public class Excepciones extends Exception {

    public static final String CADENA_SIN_NUMERO = "Esta cadena no contiene un número para imprimir";
    public static final String CADENA_SIN_TAMANIO = "Esta cadena no contiene un tamaño para imprimir";
    public static final String SIN_CADENA = "No ingresó cadena";

    public Excepciones(String mensajeDeError) {
        super(mensajeDeError);
    }

}
