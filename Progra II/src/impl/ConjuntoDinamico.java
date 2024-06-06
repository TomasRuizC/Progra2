package impl;

import api.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA {

    Nodo primero;
    int cont;
    

    @Override
    public void InicializarConjunto() {
        primero = null;
        cont = 0;
        
    }

    @Override
    public boolean ConjuntoVacio() {
        return (primero==null);
    }

    @Override
    public void Agregar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        if (this.ConjuntoVacio()){
            primero=aux;
            cont++;
        }else if(!this.Pertenece(x)){
            aux.sig = primero;
            primero = aux;
            cont++;
        }
        
       
    }

    @Override
    public int Elegir() {
        Nodo aux = primero;


        int posicionAzar = Math.abs((int)System.nanoTime() % cont);
        for (int i=0; i<posicionAzar; i++){
            aux=aux.sig;
        }
        return aux.info;
    }

    @Override
    public void Sacar(int x) {
        if(this.Pertenece(x)){
            if(primero.info == x){
                primero = primero.sig;
            }else{
                Nodo aux = primero;
                while(aux.sig != null && aux.sig.info != x ){
                    aux = aux.sig;
                }
                aux.sig = aux.sig.sig;
            }
            cont--;
        }
    }

    @Override
    public boolean Pertenece(int x) {
        Nodo aux = primero;


        while (aux.info != x && aux.sig != null) {
            aux = aux.sig;
        }
        
        return (aux.info == x);
        
    }

}
