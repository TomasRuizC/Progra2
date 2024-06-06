package api;

public interface ColaPrioridadTDA {
    void InicializarCola();
    boolean ColaVacia();
    void AcolarColaPrioridad(int x, int prioridad);
    void Desacolar();
    int Primero();
    int Prioridad();
}
