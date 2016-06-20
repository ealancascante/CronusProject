
package modelo;

import Arbol.Arbol;
import Arbol.Elemento;
import Arbol.Nodo;
import java.util.ArrayList;
import modelo.Archivo.Archivo;
import modelo.Archivo.ArchivoTexto;
import modelo.Archivo.Directorio;
import modelo.utilidades.Dto;

public class SistemaArchivo_Cronus implements SistemaArchivo{
    private String rutaActual;
    private EstructuraDato estructura;
    
    public SistemaArchivo_Cronus(){
        rutaActual = "R:\\";
        Dto datos = new Dto();
        datos.agregarElemento("nombreClase", "Arbol.Arbol");
        estructura = crearEstructraDato(datos);
    }
    
    @Override
    public boolean agregarArchivoTexto(String pNombre, long pTamano, String pContenido){       
        String extension = extraerExtension(pNombre); 
        
        if(extension.equals(""))
            return false;
        
        ArchivoTexto nuevoArhivo = new ArchivoTexto(pNombre,extension,pContenido,pTamano);
        
        return estructura.agregarElemento(nuevoArhivo);
    }
    
    @Override
    public boolean agregarDirectorio(String pNombre){
        Directorio nuevoDirectorio = new Directorio (pNombre);
        
        return estructura.agregarElemento(nuevoDirectorio);  
    }
    
        
    @Override
    public boolean navegar(String pRuta){
        String[] listaArchivos = seprarRuta(pRuta);
        boolean exito;
        /*    
        System.out.print("\n listaAntes");
        for(int contador = 0; contador < listaArchivos.length; contador++){
            System.out.print(" "+listaArchivos[contador]);
        }
        */
         //System.out.print("\n listaDespues");
        
        String[] listaLimpia = bucarCaracteresEspeciales(listaArchivos);
        
        if(listaLimpia[0].equals("$:\\Error"))
            return false;
        
        
        for(int contador = 0; contador < listaArchivos.length; contador++){
            System.out.print(" "+listaLimpia[contador]);
        }
            System.out.print("\n");
        
        exito = estructura.recorrer(listaLimpia, "ACTUAL");
        if(exito)
            rutaActual = cambiarRuta(listaLimpia, rutaActual);
        return exito;
    }
    
    @Override
    public boolean borrarElemento(String pNombre){        
        return estructura.eliminarElemento(pNombre);        
    }

    
    @Override
    public boolean cambiarNombreElemento(String pNombreViejo, String pNombreNuevo){
        Nodo modificarNodo = estructura.obtenerNodoHijo(pNombreViejo);
        
        /*      Verifica que exista     */
        if(modificarNodo == null)
            return false;
        Elemento elemento = modificarNodo.getElemento();
        elemento.setNombre(pNombreNuevo);
        
        /*      Verifica si es un archivo de texto      */
        if(obtenerTipoElemento(elemento).equals("ArchivoTexto")){
            
            ArchivoTexto nuevoArchivo = (ArchivoTexto)elemento;            
            nuevoArchivo.setExtension(pNombreNuevo);
            /*      Devolvemos el element modificado        */
            modificarNodo.setElemento(nuevoArchivo);
            
            return estructura.agregarElemento(nuevoArchivo);  
    }
        
        return estructura.agregarElemento(elemento);  
      
    }
    
    @Override
    public boolean modificarContenidoArchivoTexto(String pNombre, String pContenido, long pTamano){
        Nodo modificarNodo = estructura.obtenerNodoHijo(pNombre);     
        
        /*      Verifica que exista y sea un archivo de texto      */
        if(modificarNodo != null && obtenerTipoElemento(modificarNodo.getElemento()).equals("ArchivoTexto")){
         
            ArchivoTexto nuevoArchivo = (ArchivoTexto)modificarNodo.getElemento();            
            nuevoArchivo.setContenido(pContenido);
            nuevoArchivo.setTamano(pTamano);
            
            modificarNodo.setElemento(nuevoArchivo);
            estructura.eliminarElemento(pNombre);
            estructura.agregarNodo(modificarNodo);
            
            return true;  
        }
        
        return false;
        
    }
    
    @Override
    public String mostrarArbol(){
        return estructura.mostrarEstructura();
    }
    
    /*      Puede enviar un lista vacia si no contiene ningun elemento      */
    @Override
    public ArrayList<Archivo> listarElementos(){
            ArrayList<Elemento> listaElementos = estructura.obtenerElmentosContenidos();
            ArrayList<Archivo> listaArchivo = new ArrayList<Archivo>();
            
            for(int contador = 0; contador < listaElementos.size(); contador++){
                listaArchivo.add((Archivo)listaElementos.get(contador));
            }
            
            /*      Ver si se puede mandar objetos por el webservice    */
            return listaArchivo;
    
    }
    
    @Override
    public Archivo verPropiedadesElemento(String pNombre){
        return (Archivo) estructura.obtenerElemento(pNombre);
    }
    
    /*      Devuelve un string vacio en caso de que no se enuentre el archivo       */
    @Override
    public String mostrarContenidoArchivoTexto(String pNombre){
        Elemento archivoTexto = estructura.obtenerElemento(pNombre);  
        
        /*      Verifica que exista y sea un archivo de texto      */
        if(archivoTexto != null && obtenerTipoElemento(archivoTexto).equals("ArchivoTexto")){
         
            ArchivoTexto nuevoArchivo = (ArchivoTexto)archivoTexto;            
            return nuevoArchivo.getContenido();  
        }
        
        return "";       
    }
    
