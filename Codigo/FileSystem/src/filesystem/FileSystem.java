
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
       /* Arbol arbol = new Arbol();
        
        arbol.agregarElemento(new Directorio("Elem11"));       
        arbol.agregarElemento(new Directorio("Elem12"));
        arbol.agregarElemento(new ArchivoTexto("Elem13","doc","Adios",45));
        //System.out.println(arbol.getNodoActual());
        
        String newArray1[] = {"Elem11"};
        System.out.println(arbol.recorrer(newArray1));
        //System.out.println("Nodo Actual: "+arbol.getNodoActual());
        
        arbol.agregarElemento(new ArchivoTexto("Elem21","doc","Adios",35));
        arbol.agregarElemento(new ArchivoTexto("Elem22","doc","Adios",30));
        
        
        System.out.println();
        
        String newArray2[] = {"raiz","Elem12"};
        System.out.println(arbol.recorrer(newArray2));
        //System.out.println("Nodo Actual: "+arbol.getNodoActual());
        
        arbol.agregarElemento(new Directorio("Elem23"));
        arbol.agregarElemento(new ArchivoTexto("Elem24","doc","Hola",50));
        
        String newArray3[] = {"Elem23"};
        System.out.println("\n"+arbol.recorrer(newArray3)); 
        
        arbol.agregarElemento(new ArchivoTexto("Elem31","doc","Hola",25));
        
        
        String newArray4[] = {"Elem12","raiz"};
        System.out.println("\n"+arbol.recorrer(newArray4));
        
        System.out.println(arbol.mostrarEstructura());

         
        /*long i = arbol.obtenerNodo("Elem12").calcularTamanoElemento();
        System.out.println(" long "+i);*/
       
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
       
       
       
       
    }
    
}
