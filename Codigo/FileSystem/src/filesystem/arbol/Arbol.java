package filesystem.arbol;

import filesystem.EstructuraDato;

public class Arbol implements EstructuraDato{
    private Nodo raiz;
    private Nodo nodoActual;
    
    public Arbol(){
        raiz = new Nodo(null);
        raiz.setElemento(new Elemento("raiz"));
        nodoActual = raiz;
    }
    
    private String getNodoActual(){
        if(nodoActual == raiz)
            return "raiz";
        else
            return nodoActual.getElemento().getNombre();
    }
    
    @Override
    public boolean recorrer(String[] pRuta){
        Nodo nodoPuntero = nodoActual;
        
        for(int contador = 0; contador < pRuta.length; contador++){
          
            /*      Verifica que el nodo no sea la raiz      */
            if(nodoPuntero.getPadre() != null ){
                /*      Verifica si es el padre el que solicita     */
                if(pRuta[contador].equals(nodoPuntero.getPadre().getElemento().getNombre())){
                     nodoPuntero = nodoPuntero.getPadre();
                    continue;
                }
    
            }
               
            
            /*      Verifica si el nodo que solicita esta en los hijos      */
            if(nodoPuntero.buscarHijo(pRuta[contador]) >= 0)
                nodoPuntero = nodoPuntero.getHijo().get(contador);
            else
                return false;
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
}
