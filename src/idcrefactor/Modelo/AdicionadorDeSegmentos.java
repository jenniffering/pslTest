
package idcrefactor.Modelo;

import idcrefactor.Controlador.Controlador;

/**
 *
 * @author Jenniffer
 */
public class AdicionadorDeSegmentos {
    // Calcula el numero de filasDigito
    private int filasDigito;
    private int columnasDigito;
    private int totalFilas;
    private int totalColum;
    Controlador controlador = new Controlador();
     int tamaño = controlador.getTamaño();
     Segmentador numeroLcd = new Segmentador();
    
    // Puntos fijos
    private final int[] puntoFijo1;
    private final int[] puntoFijo2;
    private final int[] puntoFijo3;
    private final int[] puntoFijo4;
    private final int[] puntoFijo5;
    
    
    private String[][] matrizDeImpresion;
    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    public AdicionadorDeSegmentos() {
         // Inicializa variables
        this.puntoFijo1 = new int[2];
        this.puntoFijo2 = new int[2];
        this.puntoFijo3 = new int[2];
        this.puntoFijo4 = new int[2];
        this.puntoFijo5 = new int[2];
    }

    
    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote
     * @param posicionFija Posicion Fija
     * @param tamaño Tamaño Segmento
     * @param caracter Caracter Segmento
     */    
    private void adicionarLinea(String[][] matriz, int[] punto, String posicionFija,
            int tamaño, String caracter) {

        if (posicionFija.equalsIgnoreCase(POSICION_X)) 
        {
            for (int y = 1; y <= tamaño; y++) 
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } 
        else 
        {
            for (int i = 1; i <= tamaño; i++) 
            {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }
    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */  
    void adicionarSegmento(String segmento) {

        switch (segmento) {
            case "norOeste":
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo1, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case "surOeste":
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo2, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case "norEste":
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo5, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case "surEste":
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo4, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case "norte":
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo1, POSICION_X,
                        this.tamaño, CARACTER_HORIZONTAL);
                break;
            case "centro":
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo2, POSICION_X,
                        this.tamaño, CARACTER_HORIZONTAL);
                break;
            case "sur":
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo3, POSICION_X,
                        this.tamaño, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
        
    }
      /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param tamaño Tamaño Segmento Digitos
     * @param numeroaImprimir Numero a Imprimir
     * @param espacioEntreDigitos Espacio Entre digitos
     */    
    public void imprimirNumero(int tamaño, String numeroaImprimir, int espacioEntreDigitos) 
    {
        int pivotX = 0;
        char[] digitos;

        this.tamaño = tamaño;

        // Calcula el numero de filas cada digito
        this.filasDigito = (2 * this.tamaño) + 3;

        // Calcula el numero de columna de cada digito
        this.columnasDigito = this.tamaño + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDigito;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (this.columnasDigito * numeroaImprimir.length())
                + (espacioEntreDigitos * numeroaImprimir.length());

        // crea matriz para almacenar los numero a imprimir
        this.matrizDeImpresion = new String[this.totalFilas][this.totalColum];

        // crea el arreglo de digitos
        digitos = numeroaImprimir.toCharArray();

        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizDeImpresion[i][j] = " ";
            }
        }

        for (char digito : digitos) {
            
            //Valida que el caracter sea un digito
            if( ! Character.isDigit(digito))
            {
                throw new IllegalArgumentException("Caracter " + digito
                    + " no es un digito");
            }

            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.puntoFijo1[0] = 0;
            this.puntoFijo1[1] = 0 + pivotX;

            this.puntoFijo2[0] = (this.filasDigito / 2);
            this.puntoFijo2[1] = 0 + pivotX;

            this.puntoFijo3[0] = (this.filasDigito - 1);
            this.puntoFijo3[1] = 0 + pivotX;

            this.puntoFijo4[0] = (this.columnasDigito - 1);
            this.puntoFijo4[1] = (this.filasDigito / 2) + pivotX;

            this.puntoFijo5[0] = 0;
            this.puntoFijo5[1] = (this.columnasDigito - 1) + pivotX;

            pivotX = pivotX + this.columnasDigito + espacioEntreDigitos;

            numeroLcd.adicionarDigito(numero);
        }

        // Imprime matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                System.out.print(this.matrizDeImpresion[i][j]);
            }
            System.out.println();
        }
    }
}
