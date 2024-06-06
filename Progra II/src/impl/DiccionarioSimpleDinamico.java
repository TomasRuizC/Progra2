package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
    NodoClaveValor primero;
    ConjuntoTDA conjuntoClave;
    int cont;

    @Override
    public void InicializarDiccionario() {
        primero = null;
        conjuntoClave = new ConjuntoDinamico();
        conjuntoClave.InicializarConjunto();
        cont = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        NodoClaveValor aux = new NodoClaveValor();
        aux.clave = clave;
        aux.valor = valor;
        aux.sig = null;
        if (conjuntoClave.ConjuntoVacio()){
            primero = aux;
            conjuntoClave.Agregar(clave);
        }else if(!conjuntoClave.Pertenece(clave)){
            aux.sig = primero;
            primero = aux;
            conjuntoClave.Agregar(clave);
        }
        cont++;
    }

    @Override
    public void Eliminar(int clave) {
        NodoClaveValor aux = primero;

        if (conjuntoClave.Pertenece(clave)){
            if(primero.clave == clave){
                primero = primero.sig;
            }else{
            while (aux.sig != null && aux.sig.clave != clave ){
                aux = aux.sig;
            }
            aux.sig = aux.sig.sig;
            }
            conjuntoClave.Sacar(clave);
        }
    }

    @Override
    public int Recuperar(int clave) {
        int resultado =-1;
        if(conjuntoClave.Pertenece(clave)){
            NodoClaveValor aux = primero;
            while(aux.clave != clave){
                aux = aux.sig;
            }
            resultado = aux.valor;
        }
        return resultado;
    }

    @Override
    public ConjuntoTDA Claves() {
        return conjuntoClave;
        
    }

}
