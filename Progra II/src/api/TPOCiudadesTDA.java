package api;

public interface TPOCiudadesTDA {
    void Inicializar();
    void ListarProvincias();
    void ListarCiudades();
    void AgregarCiudades(String x, String provincia);
    void EliminarCiudades(String x);
    void CiudadesVecinas(String x);
    void ListarCiudadesPuente(String x, String y);
    void ListarCiudadesPredecesoras(String x);
    void ListarCiudadesExtremo();
    void ListarCiudadesFuertementeConectadas();
    int CalcularCamino(String x, String y);
}
