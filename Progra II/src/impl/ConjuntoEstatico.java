package impl;

import api.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {

    int[] vector;
    int cont;

    @Override
    public void InicializarConjunto() {
        vector = new int[100];
        cont = 0;
    }

    @Override
    public boolean ConjuntoVacio() {
        return (cont == 0);
    }

    @Override
    public void Agregar(int x) {
        if(!this.Pertenece(x)){
            vector[cont] = x;
            cont++;
        }
    }

    @Override
    public int Elegir() {
        return (vector[Math.abs((int)System.nanoTime() % cont)]);
    }

    @Override
    public void Sacar(int x) {
        if (this.Pertenece(x)){
            int i = 0;
            int index = -1;
            while (i < cont && index == -1){
                if (x == vector[i]){
                    index = i;
                }
                i++;
            }
            vector[index] = vector[cont -1];
            
            cont--;
       
        }
    }

    @Override
    public boolean Pertenece(int x) {
        boolean band = false;
        int i = 0;
        while(i < cont && band != true){
            if(vector[i] == x){
                band = true;
            }
            i++;
        }
        return band;
    }

}
