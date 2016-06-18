package filesystem.arbol;

import filesystem.EstructuraDato;
import java.util.ArrayList;

public class Arbol implements EstructuraDato{
    private Nodo raiz;
    private Nodo nodoActual;
    
    public Arbol(){
        raiz = new Nodo(null);
        raiz.setElemento(new Elemento("R:"));
        nodoActual = raiz;
    }
    
    private String getNodoActual(){
        if(nodoActual == raiz)
            return "raiz";
        else
            return nodoActual.getElemento().getNombre();
    }
    
    @Override
    public boolean recorrer(String[] pRuta, String pTipoRuta){
        Nodo nodoPuntero = null;
        int contador = 0;
        
        if(pTipoRuta.equals("REAL")){
            nodoPuntero = raiz;
            contador++;
        }
        
        if(pTipoRuta.equals("ACTUAL"))
            nodoPuntero = nodoActual;
        
        if(nodoPuntero == null)
           return false;
         
        while(contador < pRuta.length){
            
            /*      Si la ruta esta vacia lo ignora     */
            if(pRuta[contador].equals("")){
                contador++;
                continue;
            }
            /*      Verifica que el nodo no sea la raiz      */
            if(nodoPuntero.getPadre() != null ){
                /*      Verifica si es el padre el que solicita     */
                if(pRuta[contador].equals(nodoPuntero.getPadre().getElemento().getNombre())){
                     nodoPuntero = nodoPuntero.getPadre();
                     contador++;
                     continue;
                }  
            }
  
            /*      Verifica si el nodo que solicita esta en los hijos      */
            if(nodoPuntero.buscarHijo(pRuta[contador]) >= 0){
                nodoPuntero = nodoPuntero.getHijo().get(nodoPuntero.buscarHijo(pRuta[contador]));  
                
            }else
                return false;
            
            contador++;
    
        }
  
        nodoActual = nodoPuntero;
        
        return true;
        
    }
    
    
    @Override
    public boolean agregarElemento(Elemento pElemento){
        /*      Veifica si ya existe        */
        if(nodoActual.buscarHijo(pElemento.getNombre()) == -1){               
            nodoActual.agregarHijo(pElemento);
            return true;   
        }
        return false;
    }
    
    @Override
    public boolean eliminarElemento(String pNombre){
        /*      Verifica que existe     */
        if(nodoActual.buscarHijo(pNombre) >= 0){ 
             return nodoActual.eliminarHijo(pNombre);
        }
        return false;
    }
    
    @Override
    public boolean modificarElemento(Elemento pElemento){
        if(eliminarElemento(pElemento.getNombre()) == true){
            if(agregarElemento(pElemento) == true)
                return true;
        }   
        return false;
    }
    
    /*      Fevuelve Null si no encuentra el Elemento       */
    @Override
    public Elemento obtenerElemento(String pNombre){
        Nodo nodoExtraido = obtenerNodo(pNombre);
        if(nodoExtraido != null){
            return nodoExtraido.getElemento();
        }
        return null;
    }
    
    /*      Devuelve un Null si no encuetra el nodo     */
    private Nodo obtenerNodo(String pNombre){
        /*      Verifica si es el nodo actual       */
        if(nodoActual.getElemento().getNombre().equals(pNombre))
            return nodoActual;
        
        /*      Verifica si es algunos de los hijos     */
        if(nodoActual.buscarHijo(pNombre) >= 0){               
             return nodoActual.getHijo().get(nodoActual.buscarHijo(pNombre));
        }
        
        return null;
    }
    
    @Override
    public String mostrarEstructura(){
        String strEstructura = "raiz \n";
        return strEstructura + MostarNodo(raiz);
    }

    private String MostarNodo(Nodo pNodo){
        String strNodo = "";
        
        /*      Verifica si esta vacio      */
        if(!pNodo.tieneHijos())
            return strNodo;
        
       strNodo += pNodo.imprimirHijos();
        
        strNodo+= "\n";
        for(int contador = 0; contador < pNodo.cantidadHijos(); contador++){
             strNodo += MostarNodo(pNodo.getHijo().get(contador));
        }
        
        return strNodo;
         
    }
    
    
    /*      Devuelve un -1 si no lo encuentra       */
    @Override
    public long calcularTamanoElemento(String pNombre){      
        Nodo nodoBuscado = obtenerNodo(pNombre);
        if(nodoBuscado != null)
            return nodoBuscado.calcularTamanoElemento();
        else
            return -1;
                
    }
    
    @Override
    public ArrayList<Elemento> obtenerElmentosContenidos(){
        ArrayList<Elemento> listaElementos = new ArrayList <Elemento>();

        for(int contador = 0; contador < nodoActual.cantidadHijos(); contador++){
            listaElementos.add(nodoActual.getHijo().get(contador).getElemento()) ;
        }
        
        return listaElementos;     
    }
    
    
}
