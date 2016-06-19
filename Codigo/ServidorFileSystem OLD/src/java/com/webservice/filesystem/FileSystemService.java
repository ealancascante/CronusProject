package com.webservice.filesystem;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class FileSystemService {
    
    /*  Metodos que se van a compartir mediante el presente web service del FS*/
    @WebMethod
    public String crearDisco (@WebParam(name = "pSectores") int pSectores, 
                              @WebParam(name = "pTamano") int pTamano){
        System.out.println("Solicitó crear un disco! devuelve el nombre del usuario!");
        return "Solicitó crear un disco! devuelve el nombre del usuario!";
    }
    
    @WebMethod
    public String crearArchivo (@WebParam(name = "pNombre") String pNombre, 
                                @WebParam(name = "pContenido") String pContenido, 
                                @WebParam(name = "pExtension") String pExtension,
                                @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó crear un archivo!");
        return "Solicitó crear un archivo!";
    }
    
    @WebMethod
    public String crearDirectorio (@WebParam(name = "pNombre") String pNombre,
                                   @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó crear un directorio!");
        return "Solicitó crear un directorio!";
    }
    
    @WebMethod
    public String cambiarDirectorio (@WebParam(name = "pRuta") String pRuta,
                                     @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó cambiar de directorio!");
        return "Solicitó cambiar de directorio!";
    }
    
    @WebMethod
    public String listarDirectorio (@WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó listar un directorio!");
        return "Solicitó listar un directorio!";
    }
    
    @WebMethod
    public String modificarArchivo (@WebParam(name = "pNombre") String pNombre,
                                    @WebParam(name = "pContenido") String pContenido,
                                    @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó modificar un archivo!");
        return "Solicitó modificar un archivo!";
    }
    
    @WebMethod
    public String verPropiedades (@WebParam(name = "pNombre") String pNombre,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó ver propiedades de un archivo!");
        return "Solicitó ver propiedades de un archivo!";
    }
    
    @WebMethod
    public String contenidoArchivo (@WebParam(name = "pNombre") String pNombre,
                                    @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó ver el contenido de un archivo!");
        return "Solicitó ver el contenido de un archivo!";
    }
    
    @WebMethod
    public String copiarElemento (@WebParam(name = "pRutaOrigen") String pRutaOrigen,
                                  @WebParam(name = "pRutaDestino") String pRutaDestino,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó copiar un archivo / directorio!");
        return "Solicitó copiar un archivo / directorio!";
    }
    
    @WebMethod
    public String moverElemento (@WebParam(name = "pRutaOrigen") String pRutaOrigen,
                                 @WebParam(name = "pRutaDestino") String pRutaDestino,
                                 @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó mover un archivo / directorio!");
        return "Solicitó mover un archivo / directorio!";
    }
    
    @WebMethod
    public String removerElemento (@WebParam(name = "pRutaOrigen") String pRutaOrigen,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó eliminar un archivo / directorio!");
        return "Solicitó eliminar un archivo / directorio!";
    }
    
    @WebMethod
    public String encontrarElemento (@WebParam(name = "pNombre") String pNombre,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó encontrar un archivo / directorio!");
        return "Solicitó encontrar un archivo / directorio!";
    }
    
    @WebMethod
    public String generarArbol (@WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó crear un arbol del file system!");
        return "Solicitó crear un arbol del file system!";
    }
}
