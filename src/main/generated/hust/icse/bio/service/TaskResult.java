
package hust.icse.bio.service;

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
 *         &lt;element name="outputFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    protected String outputFile;

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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputFile() {
        return outputFile;
    }

    /**
     * Sets the value of the outputFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputFile(String value) {
        this.outputFile = value;
    }

}
