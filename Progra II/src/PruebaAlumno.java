import api.AlumnoTDA;
import api.ConjuntoTDA;
import api.ListaTDA;
import impl.AlumnoDinamico;
import impl.ConjuntoDinamico;
import impl.ListaDinamica;

public class PruebaAlumno {
    public static void main(String[] args) {
        AlumnoTDA alumnos = new AlumnoDinamico();
        ConjuntoTDA cantAlumnos = new ConjuntoDinamico();
        ListaTDA notas = new ListaDinamica();
        int n;
        alumnos.Inicializar();
        alumnos.Cargar(1, 10);
        alumnos.Cargar(1, 4);
        alumnos.Cargar(1, 6);
        alumnos.Cargar(2, 1);
        alumnos.Cargar(2, 2);
        alumnos.Cargar(2, 2);
        alumnos.Cargar(3, 9);
        alumnos.Cargar(3, 9);
        alumnos.Cargar(3, 7);
        notas = alumnos.VerNotas(1);
        notas.mostrarLista();
        cantAlumnos = alumnos.Alumnos();
        while(!cantAlumnos.ConjuntoVacio()){
            n = cantAlumnos.Elegir();
            System.out.println(n);
            cantAlumnos.Sacar(n);
        }
        System.out.println(alumnos.Aprobo(2));
        System.out.println(alumnos.Promedio(3));
        alumnos.ELiminarID(3);
        alumnos.EliminarNota(1, 10);
        cantAlumnos = alumnos.Alumnos();
        while(!cantAlumnos.ConjuntoVacio()){
            n = cantAlumnos.Elegir();
            System.out.println(n);
            cantAlumnos.Sacar(n);
        }
        notas = alumnos.VerNotas(1);
        notas.mostrarLista();
        notas = alumnos.VerNotas(2);
        notas.mostrarLista();
        notas = alumnos.VerNotas(3);
        notas.mostrarLista();
    }
}
