package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class Modfile implements IComando {
    public Modfile(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String nombre, contenido, cliente;
        nombre = pArrayTokens.get(1);
        contenido = pArrayTokens.get(2);
        cliente = pArrayTokens.get(3);
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.modificarArchivo(nombre, contenido, cliente);
        return respuesta;
    }
    
}
