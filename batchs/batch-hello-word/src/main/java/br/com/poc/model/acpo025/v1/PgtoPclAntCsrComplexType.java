//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.04 at 10:40:19 AM BRT 
//


package br.com.poc.model.acpo025.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PgtoPclAntCsrComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PgtoPclAntCsrComplexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="DtPgtoPclAntCsr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[0-3][0-9][0-1][0-9][0-2][0-9][0-9][0-9]"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="VlPgtoPclAntCsr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="999999999999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PgtoPclAntCsrComplexType")
public class PgtoPclAntCsrComplexType {

    @XmlAttribute(name = "DtPgtoPclAntCsr")
    protected String dtPgtoPclAntCsr;
    @XmlAttribute(name = "VlPgtoPclAntCsr")
    protected Long vlPgtoPclAntCsr;

    /**
     * Gets the value of the dtPgtoPclAntCsr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtPgtoPclAntCsr() {
        return dtPgtoPclAntCsr;
    }

    /**
     * Sets the value of the dtPgtoPclAntCsr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtPgtoPclAntCsr(String value) {
        this.dtPgtoPclAntCsr = value;
    }

    /**
     * Gets the value of the vlPgtoPclAntCsr property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVlPgtoPclAntCsr() {
        return vlPgtoPclAntCsr;
    }

    /**
     * Sets the value of the vlPgtoPclAntCsr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVlPgtoPclAntCsr(Long value) {
        this.vlPgtoPclAntCsr = value;
    }

}
