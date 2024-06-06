// Realizado por Lussoro Nicolás y Ruiz Conforti Tomás
import impl.ListaEstatica;
import api.ListaTDA;

public class PruebaDeListasEstatica {
    public static void main(String[] args) {
        ListaTDA mi_lista = new ListaEstatica();
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
        mi_lista.clear();
        mi_lista.mostrarLista();
        System.out.println(mi_lista.listaVacia());
    }
}
