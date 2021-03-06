
package modelo;

import Controlador.InterfaceControlador;
import Controlador.Controlador;

public class FileSystem {
    
    public static void main(String[] args) {
       /*
       Almacenamiento disco = new DiscoVirtual();
       disco.inicializarDisco(10, 10);
       System.out.println( disco.agregarArchivoTexto("Archivo.txt", "Hola arhivo") );
       System.out.println( disco.agregarDirectorio("Directorio1") );
       System.out.println( disco.agregarDirectorio("Directorio2") );

       System.out.println( disco.listarElementos() );
       System.out.println( disco.verPropiedadesElemento("Archivo.txt") );
       System.out.println( disco.navegar("Directorio1\\..\\Directorio2") );
       System.out.println( disco.navegar("..") );
       System.out.println( "Arbol : " + disco.mostrarArbol() );
       System.out.println( disco.borrarElemento("Archivo.txt") );
       System.out.println( disco.mostrarArbol() );
       System.out.println( disco.agregarArchivoTexto("Archivo2.txt", "Hola arhivo 2.0") );
       System.out.println( disco.mostrarArbol() );
       System.out.println( disco.copiarElemento("Archivo2.txt", "Directorio2") );
       //System.out.println( disco.moverElemnto("Archivo2.txt", "Directorio2") );
       System.out.println( disco.mostrarArbol() );
       System.out.println( disco.navegar(".") );
       System.out.println( disco.modificarContenidoArchivoTexto("Archivo2.txt", "Nuevo Contenido") );
       System.out.println( disco.mostrarContenidoArchivoTexto("Archivo2.txt") );
       System.out.println( disco.buscarArchivo("Archivo2.txt"));
       */
       
      /*
        InterfaceControlador controlador = new Controlador();
       String pCliente = controlador.crearDisco(10, 10);
       System.out.println( pCliente );
       System.out.println( controlador.crearArchivo("Arch1.txt", "Este es el Arch1", pCliente));
       System.out.println( controlador.obtenerRuta(pCliente) );
       System.out.println( controlador.crearArchivo("Arch2.txt", "Este es el Arch2", pCliente));
       System.out.println( controlador.crearDirectorio("Dir1", pCliente) );
       System.out.println( controlador.generarArbol(pCliente));
       System.out.println( controlador.modificarArchivo("Arch1.txt", "Este es el nuevo Contenido", pCliente));
       System.out.println( controlador.contenidoArchivo("Arch1.txt", pCliente) );
       System.out.println( controlador.listarDirectorio(pCliente));
       System.out.println( controlador.removerElemento("Arch2.txt", pCliente));
       System.out.println( controlador.cambiarDirectorio("Dir1", pCliente) );
       System.out.println( controlador.obtenerRuta(pCliente) );
       System.out.println( controlador.cambiarDirectorio("..", pCliente) );
       System.out.println( controlador.obtenerRuta(pCliente) );
       System.out.println( controlador.copiarElemento("Arch1.txt", "Dir1", pCliente) );
       System.out.println( controlador.generarArbol(pCliente) );
       
        System.out.println( controlador.obtenerRuta(pCliente) );
       System.out.println( controlador.cambiarDirectorio("..", pCliente) );
       System.out.println( controlador.crearDirectorio("Dir2", pCliente) );
       System.out.println( controlador.cambiarDirectorio("Dir2", pCliente) );
       System.out.println( controlador.crearArchivo("Arch3.txt", "Este es el Arch2", pCliente));
       System.out.println( controlador.verPropiedades("Arch3.txt", pCliente));
             
      
        System.out.println( controlador.generarArbol(pCliente) );
        System.out.println( controlador.cambiarDirectorio("..", pCliente) );
        
        System.out.println( controlador.moverElemento("Dir2", "Dir1", pCliente));
        System.out.println( controlador.generarArbol(pCliente) );
        
        System.out.println( controlador.cambiarDirectorio("Dir2", pCliente) );
        System.out.println( controlador.obtenerRuta(pCliente) );
        System.out.println( controlador.listarDirectorio(pCliente) );
        
        System.out.println(controlador.encontrarElemento("Arch1.txt", pCliente));
        
        System.out.println(controlador.modificarArchivo(pCliente, pCliente, pCliente));
        
        System.out.println( controlador.cambiarDirectorio("..\\..\\Arch1.txt", pCliente) );
        System.out.println( controlador.verPropiedades("Dir1", pCliente));
    */
        
      /*Almacenamiento disco = new DiscoVirtual();
       disco.inicializarDisco(10, 10);
       disco.agregarArchivoTexto("a.txt", "Hola");
       disco.agregarDirectorio("Dir1");
       disco.navegar("Dir1");
       disco.agregarDirectorio("Dir2");
       disco.agregarDirectorio("Dir3");
       disco.navegar("Dir3");
       disco.agregarArchivoTexto("arh.txt", "Hola");
       System.out.println( disco.mostrarArbol());
       
       System.out.println( disco.borrarElemento("arh.txt"));
       System.out.println( disco.obtenerRutaActual());
       System.out.println( disco.listarElementos());
    */
      /*
      Almacenamiento disco = new DiscoVirtual();
       disco.inicializarDisco(1, 100);
      System.out.println( disco.agregarArchivoTexto("aloa.txt", "Hola cmom esta"));
       System.out.println( disco.borrarElemento("a.txt"));
       */
       InterfaceControlador controlador = new Controlador();
       String pCliente = controlador.crearDisco(1, 100);
       System.out.println( controlador.crearArchivo("arch1.doc", "dasda", pCliente));
       System.out.println( controlador.generarArbol(pCliente));
    /*   
        String cliente2 = controlador.crearDisco(10, 10);
        System.out.println( controlador.crearArchivo("arch2.doc", "dasda", cliente2));
        System.out.println( controlador.generarArbol(cliente2));*/
    }
    
}

