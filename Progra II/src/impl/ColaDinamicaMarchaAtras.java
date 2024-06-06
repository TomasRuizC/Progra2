package impl;

import api.ColaTDA;

public class ColaDinamicaMarchaAtras implements ColaTDA {

    Nodo primero;
    Nodo ultimo;

    @Override
    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    @Override
    public boolean ColaVacia() {
        return (primero==null);
    }

    @Override
    public void Acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        if (this.ColaVacia()){
            primero=aux;
            ultimo = aux;
        }else{
            aux.sig= ultimo;
            ultimo=aux;
        }
    }

    @Override
    public void Desacolar() {
        Nodo aux;
        aux=ultimo;
        if (aux.sig == null){
            primero = null;
            ultimo = null;

        }else{
            while(aux.sig.sig != null){
                aux = aux.sig;
            }
            aux.sig = null;
            primero = aux;
        }
        
        
    }

    @Override
    public int Primero() {
        return primero.info;
    }


}
