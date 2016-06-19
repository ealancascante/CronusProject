
package filesystem;

import Utilidades.Dto;

public interface Almacenamiento {
    public Dto inicializarDisco(long pCantidad, long pTamano);
    public Dto agregarArchivoTexto(String pNombre, String pContenido);
    public Dto agregarDirectorio(String pNombre);
    public Dto listarElementos();
    public Dto verPropiedadesElemento(String pNombre);
    public Dto copiarElemento(String pNombre, String pRuta);
    public Dto moverElemnto (String pNombre, String pRuta);
    public Dto borrarElemento(String pNombre);
    public Dto modificarContenidoArchivoTexto(String pNombre, String pContenido);
    public Dto mostrarContenidoArchivoTexto(String pNombre);
    public Dto mostrarArbol();
    public Dto navegar(String pRuta);
    public Dto obtenerRutaActual();
}
