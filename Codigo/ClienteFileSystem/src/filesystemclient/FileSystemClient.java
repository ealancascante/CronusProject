package filesystemclient;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import java.time.Clock;

public class FileSystemClient { 
    public static void main(String[] args) {
        /*//Creamos un nuevo servicio el cual va a conectar mediante SOAP con el
        //WS del servidor
        FileSystemServiceService fileSystemService = new FileSystemServiceService();
        
        //Obtenemos el puerto para establecer a comunicacion
        FileSystemService fsService = fileSystemService.getFileSystemServicePort();
        
        //fsService ahora posee acceso a los metodos descritos en el WSDL :)
        System.out.println(fsService.crearDisco(1, 100));*/

        
        long tamanoSectores = 10;
        long pTamano = 5;
        long sectores = 0;
        sectores = pTamano / tamanoSectores;
        long sobrante = pTamano % tamanoSectores;
        if(sobrante > 0) sectores++;
        System.out.println(sectores);
    }
    
}
