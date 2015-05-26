
package hust.icse.bio.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hust.icse.bio.service package. 
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

    private final static QName _Authenticate_QNAME = new QName("http://service.bio.icse.hust/", "authenticate");
    private final static QName _AuthenticateResponse_QNAME = new QName("http://service.bio.icse.hust/", "authenticateResponse");
    private final static QName _CreateWorkflow_QNAME = new QName("http://service.bio.icse.hust/", "createWorkflow");
    private final static QName _CreateWorkflowResponse_QNAME = new QName("http://service.bio.icse.hust/", "createWorkflowResponse");
    private final static QName _GetResult_QNAME = new QName("http://service.bio.icse.hust/", "getResult");
    private final static QName _GetResultResponse_QNAME = new QName("http://service.bio.icse.hust/", "getResultResponse");
    private final static QName _GetStatus_QNAME = new QName("http://service.bio.icse.hust/", "getStatus");
    private final static QName _GetStatusResponse_QNAME = new QName("http://service.bio.icse.hust/", "getStatusResponse");
    private final static QName _UploadData_QNAME = new QName("http://service.bio.icse.hust/", "uploadData");
    private final static QName _UploadDataResponse_QNAME = new QName("http://service.bio.icse.hust/", "uploadDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hust.icse.bio.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Authenticate }
     * 
     */
    public Authenticate createAuthenticate() {
        return new Authenticate();
    }

    /**
     * Create an instance of {@link AuthenticateResponse }
     * 
     */
    public AuthenticateResponse createAuthenticateResponse() {
        return new AuthenticateResponse();
    }

    /**
     * Create an instance of {@link CreateWorkflow }
     * 
     */
    public CreateWorkflow createCreateWorkflow() {
        return new CreateWorkflow();
    }

    /**
     * Create an instance of {@link CreateWorkflowResponse }
     * 
     */
    public CreateWorkflowResponse createCreateWorkflowResponse() {
        return new CreateWorkflowResponse();
    }

    /**
     * Create an instance of {@link GetResult }
     * 
     */
    public GetResult createGetResult() {
        return new GetResult();
    }

    /**
     * Create an instance of {@link GetResultResponse }
     * 
     */
    public GetResultResponse createGetResultResponse() {
        return new GetResultResponse();
    }

    /**
     * Create an instance of {@link GetStatus }
     * 
     */
    public GetStatus createGetStatus() {
        return new GetStatus();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link UploadData }
     * 
     */
    public UploadData createUploadData() {
        return new UploadData();
    }

    /**
     * Create an instance of {@link UploadDataResponse }
     * 
     */
    public UploadDataResponse createUploadDataResponse() {
        return new UploadDataResponse();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link ActivityStatus }
     * 
     */
    public ActivityStatus createActivityStatus() {
        return new ActivityStatus();
    }

    /**
     * Create an instance of {@link TaskStatus }
     * 
     */
    public TaskStatus createTaskStatus() {
        return new TaskStatus();
    }

    /**
     * Create an instance of {@link FileUploader }
     * 
     */
    public FileUploader createFileUploader() {
        return new FileUploader();
    }

    /**
     * Create an instance of {@link TaskResult }
     * 
     */
    public TaskResult createTaskResult() {
        return new TaskResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authenticate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "authenticate")
    public JAXBElement<Authenticate> createAuthenticate(Authenticate value) {
        return new JAXBElement<Authenticate>(_Authenticate_QNAME, Authenticate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "authenticateResponse")
    public JAXBElement<AuthenticateResponse> createAuthenticateResponse(AuthenticateResponse value) {
        return new JAXBElement<AuthenticateResponse>(_AuthenticateResponse_QNAME, AuthenticateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWorkflow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "createWorkflow")
    public JAXBElement<CreateWorkflow> createCreateWorkflow(CreateWorkflow value) {
        return new JAXBElement<CreateWorkflow>(_CreateWorkflow_QNAME, CreateWorkflow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWorkflowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "createWorkflowResponse")
    public JAXBElement<CreateWorkflowResponse> createCreateWorkflowResponse(CreateWorkflowResponse value) {
        return new JAXBElement<CreateWorkflowResponse>(_CreateWorkflowResponse_QNAME, CreateWorkflowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getResult")
    public JAXBElement<GetResult> createGetResult(GetResult value) {
        return new JAXBElement<GetResult>(_GetResult_QNAME, GetResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getResultResponse")
    public JAXBElement<GetResultResponse> createGetResultResponse(GetResultResponse value) {
        return new JAXBElement<GetResultResponse>(_GetResultResponse_QNAME, GetResultResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getStatus")
    public JAXBElement<GetStatus> createGetStatus(GetStatus value) {
        return new JAXBElement<GetStatus>(_GetStatus_QNAME, GetStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getStatusResponse")
    public JAXBElement<GetStatusResponse> createGetStatusResponse(GetStatusResponse value) {
        return new JAXBElement<GetStatusResponse>(_GetStatusResponse_QNAME, GetStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "uploadData")
    public JAXBElement<UploadData> createUploadData(UploadData value) {
        return new JAXBElement<UploadData>(_UploadData_QNAME, UploadData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "uploadDataResponse")
    public JAXBElement<UploadDataResponse> createUploadDataResponse(UploadDataResponse value) {
        return new JAXBElement<UploadDataResponse>(_UploadDataResponse_QNAME, UploadDataResponse.class, null, value);
    }

}
