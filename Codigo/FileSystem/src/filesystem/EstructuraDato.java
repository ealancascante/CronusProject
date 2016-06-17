
package filesystem;

import filesystem.arbol.Elemento;


public interface EstructuraDato {
    
    public boolean recorrer(String[] pRuta);
    public boolean agregarElemento(Elemento pElemento);
    public boolean eliminarElemento(String pNombre);
    public boolean modificarElemento(Elemento pElemento);
    public Elemento obtenerElemento(String pNombre);
    public String mostrarEstructura();
    public long calcularTamanoElemento(String pNombre);
    
}
