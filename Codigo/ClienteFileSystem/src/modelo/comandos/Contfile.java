package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Contfile  implements IComando{
    public Contfile(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String nombre, cliente;
        nombre = pArrayTokens.get(1);
        cliente = pArrayTokens.get(2);
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.contenidoArchivo(nombre, cliente);
        return respuesta;
    }
    
}
