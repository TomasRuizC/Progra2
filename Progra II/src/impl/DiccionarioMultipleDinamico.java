package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA{

    NodoClaveValorMultiple primero;
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
        if (primero==null){
            NodoClaveValorMultiple aux = new NodoClaveValorMultiple();
            aux.clave = clave;
            aux.conjuntoValor = new ConjuntoDinamico();
            aux.sig = null;
            aux.conjuntoValor.InicializarConjunto();
            aux.conjuntoValor.Agregar(valor);
            primero = aux;
            conjuntoClave.Agregar(clave);
            cont++;

        }else if (!conjuntoClave.Pertenece(clave)){
            NodoClaveValorMultiple aux = new NodoClaveValorMultiple();
            aux.clave = clave;
            aux.conjuntoValor = new ConjuntoDinamico();
            aux.sig = null;
            aux.conjuntoValor.InicializarConjunto();
            aux.conjuntoValor.Agregar(valor);
            aux.sig = primero;
            primero = aux;
            conjuntoClave.Agregar(clave);
            cont++;

        }else if (conjuntoClave.Pertenece(clave)){
            NodoClaveValorMultiple aux2=primero;
            while (aux2.clave!=clave){
                aux2=aux2.sig;
            }
            aux2.conjuntoValor.Agregar(valor);
        }
        
    }

    public void Eliminar(int clave) {
        NodoClaveValorMultiple aux = primero;

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
    public void EliminarValor(int clave, int valor) {
        if (conjuntoClave.Pertenece(clave)){
            NodoClaveValorMultiple aux2=primero;
            while (aux2.clave!=clave){
                aux2=aux2.sig;
            }
            aux2.conjuntoValor.Sacar(valor);
        }
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        NodoClaveValorMultiple aux2=primero;
        if (conjuntoClave.Pertenece(clave)){
            while (aux2.clave!=clave){
                aux2=aux2.sig;
            }
        }
        return aux2.conjuntoValor;
    }

    @Override
    public ConjuntoTDA Claves() {
        return conjuntoClave;
    }

}

