
package filesystem;

import Archivo.Directorio;
import Archivo.ArchivoTexto;
import filesystem.arbol.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSystem {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        
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
        
 
    }
    
}
