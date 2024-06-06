import algoritmos.metodosABB;
import api.ABBTDA;
import impl.ABB;

public class PruebaDeABB {
    public static void main(String[] args) {
        ABBTDA mi_arbol = new ABB();

        mi_arbol.AgregarElem(10);
        mi_arbol.AgregarElem(5);
        mi_arbol.AgregarElem(15);
        mi_arbol.AgregarElem(3);
        mi_arbol.AgregarElem(7);
        mi_arbol.AgregarElem(18);
        mi_arbol.AgregarElem(6);
        mi_arbol.AgregarElem(19);

        metodosABB.imprimirPadresDeHojas(mi_arbol);
    }
}
