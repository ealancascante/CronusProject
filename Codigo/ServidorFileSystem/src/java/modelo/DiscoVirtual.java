package modelo;

import java.util.ArrayList;
import modelo.Archivo.Archivo;
import modelo.Archivo.ArchivoTexto;
import modelo.utilidades.Dto;

public class DiscoVirtual implements Almacenamiento {
private long cantidadSectores;
    private long tamanoSectores;
    private long sectoresLibres;
    private String propietario;
    private boolean activo;
    private static int contadorUsuario = 0;
    private SistemaArchivo sistemaArchivo;
    
    
    public DiscoVirtual(){
        Dto datos = new Dto();
        datos.agregarElemento("nombreClase", "modelo.SistemaArchivo_Cronus");
        sistemaArchivo = FabricaSistemaArchivo.crearSistemaArchivo(datos);
    }
    
    public Dto crearUsuario(){
        String nombreUsuario = "usr - " + Integer.toString(contadorUsuario);
        contadorUsuario++;
        
        propietario = nombreUsuario;
                
        Dto dto = new Dto();
        dto.agregarElemento("nombreUsuario", nombreUsuario);
        return dto;
    }
    
    @Override
    public Dto inicializarDisco(long pCantidadSectores, long pTamanoSectores){
        cantidadSectores = pCantidadSectores;
        tamanoSectores = pTamanoSectores;
        sectoresLibres = cantidadSectores;
        Dto dto = new Dto();
        dto.agregarElemento("asignacionEspacio", "Disco creado exitosamente");
        return dto;
    }
    
    @Override
    public Dto agregarArchivoTexto(String pNombre, String pContenido){
        long tamano = pContenido.length();
        String mensaje;
        Dto dto = new Dto();
        
        if(tamanoSectores <= 0)
            mensaje = "No hay espacio en disco";
        
        //calculamos la cantidad de sectores que ocupa el archivo :)
         long sectores = calcularCantidadSectores(tamano);
             System.out.println("cantidad de sectores: "+sectores +" tamano: "+tamano);
        if(ocuparSector(sectores)){
            if(sistemaArchivo.agregarArchivoTexto(pNombre, tamano, pContenido))          
                mensaje = "Se almacenó en disco";
            else
                mensaje = "No se pudo crear el archivo " + pNombre;   
        } 
        else
            mensaje = "No hay espacio en disco";
          
        dto.agregarElemento("agregarArchivo",mensaje);
        return dto;
    }
    
    @Override
    public Dto agregarDirectorio(String pNombre){
        //calculamos la cantidad de sectores que ocupa el archivo :)
        String mensaje;
        
        if(tamanoSectores <= 0)
            mensaje = "No hay espacio en disco";
        
        long sectores = calcularCantidadSectores(pNombre.length());
        
        Dto dto = new Dto();
        //Verificamos si hay espacio
        if(ocuparSector(sectores)){
            
            if(sistemaArchivo.agregarDirectorio(pNombre))          
                mensaje = "Se almacenó en disco";
            else
                mensaje = "No se pudo crear el directorio " + pNombre; 
        
        }else
            mensaje =  "No hay espacio en disco";
        
        dto.agregarElemento("agregarDirectorio", mensaje);
        return dto;
    }
    
    @Override
    public Dto listarElementos(){
        ArrayList<Archivo> listaArchivos = sistemaArchivo.listarElementos();
        String strArchivos = "";
        String tipoClase;
        Dto dto = new Dto();
        Archivo archvoImprimir;
        
        
        for(int contador = 0; contador < listaArchivos.size(); contador++){
            archvoImprimir = listaArchivos.get(contador);
            tipoClase = obtenerTipoArchivo(archvoImprimir);
            strArchivos += "Nombre: " + archvoImprimir.getNombre() + " Tipo: " + tipoClase + "\n";        
        }
        
        dto.agregarElemento("listaArchivo", strArchivos);
        
        return dto;
    }
    
    @Override
    public Dto verPropiedadesElemento(String pNombre){
        Archivo archivoPropiedades = sistemaArchivo.verPropiedadesElemento(pNombre);
        String strPropiedades = "";
        Dto dto = new Dto();
        String mensaje;
        
        if(archivoPropiedades != null){
            strPropiedades += "Nombre: " + archivoPropiedades.getNombre();
            if(obtenerTipoArchivo(archivoPropiedades).equals("ArchivoTexto")){
                ArchivoTexto archivoTexto = (ArchivoTexto) archivoPropiedades;              
                strPropiedades += "\n Extesion:" + archivoTexto.getExtension();
            }
            strPropiedades += "\n Tamano: " + sistemaArchivo.obtenerTamanoArchivo(pNombre) + "\n Fecha Creacion: "+archivoPropiedades.getFechaCreacion() + "\n Fecha Modificacion: " + archivoPropiedades.getFechaModificacion();                   
            
           mensaje = strPropiedades; 
        }else
           mensaje = "El archivo "+pNombre+" no existe ";
        
        dto.agregarElemento("propiedadesArchivo", mensaje);
        return dto;
    }
    
    @Override
    public Dto copiarElemento(String pNombre, String pRuta){
        Dto dto = new Dto();
        String mensaje;
        long tamano;
        long sectores;
        
        Archivo archivoPropiedades = sistemaArchivo.verPropiedadesElemento(pNombre);
        tamano = sistemaArchivo.obtenerTamanoArchivo(pNombre);
        
        if( archivoPropiedades != null && tamano != -1 ){
             sectores = calcularCantidadSectores(tamano);
            
            if(tamanoSuficiente(sectores)){
                
                if(sistemaArchivo.copiarElemento(pNombre, pRuta)){
                    mensaje = "Archivo copiado correctamente";
                    ocuparSector(sectores);
                }else
                    mensaje = "No se pudo copiar el archivo "+pNombre;
            }else
                mensaje = "No hay espacio en disco";
            
        }else
            mensaje = "El archivo "+pNombre+" no existe ";
        
        dto.agregarElemento("copiarArchivo", mensaje);
        return dto;
        
    }
    
