import algoritmos.metodosPila;
import api.PilaTDA;
import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.ConjuntoTDA;
import impl.PilaDinamica;
import impl.PilaEstatica;
import impl.ColaEstatica;
import impl.ColaPrioridadEstatica;
import impl.ColaPrioridadDinamica;
import impl.ColaDinamica;
import impl.ColaDinamicaMarchaAtras;
import impl.ConjuntoEstatico;
import impl.ConjuntoDinamico;

public class App {
    public static void main(String[] args) throws Exception {
        ColaPrioridadTDA cola1 = new ColaPrioridadDinamica();
        cola1.InicializarCola();
        cola1.AcolarColaPrioridad(1, 1);
        cola1.AcolarColaPrioridad(2, 2);
        cola1.AcolarColaPrioridad(3, 3);
        cola1.AcolarColaPrioridad(4, 2);
        cola1.AcolarColaPrioridad(5, 1);    
        
    while(!cola1.ColaVacia()){
        System.out.println(cola1.Primero());
        cola1.Desacolar();
    }
    }
}
