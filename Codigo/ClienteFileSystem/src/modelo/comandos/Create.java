package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Create implements IComando{
    public Create(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        int sectores, tamano;
        sectores = Integer.parseInt(pArrayTokens.get(1));
        tamano = Integer.parseInt(pArrayTokens.get(2));
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.crearDisco(sectores, tamano);
        return respuesta;
    }
    
}
