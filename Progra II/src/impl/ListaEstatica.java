// Realizado por Lussoro Nicolás y Ruiz Conforti Tomás
package impl;

import api.ListaTDA;

public class ListaEstatica implements ListaTDA {

    int[] vector;
    int i;
    
    public void inicializarLista() {
        vector = new int[100];
        i = 0;
    }

    @Override
    public void append(int x) {
        vector[i] = x;
        i++;
    }

    @Override
    public void clear() {
        i = 0;
    }

    @Override
    public int count(int x) {
        int cont = 0;
        for(int k = 0; k < i; k++){
            if(vector[k] == x){
                cont ++;
            }
        }
        return cont;
    }

    @Override
    public int index(int x) {
        int k = 0;
        while(vector[k] != x && k < i){
            k++;
        }
        return k;
    }

    @Override
    public void insert(int x, int indice) {
        for(int j = i; j > indice; j--){
            vector[j] = vector[j - 1];
        }
        vector[indice] = x;
        i++;
    }

    @Override
    public void pop() {
        i--;
    }

    @Override
    public void remove(int x) {

        for(int j = this.index(x); j < i-1 ; j++){
            vector[j] = vector[j+1];
        }
        i--;
    }

    @Override
    public void removeAll(int x) {
        for(int k = 0; k <= this.count(x); k++){
            this.remove(x);
        }
    }

    @Override
    public boolean listaVacia() {
        return (i==0);
    }

    @Override
    public void mostrarLista() {
        for(int k = 0; k < i; k++){
            if(k != i-1){
            System.out.print(vector[k]+", ");
            }else{
                System.out.println(vector[k]);
            }
        }
    }

    @Override
    public int recuperarPos(int x) {
        return vector[x];
    }

}

