package metodosdeimpresion;

/**
 *
 * @author Sara Muñoz Henao
 * Esta clase fue creada para los métodos del proceso de impresión de números al estilo LCD
 */
public class ImpresionNumeros {

    public static int[] numeros;
    public static String[] separador;
    public static String size;
    public static int columnas;
    public static int filas;

    public ImpresionNumeros() {

    }
/**
 * Este método sirve para separar la cadena que llega por 
 * @param entradaDatos para conocer cual es el tamaño del display y cuales son los números
 * a mostrar por el display, con  @param cantRegistros tengo control de cuántos números se van a 
 * imprimir por pantalla respecto a la entradaDatos.
 */
    public static void separarNumeros(String[] entradaDatos, int cantRegistros) {
        for (int i = 0; i < cantRegistros; i++) {
            separador = entradaDatos[i].split(",");
            size = separador[0];
            int cantNumeros = (separador[1]).length();
            int digitos = Integer.parseInt((separador[1]));
            numeros = new int[cantNumeros];

            for (int j = cantNumeros - 1; j >= 0; j--) {
                numeros[j] = digitos % 10;
                digitos = digitos / 10;
            }
            imprimirNumeros();
        }
    }
    /**
     * Este método es el principal, el que hace todo el proceso dependiendo de los números ingresados y
     * ya separados  en un vector, este me llama los métodos de los números respectivos y los guarda
     * en un vector, para este luego ser impreso.
     */

    public static void imprimirNumeros() {
        columnas = ((Integer.parseInt(size)) + 2) * 2 - 1;
        filas = (2 * (Integer.parseInt(size)) + 3) * 2 - 1;
        String[] vectorNumeros = new String[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            switch (numeros[i]) {
                case 0:
                    vectorNumeros[i] = imprimirNumeroCero();
                    break;
                case 1:
                    vectorNumeros[i] = imprimirNumeroUno();
                    break;
                case 2:
                    vectorNumeros[i] = imprimirNumeroDos();
                    break;
                case 3:
                    vectorNumeros[i] = imprimirNumeroTres();
                    break;
                case 4:
                    vectorNumeros[i] = imprimirNumeroCuatro();
                    break;
                case 5:
                    vectorNumeros[i] = imprimirNumeroCinco();
                    break;
                case 6:
                    vectorNumeros[i] = imprimirNumeroSeis();
                    break;
                case 7:
                    vectorNumeros[i] = imprimirNumeroSiete();
                    break;
                case 8:
                    vectorNumeros[i] = imprimirNumeroOcho();
                    break;
                case 9:
                    vectorNumeros[i] = imprimirNumeroNueve();
                    break;
            }
        }
        for (int i = 0; i < vectorNumeros.length; i++) {
            System.out.print(vectorNumeros[i]);
        }
    }
    

    /**
     * Se pensó armar el número como esta construido un BCD-7 segmentos, que dependiendo del número se "prende"
     * un segmento en específico, este método recibe el 
     * @param columnas porque dependiendo del tamaño "parte"
     * el segmento para que este ocupe el tamaño correspondiente y me  @return concatenar que es un String donde
     * concateno ese segmento.
     * Esta lógica aplica para los otros segmentos del display, los segmentos son: A-B-C-D-E-F-G.
     */
    public static String imprimirSegmentoAGD(int columnas) {
        String horizontal = "-";
        String concatenar = "";
        String[] segmento = new String[columnas];
        for (int i = 0; i < segmento.length; i++) {
            if ((i % 2 == 0) && i != 0 && i != columnas - 1) {
                segmento[i] = horizontal;
                concatenar += segmento[i];
            } else {
                segmento[i] = " ";
                concatenar += segmento[i];
            }
        }
        concatenar += "\n";
        return concatenar;
    }

    public static String imprimirSegmentoBC(int columnas) {
        String vertical = "|";
        String concatenar = "";
        String[] segmento = new String[columnas];
        for (int j = 0; j < Integer.parseInt(size); j++) {
            for (int i = 0; i < segmento.length; i++) {
                if (i != (columnas - 1)) {
                    segmento[i] = " ";
                    concatenar += segmento[i];
                } else {
                    segmento[i] = vertical;
                    concatenar += segmento[i];
                }
            }
            concatenar += "\n";
        }
        return concatenar;
    }

    public static String imprimirSegmentoFE(int columnas) {
        String vertical = "|";
        String concatenar = "";
        String[] segmento = new String[columnas];
        for (int j = 0; j < Integer.parseInt(size); j++) {
            for (int i = 0; i < segmento.length; i++) {
                if (i == 0) {
                    segmento[i] = vertical;
                    concatenar += segmento[i];
                } else {
                    segmento[i] = " ";
                    concatenar += segmento[i];
                }
            }
            concatenar += "\n";
        }
        return concatenar;
    }

    public static String imprimirSegmentoFBEC(int columnas) {
        String vertical = "|";
        String concatenar = "";
        String[] segmento = new String[columnas];
        for (int j = 0; j < Integer.parseInt(size); j++) {
            for (int i = 0; i < segmento.length; i++) {
                if (i == 0) {
                    segmento[i] = vertical;
                    concatenar += segmento[i];
                } else if (i == columnas - 1) {
                    segmento[i] = vertical;
                    concatenar += segmento[i];
                }
                segmento[i] = " ";
                concatenar += segmento[i];
            }
            concatenar += "\n";
        }
        return concatenar;
    }

    public static String imprimirSegmentoVacio(int columnas) {
        String concatenar = "";
        String[] segmento = new String[columnas];
        for (int i = 0; i < segmento.length; i++) {
            segmento[i] = " ";
            concatenar += segmento[i];
        }
        
        concatenar += "\n";
        
        return concatenar;
    }
/**
 * En este método se "arma" el número con los segmentos correspondientes de cada uno como un BCD-7segmentos y
 * @return un acumuladordeString que es una variable tipo String que concatena todos los segmentos
 * para ser guardada en un vector. Esto aplica para los números desde 0 hasta 9. Se creo un método por cada número.
 */
    public static String imprimirNumeroTres() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroCero() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFBEC(columnas);
        acumuladorDeString += imprimirSegmentoVacio(columnas);
        acumuladorDeString += imprimirSegmentoFBEC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroOcho() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFBEC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFBEC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroUno() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoVacio(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoVacio(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoVacio(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroDos() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFE(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroCuatro() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoVacio(columnas);
        acumuladorDeString += imprimirSegmentoFBEC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoVacio(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroCinco() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFE(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroSeis() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFE(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFBEC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroSiete() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoVacio(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoVacio(columnas);

        return acumuladorDeString;
    }

    public static String imprimirNumeroNueve() {
        String acumuladorDeString;

        acumuladorDeString = imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoFBEC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);
        acumuladorDeString += imprimirSegmentoBC(columnas);
        acumuladorDeString += imprimirSegmentoAGD(columnas);

        return acumuladorDeString;
    }
}
