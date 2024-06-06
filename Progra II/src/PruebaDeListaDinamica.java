// Realizado por Lussoro Nicolás y Ruiz Conforti Tomás
import impl.ListaDinamica;
import algoritmos.metodosLista;
import api.ListaTDA;

public class PruebaDeListaDinamica {
    public static void main(String[] args) {
        ListaTDA mi_lista = new ListaDinamica();
        mi_lista.inicializarLista();

        for (int i =1; i<11; i++){
            mi_lista.append(i);
        }
        System.out.println(mi_lista.count(5));
        System.out.println(mi_lista.index(7));
        mi_lista.insert(0, 0);
        mi_lista.insert(0, 2);
        mi_lista.pop();
        mi_lista.remove(7);
        mi_lista.removeAll(0);
        mi_lista.mostrarLista();
        System.out.println(mi_lista.listaVacia());
        mi_lista.mostrarLista();
        System.out.println(mi_lista.recuperarPos(1));
        mi_lista.mostrarLista();
        System.out.println(mi_lista.listaVacia());
        System.out.println(metodosLista.sumarLista(mi_lista));
        System.out.println(metodosLista.promedioLista(mi_lista));
    }
}
