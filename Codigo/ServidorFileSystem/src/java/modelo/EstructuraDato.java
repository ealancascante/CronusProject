
package modelo;

import Arbol.Elemento;
import Arbol.Nodo;
import java.util.ArrayList;


public interface EstructuraDato {
    public boolean recorrer(String[] pRuta, String pTipoRuta);
    public boolean agregarNodo(Nodo pNodo);
    public boolean agregarElemento(Elemento pElemento);
    public boolean eliminarElemento(String pNombre);
    public boolean modificarElemento(Elemento pElemento);
    public Elemento obtenerElemento(String pNombre);
    public Nodo obtenerNodoHijo(String pNombre);
    public String mostrarEstructura();
    public long calcularTamanoElemento(String pNombre);
    public ArrayList<Elemento> obtenerElmentosContenidos();
    public String encontrarElemento(String pBusqueda);
    
}
