import api.ColaTDA;
import api.ListaPromediadaTDA;
import impl.ColaDinamica;
import impl.ListaPromediadaDinamica;

public class PruebaListaPromediada {
    public static void main(String[] args) {
        ListaPromediadaTDA mi_lista = new ListaPromediadaDinamica();
        ColaTDA los_mayores = new ColaDinamica();
        ColaTDA los_menores = new ColaDinamica();

        mi_lista.Inicializar();
        los_mayores.InicializarCola();
        los_menores.InicializarCola();

        mi_lista.Agregar(3);
        mi_lista.Agregar(6);
        mi_lista.Agregar(9);
        mi_lista.Agregar(10);
        mi_lista.Agregar(5);
        mi_lista.Agregar(4);
        mi_lista.Agregar(15);
        mi_lista.Agregar(9);

        System.out.println(mi_lista.Promedio());

        mi_lista.Eliminar(3);
        mi_lista.Eliminar(9);

        System.out.println(mi_lista.Promedio());

        los_mayores = mi_lista.Mayores();
        los_menores = mi_lista.Menores();

        while(!los_mayores.ColaVacia()){
            System.out.println(los_mayores.Primero());
            los_mayores.Desacolar();
        }

        while(!los_menores.ColaVacia()){
            System.out.println(los_menores.Primero());
            los_menores.Desacolar();
        }
    }
}
