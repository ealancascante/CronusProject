package modelo;

import modelo.utilidades.Dto;

public interface Almacenamiento {
    public Dto inicializarDisco(long pCantidad, long pTamano);
    public Dto agregarArchivoTexto(String pNombre, String pContenido, long pTamano);
    public Dto agregarDirectorio(String pNombre);
    public Dto listarElementos();
    public Dto verPropiedadesElemento(String pNombre);
    public Dto copiarElemento(String pNombre, String pRuta);
    public Dto borrarElemento(String pNombre);
    public Dto modificarContenidoArchivoTexto(String pNombre, String pContenido);
    public Dto mostrarContenidoArchivoTexto(String pNombre);
    public Dto mostrarArbol();
}
