package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    int[] vector;
    int[] vectorPrioridad;
    int i;

    @Override
    public void InicializarCola() {
        vector = new int[100];
        vectorPrioridad = new int[100];
        i = 0;
    }

    @Override
    public void AcolarColaPrioridad(int x, int prioridad) {
        int k = 0;
            while(prioridad <= vectorPrioridad[k] && k < i){
                k++;
            }
            insertar(x, prioridad, k);  
        }

    @Override
    public void Desacolar() {
        for(int k = 0; k < i-1; k++){
            vector[k] = vector[k + 1];
            vectorPrioridad[k] = vectorPrioridad[k + 1];
        }
        i--;
    }

    @Override
    public boolean ColaVacia() {
        return (i == 0);
    }

    @Override
    public int Primero() {
        return vector[0];
    }
    
    @Override
    public int Prioridad() {
        return vectorPrioridad[0];
    }

    private void insertar(int x, int p, int pos){
        for(int j = i; j > pos; j--){
            vector[j] = vector[j - 1];
            vectorPrioridad[j] = vectorPrioridad[j - 1];
        }
        vector[pos] = x;
        vectorPrioridad[pos] = p;
        i++;
    }
}
