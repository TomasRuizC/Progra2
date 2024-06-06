import api.GestorDeReservasTDA;
import api.PilaTDA;
import api.ColaPrioridadTDA;
import api.DiccionarioMultipleTDA;
import impl.GestorDeReservasDinamico;

public class PruebaDeGestorDeReservas {
    public static void main(String[] args) {
        GestorDeReservasTDA mi_gestor = new GestorDeReservasDinamico();
        mi_gestor.Inicializar();
        mi_gestor.agregarReserva(1, 1, 2, 13, 221124);
        mi_gestor.agregarReserva(2, 2, 2, 14, 221124);
        mi_gestor.agregarReserva(3, 3, 2, 15, 221024);
        mi_gestor.agregarReserva(4, 4, 3, 4, 251224);
        mi_gestor.agregarReserva(5, 5, 3, 17, 251224);
        mi_gestor.agregarReserva(6, 6, 5, 19, 91224);
        mi_gestor.agregarReserva(7, 7, 3, 11, 251224);
        mi_gestor.agregarReserva(8, 8, 8, 13, 221124);
        mi_gestor.agregarReserva(9, 9, 9, 9, 8824);
        mi_gestor.agregarReserva(10, 10, 2, 20, 121124);
        mi_gestor.agregarReserva(11, 11, 1, 12, 211024);
        mi_gestor.agregarReserva(12, 12, 4, 14, 221125);

        mi_gestor.actualizarAsiento(1, 22);
        mi_gestor.actualizarFecha(3, 110525);
        mi_gestor.actualizarVuelo(2, 12);
        mi_gestor.eliminarReserva(10);
        mi_gestor.obtenerReserva(9);
        mi_gestor.obtenerReserva(1);
        mi_gestor.obtenerReserva(2);
        PilaTDA reservas = mi_gestor.listaDeReservas();
        ColaPrioridadTDA reservas_por_vuelo = mi_gestor.reservasPorVuelo(2);
        PilaTDA reservas_por_fecha = mi_gestor.reservasPorFecha(221124);
        DiccionarioMultipleTDA listar_por_vuelos = mi_gestor.listarPorVuelo();
        DiccionarioMultipleTDA listar_por_fecha = mi_gestor.listarPorFecha();

        System.out.println("Todas las reservas:");
        while(!reservas.PilaVacia()){
            System.out.println(reservas.Tope());
            reservas.Desapilar();
        }

        System.out.println("Reservas en la fecha 221124:");
        while(!reservas_por_fecha.PilaVacia()){
            System.out.println(reservas_por_fecha.Tope());
            reservas_por_fecha.Desapilar();
        }

        
    }
}
