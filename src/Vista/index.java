/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import idcrefactor.Controlador.Controlador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jenniffer
 */
public class index {
    
     static final String CADENA_FINAL = "0,0"; //cadena que indica el final de entradas.
     
     public static void main(String[] args) {
      // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        
        String comando; 
        int espacioEntreDigitos;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {
                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();
                

                // Valida si es un numero
                if (Controlador.isNumeric(comando)) 
                {
                    espacioEntreDigitos = Integer.parseInt(comando);
                    
                    // se valida que el espaciado este entre 0 y 5
                    if(espacioEntreDigitos <0 || espacioEntreDigitos >5)
                    {
                        throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre 0 y 5");
                    }
                    
                } 
                else 
                {
                    throw new IllegalArgumentException("Cadena " + comando
                            + " no es un entero");
                }
                
                do
                {
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                        listaComando.add(comando);
                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
            }

            Controlador entradaInformacion = new Controlador();

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    entradaInformacion.procesar(iterator.next(), espacioEntreDigitos);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }
}

