package modelo.comandos;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.util.ArrayList;
import modelo.IComando;

public class File implements IComando {
    
    public File(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        String nombre, contenido, cliente;
        nombre = pArrayTokens.get(1);
        contenido = pArrayTokens.get(2);
        cliente = pArrayTokens.get(3);
        
        String[] partes = nombre.split("\\.");
        
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        String respuesta = fsService.crearArchivo(nombre, contenido, partes[1], cliente);
        return respuesta;
    }
    
}
