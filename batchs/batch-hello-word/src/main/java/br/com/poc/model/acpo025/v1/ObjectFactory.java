//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.04 at 10:40:19 AM BRT 
//


package br.com.poc.model.acpo025.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnvoHstCrd_QNAME = new QName("", "EnvoHstCrd");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnvoHstCrdComplexType }
     * 
     */
    public EnvoHstCrdComplexType createEnvoHstCrdComplexType() {
        return new EnvoHstCrdComplexType();
    }

    /**
     * Create an instance of {@link PgtoAvlsCsrComplexType }
     * 
     */
    public PgtoAvlsCsrComplexType createPgtoAvlsCsrComplexType() {
        return new PgtoAvlsCsrComplexType();
    }

    /**
     * Create an instance of {@link PclAntCsrComplexType }
     * 
     */
    public PclAntCsrComplexType createPclAntCsrComplexType() {
        return new PclAntCsrComplexType();
    }

    /**
     * Create an instance of {@link DetOprComplexType }
     * 
     */
    public DetOprComplexType createDetOprComplexType() {
        return new DetOprComplexType();
    }

    /**
     * Create an instance of {@link FchtAtuComplexType }
     * 
     */
    public FchtAtuComplexType createFchtAtuComplexType() {
        return new FchtAtuComplexType();
    }

    /**
     * Create an instance of {@link PgtoPclAntComplexType }
     * 
     */
    public PgtoPclAntComplexType createPgtoPclAntComplexType() {
        return new PgtoPclAntComplexType();
    }

    /**
     * Create an instance of {@link CliComplexType }
     * 
     */
    public CliComplexType createCliComplexType() {
        return new CliComplexType();
    }

    /**
     * Create an instance of {@link FatFchdAntComplexType }
     * 
     */
    public FatFchdAntComplexType createFatFchdAntComplexType() {
        return new FatFchdAntComplexType();
    }

    /**
     * Create an instance of {@link OprComplexType }
     * 
     */
    public OprComplexType createOprComplexType() {
        return new OprComplexType();
    }

    /**
     * Create an instance of {@link PclFutCsrComplexType }
     * 
     */
    public PclFutCsrComplexType createPclFutCsrComplexType() {
        return new PclFutCsrComplexType();
    }

    /**
     * Create an instance of {@link PclFutComplexType }
     * 
     */
    public PclFutComplexType createPclFutComplexType() {
        return new PclFutComplexType();
    }

    /**
     * Create an instance of {@link PgtoFatFchdComplexType }
     * 
     */
    public PgtoFatFchdComplexType createPgtoFatFchdComplexType() {
        return new PgtoFatFchdComplexType();
    }

    /**
     * Create an instance of {@link FatFchdFutComplexType }
     * 
     */
    public FatFchdFutComplexType createFatFchdFutComplexType() {
        return new FatFchdFutComplexType();
    }

    /**
     * Create an instance of {@link PgtoAvlsComplexType }
     * 
     */
    public PgtoAvlsComplexType createPgtoAvlsComplexType() {
        return new PgtoAvlsComplexType();
    }

    /**
     * Create an instance of {@link FchtAntComplexType }
     * 
     */
    public FchtAntComplexType createFchtAntComplexType() {
        return new FchtAntComplexType();
    }

    /**
     * Create an instance of {@link PgtoPclAntCsrComplexType }
     * 
     */
    public PgtoPclAntCsrComplexType createPgtoPclAntCsrComplexType() {
        return new PgtoPclAntCsrComplexType();
    }

    /**
     * Create an instance of {@link PclAntComplexType }
     * 
     */
    public PclAntComplexType createPclAntComplexType() {
        return new PclAntComplexType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvoHstCrdComplexType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EnvoHstCrd")
    public JAXBElement<EnvoHstCrdComplexType> createEnvoHstCrd(EnvoHstCrdComplexType value) {
        return new JAXBElement<EnvoHstCrdComplexType>(_EnvoHstCrd_QNAME, EnvoHstCrdComplexType.class, null, value);
    }

}
