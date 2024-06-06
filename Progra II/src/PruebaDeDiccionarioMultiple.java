import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.DiccionarioMultipleEstatico;
import impl.ConjuntoDinamico;
import impl.ConjuntoEstatico;
import impl.DiccionarioMultipleDinamico;

public class PruebaDeDiccionarioMultiple {
    public static void main(String[] args) {
        DiccionarioMultipleTDA mi_diccionario = new DiccionarioMultipleDinamico();
        ConjuntoTDA mis_claves = new ConjuntoDinamico();
        ConjuntoTDA mis_valores = new ConjuntoDinamico();
        mi_diccionario.InicializarDiccionario();
        int claves;
        int valores;

        mi_diccionario.Agregar(1, -1);
        mi_diccionario.Agregar(1, -2);
        mi_diccionario.Agregar(1, -3);
        mi_diccionario.Agregar(2, -1);
        mi_diccionario.Agregar(3, -1);
        mi_diccionario.Agregar(3, -2);
        mi_diccionario.Agregar(3, -2);

        mi_diccionario.Eliminar(2);
        
        mi_diccionario.EliminarValor(3,-1);

        mis_claves=mi_diccionario.Claves();

        while(!mis_claves.ConjuntoVacio()){
            claves=mis_claves.Elegir();
        
            mis_valores=mi_diccionario.Recuperar(claves);
            System.out.println(claves);
            while (!mis_valores.ConjuntoVacio()) {
                valores=mis_valores.Elegir();
                System.out.println(valores);
                mis_valores.Sacar(valores);
            }
            mis_claves.Sacar(claves);
            
        }
    }
}


