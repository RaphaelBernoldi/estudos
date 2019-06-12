//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.04 at 10:40:19 AM BRT 
//


package br.com.poc.model.acpo025.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for FatFchdAntComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FatFchdAntComplexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="PgtoFatFchdAnt" type="{}PgtoFatFchdComplexType"/>
 *       &lt;/choice>
 *       &lt;attribute name="DtVnctFatFchdAnt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[0-3][0-9][0-1][0-9][0-2][0-9][0-9][0-9]"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="VlTtlPgrFatFchdAnt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;minInclusive value="-999999999999999"/>
 *             &lt;maxInclusive value="999999999999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="VlMinPgrFatFchdAnt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="999999999999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CmdoFatFchdAnt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="E"/>
 *             &lt;enumeration value="I"/>
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
@XmlType(name = "FatFchdAntComplexType", propOrder = {
    "pgtoFatFchdAnt"
})
public class FatFchdAntComplexType {

    @XmlElement(name = "PgtoFatFchdAnt")
    protected List<PgtoFatFchdComplexType> pgtoFatFchdAnt;
    @XmlAttribute(name = "DtVnctFatFchdAnt")
    protected String dtVnctFatFchdAnt;
    @XmlAttribute(name = "VlTtlPgrFatFchdAnt")
    protected Long vlTtlPgrFatFchdAnt;
    @XmlAttribute(name = "VlMinPgrFatFchdAnt")
    protected Long vlMinPgrFatFchdAnt;
    @XmlAttribute(name = "CmdoFatFchdAnt")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cmdoFatFchdAnt;

    /**
     * Gets the value of the pgtoFatFchdAnt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pgtoFatFchdAnt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPgtoFatFchdAnt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PgtoFatFchdComplexType }
     * 
     * 
     */
    public List<PgtoFatFchdComplexType> getPgtoFatFchdAnt() {
        if (pgtoFatFchdAnt == null) {
            pgtoFatFchdAnt = new ArrayList<PgtoFatFchdComplexType>();
        }
        return this.pgtoFatFchdAnt;
    }

    /**
     * Gets the value of the dtVnctFatFchdAnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtVnctFatFchdAnt() {
        return dtVnctFatFchdAnt;
    }

    /**
     * Sets the value of the dtVnctFatFchdAnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtVnctFatFchdAnt(String value) {
        this.dtVnctFatFchdAnt = value;
    }

    /**
     * Gets the value of the vlTtlPgrFatFchdAnt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVlTtlPgrFatFchdAnt() {
        return vlTtlPgrFatFchdAnt;
    }

    /**
     * Sets the value of the vlTtlPgrFatFchdAnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVlTtlPgrFatFchdAnt(Long value) {
        this.vlTtlPgrFatFchdAnt = value;
    }

    /**
     * Gets the value of the vlMinPgrFatFchdAnt property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVlMinPgrFatFchdAnt() {
        return vlMinPgrFatFchdAnt;
    }

    /**
     * Sets the value of the vlMinPgrFatFchdAnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVlMinPgrFatFchdAnt(Long value) {
        this.vlMinPgrFatFchdAnt = value;
    }

    /**
     * Gets the value of the cmdoFatFchdAnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmdoFatFchdAnt() {
        return cmdoFatFchdAnt;
    }

    /**
     * Sets the value of the cmdoFatFchdAnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmdoFatFchdAnt(String value) {
        this.cmdoFatFchdAnt = value;
    }

}
