package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {

    int[] mis_claves;
    ConjuntoTDA[] mis_valores;
    ConjuntoTDA conjuntoClave;
    int cont;

    @Override
    public void InicializarDiccionario() {
        mis_claves = new int[100];
        mis_valores = new ConjuntoTDA[100];
        conjuntoClave = new ConjuntoEstatico();
        conjuntoClave.InicializarConjunto();
        cont =0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        if (!conjuntoClave.Pertenece(clave)){
            mis_claves[cont]=clave;
            mis_valores[cont]= new ConjuntoEstatico();
            mis_valores[cont].InicializarConjunto();
            mis_valores[cont].Agregar(valor);
            cont++;
            conjuntoClave.Agregar(clave);
        } else if (conjuntoClave.Pertenece(clave)){
            int index= buscarIndexClave(clave);
            mis_valores[index].Agregar(valor);
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
    public void EliminarValor(int clave, int valor) {
        if (conjuntoClave.Pertenece(clave)){
            int index= buscarIndexClave(clave);
            mis_valores[index].Sacar(valor);
        }
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        int index = -1;
        if (conjuntoClave.Pertenece(clave)){
            index= buscarIndexClave(clave);
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
