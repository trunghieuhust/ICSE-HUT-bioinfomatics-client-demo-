
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
    private final static QName _CreateWorkflowFromTemplate_QNAME = new QName("http://service.bio.icse.hust/", "createWorkflowFromTemplate");
    private final static QName _CreateWorkflowFromTemplateResponse_QNAME = new QName("http://service.bio.icse.hust/", "createWorkflowFromTemplateResponse");
    private final static QName _CreateWorkflowResponse_QNAME = new QName("http://service.bio.icse.hust/", "createWorkflowResponse");
    private final static QName _DeleteContainer_QNAME = new QName("http://service.bio.icse.hust/", "deleteContainer");
    private final static QName _DeleteContainerResponse_QNAME = new QName("http://service.bio.icse.hust/", "deleteContainerResponse");
    private final static QName _DeleteFile_QNAME = new QName("http://service.bio.icse.hust/", "deleteFile");
    private final static QName _DeleteFileResponse_QNAME = new QName("http://service.bio.icse.hust/", "deleteFileResponse");
    private final static QName _GetAllContainer_QNAME = new QName("http://service.bio.icse.hust/", "getAllContainer");
    private final static QName _GetAllContainerResponse_QNAME = new QName("http://service.bio.icse.hust/", "getAllContainerResponse");
    private final static QName _GetAllFileInContainer_QNAME = new QName("http://service.bio.icse.hust/", "getAllFileInContainer");
    private final static QName _GetAllFileInContainerResponse_QNAME = new QName("http://service.bio.icse.hust/", "getAllFileInContainerResponse");
    private final static QName _GetLinkFile_QNAME = new QName("http://service.bio.icse.hust/", "getLinkFile");
    private final static QName _GetLinkFileResponse_QNAME = new QName("http://service.bio.icse.hust/", "getLinkFileResponse");
    private final static QName _GetResult_QNAME = new QName("http://service.bio.icse.hust/", "getResult");
    private final static QName _GetResultResponse_QNAME = new QName("http://service.bio.icse.hust/", "getResultResponse");
    private final static QName _GetStatus_QNAME = new QName("http://service.bio.icse.hust/", "getStatus");
    private final static QName _GetStatusResponse_QNAME = new QName("http://service.bio.icse.hust/", "getStatusResponse");
    private final static QName _SignUp_QNAME = new QName("http://service.bio.icse.hust/", "signUp");
    private final static QName _SignUpResponse_QNAME = new QName("http://service.bio.icse.hust/", "signUpResponse");
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
     * Create an instance of {@link CreateWorkflowFromTemplate }
     * 
     */
    public CreateWorkflowFromTemplate createCreateWorkflowFromTemplate() {
        return new CreateWorkflowFromTemplate();
    }

    /**
     * Create an instance of {@link CreateWorkflowFromTemplateResponse }
     * 
     */
    public CreateWorkflowFromTemplateResponse createCreateWorkflowFromTemplateResponse() {
        return new CreateWorkflowFromTemplateResponse();
    }

    /**
     * Create an instance of {@link CreateWorkflowResponse }
     * 
     */
    public CreateWorkflowResponse createCreateWorkflowResponse() {
        return new CreateWorkflowResponse();
    }

    /**
     * Create an instance of {@link DeleteContainer }
     * 
     */
    public DeleteContainer createDeleteContainer() {
        return new DeleteContainer();
    }

    /**
     * Create an instance of {@link DeleteContainerResponse }
     * 
     */
    public DeleteContainerResponse createDeleteContainerResponse() {
        return new DeleteContainerResponse();
    }

    /**
     * Create an instance of {@link DeleteFile }
     * 
     */
    public DeleteFile createDeleteFile() {
        return new DeleteFile();
    }

    /**
     * Create an instance of {@link DeleteFileResponse }
     * 
     */
    public DeleteFileResponse createDeleteFileResponse() {
        return new DeleteFileResponse();
    }

    /**
     * Create an instance of {@link GetAllContainer }
     * 
     */
    public GetAllContainer createGetAllContainer() {
        return new GetAllContainer();
    }

    /**
     * Create an instance of {@link GetAllContainerResponse }
     * 
     */
    public GetAllContainerResponse createGetAllContainerResponse() {
        return new GetAllContainerResponse();
    }

    /**
     * Create an instance of {@link GetAllFileInContainer }
     * 
     */
    public GetAllFileInContainer createGetAllFileInContainer() {
        return new GetAllFileInContainer();
    }

    /**
     * Create an instance of {@link GetAllFileInContainerResponse }
     * 
     */
    public GetAllFileInContainerResponse createGetAllFileInContainerResponse() {
        return new GetAllFileInContainerResponse();
    }

    /**
     * Create an instance of {@link GetLinkFile }
     * 
     */
    public GetLinkFile createGetLinkFile() {
        return new GetLinkFile();
    }

    /**
     * Create an instance of {@link GetLinkFileResponse }
     * 
     */
    public GetLinkFileResponse createGetLinkFileResponse() {
        return new GetLinkFileResponse();
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
     * Create an instance of {@link SignUp }
     * 
     */
    public SignUp createSignUp() {
        return new SignUp();
    }

    /**
     * Create an instance of {@link SignUpResponse }
     * 
     */
    public SignUpResponse createSignUpResponse() {
        return new SignUpResponse();
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
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link Container }
     * 
     */
    public Container createContainer() {
        return new Container();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWorkflowFromTemplate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "createWorkflowFromTemplate")
    public JAXBElement<CreateWorkflowFromTemplate> createCreateWorkflowFromTemplate(CreateWorkflowFromTemplate value) {
        return new JAXBElement<CreateWorkflowFromTemplate>(_CreateWorkflowFromTemplate_QNAME, CreateWorkflowFromTemplate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateWorkflowFromTemplateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "createWorkflowFromTemplateResponse")
    public JAXBElement<CreateWorkflowFromTemplateResponse> createCreateWorkflowFromTemplateResponse(CreateWorkflowFromTemplateResponse value) {
        return new JAXBElement<CreateWorkflowFromTemplateResponse>(_CreateWorkflowFromTemplateResponse_QNAME, CreateWorkflowFromTemplateResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "deleteContainer")
    public JAXBElement<DeleteContainer> createDeleteContainer(DeleteContainer value) {
        return new JAXBElement<DeleteContainer>(_DeleteContainer_QNAME, DeleteContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "deleteContainerResponse")
    public JAXBElement<DeleteContainerResponse> createDeleteContainerResponse(DeleteContainerResponse value) {
        return new JAXBElement<DeleteContainerResponse>(_DeleteContainerResponse_QNAME, DeleteContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "deleteFile")
    public JAXBElement<DeleteFile> createDeleteFile(DeleteFile value) {
        return new JAXBElement<DeleteFile>(_DeleteFile_QNAME, DeleteFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "deleteFileResponse")
    public JAXBElement<DeleteFileResponse> createDeleteFileResponse(DeleteFileResponse value) {
        return new JAXBElement<DeleteFileResponse>(_DeleteFileResponse_QNAME, DeleteFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getAllContainer")
    public JAXBElement<GetAllContainer> createGetAllContainer(GetAllContainer value) {
        return new JAXBElement<GetAllContainer>(_GetAllContainer_QNAME, GetAllContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getAllContainerResponse")
    public JAXBElement<GetAllContainerResponse> createGetAllContainerResponse(GetAllContainerResponse value) {
        return new JAXBElement<GetAllContainerResponse>(_GetAllContainerResponse_QNAME, GetAllContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFileInContainer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getAllFileInContainer")
    public JAXBElement<GetAllFileInContainer> createGetAllFileInContainer(GetAllFileInContainer value) {
        return new JAXBElement<GetAllFileInContainer>(_GetAllFileInContainer_QNAME, GetAllFileInContainer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllFileInContainerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getAllFileInContainerResponse")
    public JAXBElement<GetAllFileInContainerResponse> createGetAllFileInContainerResponse(GetAllFileInContainerResponse value) {
        return new JAXBElement<GetAllFileInContainerResponse>(_GetAllFileInContainerResponse_QNAME, GetAllFileInContainerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLinkFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getLinkFile")
    public JAXBElement<GetLinkFile> createGetLinkFile(GetLinkFile value) {
        return new JAXBElement<GetLinkFile>(_GetLinkFile_QNAME, GetLinkFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLinkFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "getLinkFileResponse")
    public JAXBElement<GetLinkFileResponse> createGetLinkFileResponse(GetLinkFileResponse value) {
        return new JAXBElement<GetLinkFileResponse>(_GetLinkFileResponse_QNAME, GetLinkFileResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "signUp")
    public JAXBElement<SignUp> createSignUp(SignUp value) {
        return new JAXBElement<SignUp>(_SignUp_QNAME, SignUp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bio.icse.hust/", name = "signUpResponse")
    public JAXBElement<SignUpResponse> createSignUpResponse(SignUpResponse value) {
        return new JAXBElement<SignUpResponse>(_SignUpResponse_QNAME, SignUpResponse.class, null, value);
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
