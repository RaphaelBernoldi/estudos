//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.04 at 10:33:42 AM BRT 
//


package br.com.poc.model.acpo021.v1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for EndCliComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndCliComplexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="LgrEndCli" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NrEndCli">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CmptEndCli">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="BaiEndCli">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CepEndCli" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="00001000"/>
 *             &lt;maxInclusive value="99999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="MunEndCli" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="UfEndCli" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="AC"/>
 *             &lt;enumeration value="AL"/>
 *             &lt;enumeration value="AM"/>
 *             &lt;enumeration value="AP"/>
 *             &lt;enumeration value="BA"/>
 *             &lt;enumeration value="CE"/>
 *             &lt;enumeration value="DF"/>
 *             &lt;enumeration value="ES"/>
 *             &lt;enumeration value="GO"/>
 *             &lt;enumeration value="MA"/>
 *             &lt;enumeration value="MT"/>
 *             &lt;enumeration value="MS"/>
 *             &lt;enumeration value="MG"/>
 *             &lt;enumeration value="PA"/>
 *             &lt;enumeration value="PB"/>
 *             &lt;enumeration value="PR"/>
 *             &lt;enumeration value="PE"/>
 *             &lt;enumeration value="PI"/>
 *             &lt;enumeration value="RJ"/>
 *             &lt;enumeration value="RN"/>
 *             &lt;enumeration value="RS"/>
 *             &lt;enumeration value="RO"/>
 *             &lt;enumeration value="RR"/>
 *             &lt;enumeration value="SC"/>
 *             &lt;enumeration value="SP"/>
 *             &lt;enumeration value="SE"/>
 *             &lt;enumeration value="TO"/>
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
@XmlType(name = "EndCliComplexType")
public class EndCliComplexType {

    @XmlAttribute(name = "LgrEndCli", required = true)
    protected String lgrEndCli;
    @XmlAttribute(name = "NrEndCli")
    protected BigInteger nrEndCli;
    @XmlAttribute(name = "CmptEndCli")
    protected String cmptEndCli;
    @XmlAttribute(name = "BaiEndCli")
    protected String baiEndCli;
    @XmlAttribute(name = "CepEndCli", required = true)
    protected int cepEndCli;
    @XmlAttribute(name = "MunEndCli", required = true)
    protected String munEndCli;
    @XmlAttribute(name = "UfEndCli", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ufEndCli;

    /**
     * Gets the value of the lgrEndCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLgrEndCli() {
        return lgrEndCli;
    }

    /**
     * Sets the value of the lgrEndCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLgrEndCli(String value) {
        this.lgrEndCli = value;
    }

    /**
     * Gets the value of the nrEndCli property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNrEndCli() {
        return nrEndCli;
    }

    /**
     * Sets the value of the nrEndCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNrEndCli(BigInteger value) {
        this.nrEndCli = value;
    }

    /**
     * Gets the value of the cmptEndCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmptEndCli() {
        return cmptEndCli;
    }

    /**
     * Sets the value of the cmptEndCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmptEndCli(String value) {
        this.cmptEndCli = value;
    }

    /**
     * Gets the value of the baiEndCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaiEndCli() {
        return baiEndCli;
    }

    /**
     * Sets the value of the baiEndCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaiEndCli(String value) {
        this.baiEndCli = value;
    }

    /**
     * Gets the value of the cepEndCli property.
     * 
     */
    public int getCepEndCli() {
        return cepEndCli;
    }

    /**
     * Sets the value of the cepEndCli property.
     * 
     */
    public void setCepEndCli(int value) {
        this.cepEndCli = value;
    }

    /**
     * Gets the value of the munEndCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunEndCli() {
        return munEndCli;
    }

    /**
     * Sets the value of the munEndCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunEndCli(String value) {
        this.munEndCli = value;
    }

    /**
     * Gets the value of the ufEndCli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUfEndCli() {
        return ufEndCli;
    }

    /**
     * Sets the value of the ufEndCli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUfEndCli(String value) {
        this.ufEndCli = value;
    }

}
