package algoritmos;

import api.ListaTDA;

public class metodosLista {
    public static int sumarLista(ListaTDA lista){
        int suma = 0;
        ListaTDA aux = lista;
        while (!aux.listaVacia()) {
            suma = suma + aux.recuperarPos(0);
            aux.remove(aux.recuperarPos(0));
        }
        return suma;
    }

    public static float promedioLista(ListaTDA lista){
        int suma = metodosLista.sumarLista(lista);
        int cont = 0;
        ListaTDA aux = lista;
        while (!aux.listaVacia()) {
            cont++;
            aux.remove(aux.recuperarPos(0));
        }
        return (suma / cont);
    }
}
