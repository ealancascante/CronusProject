
package modelo.Archivo;

import Arbol.Elemento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Archivo extends Elemento{
    private Date fechaCreacion;
    private Date fechaModificacion;
    
    public Archivo(String pNombre){       
        super(pNombre);
        fechaCreacion = obtenerFechaActual();
        fechaModificacion = fechaCreacion;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    
    public void setFechaModificacion(Date pFecha){
        fechaModificacion = pFecha;
    }
    
    private Date obtenerFechaActual(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        return date;
    }
}
