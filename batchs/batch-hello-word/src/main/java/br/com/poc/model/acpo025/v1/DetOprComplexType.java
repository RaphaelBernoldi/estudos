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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for DetOprComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DetOprComplexType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="InPreFix">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="N"/>
 *             &lt;enumeration value="S"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="DtVnctUltPcl">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[0-3][0-9][0-1][0-9][0-2][0-9][0-9][0-9]"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="VlCtrdFut" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="QtPcl">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NrPlstCrt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="9999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SdoDvdr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;minInclusive value="-999999999999999"/>
 *             &lt;maxInclusive value="999999999999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="DtVnctOpr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[0-3][0-9][0-1][0-9][0-9][0-9][0-9][0-9]"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NrGr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="10"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CdCt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="99999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SeqCt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SitCt">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *             &lt;enumeration value="4"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="VlObgc">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="999999999999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="DtVnctUltPclCsr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[0-3][0-9][0-1][0-9][0-2][0-9][0-9][0-9]"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="QtPclCtCsr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SdoDvdrCtCsr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="999999999999999"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="DtContCtCsr">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="[0-3][0-9][0-1][0-9][0-2][0-9][0-9][0-9]"/>
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
@XmlType(name = "DetOprComplexType")
public class DetOprComplexType {

    @XmlAttribute(name = "InPreFix")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String inPreFix;
    @XmlAttribute(name = "DtVnctUltPcl")
    protected String dtVnctUltPcl;
    @XmlAttribute(name = "VlCtrdFut")
    protected Long vlCtrdFut;
    @XmlAttribute(name = "QtPcl")
    protected Short qtPcl;
    @XmlAttribute(name = "NrPlstCrt")
    protected Short nrPlstCrt;
    @XmlAttribute(name = "SdoDvdr")
    protected Long sdoDvdr;
    @XmlAttribute(name = "DtVnctOpr")
    protected String dtVnctOpr;
    @XmlAttribute(name = "NrGr")
    protected String nrGr;
    @XmlAttribute(name = "CdCt")
    protected Integer cdCt;
    @XmlAttribute(name = "SeqCt")
    protected String seqCt;
    @XmlAttribute(name = "SitCt")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String sitCt;
    @XmlAttribute(name = "VlObgc")
    protected Long vlObgc;
    @XmlAttribute(name = "DtVnctUltPclCsr")
    protected String dtVnctUltPclCsr;
    @XmlAttribute(name = "QtPclCtCsr")
    protected Short qtPclCtCsr;
    @XmlAttribute(name = "SdoDvdrCtCsr")
    protected Long sdoDvdrCtCsr;
    @XmlAttribute(name = "DtContCtCsr")
    protected String dtContCtCsr;

    /**
     * Gets the value of the inPreFix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInPreFix() {
        return inPreFix;
    }

    /**
     * Sets the value of the inPreFix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInPreFix(String value) {
        this.inPreFix = value;
    }

    /**
     * Gets the value of the dtVnctUltPcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtVnctUltPcl() {
        return dtVnctUltPcl;
    }

    /**
     * Sets the value of the dtVnctUltPcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtVnctUltPcl(String value) {
        this.dtVnctUltPcl = value;
    }

    /**
     * Gets the value of the vlCtrdFut property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVlCtrdFut() {
        return vlCtrdFut;
    }

    /**
     * Sets the value of the vlCtrdFut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVlCtrdFut(Long value) {
        this.vlCtrdFut = value;
    }

    /**
     * Gets the value of the qtPcl property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getQtPcl() {
        return qtPcl;
    }

    /**
     * Sets the value of the qtPcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setQtPcl(Short value) {
        this.qtPcl = value;
    }

    /**
     * Gets the value of the nrPlstCrt property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNrPlstCrt() {
        return nrPlstCrt;
    }

    /**
     * Sets the value of the nrPlstCrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNrPlstCrt(Short value) {
        this.nrPlstCrt = value;
    }

    /**
     * Gets the value of the sdoDvdr property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSdoDvdr() {
        return sdoDvdr;
    }

    /**
     * Sets the value of the sdoDvdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSdoDvdr(Long value) {
        this.sdoDvdr = value;
    }

    /**
     * Gets the value of the dtVnctOpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtVnctOpr() {
        return dtVnctOpr;
    }

    /**
     * Sets the value of the dtVnctOpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtVnctOpr(String value) {
        this.dtVnctOpr = value;
    }

    /**
     * Gets the value of the nrGr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrGr() {
        return nrGr;
    }

    /**
     * Sets the value of the nrGr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrGr(String value) {
        this.nrGr = value;
    }

    /**
     * Gets the value of the cdCt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCdCt() {
        return cdCt;
    }

    /**
     * Sets the value of the cdCt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCdCt(Integer value) {
        this.cdCt = value;
    }

    /**
     * Gets the value of the seqCt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqCt() {
        return seqCt;
    }

    /**
     * Sets the value of the seqCt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqCt(String value) {
        this.seqCt = value;
    }

    /**
     * Gets the value of the sitCt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSitCt() {
        return sitCt;
    }

    /**
     * Sets the value of the sitCt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSitCt(String value) {
        this.sitCt = value;
    }

    /**
     * Gets the value of the vlObgc property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVlObgc() {
        return vlObgc;
    }

    /**
     * Sets the value of the vlObgc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVlObgc(Long value) {
        this.vlObgc = value;
    }

    /**
     * Gets the value of the dtVnctUltPclCsr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtVnctUltPclCsr() {
        return dtVnctUltPclCsr;
    }

    /**
     * Sets the value of the dtVnctUltPclCsr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtVnctUltPclCsr(String value) {
        this.dtVnctUltPclCsr = value;
    }

    /**
     * Gets the value of the qtPclCtCsr property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getQtPclCtCsr() {
        return qtPclCtCsr;
    }

    /**
     * Sets the value of the qtPclCtCsr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setQtPclCtCsr(Short value) {
        this.qtPclCtCsr = value;
    }

    /**
     * Gets the value of the sdoDvdrCtCsr property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSdoDvdrCtCsr() {
        return sdoDvdrCtCsr;
    }

    /**
     * Sets the value of the sdoDvdrCtCsr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSdoDvdrCtCsr(Long value) {
        this.sdoDvdrCtCsr = value;
    }

    /**
     * Gets the value of the dtContCtCsr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtContCtCsr() {
        return dtContCtCsr;
    }

    /**
     * Sets the value of the dtContCtCsr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtContCtCsr(String value) {
        this.dtContCtCsr = value;
    }

}
