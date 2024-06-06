public class Insercion {

    public static void insertarEnVector (int[] origen, int index, int elem, int ultElem){

        for (int i=ultElem; i<index; i--){
            origen[i]=origen[i-1];
        }
        origen[index]=elem;
    }

    public static void main (String[] args) {
        int cont = 0;
        int[] v = new int[30];
        for(int i = 0; i <= 5; i++){
            v[i] = i;
            cont++; 
        }

        insertarEnVector(v,3,7,cont);

        for (int elem:v){
            System.out.println(elem);
        }

    }

}
