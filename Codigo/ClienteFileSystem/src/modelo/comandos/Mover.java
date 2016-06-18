package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Mover  implements IComando {
    public Mover(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String nombre, ruta, cliente;
        nombre = pArrayTokens.get(1);
        ruta = pArrayTokens.get(2);
        cliente = pArrayTokens.get(3);
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.moverElemento(nombre, ruta, cliente);
        return respuesta;
    }
    
}
