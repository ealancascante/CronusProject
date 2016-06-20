package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Verprop  implements IComando {
    public Verprop(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String cliente, nombre;
        nombre = pArrayTokens.get(1);
        cliente = pArrayTokens.get(2);
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.verPropiedades(nombre,cliente);
        return respuesta;
    }
    
}
