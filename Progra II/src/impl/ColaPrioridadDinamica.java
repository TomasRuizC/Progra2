package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {
    
    NodoPrioridad primero;
    NodoPrioridad ultimo;
    
    @Override
    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    @Override
    public boolean ColaVacia() {
        return (primero == null);
    }


    @Override
    public void AcolarColaPrioridad(int x, int prioridad) {
        NodoPrioridad aux = new NodoPrioridad();
        NodoPrioridad indice;
        aux.info = x;
        aux.prioridad = prioridad;
        if (this.ColaVacia()){
            primero=aux;
            ultimo=aux;
        }else{
            if (primero.prioridad<prioridad){
                aux.sig=primero;
                primero=aux;
            }else if (ultimo.prioridad>prioridad){
                ultimo.sig=aux;
                ultimo=aux;
            }else{
                indice = primero;

                while(indice.sig != null && prioridad<=indice.sig.prioridad){
                    indice=indice.sig;
                }
                aux.sig=indice.sig;
                indice.sig=aux;
                }
        }
    }

    @Override
    public void Desacolar() {
        primero = primero.sig;
        if(primero == null){
            ultimo = null;
        }
    }


    @Override
    public int Primero() {
        return primero.info;
    }

    public int Prioridad(){
        return primero.prioridad;        
    }
}
