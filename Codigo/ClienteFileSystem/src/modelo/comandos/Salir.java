package modelo.comandos;

import java.util.ArrayList;
import modelo.IComando;

public class Salir implements IComando {
    public Salir(){
    }
    
    @Override
    public String ejecutar(ArrayList<String> pArrayTokens) {
        return    "Gracias por usar nuestro File System! :)\n"
                + "Creado por:\n"
                + "+Eliécer Alán Cascante\n"
                + "+Alexander Sánchez Bustamante\n";
    }
}
