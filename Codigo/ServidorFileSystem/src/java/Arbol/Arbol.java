
package Arbol;

import java.util.ArrayList;
import modelo.Archivo.ArchivoTexto;
import modelo.EstructuraDato;


public class Arbol implements EstructuraDato{
    private Nodo raiz;
    private Nodo nodoActual;
    private String stringArbol;
    
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
        stringArbol = "";
        recorreArbol(0, raiz);
        System.out.println(stringArbol);
        return stringArbol;
    }

       private void recorreArbol(int pLevel, Nodo pRoot){
    if (pRoot != null) {
            if (pLevel > 0) {
                for (int i = 0; i < pLevel; i++)
                  stringArbol = stringArbol + " ";
              stringArbol = stringArbol + "->";
            }
            
            if(pRoot.getElemento() instanceof ArchivoTexto){                            
                stringArbol = stringArbol + pRoot.getElemento().getNombre()+"\n";
            }else{
                stringArbol =  stringArbol + pRoot.getElemento().getNombre() + "\n";
                for (int j = 0; j < pRoot.getHijo().size(); j++) {
                  recorreArbol(pLevel + 1, pRoot.getHijo().get(j));
                }
                
          }
        }
         
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
    
    @Override
    public String encontrarElemento(String pBusqueda){
        stringArbol = "";
        if(pBusqueda != null){
            if(pBusqueda.length() > 2 && pBusqueda.charAt(0) == '*' && pBusqueda.charAt(1) == '.'){
                String extension = parseExtensionArchivo(pBusqueda);
                findFileExtension(0, raiz, "", extension);
            } 
            else{
                String nombre = parseNombreArchivo(pBusqueda);
                findFileSistema(0, raiz, "", nombre);
            }
            
            return stringArbol;
        }
        
        return "";
    }
    
    private void findFileExtension(int level, Nodo root, String pRuta, String pExtension){
        String str = "";
        str = pRuta;
        if (root != null){
            if(root.getElemento() instanceof ArchivoTexto && 
                pExtension.equals(parseExtensionArchivo(root.getElemento().getNombre()))){
                if(level != 0)
                  str = str + "\\"; 
                str = str + root.getElemento().getNombre();
                stringArbol = stringArbol + str + "\n";
            }
            if(level != 0)
                str = str + "\\"; 
            str = str + root.getElemento().getNombre();
            for (int j = 0; j < root.getHijo().size(); j++) {
                findFileExtension(level + 1, root.getHijo().get(j), str, pExtension);
            }
        }
    }
    
    
    private void findFileSistema(int level, Nodo root, String pRuta, String pNombre) {
        String str = "";
        str = pRuta;
        if (root != null){
            if(root.getElemento() instanceof ArchivoTexto && 
                pNombre.equals(parseNombreArchivo(root.getElemento().getNombre()))){
                if(level != 0)
                  str = str + "\\"; 
                str = str + root.getElemento().getNombre();
                stringArbol = stringArbol + str + "\n";
            }
            else {
                if(pNombre.equals(root.getElemento().getNombre())){
                  if(level != 0)
                    str = str + "\\"; 
                  str = str + root.getElemento().getNombre();
                  stringArbol = stringArbol + str + "\n";
                }
            }
            if(level != 0)
                str = str + "\\"; 
            str = str + root.getElemento().getNombre();
            for (int j = 0; j < root.getHijo().size(); j++) {
                findFileSistema(level + 1, root.getHijo().get(j), str, pNombre);
            }
        }
    }
      
    private String parseNombreArchivo(String pNombre){
        if(pNombre.contains(".")){
            String[] partes = pNombre.split("\\.");
            return partes[0];
        }
        return pNombre;
    }
    
    private String parseExtensionArchivo(String pExpresion){
        String[] partes = pExpresion.split("\\.");
        return partes[1];
    }
}
