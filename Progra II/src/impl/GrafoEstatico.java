package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoEstatico implements GrafoTDA{

    int n= 100;
    int [][] Mady;
    int [] Etiqs;
    int cantNodos;

    @Override
    public void InicializarGrafo() {
        Mady = new int[n][n];
        Etiqs = new int [n];
        cantNodos = 0;
    }

    @Override
    public void AgregarVertice(int v) {
        Etiqs[cantNodos]=v;
        for (int i=0; i<=cantNodos; i++){
            Mady[cantNodos][i]=0;
            Mady[i][cantNodos]=0;
        }
        cantNodos++;
    }

    @Override
    public void EliminarVertice(int v) {
        int indice = IndiceDeVertice(v);
        for (int k = 0; k < cantNodos; k++) {
            Mady[k][indice]=Mady[k][cantNodos-1];
        }
        for (int k = 0; k < cantNodos; k++) {
            Mady[indice][k]=Mady[cantNodos-1][k];
        }
        Etiqs[indice]= Etiqs[cantNodos-1];
        cantNodos--;
    }

    @Override
    public ConjuntoTDA Vertices() {
        ConjuntoTDA conjuntoVertices = new ConjuntoEstatico();
        conjuntoVertices.InicializarConjunto();

        for (int i = 0; i <cantNodos; i++) {
            conjuntoVertices.Agregar(Etiqs[i]);
        }
        return conjuntoVertices;
    }

    @Override
    public void AgregarArista(int v1, int v2, int peso) {
        int indiceOrigen = IndiceDeVertice(v1);
        int indiceDestino = IndiceDeVertice(v2);
        Mady [indiceOrigen][indiceDestino]= peso;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        int indiceOrigen = IndiceDeVertice(v1);
        int indiceDestino = IndiceDeVertice(v2);
        Mady [indiceOrigen][indiceDestino]= 0;
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        int indiceOrigen = IndiceDeVertice(v1);
        int indiceDestino = IndiceDeVertice(v2);
        return (Mady [indiceOrigen][indiceDestino]!=0);
    }

    @Override
    public int PesoArista(int v1, int v2) {
        int indiceOrigen = IndiceDeVertice(v1);
        int indiceDestino = IndiceDeVertice(v2);
        return Mady [indiceOrigen][indiceDestino];
    }

    private int IndiceDeVertice(int v){
        int i = cantNodos-1;
        while (i>=0 && Etiqs[i]!=v) {
            i--;
        }
        return i;
    }

}
