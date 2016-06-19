
package modelo;

public class FileSystem {
    
    public static void main(String[] args) {
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
       
       
    }
    
}

