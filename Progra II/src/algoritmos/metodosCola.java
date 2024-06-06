package algoritmos;

import api.ColaTDA;
import api.PilaTDA;
import impl.ColaDinamica;
import impl.PilaDinamica;

public class metodosCola {

    public static void pasarCola (ColaTDA origen, ColaTDA destino){

        ColaTDA aux = new ColaDinamica();
        aux.InicializarCola();

        while (!origen.ColaVacia()){
            aux.Acolar(origen.Primero());
            destino.Acolar(origen.Primero());
            origen.Desacolar();
        }

        while (!aux.ColaVacia()){
            origen.Acolar(aux.Primero());
            aux.Desacolar();
        }
    }

    public static void imprimirCola (ColaTDA origen){

        ColaTDA aux = new ColaDinamica();
        aux.InicializarCola();


        while(!origen.ColaVacia()){
            aux.Acolar(origen.Primero());
            System.out.println(origen.Primero());
            origen.Desacolar();
        }

        while (!aux.ColaVacia()){
            origen.Acolar(aux.Primero());
            aux.Desacolar();
        }
    }

    public static int contarCola (ColaTDA origen){
        ColaTDA aux = new ColaDinamica();
        aux.InicializarCola();

        int cont = 0;

        while(!origen.ColaVacia()){
            aux.Acolar(origen.Primero());
            cont++;
            origen.Desacolar();
        }

        while (!aux.ColaVacia()){
            origen.Acolar(aux.Primero());
            aux.Desacolar();
        }
        return cont;
    }

    public static void invertirColaConPila (ColaTDA origen){
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        while (!origen.ColaVacia()) {
            aux.Apilar(origen.Primero());
            origen.Desacolar();
        }
        while(!aux.PilaVacia()){
            origen.Acolar(aux.Tope());
            aux.Desapilar();
        }
    }

    public static void invertirColaRecursiva (ColaTDA origen){

        int aux = origen.Primero();
        origen.Desacolar();

        if (!origen.ColaVacia()){
            invertirColaRecursiva(origen);
        }
        origen.Acolar(aux);

    }

    public static boolean mismoFinal (ColaTDA origen, ColaTDA destino){
        
        invertirColaRecursiva(origen);
        invertirColaConPila(destino);

        boolean resultado = (origen.Primero()==destino.Primero());

        invertirColaRecursiva(origen);
        invertirColaConPila(destino);

        return resultado;
    }
    
    public static boolean esCapicua (ColaTDA origen){
        ColaTDA aux = new ColaDinamica();
        aux.InicializarCola();
        ColaTDA aux2 = new ColaDinamica();
        aux2.InicializarCola();

        boolean resultado = true;

        pasarCola(origen, aux);
        pasarCola(origen, aux2);

        invertirColaConPila(aux);

        while (!aux.ColaVacia()){
            if (origen.Primero()!=aux.Primero()){
                resultado = false;
                break;
            }else{
                origen.Desacolar();
                aux.Desacolar();
            }
        }
        pasarCola(aux2, origen);
        
        return resultado;
    }

    public static boolean esInversa (ColaTDA origen, ColaTDA destino){
        ColaTDA aux = new ColaDinamica();
        aux.InicializarCola();
        ColaTDA aux2 = new ColaDinamica();
        aux2.InicializarCola();
        boolean resultado = true;

        pasarCola(origen, aux);
        pasarCola(destino, aux2);

        invertirColaRecursiva(aux);
        
        while (!aux.ColaVacia()){
            if (aux.Primero()!=aux2.Primero()){
                resultado = false;
                break;
            }else{
                aux.Desacolar();
                aux2.Desacolar();
            }
        }
        
        
        return resultado;
    }
}
