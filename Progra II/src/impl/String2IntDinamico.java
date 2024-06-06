package impl;

import api.String2IntTDA;

public class String2IntDinamico implements String2IntTDA{

    NodoString2Int primero;
    int cont;

    @Override
    public void Inicializar() {
        primero = null;
        cont = 0;
    }

    @Override
    public void Agregar(String x) {
        NodoString2Int aux = new NodoString2Int();
        aux.num = cont;
        cont++;
        aux.str = x;
        aux.sig = null;

        if (primero==null){
            primero = aux;
        }else if (!Pertenece(x)){
            aux.sig = primero;
            primero = aux;
        }
    }

    @Override
    public String DevolverString(int y) {
        NodoString2Int aux = primero;
        while (aux.num!=y){
            aux = aux.sig;
        }
        return aux.str;
    }

    @Override
    public int DevolverInt(String x) {
        NodoString2Int aux = primero;
        while (aux.str!=x){
            aux = aux.sig;
        }
        return aux.num;
    }

    @Override
    public boolean Pertenece(String x) {
        NodoString2Int aux = primero;

        if (aux==null){
            return false;
        }

        while (aux.str != x && aux.sig != null) {
            aux = aux.sig;
        }
        
        return (aux.str == x);
    }

    


}
