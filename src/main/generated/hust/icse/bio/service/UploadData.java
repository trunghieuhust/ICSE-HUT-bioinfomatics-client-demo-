
package hust.icse.bio.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uploadData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uploadData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="uploadFile" type="{http://service.bio.icse.hust/}fileUploader" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadData", propOrder = {
    "uploadFile"
})
public class UploadData {

    protected FileUploader uploadFile;

    /**
     * Gets the value of the uploadFile property.
     * 
     * @return
     *     possible object is
     *     {@link FileUploader }
     *     
     */
    public FileUploader getUploadFile() {
        return uploadFile;
    }

    /**
     * Sets the value of the uploadFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileUploader }
     *     
     */
    public void setUploadFile(FileUploader value) {
        this.uploadFile = value;
    }

}
