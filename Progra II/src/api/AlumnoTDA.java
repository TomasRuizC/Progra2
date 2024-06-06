package api;

public interface AlumnoTDA {
    void Inicializar();    
    void ELiminarID(int x);    
    void EliminarNota(int x, int y);    
    void Cargar(int x, int y);
    ListaTDA VerNotas(int x);
    float Promedio(int x);
    boolean Aprobo(int x);
    ConjuntoTDA Alumnos();
}
