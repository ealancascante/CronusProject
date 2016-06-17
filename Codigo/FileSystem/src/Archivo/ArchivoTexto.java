
package Archivo;

import Archivo.Archivo;


public class ArchivoTexto extends Archivo {
    private long tamano;
    private String extension;
    private String contenido;
    
    public ArchivoTexto(String pNombre,String pExtension, String pContenido, long pTamano){
        super(pNombre);     
        extension = pExtension;
        tamano = pTamano;
        contenido = pContenido;
    
    }

    public long getTamano() {
        return tamano;
    }

    public String getExtension() {
        return extension;
    }

    public String getContenido() {
        return contenido;
    }
    
    public void setTamano(long pTamano) {
        tamano = pTamano;
    }

    public void setExtension(String pExtension) {
        extension = pExtension;
    }

    public void setContenido(String pContenido) {
        contenido = pContenido;
    }
            
            
    
    
}
