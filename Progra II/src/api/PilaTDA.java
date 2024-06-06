package api;

public interface PilaTDA {
    void InicializarPila(); /** Sin pre condición */
    void Apilar (int x); /** Pila inicializada */
    void Desapilar ();
    int Tope ();
    boolean PilaVacia();
}