    @Override
    public boolean copiarElemento(String pNombre, String pRuta){
        
        Nodo nodoCopiar = estructura.obtenerNodoHijo(pNombre);
        String[] listaArchivos = seprarRuta(pRuta);
        
        /*      Verifica que exista     */
        if(nodoCopiar == null)
            return false;

       return agregarArchivoRuta(nodoCopiar,listaArchivos); 
    }
    
    @Override
    public boolean moverElemento (String pNombre, String pRuta){
        Nodo nodoCopiar = estructura.obtenerNodoHijo(pNombre);
        String[] listaArchivos = seprarRuta(pRuta);

        boolean exito;
        
        /*      Verifica que exista     */
        if(nodoCopiar == null)
            return false;
        /*      Elimina el elemento     */
        exito = estructura.eliminarElemento(pNombre);

        if(exito == false)
            return false;
        
        return agregarArchivoRuta(nodoCopiar,listaArchivos);
    
    }
    
    @Override
    public String obtenerRutaActual(){
        Arbol ar = (Arbol)estructura;
        System.out.println("NODO "+ar.getNodoActual());
        return rutaActual;
    }
    
    @Override
    public long obtenerTamanoArchivo(String pNombre){
        return estructura.calcularTamanoElemento(pNombre);
    }
    
    @Override
    public String buscarArchivo(String pNombre){
        return estructura.encontrarElemento(pNombre);
    }
    
    private String obtenerTipoElemento(Elemento pElmento){
        Class clase = pElmento.getClass();
        return clase.getSimpleName();
    }
    
    private String extraerExtension(String pNombre){
        if(pNombre.contains(".") != true)
            return "";
        
        String[] nombreParte = pNombre.split("\\.");
        return nombreParte[1];
    }
    
    private String[] seprarRuta (String pRuta){
        if(pRuta.contains("\\"))
             return pRuta.split("\\\\");
             
        String[] ruta = {pRuta};    
        return ruta;
    }
    
    private String[] bucarCaracteresEspeciales(String[] pRuta){
        
        String punteroActual = rutaActual;

        for(int contador = 0; contador < pRuta.length; contador++){
            if(pRuta[contador].equals("..")){                
                String dirPadre = getDirectorioPadre(punteroActual);
                if(!dirPadre.equals("")){
                    pRuta[contador] = dirPadre;
                    punteroActual = deveolverUnDirectorio(punteroActual);
                }else    /* Si el rutaActual es solo la raiz */
                    pRuta[0] = "$:\\Error";
                continue;
            }
            
            if(pRuta[contador].equals(".")){
                pRuta[contador] = "";
                continue;
            }
            punteroActual += pRuta[contador]+ "\\";
            
        }
        return pRuta;
    }
    
    private String cambiarRuta(String[] pRuta, String pActual){
        String dirPadre;

        for(int contador = 0; contador < pRuta.length; contador++){
            dirPadre = getDirectorioPadre(pActual);
            if(!dirPadre.equals("") && pRuta[contador].equals(dirPadre)){                           
                pActual = deveolverUnDirectorio(pActual);
                continue;
            }
            
            if(pRuta[contador].equals(""))
                continue;
            
            pActual+= pRuta[contador]+"\\";

        }
        
        return pActual;
    }
    
    private String cambiarRutaReal(String[] pRuta, String pActual){
        String[] pRutaActual = seprarRuta (pActual);
        int contadorRuta = 0;
        String dirPadre;
        
        /*      Se mueve hasta a donde ambas ruta son iguales        */
        while((pRuta.length < contadorRuta && pRutaActual.length < contadorRuta)){
            if( !pRutaActual[contadorRuta].equals(pRutaActual[contadorRuta]) )
                break;
            contadorRuta++;    
        }
        
        /*      Cambia la ruta      */
        for(int contador = contadorRuta; contador < pRuta.length; contador++){
            dirPadre = getDirectorioPadre(pActual);
            if(!dirPadre.equals("") && pRuta[contador].equals(dirPadre)){                           
                pActual = deveolverUnDirectorio(pActual);
                continue;
            }
            
            if(pRuta[contador].equals(""))
                continue;
            
            pActual+= pRuta[contador]+"\\";

        }
        
        return pActual;
    }
    
    private String getDirectorioPadre(String pActual){
        String[] parteRuta = seprarRuta(pActual);
       
        if(parteRuta.length >= 2){
            return parteRuta[parteRuta.length-2];
            
        }else    /* Si el rutaActual es solo la raiz */
            return "";
    }
    
    private String getDirectorioActual(String pAcual){
        String[] parteRuta = seprarRuta(pAcual);
        return parteRuta[parteRuta.length-1];
    }
    
    private String deveolverUnDirectorio(String pActual){
        String [] rutaParte = pActual.split(getDirectorioActual(pActual));
        return rutaParte[0];
    }
    
    private boolean agregarArchivoRuta(Nodo pNodo, String[] pRuta){
        String tipo;
        boolean exito;
        String[] listaLimpia = bucarCaracteresEspeciales(pRuta);
        
        if("R:".equals(listaLimpia[0]))
            tipo = "REAL";
        else
            tipo = "ACTUAL";
        
        exito = estructura.recorrer(listaLimpia,tipo);
        
        if(exito){
            if(tipo.equals("ACTUAL"))
                rutaActual = cambiarRuta(listaLimpia,rutaActual);
            else
               rutaActual = cambiarRutaReal(listaLimpia,rutaActual);
            return estructura.agregarNodo(pNodo);  
        }else
            return false;
    }
    
    private EstructuraDato crearEstructraDato(Dto pDatos){
       return FabricaEstructuraDato.crearEstructuraDato(pDatos);
    }    
}
