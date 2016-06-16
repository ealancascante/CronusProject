
package com.webservice.filesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cambiarDirectorio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cambiarDirectorio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pRuta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cambiarDirectorio", propOrder = {
    "pRuta",
    "pCliente"
})
public class CambiarDirectorio {

    protected String pRuta;
    protected String pCliente;

    /**
     * Obtiene el valor de la propiedad pRuta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRuta() {
        return pRuta;
    }

    /**
     * Define el valor de la propiedad pRuta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRuta(String value) {
        this.pRuta = value;
    }

    /**
     * Obtiene el valor de la propiedad pCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCliente() {
        return pCliente;
    }

    /**
     * Define el valor de la propiedad pCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCliente(String value) {
        this.pCliente = value;
    }

}
