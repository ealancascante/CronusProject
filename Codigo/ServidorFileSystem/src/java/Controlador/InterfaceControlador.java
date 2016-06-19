
package Controlador;


public interface InterfaceControlador {
    public String crearDisco(long pCantidadSectores, long pTamanoSectores);
    public String crearArchivo (String pNombre, String pContenido, String pCliente);
    public String crearDirectorio (String pNombre, String pCliente);
    public String cambiarDirectorio (String pRuta, String pCliente);
    public String listarDirectorio (String pCliente);
    public String modificarArchivo (String pNombre, String pContenido, String pCliente);
    public String verPropiedades (String pNombre, String pCliente);
    public String contenidoArchivo (String pNombre, String pCliente);
    public String copiarElemento (String pNombre, String pRuta, String pCliente);
    public String moverElemento (String pNombre, String pRuta, String pCliente);
    public String removerElemento (String pNombre, String pCliente);
    public String generarArbol (String pCliente);
    public String obtenerRuta (String pCliente);
    public String encontrarElemento (String pRuta, String pCliente);
}
