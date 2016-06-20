package controlador;

import java.util.ArrayList;
import java.util.Arrays;
import modelo.ModeloCliente;
import vista.VistaConsola;

public class ControladorConsola {
    private ModeloCliente modelo;
    private VistaConsola vista;
    private String entrada, respuesta, cliente = "", rutaActual = "";
    private ArrayList<String> comandos;
    private ArrayList<String> comandoEntrada;
    private boolean discoCreado = false;
    private boolean terminarPrograma = false;
    
    public ControladorConsola(ModeloCliente pModelo, VistaConsola pVista){
        vista = pVista;
        modelo = pModelo;
        comandos = new ArrayList<>();
        comandos.addAll(Arrays.asList("create","file","mkdir","cd","listardir",
                                      "modfile","verprop","contfile","copy","mover",
                                      "remove", "find", "tree", "salir", "ayuda","ruta"));
    }
    
    public void atenderConsola(){
        respuesta = "";
        parseComando();
        if(isComandoValido()){
            if(isParametrosValidos()){
                if(!comandoEntrada.get(0).equals("create")){
                    if(discoCreado != false || comandoEntrada.get(0).equals("ayuda") || comandoEntrada.get(0).equals("salir")){
                        comandoEntrada.add(cliente);
                        respuesta = modelo.ejecutarComando(comandoEntrada);
                        
                        if(comandoEntrada.get(0).equals("salir"))
                            terminarPrograma = true;
                        
                        if((!comandoEntrada.get(0).equals("file") || !comandoEntrada.get(0).equals("mkdir")) && 
                            (respuesta.contains("No se pudo crear"))){
                            if(vista.getDecision().equals("y")){
                                ArrayList<String> comandoFantasma = new ArrayList<>();
                                comandoFantasma.add("remove");
                                comandoFantasma.add(comandoEntrada.get(1));
                                comandoFantasma.add(cliente);
                                modelo.ejecutarComando(comandoFantasma);
                                respuesta = modelo.ejecutarComando(comandoEntrada);
                            }
                        }
                        if(!comandoEntrada.get(0).equals("ayuda") && !comandoEntrada.get(0).equals("salir")){
                            comandoEntrada = new ArrayList<>();
                            comandoEntrada.add("ruta");
                            comandoEntrada.add(cliente);
                            rutaActual = modelo.ejecutarComando(comandoEntrada);
                        }
                    }
                    else
                        respuesta = "Error: Debe de crear un disco primero.";
                }
                else{
                    if(comandoEntrada.get(0).equals("create") && discoCreado == false){
                        discoCreado = true;
                        cliente = modelo.ejecutarComando(comandoEntrada);
                        rutaActual = "R:\\";
                        respuesta = "Se creó el disco con exito!";
                    }
                    else
                        respuesta = "Error: Usted ya creó un disco.";
                }
            }
            else
                respuesta = "Error: Parametros incorrectos.";
        }
        else
            respuesta = "Error: Comando no reconocido -> " + comandoEntrada.get(0);
    }
    
    public void parseComando(){
        comandoEntrada = new ArrayList<>();
        String[] partes1 = entrada.split("\\$:+");
        String[] partes2 = partes1[0].split("\\ +");
        for(int i = 0; i < partes2.length; i++)
            comandoEntrada.add(partes2[i]);
        if(partes1.length > 1){
            String str = "";
            for(int i = 1; i < partes1.length; i++)
                str = str + partes1[i];
            comandoEntrada.add(str);
        }
    }
    
    public boolean isComandoValido(){
        String str = comandoEntrada.get(0);
        for(int i = 0; i < comandos.size(); i++){
            if(comandos.get(i).equals(str))
                return true;
        }
        return false;
    }
    
    public boolean isParametrosValidos(){
        switch(comandoEntrada.get(0).toLowerCase()){
            case "create":
                if(!discoCreado && createValido()){
                    return true;
                }
                return false;
            case "file":
                return fileValido();
            case "mkdir":
                return mkdirValido();
            case "cd":
                return cambiardirValido();
            case "listardir":
                return listardirValido();
            case "modfile":
                return modfileValido();
            case "verprop":
                return verpropValido();
            case "contfile":
                return contfileValido();
            case "copy":
                return copyValido();
            case "mover":
                return moverValido();
            case "remove":
                return removerValido();
            case "find":
                return findValido();
            case "tree":
                return treeValido();
            case "salir":
                return salirValido();
            case "ayuda":
                return ayudaValido();
            case "ruta":
                return rutaValido();
            default:
                return false;
        }
    }
    
