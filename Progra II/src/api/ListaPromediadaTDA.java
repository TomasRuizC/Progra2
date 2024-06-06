package api;

public interface ListaPromediadaTDA {
    void Inicializar();
    void Agregar(int x);
    void Eliminar(int x);
    float Promedio();
    ColaTDA Menores();
    ColaTDA Mayores();
    boolean EstaVacia();
}
