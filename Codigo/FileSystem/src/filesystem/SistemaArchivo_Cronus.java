
package filesystem;

import Archivo.ArchivoTexto;
import Archivo.Directorio;
import filesystem.arbol.Arbol;
import filesystem.arbol.Elemento;


public class SistemaArchivo_Cronus {
    private String rutaActual;
    private EstructuraDato estructura;
    
    public SistemaArchivo_Cronus(){
        rutaActual = "R:/";
        estructura = new Arbol();
    }
    
    public boolean agregarArchivoTexto(String pNombre, long pTamano, String pContenido){       
        String extension = extraerExtension(pNombre); 
        
        if(extension.equals(""))
            return false;
        
        ArchivoTexto nuevoArhivo = new ArchivoTexto(pNombre,extension,pContenido,pTamano);
        
        return estructura.agregarElemento(nuevoArhivo);
    }
    
    public boolean agregarDirectorio(String pNombre){
        Directorio nuevoDirectorio = new Directorio (pNombre);
        
        return estructura.agregarElemento(nuevoDirectorio);  
    }
    
    public boolean borrarElemento(String pNombre){        
        return estructura.eliminarElemento(pNombre);        
    }
    
    public boolean cambiarNombreElemento(String pNombreViejo, String pNombreNuevo){
        Elemento modificarElemento = estructura.obtenerElemento(pNombreViejo);
        
        /*      Verifica que exista     */
        if(modificarElemento == null)
            return false;
        
        modificarElemento.setNombre(pNombreNuevo);
        
        /*      Verifica si es un archivo de texto      */
        if(obtenerTipoElemento(modificarElemento).equals("ArchvoTexto")){
            String extension = extraerExtension(pNombreNuevo); 
        
            if(extension.equals(""))
                return false;
            
            ArchivoTexto nuevoArhivo = (ArchivoTexto)modificarElemento;            
            nuevoArhivo.setExtension(pNombreNuevo);
            
            return estructura.agregarElemento(nuevoArhivo);  
    }
        
        return estructura.agregarElemento(modificarElemento);  
      
    }
    
    private String obtenerTipoElemento(Elemento pElmento){
        Class clase = pElmento.getClass();
        return clase.getSimpleName();
    }
    
    private String extraerExtension(String pNombre){
        if(pNombre.contains(".") != true)
            return "";
        
        String[] nombreParte = pNombre.split(".");
        return nombreParte[1];
    }
}
