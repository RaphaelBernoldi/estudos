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
 * <p>Java class for CliComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CliComplexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Opr" type="{}OprComplexType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TipCli" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="IdfcCli" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="99999999999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NmCli">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NtzRlc">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *             &lt;enumeration value="4"/>
 *             &lt;enumeration value="5"/>
 *             &lt;enumeration value="9"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CmdoCli">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="A"/>
 *             &lt;enumeration value="E"/>
 *             &lt;enumeration value="I"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CdOcr" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="99999"/>
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
@XmlType(name = "CliComplexType", propOrder = {
    "opr"
})
public class CliComplexType {

    @XmlElement(name = "Opr")
    protected List<OprComplexType> opr;
    @XmlAttribute(name = "TipCli", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipCli;
    @XmlAttribute(name = "IdfcCli", required = true)
    protected long idfcCli;
    @XmlAttribute(name = "NmCli")
    protected String nmCli;
    @XmlAttribute(name = "NtzRlc")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ntzRlc;
    @XmlAttribute(name = "CmdoCli")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cmdoCli;
    @XmlAttribute(name = "CdOcr", required = true)
    protected int cdOcr;

    /**
     * Gets the value of the opr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OprComplexType }
     * 
     * 
     */
    public List<OprComplexType> getOpr() {
        if (opr == null) {
            opr = new ArrayList<OprComplexType>();
        }
        return this.opr;
    }

    /**
     * Gets the value of the tipCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipCli() {
        return tipCli;
    }

    /**
     * Sets the value of the tipCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipCli(String value) {
        this.tipCli = value;
    }

    /**
     * Gets the value of the idfcCli property.
     * 
     */
    public long getIdfcCli() {
        return idfcCli;
    }

    /**
     * Sets the value of the idfcCli property.
     * 
     */
    public void setIdfcCli(long value) {
        this.idfcCli = value;
    }

    /**
     * Gets the value of the nmCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNmCli() {
        return nmCli;
    }

    /**
     * Sets the value of the nmCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNmCli(String value) {
        this.nmCli = value;
    }

    /**
     * Gets the value of the ntzRlc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtzRlc() {
        return ntzRlc;
    }

    /**
     * Sets the value of the ntzRlc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtzRlc(String value) {
        this.ntzRlc = value;
    }

    /**
     * Gets the value of the cmdoCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmdoCli() {
        return cmdoCli;
    }

    /**
     * Sets the value of the cmdoCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmdoCli(String value) {
        this.cmdoCli = value;
    }

    /**
     * Gets the value of the cdOcr property.
     * 
     */
    public int getCdOcr() {
        return cdOcr;
    }

    /**
     * Sets the value of the cdOcr property.
     * 
     */
    public void setCdOcr(int value) {
        this.cdOcr = value;
    }

}
