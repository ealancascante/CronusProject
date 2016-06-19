package modelo;

import java.util.ArrayList;
import modelo.utilidades.Dto;

public interface SistemaArchivo {
    public boolean agregarArchivoTexto(String pNombre, String pContenido, long pTamano);
    public boolean agregarDirectorio(String pNombre);
    public boolean navegar(String pRuta);
    public ArrayList<String> listarElementos();
}
