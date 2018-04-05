package idcrefactor.Modelo;

import idcrefactor.Controlador.Controlador;

/**
 *
 * @author Jenniffer
 */
public class ImpresorLCD {
    private String[][] matrizDeImpresion;
    // Calcula el numero de filasDigito
    private int filasDigito;
    private int columnasDigito;
    private int totalFilas;
    private int totalColum;
    Controlador controlador = new Controlador();
    int tamaño = controlador.getTamaño();
      /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param tamaño Tamaño Segmento Digitos
     * @param numeroaImprimir Numero a Imprimir
     * @param espacioEntreDigitos Espacio Entre digitos
     */    
    private void imprimirNumero(int tamaño, String numeroaImprimir, int espacioEntreDigitos) 
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

            adicionarDigito(numero);
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
