package modelo.comandos;

import java.util.ArrayList;
import modelo.IComando;

public class Ayuda implements IComando {

    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        return    "--------------\n"
                + "    Ayuda\n"
                + "--------------\n"
                + "Comandos (key sensitive):\n"
                + "-> create <sectores> <tamañoSector> \n"
                + "-> file <nombre> $:<contenido> \n"
                + "-> mkdir <nombre>\n"
                + "-> cd <nombre>\n"
                + "-> listardir\n"
                + "-> modfile <nombre> <nuevoContenido>\n"
                + "-> verprop <nombre>\n"
                + "-> contfile <nombre>\n"
                + "-> copy <nombre> <ruta>\n"
                + "-> mover <nombre> <ruta>\n"
                + "-> remove <nombre>\n"
                + "-> find <nombre>\n"
                + "-> tree\n"
                + "-> ruta\n"
                + "-> salir\n";
    }
    
}
