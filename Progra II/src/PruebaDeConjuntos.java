import api.ConjuntoTDA;
import impl.ConjuntoDinamico;
import impl.ConjuntoEstatico;

public class PruebaDeConjuntos {
    public static void main(String[] args) {
        int n;
        ConjuntoTDA mi_conjunto = new ConjuntoDinamico();
        mi_conjunto.InicializarConjunto();

        mi_conjunto.Agregar(1);
        mi_conjunto.Agregar(2);
        mi_conjunto.Agregar(3);
        mi_conjunto.Agregar(4);
        mi_conjunto.Agregar(5);
        mi_conjunto.Agregar(5);

        System.out.println( mi_conjunto.Pertenece(9));

        mi_conjunto.Sacar(4);
        System.out.println(mi_conjunto.Pertenece(9));

        while(!mi_conjunto.ConjuntoVacio()){
            n = mi_conjunto.Elegir();
            System.out.println(n);
            mi_conjunto.Sacar(n);
        }
    }

}
