package modelo;

import java.util.ArrayList;
import modelo.Archivo.Archivo;

public interface SistemaArchivo {
    public boolean agregarArchivoTexto(String pNombre, long pTamano, String pContenido);
    public boolean agregarDirectorio(String pNombre);
    public boolean navegar(String pRuta);
    public boolean borrarElemento(String pNombre);
    public boolean cambiarNombreElemento(String pNombreViejo, String pNombreNuevo);
    public boolean modificarContenidoArchivoTexto(String pNombre, String pContenido, long pTamano);
    public String mostrarArbol();
    public ArrayList<Archivo> listarElementos();
    public Archivo verPropiedadesElemento(String pNombre);
    public String mostrarContenidoArchivoTexto(String pNombre);
    public boolean copiarElemento(String pNombre, String pRuta);
    public boolean moverElemento (String pNombre, String pRuta);
    public String obtenerRutaActual();
    public long obtenerTamanoArchivo(String pNombre);
    public String buscarArchivo(String pNombre);
}
