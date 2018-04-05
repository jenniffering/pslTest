package idcrefactor.Controlador;


import idcrefactor.Modelo.ImpresorLCD;

/**
 *
 * @author Jenniffer
 */
public class Controlador {
    int tamaño;
    int espacioEntreDigitos;
    
    ImpresorLCD imprimirN = new ImpresorLCD();

    public Controlador() {
        this.tamaño= 0;
        this.espacioEntreDigitos=0;
    }

    public int getTamaño() {
        return this.tamaño;
    }

    public int getEspacioEntreDigitos() {
        return this.espacioEntreDigitos;
    }
   

    /**
     *
     * Metodo encargado de procesar la entrada que contiene el tamaño del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el tamaño del segmento de los digito
     * y el numero a imprimir
     * @param espacioEntreDigitos Espacio Entre digitos
     */  
    public void procesar(String comando, int espacioEntreDigitos) {
        
        this.espacioEntreDigitos=espacioEntreDigitos;
        String[] parametros;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }
        
        //Se hace el split de la cadena
        parametros = comando.split(",");
        
        //Valida la cantidad de parametros
        if(parametros.length>2)
        {
           throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas caracter ,"); 
        }else if (parametros.length<2){
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos"); 
        }
        
        
        //Valida que el parametro tamaño sea un numerico
        if(isNumeric(parametros[0]))
        {
            this.tamaño = Integer.parseInt(parametros[0]);
            
            // se valida que el tamaño este entre 1 y 10
            if(this.tamaño <1 || this.tamaño >10)
            {
                throw new IllegalArgumentException("El parametro size ["+this.tamaño
                        + "] debe estar entre 1 y 10");
            }
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
        // Realiza la impresion del numero
    
       imprimirN.imprimirNumero(this.tamaño,parametros[1],this.espacioEntreDigitos);
      
       

    }
    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */  
      public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
     
    
}
