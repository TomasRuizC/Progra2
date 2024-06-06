package impl;

import algoritmos.metodosLista;
import api.AlumnoTDA;
import api.ConjuntoTDA;
import api.ListaTDA;

public class AlumnoDinamico implements AlumnoTDA {

    NodoAlumno primero;
    ConjuntoTDA conjuntoID = new ConjuntoDinamico();


    @Override
    public void Inicializar() {
        primero = null;
        conjuntoID.InicializarConjunto();
    }

    @Override
    public void ELiminarID(int x) {
        if(conjuntoID.Pertenece(x)){
            if(primero.info == x){
                primero = primero.sig;
            }else{
                NodoAlumno aux = primero;
                while(aux.sig != null && aux.sig.info != x){
                    aux = aux.sig;
                }
                aux.sig = aux.sig.sig;
            }
            conjuntoID.Sacar(x);
        }
    }

    @Override
    public void EliminarNota(int x, int y) {
        if(conjuntoID.Pertenece(x)){
            if(primero.info == x){
                primero.notas.remove(x);
            }else{
                NodoAlumno aux = primero;
                while(aux.sig != null && aux.info != x){
                    aux = aux.sig;
                }
                aux.notas.remove(y);
            }
        }
    }

    @Override
    public void Cargar(int x, int y) {
        if (primero==null){
            NodoAlumno aux = new NodoAlumno();
            aux.info = x;
            aux.notas = new ListaDinamica();
            aux.sig = null;
            aux.notas.inicializarLista();
            aux.notas.append(y);
            primero = aux;
            conjuntoID.Agregar(x);

        }else if (!conjuntoID.Pertenece(x)){
            NodoAlumno aux = new NodoAlumno();
            aux.info = x;
            aux.notas = new ListaDinamica();
            aux.sig = null;
            aux.notas.inicializarLista();
            aux.notas.append(y);;
            aux.sig = primero;
            primero = aux;
            conjuntoID.Agregar(x);

        }else if (conjuntoID.Pertenece(x)){
            NodoAlumno aux2=primero;
            while (aux2.info!=x){
                aux2=aux2.sig;
            }
            aux2.notas.append(y);;
        }
    }

    @Override
    public ListaTDA VerNotas(int x) {
        ListaTDA notasAlumno = new ListaDinamica();
        notasAlumno.inicializarLista();
        if(conjuntoID.Pertenece(x)){
            if(primero.info == x){
                notasAlumno = primero.notas;
            }else{
                NodoAlumno aux = primero;
                while(aux.sig != null && aux.info != x){
                    aux = aux.sig;
                }
                notasAlumno = aux.notas;
            }
        }
        return notasAlumno;
    }

    @Override
    public float Promedio(int x) {
        float prom = 0;
        if(conjuntoID.Pertenece(x)){
            if(primero.info == x){
                prom = metodosLista.promedioLista(primero.notas);
            }else{
                NodoAlumno aux = primero;
                while(aux.sig != null && aux.info != x){
                    aux = aux.sig;
                }
                prom = metodosLista.promedioLista(aux.notas);
            }
        }
        return prom;
    }

    @Override
    public boolean Aprobo(int x) {
        return (this.Promedio(x) >= 4);
    }

    @Override
    public ConjuntoTDA Alumnos() {
        return conjuntoID;
    }

}
