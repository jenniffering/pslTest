
package idcrefactor.Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jenniffer
 */
public class Segmentador {
 
    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito en la matriz.
     *
     * @param numero Digito
     */
    private void adicionarDigito(int numero) {

        // Establece los segmentos de cada numero
        List<String> segmentosDeNumeros = new ArrayList<>();

        switch (numero) {
            case 1:
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("surEste");
                break;
            case 2:
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("centro");
                segmentosDeNumeros.add("surOeste");
                segmentosDeNumeros.add("sur");
                break;
            case 3:
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("centro");
                segmentosDeNumeros.add("surEste");
                segmentosDeNumeros.add("sur");
                break;
            case 4:
                segmentosDeNumeros.add("norOeste");
                segmentosDeNumeros.add("centro");
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("surEste");
                break;
            case 5:
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("norOeste");
                segmentosDeNumeros.add("centro");
                segmentosDeNumeros.add("surEste");
                segmentosDeNumeros.add("sur");
                break;
            case 6:
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("norOeste");
                segmentosDeNumeros.add("centro");
                segmentosDeNumeros.add("surOeste");
                segmentosDeNumeros.add("sur");
                segmentosDeNumeros.add("surEste");
                break;
            case 7:
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("surEste");
                break;
            case 8:
                segmentosDeNumeros.add("norOeste");
                segmentosDeNumeros.add("surOeste");
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("surEste");
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("centro");
                segmentosDeNumeros.add("sur");
                break;
            case 9:
                segmentosDeNumeros.add("norOeste");
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("surEste");
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("centro");
                segmentosDeNumeros.add("sur");
                break;
            case 0:
                segmentosDeNumeros.add("norOeste");
                segmentosDeNumeros.add("surOeste");
                segmentosDeNumeros.add("norEste");
                segmentosDeNumeros.add("surEse");
                segmentosDeNumeros.add("norte");
                segmentosDeNumeros.add("sur");
                break;
            default:
                break;
        }
/*
        Iterator<Integer> iterator = segmentosDeNumeros.iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
*/
    }
    
}
