package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Cambiardir implements IComando{
    public Cambiardir(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String ruta, cliente;
        ruta = pArrayTokens.get(1);
        cliente = pArrayTokens.get(2);
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.cambiarDirectorio(ruta, cliente);
        return respuesta;
    }
    
}
