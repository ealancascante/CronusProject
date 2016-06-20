package modelo;

import java.util.ArrayList;
import modelo.comandos.Ayuda;
import modelo.comandos.Cambiardir;
import modelo.comandos.Contfile;
import modelo.comandos.Copy;
import modelo.comandos.Create;
import modelo.comandos.File;
import modelo.comandos.Find;
import modelo.comandos.Listardir;
import modelo.comandos.Mkdir;
import modelo.comandos.Modfile;
import modelo.comandos.Mover;
import modelo.comandos.Remove;
import modelo.comandos.Ruta;
import modelo.comandos.Salir;
import modelo.comandos.Tree;
import modelo.comandos.Verprop;

public class ModeloCliente {
    private static ModeloCliente singleModeloCliente = null;
    
    private ModeloCliente(){}
     
    public static synchronized ModeloCliente getModeloCliente(){
       if(singleModeloCliente == null){
           singleModeloCliente = new ModeloCliente();
       }
       return singleModeloCliente;
    }
    
    public String ejecutarComando(ArrayList<String> pTokens){
        IComando comando;
        
        switch(pTokens.get(0)){
            case "create":
                comando = new Create();
                return comando.ejecutar(pTokens);
            case "file":
                comando = new File();
                return comando.ejecutar(pTokens);
            case "mkdir":
                comando = new Mkdir();
                return comando.ejecutar(pTokens);
            case "cd":
                comando = new Cambiardir();
                return comando.ejecutar(pTokens);
            case "listardir":
                comando = new Listardir();
                return comando.ejecutar(pTokens);
            case "modfile":
                comando = new Modfile();
                return comando.ejecutar(pTokens);
            case "verprop":
                comando = new Verprop();
                return comando.ejecutar(pTokens);
            case "contfile":
                comando = new Contfile();
                return comando.ejecutar(pTokens);
            case "copy":
                comando = new Copy();
                return comando.ejecutar(pTokens);
            case "mover":
                comando = new Mover();
                return comando.ejecutar(pTokens);
            case "remove":
                comando = new Remove();
                return comando.ejecutar(pTokens);
            case "find":
                comando = new Find();
                return comando.ejecutar(pTokens);
            case "tree":
                comando = new Tree();
                return comando.ejecutar(pTokens);
            case "salir":
                comando = new Salir();
                return comando.ejecutar(pTokens);
            case "ayuda":
                comando = new Ayuda();
                return comando.ejecutar(pTokens);
            case "ruta":
                comando = new Ruta();
                return comando.ejecutar(pTokens);
            default:
                return "Error modelo: Comando irreconocible";
        }
    }
}
