package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {

    int[] mis_claves;
    ConjuntoTDA conjuntoClave;
    int[] mis_valores;
    int cont;
    
    @Override
    public void InicializarDiccionario() {
        mis_claves = new int[100];
        mis_valores = new int[100];
        cont = 0;
        conjuntoClave = new ConjuntoEstatico();
        conjuntoClave.InicializarConjunto();
    }

    @Override
    public void Agregar(int clave, int valor) {
        if (!conjuntoClave.Pertenece(clave)){
            mis_claves[cont]=clave;
            mis_valores[cont]=valor;
            cont++;
            conjuntoClave.Agregar(clave);
        } 
    }

    @Override
    public void Eliminar(int clave) {
        if (conjuntoClave.Pertenece(clave)){
            int index = buscarIndexClave(clave);
            mis_claves[index]=mis_claves[cont-1];
            mis_valores[index]=mis_valores[cont-1];
            conjuntoClave.Sacar(clave);
            cont--;
    }
    }

    @Override
    public int Recuperar(int clave) {
        int index = -1;
        if (conjuntoClave.Pertenece(clave)){
            index = buscarIndexClave(clave);
        }
        return mis_valores[index];
        
        
    }

    @Override
    public ConjuntoTDA Claves() {
        return conjuntoClave;
        
    }

    private int buscarIndexClave (int clave){
        int i = 0;
        int index = -1;
        while (i < cont && index == -1){
            if (clave == mis_claves[i]){
                index = i;
            }
            i++;
        }
        return index;
    }

}
