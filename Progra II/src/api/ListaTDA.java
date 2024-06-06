// Realizado por Lussoro Nicolás y Ruiz Conforti Tomás
package api;

public interface ListaTDA {
    void inicializarLista(); // Inicializa la lista.
    void append(int x);// Añade un ítem al final de la lista.
    void clear(); //Vacía todos los ítems de una lista.
    int count(int x); //Cuenta el número de veces que aparece un ítem.
    int index(int x); // Devuelve el índice en el que aparece un ítem (error si no aparece).
    void insert(int x, int indice); // Agrega un ítem a la lista en un índice específico.
    void pop(); // Elimina último elemento de la lista.
    void remove(int x); // Elimina el primer elemento de la lista que coincide con el valor especificado.
    void removeAll(int x); // Elimina todos los elemento de la lista que coincide con el valor especificado.
    boolean listaVacia(); // Devuelve si la lista esta vacia.
    void mostrarLista(); //Imprime toda la lista
    int recuperarPos (int x); //Devuelve el valor de una posición dada.
}
