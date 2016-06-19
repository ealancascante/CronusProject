package filesystem.arbol;

import Archivo.ArchivoTexto;
import filesystem.EstructuraDato;
import java.util.ArrayList;
import java.util.List;

public class Arbol implements EstructuraDato{
    private Nodo raiz;
    private Nodo nodoActual;
    
    public Arbol(){
        raiz = new Nodo(null);
        raiz.setElemento(new Elemento("R:"));
        nodoActual = raiz;
    }
    
    public Nodo getRaiz(){
        return raiz;
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
    
      public void printFileSystem() {
        // Call an auxiliary recursive method.
        printFileSystem(0, raiz);
      }// end printFileSystem

      /**
       * Print the file system structure in screen. This method is recursive, and is
       * called over each subtree by specifying the root of the corresponding
       * subtree.
       * 
       * @param level
       *          Tree level where the root of the subtree is.
       * @param root
       *          Root folder of the subtree over which the method is applied.
       */
      private void printFileSystem(int level, Nodo root) {
        // Check if the current root is not null
        if (root != null) {
          if (level > 0) {
            // If level is greater than 0 (the root is not
            // the root of whole file system)...
            for (int i = 0; i < level; i++) {
              // ...print as many white spaces as levels...
              System.out.print(" ");
            }
            // ...and print the symbol representing the directory...
            System.out.print("|_");
          }
          // ...print the name of the folder
          
          //verificamos si es un archivo o un directorio extra
          if(root.getElemento() instanceof ArchivoTexto)
              System.out.println(root.getElemento().getNombre());
          else{
            System.out.println(root.getElemento().getNombre());
            for (int j = 0; j < root.getHijo().size(); j++) {
              // Take each subdirectory as root of a subtree, and
              // apply the method over that subtree
              printFileSystem(level + 1, root.getHijo().get(j));
            }
          }
        }// end printFileSystem
    }
}
