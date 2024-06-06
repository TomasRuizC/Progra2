package impl;

import algoritmos.metodosCola;
import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.ListaPromediadaTDA;

public class ListaPromediadaDinamica implements ListaPromediadaTDA {

    Nodo primero;
    Nodo ultimo;
    float sumaElem;
    int i;

    @Override
    public void Inicializar() {
        primero = null;
        ultimo = null;
        sumaElem = 0;
        i=0;
    }

    @Override
    public void Agregar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        if(primero==null){
            primero=aux;
            ultimo=aux;
            i++; 
            sumaElem+=x;
        }else{
            if (x<this.Promedio()){
                aux.sig = primero;
                primero = aux;
                i++;
                sumaElem+=x;
            }else if (x>this.Promedio()){
                if(ultimo != null){
                    ultimo.sig = aux;
                }
                ultimo = aux;
                i++;
                sumaElem+=x;
        }

        }
    }

    @Override
    public void Eliminar(int x) {
        Nodo aux = primero;
        if(aux.info == x){
            primero = primero.sig;
        }
        while (aux.sig.sig!=null){
            while (aux.sig.info != x && aux.sig.sig!=null){
                aux = aux.sig;
            }
            while (aux.sig.info==x){
                aux.sig = aux.sig.sig;
            }
        }
        i--;
        sumaElem-=x;
    }
    

    @Override
    public float Promedio() {
        return (float) (sumaElem/i);
    }

    @Override
    public ColaTDA Menores() {
        ColaPrioridadTDA colaMenores = new ColaPrioridadDinamica();
        colaMenores.InicializarCola();
        Nodo aux=primero;
        while (aux != null){
            if (aux.info <this.Promedio()){
                colaMenores.AcolarColaPrioridad(aux.info, aux.info);
            }
            aux = aux.sig;
        }
        ColaTDA menoresOrdenados = new ColaDinamica();
        menoresOrdenados.InicializarCola();
        while (!colaMenores.ColaVacia()){
            menoresOrdenados.Acolar(colaMenores.Primero());
            colaMenores.Desacolar();
        }
        return menoresOrdenados;
        
    }

    @Override
    public ColaTDA Mayores() {
        ColaPrioridadTDA colaMayores = new ColaPrioridadDinamica();
        colaMayores.InicializarCola();
        Nodo aux=primero;
        while (aux != null ){
            if(aux.info >this.Promedio()){
                colaMayores.AcolarColaPrioridad(aux.info, -(aux.info));
            }
            aux = aux.sig;
        }
        ColaTDA mayoresOrdenados = new ColaDinamica();
        mayoresOrdenados.InicializarCola();
        while (!colaMayores.ColaVacia()){
            mayoresOrdenados.Acolar(colaMayores.Primero());
            colaMayores.Desacolar();
        }
        metodosCola.invertirColaConPila(mayoresOrdenados);
        return mayoresOrdenados;
    }

    @Override
    public boolean EstaVacia() {
        return (primero==null);
    }

   

}