
package filesystem;

import Utilidades.Dto;
import java.lang.reflect.Constructor;


public class FabricaSistemaArchivo {
    public static SistemaArchivo crearSistemaArchivo(Dto pDatos){
        String nombreClase = (String) pDatos.buscarLlave("nombreClase");
        Class claseEstructura;
        
        try{
            claseEstructura = Class.forName(nombreClase);
            Constructor constructorArchivo = claseEstructura.getConstructors()[0];
            return (SistemaArchivo) claseEstructura.newInstance();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);           
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println(ex);
        }
        
        return null;
        
    }
}
