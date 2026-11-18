
package eva3_1_ordenamientos;

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        int[] original, selection, insertion, bubble, quick;
        long inicio, fin, tiempo;
        original = new int[10];        
        //-----Arreglo original-----
        llenar(original);
        System.out.println("-----Arreglo original-----");
        imprimir(original);
        //Selection sort
        System.out.println("-----Selection sort-----");
        selection = copiar(original);
        inicio = System.nanoTime();
        selectionSort(selection);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        imprimir(selection);
        System.out.println("Selection Sort = " + tiempo);
        
        System.out.println("-----Insertion Sort-----");
        insertion = copiar(original);
        inicio = System.nanoTime();
        insertionSort(insertion);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        imprimir(insertion);
        System.out.println("Insertion Sort = " + tiempo);
        
        System.out.println("-----Bubble Sort-----");
        bubble = copiar(original);
        inicio = System.nanoTime();
        BubbleSort(bubble);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        imprimir(bubble);
        System.out.println("Bubble Sort = " + tiempo);
        
        System.out.println("-----Quick Sort-----");
        quick = copiar(original);
        inicio = System.nanoTime();
        QuickSort(quick);
        fin = System.nanoTime();
        tiempo = fin - inicio;
        imprimir(quick);
        System.out.println("Quick Sort = " + tiempo);

        
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
    public static int[] copiar(int[] arreglo){
        int resu[] = new int[arreglo.length];
        for(int i = 0; i < arreglo.length; i++){
            resu[i] = arreglo[i];
        }
        return resu;
    }
    //Metodos de ordenamiento
    //Selection sort
    //O(N2)
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
    public static void insertionSort(int[] arreglo){
        for(int i = 1; i < arreglo.length; i++){ 
            int temporal = arreglo[i];
            int j = i - 1;

            while(j >= 0 && arreglo[j] > temporal){
                arreglo[j + 1] = arreglo[j]; 
                j--;
            }
            arreglo[j + 1] = temporal; 
            //Arreglo[i]= n, Temporal = n
            //insP = 1 -> Arreglo[insP] = n --> insertion Sort
            //Arreglo[Prev] = n
        }
    }
    //El peor de los peores
    //O(N2)
    //Tiene los peores atributos de los algoritmos anteriores:
    //Compara mucho
    //Intercambia mucho
    //Tentador: el más facil
    public static void BubbleSort(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){ 
            for(int j = 0; j < arreglo.length - 1; j++){
                if(arreglo[j] > arreglo[j + 1]){
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
            }
        }
    }
    public static void QuickSort(int[] arreglo){
        QuickSortRec(arreglo, 0, arreglo.length - 1);
    }
    public static void QuickSortRec(int[] arreglo, int ini, int fin){
        int i = ini;
        int j = fin;
        int pivote = arreglo[(ini + fin) / 2];
        
        while(i <= j){
            while(arreglo[i] < pivote){
                i++;
            }
            while(arreglo[j] > pivote){
                j--;
            }
            
            if(i <= j){
                int temporal = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temporal;
                i++;
                j--;
            }
            if(ini < j){
                QuickSortRec(arreglo, ini, j);
            }
            if(i < fin){
                QuickSortRec(arreglo, i, fin);
            }
            //Condicion para evitar recursividad
            //Seleccionar pivote
            //ciclo que se repite mientras los indices no se crucen
            //buscar mas grandes que el pivote
            //buscar mas pequeños que el pivote
            //No cruzado pero se detenieron
            //swap
            //si se cruzan
            //swap pequeño con pivote --> small es nuevo pivote
            //terminar ciclo principal
            //llamadas (2 izq y der de pivote) recursivas
        } 
    }
}
