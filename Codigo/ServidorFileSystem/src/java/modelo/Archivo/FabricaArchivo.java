
package modelo.Archivo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import modelo.utilidades.Dto;

public class FabricaArchivo {
     public static Archivo crearArchivo(Dto pDatos){
        String nombreClase = (String) pDatos.buscarLlave("NombreClase");
        String nombreArchivo = (String) pDatos.buscarLlave("Nombre");
        Class claseArchivo;
        Constructor constructorArchivo = null;
        
        try{
            claseArchivo = Class.forName(nombreClase);
            constructorArchivo = claseArchivo.getConstructors()[0];
        } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                return null;
        }
        
        if(nombreClase.equals("modelo.Archivo.ArchivoTexto")){
           String extension = (String) pDatos.buscarLlave("Extension"); 
           String contenido = (String) pDatos.buscarLlave("Contenido");
           long tamano = (long) pDatos.buscarLlave("Tamano");  
           
            try {
                return (Archivo) (constructorArchivo.newInstance(nombreArchivo, extension, contenido, tamano));
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                System.out.println(ex);               
            }
            return null;
        }
        
        try {     
            return (Archivo) (constructorArchivo.newInstance(nombreArchivo));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
           System.out.println(ex);           
        }
        return null;
    }
}
