
package com.webservice.filesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para copiarElemento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="copiarElemento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pRutaDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "copiarElemento", propOrder = {
    "pNombre",
    "pRutaDestino",
    "pCliente"
})
public class CopiarElemento {

    protected String pNombre;
    protected String pRutaDestino;
    protected String pCliente;

    /**
     * Obtiene el valor de la propiedad pNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPNombre() {
        return pNombre;
    }

    /**
     * Define el valor de la propiedad pNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPNombre(String value) {
        this.pNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad pRutaDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRutaDestino() {
        return pRutaDestino;
    }

    /**
     * Define el valor de la propiedad pRutaDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRutaDestino(String value) {
        this.pRutaDestino = value;
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