    public boolean createValido(){
        try{
            int sectores, tamano;
            sectores = Integer.parseInt(comandoEntrada.get(1));
            tamano = Integer.parseInt(comandoEntrada.get(2));
            return (comandoEntrada.size() == 3);
            
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean fileValido(){
        //file <nombre> $:<contenido>
        return(comandoEntrada.size() == 3 && isOcurrenciasString(comandoEntrada.get(1), ".", 1) && 
              !comandoEntrada.get(1).contains("\\") && isOcurrenciasString(comandoEntrada.get(1), "r:", 0)
                && isArchivoValido(comandoEntrada.get(1))); 
    }
    
    public boolean mkdirValido(){
        //mkdir <nombreDirectorio>
        return(comandoEntrada.size() == 2 && !comandoEntrada.get(1).contains("\\") &&
              isOcurrenciasString(comandoEntrada.get(1), "r:", 0) && !comandoEntrada.get(1).contains(".")); 
    }
    
    public boolean cambiardirValido(){
        //cambiardir <ruta>
        return(comandoEntrada.size() == 2 && isMenorOcurrenciasString(comandoEntrada.get(1), "r:\\", 1) &&
              !comandoEntrada.get(1).contains("\\r:")); 
    }
    
    public boolean listardirValido(){
        //listardir
        return(comandoEntrada.size() == 1); 
    }
    
    public boolean modfileValido(){
        //modfile <nombre> $:<contenido>
        return(comandoEntrada.size() == 3 && isOcurrenciasString(comandoEntrada.get(1), ".", 1) && 
              !comandoEntrada.get(1).contains("\\") && !comandoEntrada.get(1).contains("r:")); 
    }
    
    public boolean verpropValido(){
        //verprop <nombreArchivo>
        return(comandoEntrada.size() == 2 && isOcurrenciasString(comandoEntrada.get(1), ".", 1) && 
              !comandoEntrada.get(1).contains("\\") && !comandoEntrada.get(1).contains("r:")); 
    }
    
    public boolean contfileValido(){
        //contfile <nombreArchivo>
        return(comandoEntrada.size() == 2 && isOcurrenciasString(comandoEntrada.get(1), ".", 1) && 
              !comandoEntrada.get(1).contains("\\") && !comandoEntrada.get(1).contains("r:"));
    }
    
    public boolean copyValido(){
        //copy <nombre> <ruta>
        return(comandoEntrada.size() == 3 && isOcurrenciasString(comandoEntrada.get(1), ".", 1) && 
              !comandoEntrada.get(1).contains("\\") &&
              !comandoEntrada.get(1).contains("r:") &&
              !comandoEntrada.get(2).contains("\\r:") &&
               isMenorOcurrenciasString(comandoEntrada.get(1), "r:\\", 1));
    }
    
    public boolean moverValido(){
        //mover <nombre> <ruta>
        return(comandoEntrada.size() == 3 && isOcurrenciasString(comandoEntrada.get(1), ".", 1) && 
              !comandoEntrada.get(1).contains("\\") &&
              !comandoEntrada.get(1).contains("r:") &&
              !comandoEntrada.get(2).contains("\\r:") &&
               isUnPunto(comandoEntrada.get(2)));
    }
    
    public boolean removerValido(){
        //remover <nombre>
        return(comandoEntrada.size() == 2 && 
              isMenorOcurrenciasString(comandoEntrada.get(1), ".", 1) &&
              !comandoEntrada.get(1).contains("\\") &&
              !comandoEntrada.get(1).contains("r:"));
    }
    
    public boolean findValido(){
        //find <nombre>
        return(comandoEntrada.size() == 2 &&
               isMenorOcurrenciasString(comandoEntrada.get(1), ".", 1) &&
              !comandoEntrada.get(1).contains("\\") &&
              !comandoEntrada.get(1).contains("r:"));
    }
    
    public boolean treeValido(){
        //tree
        return(comandoEntrada.size() == 1);
    }
    
    public boolean salirValido(){
        //salir
        return(comandoEntrada.size() == 1);
    }
    
    public boolean ayudaValido(){
        //ayuda
        return(comandoEntrada.size() == 1);
    }
    
    public boolean rutaValido(){
        //ayuda
        return(comandoEntrada.size() == 1);
    }
    
    private boolean isOcurrenciasString(String pString, String pSubString, int pOcurrencias){
        int ultimoIndice = 0;
        int contador = 0;
        while (ultimoIndice != -1) {
            ultimoIndice = pString.indexOf(pSubString,ultimoIndice);
            if(ultimoIndice != -1){
                contador ++;
                ultimoIndice += pSubString.length();
            }
        }
        return (contador == pOcurrencias);
    }
    
    private boolean isMenorOcurrenciasString(String pString, String pSubString, int pOcurrencias){
        int ultimoIndice = 0;
        int contador = 0;
        while (ultimoIndice != -1) {
            ultimoIndice = pString.indexOf(pSubString,ultimoIndice);
            if(ultimoIndice != -1){
                contador ++;
                ultimoIndice += pSubString.length();
            }
        }
        return (contador <= pOcurrencias);
    }
    
    private boolean isUnPunto(String pStr){
        int contador = 0;
        for(int i = 0; i < pStr.length(); i++){
            if(pStr.charAt(i) == '.')
                contador ++;
        }
        return (contador <= 1);
    }
    
    public String getEntrada() {
        return entrada;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public boolean isDiscoCreado() {
        return discoCreado;
    }

    public boolean isTerminarPrograma() {
        return terminarPrograma;
    }

    public String getCliente() {
        return cliente;
    }

    public String getRutaActual() {
        return rutaActual;
    }
    
    private boolean isArchivoValido(String pNombre){
        String[] partes = pNombre.split("\\.");
        return partes.length == 2;
    }
}
