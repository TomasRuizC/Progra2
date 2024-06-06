// Realizado por Lussoro Nicolás y Ruiz Conforti Tomás
package impl;
import api.ListaTDA;

public class ListaDinamica implements ListaTDA {

    Nodo primero;
    Nodo ultimo;
    int i;

    @Override
    public void inicializarLista() {
        primero = null;
        ultimo = null;
        i=0;
    }

    @Override
    public void append(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        if(ultimo != null){
            ultimo.sig = aux;
        }
        ultimo = aux;
        if(primero == null){
            primero = ultimo;
        }
        if(ultimo.sig != null){
          System.out.println(ultimo.sig.info);
    }
        i++;
    }

    @Override
    public void clear() {
        primero = null;
        ultimo = null;
        i=0;
    }

    @Override
    public int count(int x) {
        Nodo aux = primero;
        int cont = 0;
        for (int k=0; k<i;k++){
            if (aux.info == x){
                cont++;
            }
            aux = aux.sig;
        }
        return cont;
    }

    @Override
    public int index(int x) {
        int cont=0;
        Nodo aux =primero;
        while (aux.info!=x && aux.sig!=null){
            cont++;
            aux=aux.sig;
        }
        return cont;
    }

    @Override
    public void insert(int x, int indice) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        Nodo aux2 =primero;
        if (indice!=0){
            for (int k=0; k<indice;k++){
                aux2=aux2.sig;
            }
            aux.sig=aux2.sig;
            aux2.sig=aux;
        }else{
            aux.sig=primero;
            primero=aux;
        }
        
        i++;
    }

    @Override
    public void pop() {
        this.remove(ultimo.info);
    }

    @Override
    public void remove(int x) {
        Nodo aux = primero;
        if(primero.info == x){
            primero = primero.sig;
        }else{
            while (aux.sig != null && aux.sig.info != x ){
                aux = aux.sig;
            }
            aux.sig = aux.sig.sig;
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
        return(primero==null);
    }

    @Override
    public void mostrarLista() {
        Nodo aux = primero;
        for(int k = 0; k < i; k++){
            if(k != i-1){
            System.out.print(aux.info + ", ");
            aux = aux.sig;
            }else{
                System.out.println(aux.info);
            }
        }
    }

    @Override
    public int recuperarPos(int x) {
        Nodo aux =primero;
        if (x!=0){
            for (int k=0; k<x;k++){
                aux=aux.sig;
            }
            return aux.info;
            
        }else{
            return primero.info;
        }
    }

}
