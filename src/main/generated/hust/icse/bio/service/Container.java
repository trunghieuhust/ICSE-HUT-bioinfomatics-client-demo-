
package hust.icse.bio.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for container complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="container"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="byteUsed" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="fileList" type="{http://service.bio.icse.hust/}file" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="objectCount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container", propOrder = {
    "byteUsed",
    "fileList",
    "name",
    "objectCount"
})
public class Container {

    protected long byteUsed;
    @XmlElement(nillable = true)
    protected List<File> fileList;
    protected String name;
    protected long objectCount;

    /**
     * Gets the value of the byteUsed property.
     * 
     */
    public long getByteUsed() {
        return byteUsed;
    }

    /**
     * Sets the value of the byteUsed property.
     * 
     */
    public void setByteUsed(long value) {
        this.byteUsed = value;
    }

    /**
     * Gets the value of the fileList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link File }
     * 
     * 
     */
    public List<File> getFileList() {
        if (fileList == null) {
            fileList = new ArrayList<File>();
        }
        return this.fileList;
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

    /**
     * Gets the value of the objectCount property.
     * 
     */
    public long getObjectCount() {
        return objectCount;
    }

    /**
     * Sets the value of the objectCount property.
     * 
     */
    public void setObjectCount(long value) {
        this.objectCount = value;
    }

}
