
package hust.icse.bio.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for file complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="file"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bytes" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="fileURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "file", propOrder = {
    "bytes",
    "fileURL",
    "name"
})
public class File {

    protected long bytes;
    protected String fileURL;
    protected String name;

    /**
     * Gets the value of the bytes property.
     * 
     */
    public long getBytes() {
        return bytes;
    }

    /**
     * Sets the value of the bytes property.
     * 
     */
    public void setBytes(long value) {
        this.bytes = value;
    }

    /**
     * Gets the value of the fileURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileURL() {
        return fileURL;
    }

    /**
     * Sets the value of the fileURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileURL(String value) {
        this.fileURL = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
