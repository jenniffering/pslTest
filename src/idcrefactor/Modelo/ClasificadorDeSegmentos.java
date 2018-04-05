
package idcrefactor.Modelo;

/**
 *
 * @author Jenniffer
 */
public class ClasificadorDeSegmentos {
    
    // Puntos fijos
    private final int[] puntoFijo1;
    private final int[] puntoFijo2;
    private final int[] puntoFijo3;
    private final int[] puntoFijo4;
    private final int[] puntoFijo5;
    
    private int tamaño;
    
    private String[][] matrizDeImpresion;
    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    public ClasificadorDeSegmentos() {
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
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo1, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo2, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo5, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo4, POSICION_Y,
                        this.tamaño, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo1, POSICION_X,
                        this.tamaño, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo2, POSICION_X,
                        this.tamaño, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizDeImpresion, this.puntoFijo3, POSICION_X,
                        this.tamaño, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
        
    }
}
