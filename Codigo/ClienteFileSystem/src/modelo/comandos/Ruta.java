package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Ruta implements IComando{
    public Ruta(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String cliente;
        cliente = pArrayTokens.get(1);
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.obtenerRuta(cliente);
        return respuesta;
    }
    
}
