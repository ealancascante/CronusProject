package modelo;

import modelo.utilidades.Dto;

public class DiscoVirtual implements Almacenamiento {
    private long cantidadSectores;
    private long tamanoSectores;
    private long sectoresLibres;
    private String propietario;
    private boolean activo;
    private static int contadorUsuario = 0;
    
    public DiscoVirtual(){
    }
    
    public Dto crearUsuario(){
        String nombreUsuario = "usr - " + Integer.toString(contadorUsuario);
        contadorUsuario++;
        Dto dto = new Dto();
        dto.agregarElemento("Nombre usuario", nombreUsuario);
        return dto;
    }
    
    @Override
    public Dto inicializarDisco(long pCantidadSectores, long pTamanoSectores){
        cantidadSectores = pCantidadSectores;
        tamanoSectores = pTamanoSectores;
        sectoresLibres = cantidadSectores;
        Dto dto = new Dto();
        dto.agregarElemento("Asignacion de espacio", "Disco creado exitosamente");
        return dto;
    }
    
    @Override
    public Dto agregarArchivoTexto(String pNombre, String pContenido, long pTamano){
        //calculamos la cantidad de sectores que ocupa el archivo :)
        long sectores = pTamano / tamanoSectores;
        long sobrante = pTamano % tamanoSectores;
        if(sobrante > 0) sectores++;
        
        Dto dto = new Dto();
        if(tamanoSuficiente(sectores)){
            sectoresLibres -= sectores;
            //aqui llamamos a la interface
            dto.agregarElemento("Agregar archivo", "Se almacenó en disco");
        } 
        else
            dto.agregarElemento("Agregar archivo", "No hay espacio en disco");
        return dto;
    }
    
    @Override
    public Dto agregarDirectorio(String pNombre){
        //calculamos la cantidad de sectores que ocupa el archivo :)
        long sectores = pNombre.length() / tamanoSectores;
        long sobrante = pNombre.length() % tamanoSectores;
        if(sobrante > 0) sectores++;
        
        Dto dto = new Dto();
        //Verificamos si hay espacio
        if(sectoresLibres >= sectores)
            dto.agregarElemento("Agregar directorio", "Se almacenó en disco");
        else
            dto.agregarElemento("Agregar directorio", "No hay espacio en disco");
        return dto;
    }
    
    @Override
    public Dto listarElementos(){
        return null;
    }
    
    @Override
    public Dto verPropiedadesElemento(String pNombre){
        return null;
    }
    
    @Override
    public Dto copiarElemento(String pNombre, String pRuta){
        return null;
    }
    
    @Override
    public Dto borrarElemento(String pNombre){
        return null;
    }
    
    @Override
    public Dto modificarContenidoArchivoTexto(String pNombre, String pContenido){
        return null;
    }
    
    @Override
    public Dto mostrarContenidoArchivoTexto(String pNombre){
        return null;
    }
    
    @Override
    public Dto mostrarArbol(){
        return null;
    }
    
    private boolean ocuparSector(long pCantidad){
        return false;
    }
    
    private boolean liberarSector(long pCantidad){
        return false;
    }
    
    private boolean sectoresDisponibles(){
        return sectoresLibres > 0;
    }
    
    private boolean tamanoSuficiente(long pTamano){
        return sectoresLibres >= pTamano;
    }
    
    public long getCantidadSectores() {
        return cantidadSectores;
    }

    public long getTamanoSectores() {
        return tamanoSectores;
    }

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

}
