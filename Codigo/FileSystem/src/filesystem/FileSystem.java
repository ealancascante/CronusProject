
package filesystem;

import Archivo.Archivo;
import Archivo.Directorio;
import Archivo.ArchivoTexto;
import filesystem.arbol.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSystem {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        
        arbol.agregarElemento(new Directorio("Elem11"));       
        arbol.agregarElemento(new Directorio("Elem12"));
        arbol.agregarElemento(new ArchivoTexto("Elem13","doc","Adios",45));
        arbol.agregarElemento(new ArchivoTexto("Alex.doc","doc","Adios",45));
        
        String[] a = {"R:", "Elem11"};
        arbol.recorrer(a , "REAL");
       arbol.agregarElemento(new Directorio("Alex 2"));
        //System.out.println(arbol.getNodoActual());
        
        
       
       SistemaArchivo_Cronus sistem = new SistemaArchivo_Cronus();
       sistem.agregarArchivoTexto("Archivo1.jpg", 1, "Este es el archivo 1");
       sistem.agregarDirectorio("Directorio1");
       sistem.agregarDirectorio("Directorio2");
       
       System.out.println("Navegar "+sistem.navegar("Directorio1"));
       
       sistem.agregarDirectorio("Directorio3");
       sistem.agregarArchivoTexto("Archivo2.jpg", 2, "Este es el archivo 2");
       sistem.agregarDirectorio("Directorio4");
       
       //System.out.println("dir"+sistem.navegar("Directorio3\\.."));
      sistem.navegar("Directorio3");
      sistem.agregarArchivoTexto("Archivo3.jpg", 8, "Este es el archivo 3");
       
      sistem.navegar("..\\..\\");
      System.out.println(sistem.mostrarArbol());
      
       System.out.println("Tamano de Directorio 1: "+sistem.obtenerTamanoArchivo("Directorio1"));
       
       sistem.agregarArchivoTexto("Archivo4.jpg", 7, "Este es el archivo 4");
       
       System.out.println(sistem.mostrarArbol());
       
      /* System.out.println(sistem.borrarElemento("Archivo4.jpg"));
        
       System.out.println(sistem.mostrarArbol());
       
       System.out.println(sistem.borrarElemento("Directorio2"));
        
       System.out.println(sistem.mostrarArbol());*/
       
       sistem.modificarContenidoArchivoTexto("Archivo1.jpg", "Hola cambiel el archivo", 500);
       
       System.out.println(sistem.mostrarArbol());
       
       System.out.println(sistem.mostrarContenidoArchivoTexto("Archivo1.jpg"));
       
       System.out.println(sistem.mostrarArbol());
       
       ArrayList<Archivo> listaArchivo = sistem.listarElementos();
       System.out.println(listaArchivo.get(0).getNombre());
       
       ArchivoTexto archivo = (ArchivoTexto)sistem.verPropiedadesElemento("Archivo1.jpg");
       
       System.out.println("Nombre: "+archivo.getNombre()+" Contenido: "+archivo.getContenido());
       
       //System.out.println("Copiando \n"+sistem.copiarElemento("Archivo1.jpg", "R:\\Directorio1\\Directorio3"));
       
       //System.out.println("Copiando \n"+sistem.moverElemento("Archivo1.jpg", "R:\\Directorio1\\Directorio3"));
       
       System.out.println("Copiando \n"+sistem.moverElemento("Archivo1.jpg", "Directorio1\\Directorio3"));
       System.out.println(sistem.mostrarArbol());
       
      arbol.printFileSystem();
       
       
    }
    
}
