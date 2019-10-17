
package excepciones;

import static excepciones.Excepciones.CADENA_SIN_NUMERO;
import static excepciones.Excepciones.CADENA_SIN_TAMANIO;
import static excepciones.Excepciones.SIN_CADENA;

/**
 *
 * @author Sara 
 */
public class Validaciones {
    

    public static void validacionSinNumero(String entrada) throws Excepciones {
        String[] separador;
        separador = entrada.split(",");
        if ((separador.length == 1)) {
            throw new Excepciones(CADENA_SIN_NUMERO);
        }
    }

    public static void validacionSinTamanio(String entrada) throws Excepciones {
        String[] separador;
        separador = entrada.split(",");
        if ((separador[0]) == null) {
            throw new Excepciones(CADENA_SIN_TAMANIO);
        }
    }
    
        public static void validacionVacio(String entrada) throws Excepciones {
        if (entrada == null || entrada==",") {
            throw new Excepciones(SIN_CADENA);
        }
    }
}
