import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import impl.DiccionarioSimpleDinamico;
import impl.DiccionarioSimpleEstatico;
import impl.ConjuntoDinamico;
import impl.ConjuntoEstatico;

public class PruebaDeDiccionarios {
    public static void main (String[] args){
        DiccionarioSimpleTDA mi_diccionario = new DiccionarioSimpleDinamico();
        ConjuntoTDA mis_claves = new ConjuntoDinamico();
        int claves;


        mi_diccionario.InicializarDiccionario();
       
       for (int i =0; i<5; i++){
            mi_diccionario.Agregar(i, -i);
       }
        
        

        mi_diccionario.Eliminar(4);

        
        

       mis_claves = mi_diccionario.Claves();
        
        
       
        
        while(!mis_claves.ConjuntoVacio()){
            claves = mis_claves.Elegir();
            System.out.println(claves);
            mis_claves.Sacar(claves);
        }

        



    }

}
