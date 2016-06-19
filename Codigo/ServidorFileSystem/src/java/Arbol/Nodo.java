
package Arbol;

import java.util.ArrayList;
import modelo.Archivo.ArchivoTexto;

public class Nodo {
    private Nodo padre;
    private ArrayList<Nodo> hijo;
    private Elemento elemento;
    
    public Nodo (Nodo pPadre){
        padre = pPadre;
        hijo = new ArrayList();
    }

    public Nodo getPadre() {
        return padre;
    }

    public ArrayList<Nodo> getHijo() {
        return hijo;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento pElemento) {
        elemento = pElemento;
    }
    
    public void agregarHijoNodo(Nodo pNodo){
        this.hijo.add(pNodo); 
    }
    
    public void agregarHijo(Elemento pElemento){
        Nodo nuevoNodo = new Nodo(this);
        nuevoNodo.setElemento(pElemento);
        this.hijo.add(nuevoNodo); 
    }
    
    public boolean eliminarNodoHijo (String pNombre){
        int indice = buscarHijo(pNombre);
        
        if(indice>=0){
            this.hijo.remove(indice);
            return true;
        }else
            return false;
    }
    
    public boolean esRaiz(){
        if(padre == null){
            return true;
        }
        return false;
        
    }
    
    public boolean tieneHijos(){
        return !this.hijo.isEmpty();
    }
    
    /*
        Si no lo encuentra el nombre entre los hijos devuelve un -1
    */
    public int buscarHijo(String pNombre){
        if(tieneHijos() == false)
            return -1;
               
        for (int contador = 0; contador < this.hijo.size(); contador++){
            if(this.hijo.get(contador).elemento.getNombre().equals(pNombre)){
                return contador;
            }
        }
        return -1;
    }
    
    public int cantidadHijos(){
        return hijo.size();
    }
    
    public String imprimirHijos(){
        String strHijos = "";
        
        for(int contador = 0; contador < cantidadHijos(); contador++){
             strHijos += hijo.get(contador).getElemento().getNombre()+" ";
        }
        
        return strHijos;
    }
    
    public long calcularTamanoElemento(){
      
        if(elemento == null)
            return 0;
        
         return calcularTamanoNodo(this);

    }
    
    private long calcularTamanoNodo(Nodo pNodo){;
        String nombreTipo = obtenerTipoElemento(pNodo);

        if(nombreTipo.equals("ArchivoTexto")){
            ArchivoTexto texto = (ArchivoTexto) pNodo.getElemento();
            return texto.getTamano();
        }
          
        if(nombreTipo.equals("Directorio")){
            long tamano = 1;

            for(int contador = 0; contador < pNodo.cantidadHijos(); contador++ ){
                tamano += calcularTamanoNodo(pNodo.getHijo().get(contador));
            }
            
            return tamano;       
        }
        
        return -1;
    
    }
    
    private String obtenerTipoElemento(Nodo pNodo){
        Class clase = pNodo.getElemento().getClass();
        return clase.getSimpleName();
    }
}