    @Override
    public Dto moverElemnto (String pNombre, String pRuta){
        Dto dto = new Dto();
        String mensaje;
        
        Archivo archivoPropiedades = sistemaArchivo.verPropiedadesElemento(pNombre);
        
        if( archivoPropiedades != null ){
                          
            if(sistemaArchivo.moverElemento(pNombre, pRuta)){
                mensaje = "Archivo movido correctamente";
            }else
                mensaje = "No se pudo mover el archivo "+pNombre;

        }else
            mensaje = "El archivo "+pNombre+" no existe ";
        
        dto.agregarElemento("moverArchivo", mensaje);
        return dto;
    }
    
    @Override
    public Dto borrarElemento(String pNombre){
        Dto dto = new Dto();
        String mensaje;
        long tamano;
        
        tamano = sistemaArchivo.obtenerTamanoArchivo(pNombre);
        
        if(tamano != -1 && sistemaArchivo.borrarElemento(pNombre)){  
            liberarSector(calcularCantidadSectores(tamano));
            mensaje = "Se borro del disco";
            System.out.println(" tamano "+tamano+" sectores "+liberarSector(calcularCantidadSectores(tamano)));
        }else
            mensaje = "No se pudo borrar el archivo " + pNombre;
        dto.agregarElemento("borrarArchivo", mensaje);
        return dto;
    }
    
    @Override
    public Dto modificarContenidoArchivoTexto(String pNombre, String pContenido){
        Dto dto = new Dto();
        String mensaje;
        
        Archivo archivoPropiedades = sistemaArchivo.verPropiedadesElemento(pNombre);
             
        if( archivoPropiedades != null ){
                          
            if(sistemaArchivo.modificarContenidoArchivoTexto(pNombre, pContenido, pContenido.length())){
                mensaje = "Archivo modificado correctamente";
            }else
                mensaje = "No se pudo modificar el archivo "+pNombre;

        }else
            mensaje = "El archivo "+pNombre+" no existe ";
        
        dto.agregarElemento("modificarArchivo", mensaje);
        return dto;
    }
    
    @Override
    public Dto mostrarContenidoArchivoTexto(String pNombre){
        Archivo archivoContenido = sistemaArchivo.verPropiedadesElemento(pNombre);
        Dto dto = new Dto();
        String mensaje;
        
        if(archivoContenido != null && obtenerTipoArchivo(archivoContenido).equals("ArchivoTexto")){
            ArchivoTexto archivoTexto = (ArchivoTexto) archivoContenido;                      
            mensaje = archivoTexto.getContenido();
        }else
            mensaje = "El archivo "+pNombre+" no existe ";
        
        dto.agregarElemento("contenidoArhivo", mensaje);
        return dto;
    }
    
    @Override
    public Dto mostrarArbol(){
        Dto dto = new Dto();
        dto.agregarElemento("mostrarArbol", sistemaArchivo.mostrarArbol());
        return dto;
    }
    
    @Override
    public Dto navegar(String pRuta){
        Dto dto = new Dto();
        String mensaje;
        if(sistemaArchivo.navegar(pRuta))
            mensaje = "";
        else
            mensaje = "No se pudo accesar la ruta "+pRuta;
        dto.agregarElemento("navegar", mensaje);
        return dto;
    }
    
    @Override
    public Dto obtenerRutaActual(){
        Dto dto = new Dto();
        dto.agregarElemento("rutaActual", sistemaArchivo.obtenerRutaActual());
        return dto;
    }
    
@Override
    public Dto buscarArchivo(String pNombre){
        Dto dto = new Dto();
        dto.agregarElemento("buscarArchivo", sistemaArchivo.buscarArchivo(pNombre));
        return dto;
    }
    
    public long getCantidadSectores() {
        return cantidadSectores;
    }

    public long getTamanoSectores() {
        return tamanoSectores;
    }

    @Override
    public String getPropietario() {
        return propietario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setCantidadSectores(long cantidadSectores) {
        this.cantidadSectores = cantidadSectores;
    }

    public void setTamanoSectores(long tamanoSectores) {
        this.tamanoSectores = tamanoSectores;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
    public long getSectoresDisponibles() {
        return sectoresLibres;
    }

    public void setSectoresDisponibles(long sectoresLibres) {
        this.sectoresLibres = sectoresLibres;
    }
    
    private String obtenerTipoArchivo(Archivo pArchivo){
        Class clase = pArchivo.getClass();
        return clase.getSimpleName();
    }

     private boolean ocuparSector(long pCantidad){
        if(tamanoSuficiente(pCantidad)){
            sectoresLibres -= pCantidad;
            return true;
        }
        return false;
    }
    
    private boolean liberarSector(long pCantidad){
        if(cantidadSectores >= pCantidad){
            sectoresLibres += pCantidad;
            return true;
        }
        return false;
    }
    
    private boolean sectoresDisponibles(){
        return sectoresLibres > 0;
    }
    
    private boolean tamanoSuficiente(long pTamano){
        return sectoresLibres >= pTamano;
    }
    
    private long calcularCantidadSectores(long pTamano){
        long sectores = pTamano / tamanoSectores;
        long sobrante = pTamano % tamanoSectores;
        if(sobrante > 0) 
            sectores++;
        return sectores;
    }
}
