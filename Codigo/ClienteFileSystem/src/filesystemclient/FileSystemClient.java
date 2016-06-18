package filesystemclient;

import com.webservice.filesystem.FileSystemService;
import com.webservice.filesystem.FileSystemServiceService;
import controlador.ControladorConsola;
import java.io.IOException;
import modelo.ModeloCliente;
import vista.VistaConsola;

public class FileSystemClient { 
    public static void main(String[] args) throws IOException {
        ModeloCliente modeloCliente = ModeloCliente.getModeloCliente();
        VistaConsola vistaConsola = new VistaConsola();
        ControladorConsola contraladorConsola = new ControladorConsola(modeloCliente, vistaConsola);
        vistaConsola.interfazConsola(contraladorConsola);
    }
}