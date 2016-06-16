
package com.webservice.filesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para crearDisco complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="crearDisco">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pSectores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pTamano" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearDisco", propOrder = {
    "pSectores",
    "pTamano"
})
public class CrearDisco {

    protected int pSectores;
    protected int pTamano;

    /**
     * Obtiene el valor de la propiedad pSectores.
     * 
     */
    public int getPSectores() {
        return pSectores;
    }

    /**
     * Define el valor de la propiedad pSectores.
     * 
     */
    public void setPSectores(int value) {
        this.pSectores = value;
    }

    /**
     * Obtiene el valor de la propiedad pTamano.
     * 
     */
    public int getPTamano() {
        return pTamano;
    }

    /**
     * Define el valor de la propiedad pTamano.
     * 
     */
    public void setPTamano(int value) {
        this.pTamano = value;
    }

}
