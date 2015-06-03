package hust.icse.bio.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-06-03T20:46:33.152+07:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://service.bio.icse.hust/", name = "bio")
@XmlSeeAlso({ObjectFactory.class})
public interface Bio {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getStatus", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetStatus")
    @WebMethod
    @ResponseWrapper(localName = "getStatusResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetStatusResponse")
    public hust.icse.bio.service.Status getStatus(
        @WebParam(name = "ID", targetNamespace = "")
        java.lang.String id
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "uploadData", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.UploadData")
    @WebMethod
    @ResponseWrapper(localName = "uploadDataResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.UploadDataResponse")
    public long uploadData(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "uploadFile", targetNamespace = "")
        hust.icse.bio.service.FileUploader uploadFile
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAllFileInContainer", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetAllFileInContainer")
    @WebMethod
    @ResponseWrapper(localName = "getAllFileInContainerResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetAllFileInContainerResponse")
    public java.util.List<hust.icse.bio.service.File> getAllFileInContainer(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "containerName", targetNamespace = "")
        java.lang.String containerName
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createWorkflowFromTemplate", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.CreateWorkflowFromTemplate")
    @WebMethod
    @ResponseWrapper(localName = "createWorkflowFromTemplateResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.CreateWorkflowFromTemplateResponse")
    public java.lang.String createWorkflowFromTemplate(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "workflowName", targetNamespace = "")
        java.lang.String workflowName,
        @WebParam(name = "inputValue", targetNamespace = "")
        java.util.List<java.lang.String> inputValue
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.Authenticate")
    @WebMethod
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.AuthenticateResponse")
    public boolean authenticate(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAllContainer", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetAllContainer")
    @WebMethod
    @ResponseWrapper(localName = "getAllContainerResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetAllContainerResponse")
    public java.util.List<hust.icse.bio.service.Container> getAllContainer(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteContainer", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.DeleteContainer")
    @WebMethod
    @ResponseWrapper(localName = "deleteContainerResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.DeleteContainerResponse")
    public boolean deleteContainer(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "containerName", targetNamespace = "")
        java.lang.String containerName
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getLinkFile", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetLinkFile")
    @WebMethod
    @ResponseWrapper(localName = "getLinkFileResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetLinkFileResponse")
    public java.lang.String getLinkFile(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "containerName", targetNamespace = "")
        java.lang.String containerName,
        @WebParam(name = "filename", targetNamespace = "")
        java.lang.String filename
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "signUp", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.SignUp")
    @WebMethod
    @ResponseWrapper(localName = "signUpResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.SignUpResponse")
    public boolean signUp(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteFile", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.DeleteFile")
    @WebMethod
    @ResponseWrapper(localName = "deleteFileResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.DeleteFileResponse")
    public boolean deleteFile(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "containerName", targetNamespace = "")
        java.lang.String containerName,
        @WebParam(name = "filename", targetNamespace = "")
        java.lang.String filename
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getResult", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetResult")
    @WebMethod
    @ResponseWrapper(localName = "getResultResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.GetResultResponse")
    public hust.icse.bio.service.TaskResult getResult(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "ID", targetNamespace = "")
        java.lang.String id
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createWorkflow", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.CreateWorkflow")
    @WebMethod
    @ResponseWrapper(localName = "createWorkflowResponse", targetNamespace = "http://service.bio.icse.hust/", className = "hust.icse.bio.service.CreateWorkflowResponse")
    public java.lang.String createWorkflow(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "workflow", targetNamespace = "")
        java.lang.String workflow
    );
}
