
package eva3_3_busqueda_binaria;

import java.util.Scanner;

public class EVA3_3_BUSQUEDA_BINARIA {

    public static void main(String[] args) {
        int[] original;
        original = new int[10];    
        llenar(original);
        System.out.println("-----Arreglo original-----");
        imprimir(original);
        
        selectionSort(original);
        System.out.println("Arreglo ordenado: ");
        imprimir(original);
        
        Scanner captu = new Scanner(System.in);
        System.out.println("Valor a buscar: ");
        int valor = captu.nextInt();
        System.out.println("Arreglo en posicion: " + busquedaBinaria(original, valor));
        
    }
    public static void llenar(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = (int)(Math.random() * 100);
            
            for(int j = 0; j < i; j++){
                if(arreglo[i] == arreglo[j]){
                    i--;
                    break;
                }
            }
        }
    }
    public static void imprimir(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    public static void selectionSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++){//controla las pasadas
            int min = i; //cuando empiezo, el más pequeño es el primer elemento
            for(int j = i + 1; j < arreglo.length; j++){ //busca el valor mas pequeño
                if(arreglo[min] > arreglo[j]) //nuevo minimo
                    min = j;                
            }
            //Intercambio o swap
            int temporal = arreglo[min];
            arreglo[min] = arreglo[i];
            arreglo[i] = temporal;
        }
    }
    public static int busquedaBinaria(int[] arreglo, int valor){
        return busquedaBinariaRecu(arreglo, valor, 0, arreglo.length - 1);
    }
    private static int busquedaBinariaRecu(int[] arreglo, int valor, int ini, int fin){
        int mitad = ini + ((fin-ini) / 2); //Determina la posicion intermedia
        int posicion = -1;   //por default --> no encontrado (-1 no es posicion valida)
        if(ini <= fin){
        if(valor > arreglo[mitad]) //no esta --> buscar en lado derecho
            posicion = busquedaBinariaRecu(arreglo, valor, mitad + 1, fin);
        else if(valor < arreglo[mitad]) //no esta --> buscar en lado derecho
            posicion = busquedaBinariaRecu(arreglo, valor, ini, mitad - 1);
        else //lo encontre
            posicion = mitad;
        }
        return posicion; //regreso la posición del elemento
    }
}
