package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.GrafoTDA;
import api.String2IntTDA;
import api.TPOCiudadesTDA;

public class TPOCiudades implements TPOCiudadesTDA {

    GrafoTDA miGrafo;

    String2IntTDA ciudades;

    String2IntTDA provincias;

    DiccionarioMultipleTDA ProvinciaCiudad;

    int contVert;

    static final int INFINITO = Integer.MAX_VALUE;

    

    @Override
    public void ListarProvincias() {
        ConjuntoTDA mis_claves = ProvinciaCiudad.Claves();
        ConjuntoTDA mis_valores;
        int claves;
        int valores;

        while(!mis_claves.ConjuntoVacio()){
            claves=mis_claves.Elegir();
            System.out.println();
            System.out.println("Provincia: "+provincias.DevolverString(claves));
            
        
            mis_valores=ProvinciaCiudad.Recuperar(claves);
            while (!mis_valores.ConjuntoVacio()) {
                valores=mis_valores.Elegir();
                System.out.println("Ciudad: "+ciudades.DevolverString(valores));
                mis_valores.Sacar(valores);
            }
            mis_claves.Sacar(claves);
            
        }
    }

    @Override
    public void ListarCiudades() {
        ConjuntoTDA conjuntoCiudades = miGrafo.Vertices();
        while(!conjuntoCiudades.ConjuntoVacio()){
            int ciudad = conjuntoCiudades.Elegir();

            System.out.println(ciudades.DevolverString(ciudad));

            conjuntoCiudades.Sacar(ciudad);
        }
    }

    @Override
    public void AgregarCiudades(String x, String provincia) {

        if (contVert!=0){
            provincias.Agregar(provincia);
            ciudades.Agregar(x);
            miGrafo.AgregarVertice(ciudades.DevolverInt(x));
            contVert++;
            ProvinciaCiudad.Agregar(provincias.DevolverInt(provincia), ciudades.DevolverInt(x));
        }else{
            if (!ciudades.Pertenece(x)){
                provincias.Agregar(provincia);
                ciudades.Agregar(x);
                miGrafo.AgregarVertice(ciudades.DevolverInt(x));
                contVert++;
                ProvinciaCiudad.Agregar(provincias.DevolverInt(provincia), ciudades.DevolverInt(x));
            }
        }
        
    }

    @Override
    public void EliminarCiudades(String x) {
        miGrafo.EliminarVertice(ciudades.DevolverInt(x));
        contVert--;
    }

    @Override
    public void CiudadesVecinas(String x) {
        ConjuntoTDA conjuntoCiudades = miGrafo.Vertices();
        while(!conjuntoCiudades.ConjuntoVacio()){
            int ciudad = conjuntoCiudades.Elegir();

            if (miGrafo.ExisteArista(ciudades.DevolverInt(x), ciudad)){
                System.out.println(ciudades.DevolverString(ciudad));
            }

            conjuntoCiudades.Sacar(ciudad);
        }
    }

    @Override
    public void ListarCiudadesPuente(String x, String y) {
        ConjuntoTDA conjuntoCiudades = miGrafo.Vertices();
        while(!conjuntoCiudades.ConjuntoVacio()){
            int ciudad = conjuntoCiudades.Elegir();
            
            if (miGrafo.ExisteArista(ciudades.DevolverInt(x), ciudad) && miGrafo.ExisteArista(ciudad, ciudades.DevolverInt(y))){
                System.out.print(ciudades.DevolverString(ciudad) + " ");
                System.out.print(miGrafo.PesoArista(ciudades.DevolverInt(x), ciudad)+miGrafo.PesoArista(ciudad, ciudades.DevolverInt(y)));
                System.out.println();
            }

            conjuntoCiudades.Sacar(ciudad);
        }
    }

    @Override
    public void ListarCiudadesPredecesoras(String x) {
        ConjuntoTDA conjuntoCiudades = miGrafo.Vertices();
        while(!conjuntoCiudades.ConjuntoVacio()){
            int ciudad = conjuntoCiudades.Elegir();

            if (miGrafo.ExisteArista(ciudad, ciudades.DevolverInt(x))){
                System.out.println(ciudades.DevolverString(ciudad));
            }

            conjuntoCiudades.Sacar(ciudad);
        }
    }

    @Override
    public void ListarCiudadesExtremo() {
        ConjuntoTDA conjuntoCiudades = miGrafo.Vertices();
        boolean band;
        
        while(!conjuntoCiudades.ConjuntoVacio()){
            band = true;
            int ciudad = conjuntoCiudades.Elegir();
            ConjuntoTDA conjuntoCiudades2 = miGrafo.Vertices();

            while(!conjuntoCiudades2.ConjuntoVacio()){

                int ciudad2 = conjuntoCiudades2.Elegir();

                if (miGrafo.ExisteArista(ciudad, ciudad2)){
                    band=false;
                }
                conjuntoCiudades2.Sacar(ciudad2);
            }
            if (band){
                System.out.println(ciudades.DevolverString(ciudad));
            }
            conjuntoCiudades.Sacar(ciudad);
        }
    }

    @Override
    public void ListarCiudadesFuertementeConectadas() {
        ConjuntoTDA conjuntoCiudades = miGrafo.Vertices();
        
        while(!conjuntoCiudades.ConjuntoVacio()){
            int ciudad = conjuntoCiudades.Elegir();
            ConjuntoTDA conjuntoCiudades2 = miGrafo.Vertices();

            while(!conjuntoCiudades2.ConjuntoVacio()){

                int ciudad2 = conjuntoCiudades2.Elegir();

                if (miGrafo.ExisteArista(ciudad, ciudad2) && miGrafo.ExisteArista(ciudad2, ciudad)){
                    System.out.println(ciudades.DevolverString(ciudad)+" esta fuertemente conectada con " + ciudades.DevolverString(ciudad2));
                }
                conjuntoCiudades2.Sacar(ciudad2);
            }
           
            conjuntoCiudades.Sacar(ciudad);
        }
    }

