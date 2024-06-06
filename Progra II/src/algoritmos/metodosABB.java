package algoritmos;

import api.ABBTDA;

public class metodosABB {

    //imprimir de derecha a izquierda
    public void inOrder(ABBTDA a){ 
        if(!a.ArbolVacio()){
            inOrder(a.HijoIzq());
            System.out.println(a.Raiz());
            inOrder(a.HijoDer());
        }
    }
    //imprimir de arriba a abajo
    public void preOrder(ABBTDA a){ 
        if(!a.ArbolVacio()){
            System.out.println(a.Raiz());
            preOrder(a.HijoIzq());
            preOrder(a.HijoDer());
        }
    }
    //imprimir de abajo a arriba
    public void postOrder(ABBTDA a){ 
        if(!a.ArbolVacio()){
            postOrder(a.HijoIzq());
            postOrder(a.HijoDer());
            System.out.println(a.Raiz());
        }
    }

    public int Contar(ABBTDA a){
        if(a.ArbolVacio()){
            return 0;
        }
        else{
            return(1+ Contar(a.HijoIzq()) + Contar(a.HijoDer()));
        }
    }

    public int calcularProfundidad (ABBTDA t, int x) {
        if (t.ArbolVacio()){
            return 0;
        }
        else if (t.Raiz () == x) {
            return 0;
        }
        else if (t.Raiz () > x){

            return (1+ this.calcularProfundidad (t.HijoIzq() , x));

        }else{

            return (1+ this.calcularProfundidad (t.HijoDer(), x));
        }
    }

    public boolean existeElementoEnABB (ABBTDA t, int x){
        if (t.ArbolVacio ()){
            return false;
        }
        else if (t.Raiz () == x){
            return true;
        }
        else if (t.Raiz () > x){
            return this.existeElementoEnABB (t.HijoIzq() , x);
        }
        else{
            return this.existeElementoEnABB (t.HijoDer() , x);
        }
    }

    public static boolean esHoja(ABBTDA a){
        if (!a.ArbolVacio()){
            return(a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio());
        }else{
            return false;
        }
        
    }

    public static void imprimirPadresDeHojas (ABBTDA a){
        if (!a.ArbolVacio()){
            if (esHoja(a.HijoDer()) || esHoja(a.HijoIzq())){
                System.out.println(a.Raiz());
            }
            imprimirPadresDeHojas(a.HijoDer());
            imprimirPadresDeHojas(a.HijoIzq());
        }
            
    }

    public static int minimoAncestroComun (ABBTDA a, int x, int y){
        int mayor,menor;
        int resultado;
        if (x<y){
            mayor=y;
            menor=x;
        }else{
            mayor=x;
            menor=y;
        }

        if (a.Raiz()<menor){
            return minimoAncestroComun(a.HijoDer(), x, y);
        }else if (a.Raiz()>mayor){
            return minimoAncestroComun(a.HijoIzq(), x, y);
        }else{
            return a.Raiz();
        }

        
    }

}
