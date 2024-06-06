package impl;

import api.ColaTDA;

public class ColaEstatica implements ColaTDA {

    int[] vector;
    int i;

    @Override
    public void InicializarCola() {
        vector = new int[100];
        i = 0;
    }

    @Override
    public void Acolar(int x) {
        vector[i] = x;
        i++;
    }

    @Override
    public void Desacolar() {
        for (int k = 0; k < i-1; k++){
            vector[k] = vector[k+1];
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

}
