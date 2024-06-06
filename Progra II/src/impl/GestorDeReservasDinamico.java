package impl;

import api.ColaPrioridadTDA;
import api.DiccionarioMultipleTDA;
import api.GestorDeReservasTDA;
import api.PilaTDA;

public class GestorDeReservasDinamico implements GestorDeReservasTDA {

    NodoGestorDeReservas primero;
    int cont;

    @Override
    public void Inicializar() {
        primero = null;
        cont = 0;
    }

    @Override
    public void agregarReserva(int id_reserva, int id_pasajero, int nro_vuelo, int nro_asiento, int fecha) {
        NodoGestorDeReservas aux = new NodoGestorDeReservas();
        aux.reserva = id_reserva;
        aux.pasajero = id_pasajero;
        aux.vuelo = nro_vuelo;
        aux.asiento = nro_asiento;
        aux.fecha = fecha;
        aux.reserva = id_reserva;
        aux.sig = null;
        if(primero == null){
            primero = aux;
            cont++;
        }else{
            aux.sig = primero;
            primero = aux;
            cont++;
        }
    }

    @Override
    public void eliminarReserva(int id_reserva) {
        if(primero.reserva == id_reserva){
            primero = primero.sig;
            cont--;
        }else{
            NodoGestorDeReservas aux = primero;
            while(aux.sig.sig != null && aux.sig.reserva != id_reserva){
                aux = aux.sig;
            }
                aux.sig = aux.sig.sig;
                cont--;
        }
    }

    @Override
    public void actualizarAsiento(int id_reserva, int nro_asiento) {
        if(primero.reserva == id_reserva){
            primero.asiento = nro_asiento;
        }else{
            NodoGestorDeReservas aux = primero;
            while(aux.sig != null && aux.reserva != id_reserva){
                aux = aux.sig;
            }
            if(aux != null){
                aux.asiento = nro_asiento;
            } 
        }
    }

    @Override
    public void actualizarVuelo(int id_reserva, int nro_vuelo) {
        if(primero.reserva == id_reserva){
            primero.vuelo = nro_vuelo;
        }else{
            NodoGestorDeReservas aux = primero;
            while(aux.sig != null && aux.reserva != id_reserva){
                aux = aux.sig;
            }
            if(aux != null){
                aux.vuelo = nro_vuelo;
            } 
        }
    }

    @Override
    public void actualizarFecha(int id_reserva, int fecha) {
        if(primero.reserva == id_reserva){
            primero.fecha = fecha;
        }else{
            NodoGestorDeReservas aux = primero;
            while(aux.sig != null && aux.reserva != id_reserva){
                aux = aux.sig;
            }
            if(aux != null){
                aux.fecha = fecha;
            } 
        }
    }

    @Override
    public void obtenerReserva(int id_reserva) {
        if(primero.reserva == id_reserva){
            System.out.println("Reserva número: "+ primero.reserva + ", pasajero: "+ primero.pasajero + ", vuelo número: " + primero.vuelo + " y asiento número: " + primero.asiento);
        }else{
            NodoGestorDeReservas aux = primero;
            while(aux.sig != null && aux.reserva != id_reserva){
                aux = aux.sig;
            }
            if(aux != null){
            System.out.println("Reserva número: "+ aux.reserva + ", pasajero: "+ aux.pasajero + ", vuelo número: " + aux.vuelo + " y asiento número: " + aux.asiento);                
            } 
        }
    }

    @Override
    public PilaTDA listaDeReservas() {
        PilaTDA reservas = new PilaDinamica();
        reservas.InicializarPila();
        NodoGestorDeReservas aux = primero;;
        for(int i = 0; i < cont; i++){
            reservas.Apilar(aux.reserva);
            aux = aux.sig;
        }
        return reservas;
    }

    @Override
    public ColaPrioridadTDA reservasPorVuelo(int nro_vuelo) {
        ColaPrioridadTDA reservasEnVuelo = new ColaPrioridadDinamica();
        reservasEnVuelo.InicializarCola();
        NodoGestorDeReservas aux = primero;
        for(int i = 0; i < cont; i++){
            if(aux.vuelo == nro_vuelo){
                reservasEnVuelo.AcolarColaPrioridad(aux.reserva, aux.reserva);
            }
            aux = aux.sig;
        }
        return reservasEnVuelo;
    }

    @Override
    public PilaTDA reservasPorFecha(int fecha) {
        PilaTDA reservasEnFecha = new PilaDinamica();
        reservasEnFecha.InicializarPila();;
        NodoGestorDeReservas aux = primero;
        for(int i = 0; i < cont; i++){
            if(aux.fecha == fecha){
                reservasEnFecha.Apilar(aux.reserva);;
            }
            aux = aux.sig;
        }
        return reservasEnFecha;
    }

    @Override
    public DiccionarioMultipleTDA listarPorVuelo() {
        DiccionarioMultipleTDA diccionarioPorVuelo = new DiccionarioMultipleDinamico();
        diccionarioPorVuelo.InicializarDiccionario();
        NodoGestorDeReservas aux = primero;
        for(int i = 0; i < cont; i++){
            diccionarioPorVuelo.Agregar(aux.vuelo, aux.reserva);
            aux = aux.sig;
        }
        return diccionarioPorVuelo;
    }

    @Override
    public DiccionarioMultipleTDA listarPorFecha() {
        DiccionarioMultipleTDA diccionarioPorFecha = new DiccionarioMultipleDinamico();
        diccionarioPorFecha.InicializarDiccionario();
        NodoGestorDeReservas aux = primero;
        for(int i = 0; i < cont; i++){
            diccionarioPorFecha.Agregar(aux.fecha, aux.reserva);
            aux = aux.sig;
        }
        return diccionarioPorFecha;
    }

}
