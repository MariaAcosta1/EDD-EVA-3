
package eva3_2_ordenar_collections;

import java.util.Comparator;
import java.util.LinkedList;

public class EVA3_2_ORDENAR_COLLECTIONS {

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(500);
        lista.add(200);
        lista.add(100);
        lista.add(700);
        lista.add(300);
        lista.add(600);
        lista.add(400);
        lista.add(800); 
        
        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                int val1 = (int)o1;
                int val2 = (int)o2;
                
                //el compare regresa un valor entero, que significa:
                //positivo --> o1 es mayor
                //cero --> o1 y o2 son iguales
                //negativo --> o2 es mayor
                return val1 - val2;                        
            }
        };
        lista.sort(comparator);
        System.out.println(lista);
        
        LinkedList<String> datos = new LinkedList<>();
        datos.add("Hol");
        datos.add("");
        datos.add("223");
        datos.add("%%%");
        Comparator comparator2 = new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                String cade1 = (String)o1;
                String cade2 = (String)o2;
                return cade1.compareTo(cade2);                      
            }
        };
        datos.sort(comparator2);
        System.out.println(datos);
    }
    
}