    @Override
    public int CalcularCamino(String x, String y) {

        int origen = ciudades.DevolverInt(x);
        int fin = ciudades.DevolverInt(y);

        int[] resultado = dijkstra (miGrafo,origen);

        return resultado[fin];
        
        
    }

    @Override
    public void Inicializar() {
        miGrafo = new GrafoEstatico();
        miGrafo.InicializarGrafo();
        ciudades = new String2IntDinamico();
        ciudades.Inicializar();
        provincias = new String2IntDinamico();
        provincias.Inicializar();
        ProvinciaCiudad = new DiccionarioMultipleDinamico();
        ProvinciaCiudad.InicializarDiccionario();
        contVert = 0;

        this.AgregarCiudades("La Plata","Buenos Aires");
        this.AgregarCiudades("Mar del Plata", "Buenos Aires");
        this.AgregarCiudades("CABA", "Buenos Aires");
        this.AgregarCiudades("Tandil", "Buenos Aires");

        this.AgregarCiudades("Ciudad de Cordoba", "Cordoba");
        this.AgregarCiudades("Rio Cuarto", "Cordoba");
        this.AgregarCiudades("Villa Carlos Paz", "Cordoba");

        this.AgregarCiudades("Cafayate", "Salta");

        this.AgregarCiudades("Rawson", "Chubut");
        this.AgregarCiudades("Trelew", "Chubut");
        this.AgregarCiudades("Puerto Madryn", "Chubut");

        miGrafo.AgregarArista(ciudades.DevolverInt("CABA"), ciudades.DevolverInt("Mar del Plata"), 400);
        miGrafo.AgregarArista(ciudades.DevolverInt("CABA"), ciudades.DevolverInt("La Plata"), 60);
        miGrafo.AgregarArista(ciudades.DevolverInt("CABA"), ciudades.DevolverInt("Tandil"), 350);
        miGrafo.AgregarArista(ciudades.DevolverInt("CABA"), ciudades.DevolverInt("Ciudad de Cordoba"), 1300);
        miGrafo.AgregarArista(ciudades.DevolverInt("Mar del Plata"), ciudades.DevolverInt("CABA"), 500);
        miGrafo.AgregarArista(ciudades.DevolverInt("Mar del Plata"), ciudades.DevolverInt("Ciudad de Cordoba"), 1800);
        miGrafo.AgregarArista(ciudades.DevolverInt("La Plata"), ciudades.DevolverInt("Ciudad de Cordoba"), 1500);
        miGrafo.AgregarArista(ciudades.DevolverInt("La Plata"), ciudades.DevolverInt("Rawson"), 2700);
        miGrafo.AgregarArista(ciudades.DevolverInt("Tandil"), ciudades.DevolverInt("CABA"), 480);
        miGrafo.AgregarArista(ciudades.DevolverInt("Ciudad de Cordoba"), ciudades.DevolverInt("Rawson"), 2800);
        miGrafo.AgregarArista(ciudades.DevolverInt("Ciudad de Cordoba"), ciudades.DevolverInt("Rio Cuarto"), 200);
        miGrafo.AgregarArista(ciudades.DevolverInt("Rio Cuarto"), ciudades.DevolverInt("Puerto Madryn"), 1150);
        miGrafo.AgregarArista(ciudades.DevolverInt("Villa Carlos Paz"), ciudades.DevolverInt("Ciudad de Cordoba"), 40);
        miGrafo.AgregarArista(ciudades.DevolverInt("Villa Carlos Paz"), ciudades.DevolverInt("Rio Cuarto"), 250);
        miGrafo.AgregarArista(ciudades.DevolverInt("Villa Carlos Paz"), ciudades.DevolverInt("Trelew"), 1400);
        miGrafo.AgregarArista(ciudades.DevolverInt("Rawson"), ciudades.DevolverInt("Villa Carlos Paz"), 1200);
        miGrafo.AgregarArista(ciudades.DevolverInt("Rawson"), ciudades.DevolverInt("Cafayate"), 2200);
        miGrafo.AgregarArista(ciudades.DevolverInt("Rawson"), ciudades.DevolverInt("Trelew"), 20);
    }

    
    
    private int[] dijkstra(GrafoTDA grafo, int origen) {
        int n = contVert;
        int[] distancias = new int[n];
        boolean[] visitados = new boolean[n];

        // Inicialización de distancias y visitados
        for (int k=0; k<n; k++){
            distancias[k]=INFINITO;
        }
        distancias[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            // Selección del vértice no visitado con la distancia mínima
            int u = seleccionarMinimo(distancias, visitados);
            visitados[u] = true;

            // Actualización de las distancias de los vértices adyacentes al vértice seleccionado
            for (int v = 0; v < n; v++) {
                if (miGrafo.ExisteArista(u,v)){
                    if (!visitados[v] && distancias[u] != INFINITO
                            && distancias[u] + miGrafo.PesoArista(u,v) < distancias[v]) {
                        distancias[v] = distancias[u] + miGrafo.PesoArista(u,v);
                    }
                }
            }
        }

        return distancias;
    }

    // Selecciona el vértice no visitado con la distancia mínima
    private int seleccionarMinimo(int[] distancias, boolean[] visitados) {
        int min = INFINITO, minIndex = -1;
        for (int v = 0; v < contVert; v++) {
            if (!visitados[v] && distancias[v] < min) {
                min = distancias[v];
                minIndex = v;
            }
        }
        return minIndex;
    }


}