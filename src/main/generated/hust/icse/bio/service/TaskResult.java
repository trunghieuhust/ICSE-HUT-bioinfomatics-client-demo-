
package hust.icse.bio.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="durationTime" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="outputConsole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="outputFile" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskResult", propOrder = {
    "durationTime",
    "outputConsole",
    "outputFile"
})
public class TaskResult {

    protected long durationTime;
    protected String outputConsole;
    protected List<String> outputFile;

    /**
     * Gets the value of the durationTime property.
     * 
     */
    public long getDurationTime() {
        return durationTime;
    }

    /**
     * Sets the value of the durationTime property.
     * 
     */
    public void setDurationTime(long value) {
        this.durationTime = value;
    }

    /**
     * Gets the value of the outputConsole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputConsole() {
        return outputConsole;
    }

    /**
     * Sets the value of the outputConsole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputConsole(String value) {
        this.outputConsole = value;
    }

    /**
     * Gets the value of the outputFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOutputFile() {
        if (outputFile == null) {
            outputFile = new ArrayList<String>();
        }
        return this.outputFile;
    }

}
