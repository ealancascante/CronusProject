
package Controlador;

import java.util.ArrayList;
import modelo.Almacenamiento;
import modelo.FabricaAlmacenamiento;
import modelo.utilidades.Dto;


public class Controlador implements InterfaceControlador{
    private ArrayList<Almacenamiento> listaAlmacenamiento;
    
    public Controlador(){
        listaAlmacenamiento = new ArrayList<Almacenamiento>();
    }
    
    @Override
    public String crearDisco(long pCantidadSectores, long pTamanoSectores){
        Dto datos = new Dto();
        Almacenamiento almacenamiento;
        Dto dtoUsuario;
        Dto dtoCrear;
        
        /*      Crea y agrega el objeto     */
        datos.agregarElemento("nombreClase", "modelo.DiscoVirtual");
        listaAlmacenamiento.add(FabricaAlmacenamiento.crearAlmaceamiento(datos));
        
        /*      Obtenermos almacenamiento que creamos       */
        almacenamiento = listaAlmacenamiento.get(listaAlmacenamiento.size()-1);
        if(almacenamiento == null)
            return "Usuario invalido";
        /*      Inicializamos el almacenamiento     */
        dtoUsuario = almacenamiento.crearUsuario();          
        dtoCrear = almacenamiento.inicializarDisco(pCantidadSectores, pCantidadSectores);
        
        return (String) dtoUsuario.buscarLlave("nombreUsuario");
    }
    
    @Override
    public String crearArchivo (String pNombre, String pContenido, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoCrear;
        
        /*      Verifica si el cliente es dueno de una unidad de almacenamiento     */
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoCrear = almacenamiento.agregarArchivoTexto(pNombre, pContenido);
        
        return (String) dtoCrear.buscarLlave("agregarArchivo");
    }
    
    @Override
    public String crearDirectorio (String pNombre, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoCrear;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoCrear = almacenamiento.agregarDirectorio(pNombre);
        
        return (String) dtoCrear.buscarLlave("agregarDirectorio");
    }
    
    @Override
    public String cambiarDirectorio (String pRuta, String pCliente){
         Almacenamiento almacenamiento;
        Dto dtoCambiar;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoCambiar = almacenamiento.navegar(pRuta);
        
        return (String) dtoCambiar.buscarLlave("navegar");
    }
     
    @Override
    public String listarDirectorio (String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoLista;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoLista = almacenamiento.listarElementos();
        
        return (String) dtoLista.buscarLlave("listaArchivo");
    }
     
    @Override
    public String modificarArchivo (String pNombre, String pContenido, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoModificar;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoModificar = almacenamiento.modificarContenidoArchivoTexto(pNombre, pContenido);
        
        return (String) dtoModificar.buscarLlave("modificarArchivo");
    }
     
    @Override
    public String verPropiedades (String pNombre, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoPropiedades;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoPropiedades = almacenamiento.verPropiedadesElemento(pNombre);
        
        return (String) dtoPropiedades.buscarLlave("propiedadesArchivo");
    }
     
    @Override
    public String contenidoArchivo (String pNombre, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoContenido;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";     
        
        dtoContenido = almacenamiento.mostrarContenidoArchivoTexto(pNombre);
        
        return (String) dtoContenido.buscarLlave("contenidoArhivo");
    }
     
    @Override
    public String copiarElemento (String pNombre, String pRuta, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoCopiar;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoCopiar = almacenamiento.copiarElemento(pNombre, pRuta);
        
        return (String) dtoCopiar.buscarLlave("copiarArchivo");
    }
     
    @Override
    public String moverElemento (String pNombre, String pRuta, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoMover;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoMover = almacenamiento.moverElemnto(pNombre, pRuta);
        
        return (String) dtoMover.buscarLlave("moverArchivo");
    }
     
    @Override
    public String removerElemento (String pNombre, String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoRemover;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoRemover = almacenamiento.borrarElemento(pNombre);
        
        return (String) dtoRemover.buscarLlave("borrarArchivo");
    }
     
    @Override
     public String encontrarElemento (String pRuta, String pCliente){
         Almacenamiento almacenamiento;
        Dto dtoEncontrar;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoEncontrar = almacenamiento.buscarArchivo(pRuta);
        
        return (String) dtoEncontrar.buscarLlave("buscarArchivo");
    }
     
    @Override
    public String generarArbol (String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoGenerar;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoGenerar = almacenamiento.mostrarArbol();
        
        return (String) dtoGenerar.buscarLlave("mostrarArbol");
    }
    
    @Override
    public String obtenerRuta (String pCliente){
        Almacenamiento almacenamiento;
        Dto dtoRuta;
        
        almacenamiento = getDisco(pCliente);
        if(almacenamiento == null)
            return "Usuario invalido";
        
        dtoRuta = almacenamiento.obtenerRutaActual();
        
        return (String) dtoRuta.buscarLlave("rutaActual");
    }
    
    private Almacenamiento getDisco(String pCliente){
        for(int contador =0; contador < listaAlmacenamiento.size(); contador++){
            if(listaAlmacenamiento.get(contador).getPropietario().equals(pCliente))
                return listaAlmacenamiento.get(contador);
        }
        return null;
    }
}
