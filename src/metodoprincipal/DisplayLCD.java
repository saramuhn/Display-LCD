package metodoprincipal;

import excepciones.Excepciones;
import static excepciones.Excepciones.CADENA_SIN_NUMERO;
import static excepciones.Excepciones.CADENA_SIN_TAMANIO;
import excepciones.Validaciones;
import metodosdeimpresion.ImpresionNumeros;
import java.util.Scanner;

/**
 *
 * @author Sara Muñoz Henao
 */
public class DisplayLCD {

    public static void main(String[] args) {
        String entrada = "";
        String[] entradaDatos = new String[100];
        Scanner entradaEscaner = new Scanner(System.in);
        int cantRegistros = 0;
        while (!entrada.equals(String.valueOf("0,0"))) {
            try {
                System.out.print("Ingrese la cadena de números : ");
                entrada = entradaEscaner.nextLine();
                Validaciones.validacionSinNumero(entrada);
                Validaciones.validacionSinTamanio(entrada);
                Validaciones.validacionVacio(entrada);
            } catch (Excepciones e) {
                System.out.println(e.getMessage());
                break;
            }
            entradaDatos[cantRegistros] = entrada;
            cantRegistros++;
        }
        ImpresionNumeros.separarNumeros(entradaDatos, cantRegistros - 1);
    }

}
