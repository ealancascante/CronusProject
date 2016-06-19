
package modelo;

import java.lang.reflect.Constructor;
import modelo.utilidades.Dto;


public class FabricaAlmacenamiento {
      public static Almacenamiento crearAlmaceamiento(Dto pDatos){
        String nombreClase = (String) pDatos.buscarLlave("nombreClase");
        Class claseEstructura;
        
        try{
            claseEstructura = Class.forName(nombreClase);
            Constructor constructorArchivo = claseEstructura.getConstructors()[0];
            return (Almacenamiento) claseEstructura.newInstance();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);           
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println(ex);
        }
        
        return null;
        
    }
}
