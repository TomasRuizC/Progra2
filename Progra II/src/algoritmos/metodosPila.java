package algoritmos;

import api.PilaTDA;
import impl.PilaDinamica;
import impl.PilaEstatica;

public class metodosPila {

    public static void copiarPilaOrdenInverso (PilaTDA origen, PilaTDA destino){
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();

        while(!origen.PilaVacia()){
            aux.Apilar(origen.Tope());
            destino.Apilar(origen.Tope());
            origen.Desapilar();
        }

        while(!aux.PilaVacia()){
            origen.Apilar(aux.Tope());
            aux.Desapilar();
        }
    }

    public static void PasarPila (PilaTDA origen, PilaTDA destino) {
        while(!origen.PilaVacia()){
            destino.Apilar(origen.Tope());
            origen.Desapilar();
        }
    }

    public static void CopiarPila (PilaTDA origen, PilaTDA destino) {
        PilaTDA aux = new PilaDinamica();

        while(!origen.PilaVacia()){
            aux.Apilar(origen.Tope());
            origen.Desapilar();
        }

        while(!aux.PilaVacia()){
            origen.Apilar(aux.Tope());
            destino.Apilar(aux.Tope());
            aux.Desapilar();
        }
    }

    public static void InvertirPila (PilaTDA origen){
        PilaTDA aux = new PilaDinamica();

        while(!origen.PilaVacia()){
            aux.Apilar(origen.Tope());
            origen.Desapilar();
        }

        while(!aux.PilaVacia()){
            origen.Apilar(aux.Tope());
            aux.Desapilar();
        }
    }
    public static int ContarPila(PilaTDA pila) {
        int n = 0;
        PilaTDA aux = new PilaDinamica();
        while(!pila.PilaVacia()){
            n++;
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }
        while(!aux.PilaVacia()){
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }
        return n;
    }

    public static int SumarPila(PilaTDA pila) {
        int sum = 0;
        PilaTDA aux = new PilaDinamica();
        while(!pila.PilaVacia()){
            sum = sum + pila.Tope();
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }
        while(!aux.PilaVacia()){
            pila.Apilar(aux.Tope());
            aux.Desapilar();
        }
        return sum;
    }

    public static float promedioPila(PilaTDA pila){
        float prom = (float) SumarPila(pila) / ContarPila(pila);
        return prom;
    }
}
