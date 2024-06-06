package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoDinamico implements GrafoTDA{

    NodoGrafo origen;

    @Override
    public void InicializarGrafo() {
        origen=null;
    }

    @Override
    public void AgregarVertice(int v) {
        //El vertice se inserta al inicio de la lista de nodos
        NodoGrafo aux = new NodoGrafo();
        aux.nodo= v;
        aux.arista= null;
        aux.sigNodo= origen;
        origen = aux;
    }

    @Override
    public void EliminarVertice(int v) {
        // busca y elimina vertice y las arista del mismo
        if (origen.nodo == v){
            origen=origen.sigNodo;
        }

        NodoGrafo aux = origen;
        while (aux != null){
            this.EliminarAristaNodo(aux, v);

            if (aux.sigNodo!=null && aux.sigNodo.nodo == v){
                aux.sigNodo=aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    @Override
    public ConjuntoTDA Vertices() {
        ConjuntoTDA conjuntoVertices = new ConjuntoDinamico();
        conjuntoVertices.InicializarConjunto();

        NodoGrafo aux = origen;
        while (aux!=null){
            conjuntoVertices.Agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return conjuntoVertices;
    }

    @Override
    public void AgregarArista(int v1, int v2, int peso) {
        //La arista se inserta al inicio de la lista de nodos adyacentes del nodo origen
        NodoGrafo n1 = IndiceDeVertice(v1);
        NodoGrafo n2 = IndiceDeVertice(v2);

        NodoArista aux =new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista =n1.arista;
        n1.arista= aux;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        NodoGrafo n1 = IndiceDeVertice(v1);
        EliminarAristaNodo(n1,v2);
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        NodoGrafo n1 = IndiceDeVertice(v1);

        NodoArista aux = n1.arista;
        while (aux!=null && aux.nodoDestino.nodo!=v2){
            aux = aux.sigArista;
        }
        return (aux!=null);
    }

    @Override
    public int PesoArista(int v1, int v2) {
        NodoGrafo n1 = IndiceDeVertice(v1);
        NodoArista aux = n1.arista;

        while (aux.nodoDestino.nodo!=v2){
            aux = aux.sigArista;
        }
        return aux.etiqueta;
    }

    private NodoGrafo IndiceDeVertice(int v){
        NodoGrafo aux = origen;
        while (aux!=null && aux.nodo!=v){
            aux =aux.sigNodo;
        }
        return aux;
    }

    private void EliminarAristaNodo (NodoGrafo nodo, int v){
        NodoArista aux = nodo.arista;
        if (aux!=null){
            if (aux.nodoDestino.nodo == v){
                nodo.arista = aux.sigArista;
            }
            else{
                while (aux.sigArista!=null && aux.sigArista.nodoDestino.nodo !=v){
                    aux = aux.sigArista;
                }
                if (aux.sigArista!=null){
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

}
