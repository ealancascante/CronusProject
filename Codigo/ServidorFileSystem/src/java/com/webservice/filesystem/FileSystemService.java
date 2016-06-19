package com.webservice.filesystem;

import Controlador.Controlador;
import Controlador.InterfaceControlador;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class FileSystemService{

    private InterfaceControlador controlador = new Controlador();
    /*  Metodos que se van a compartir mediante el presente web service del FS*/
    @WebMethod
    public String crearDisco (@WebParam(name = "pSectores") int pSectores, 
                              @WebParam(name = "pTamano") int pTamano){
        
        System.out.println("Solicitó crear un disco! devuelve el nombre del usuario!");
        return controlador.crearDisco(pSectores, pSectores);
    }
    
    @WebMethod
    public String crearArchivo (@WebParam(name = "pNombre") String pNombre, 
                                @WebParam(name = "pContenido") String pContenido, 
                                @WebParam(name = "pExtension") String pExtension,
                                @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó crear un archivo!");
        return controlador.crearArchivo(pNombre, pContenido, pCliente);
    }
    
    @WebMethod
    public String crearDirectorio (@WebParam(name = "pNombre") String pNombre,
                                   @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó crear un directorio!");
        return controlador.crearDirectorio(pNombre, pCliente);
    }
    
    @WebMethod
    public String cambiarDirectorio (@WebParam(name = "pRuta") String pRuta,
                                     @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó cambiar de directorio!");
        return controlador.cambiarDirectorio(pRuta, pCliente);
    }
    
    @WebMethod
    public String listarDirectorio (@WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó listar un directorio!");
        return controlador.listarDirectorio(pCliente);
    }
    
    @WebMethod
    public String modificarArchivo (@WebParam(name = "pNombre") String pNombre,
                                    @WebParam(name = "pContenido") String pContenido,
                                    @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó modificar un archivo!");
        return controlador.modificarArchivo(pNombre, pContenido, pCliente);
    }
    
    @WebMethod
    public String verPropiedades (@WebParam(name = "pNombre") String pNombre,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó ver propiedades de un archivo!");
        return controlador.verPropiedades(pNombre, pCliente);
    }
    
    @WebMethod
    public String contenidoArchivo (@WebParam(name = "pNombre") String pNombre,
                                    @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó ver el contenido de un archivo!");
        return controlador.contenidoArchivo(pNombre, pCliente);
    }
    
    @WebMethod
    public String copiarElemento (@WebParam(name = "pRutaOrigen") String pRutaOrigen,
                                  @WebParam(name = "pRutaDestino") String pRutaDestino,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó copiar un archivo / directorio!");
        return controlador.copiarElemento(pRutaOrigen, pRutaDestino, pCliente);
    }
    
    @WebMethod
    public String moverElemento (@WebParam(name = "pRutaOrigen") String pRutaOrigen,
                                 @WebParam(name = "pRutaDestino") String pRutaDestino,
                                 @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó mover un archivo / directorio!");
        return controlador.moverElemento(pRutaOrigen, pRutaDestino, pCliente);
    }
    
    @WebMethod
    public String removerElemento (@WebParam(name = "pRutaOrigen") String pRutaOrigen,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó eliminar un archivo / directorio!");
        return controlador.removerElemento(pRutaOrigen, pCliente);
    }
    
    @WebMethod
    public String encontrarElemento (@WebParam(name = "pNombre") String pNombre,
                                  @WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó encontrar un archivo / directorio!");
        return controlador.encontrarElemento(pNombre, pCliente);
    }
    
    @WebMethod
    public String generarArbol (@WebParam(name = "pCliente") String pCliente){
        System.out.println("Solicitó crear un arbol del file system!");
        return controlador.generarArbol(pCliente);
    }
    
    @WebMethod
    public String obtenerRuta (@WebParam(name = "pCliente") String pCliente){
        System.out.println(pCliente + " solicitó su ruta actual!");
        return controlador.obtenerRuta(pCliente);
    }
}
