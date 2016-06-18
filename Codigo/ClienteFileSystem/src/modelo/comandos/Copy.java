package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Copy implements IComando {
    public Copy(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String nombre, ruta, cliente;
        nombre = pArrayTokens.get(1);
        ruta = pArrayTokens.get(2);
        cliente = pArrayTokens.get(3);
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.copiarElemento(nombre, ruta, cliente);
        return respuesta;
    }
    
}
