package hust.icse.BioServiceClient;

import hust.icse.bio.service.Bio;
import hust.icse.bio.service.BioServiceImplService;

import javax.swing.JFrame;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public class Main {
	private static String username;
	private static String password;
	private static Bio bio;
	private static JFrame loginWindow;

	public static void main(String[] args) {
		bio = new BioServiceImplService().getBioServiceImplPort();
		setMtomClientEnable();
		loginWindow = new LoginWindow();
		loginWindow.setVisible(true);
	}

	public static void showLoginWindows() {
		if (loginWindow != null) {
			loginWindow.setVisible(true);
		}
	}

	private static void setMtomClientEnable() {
		Binding binding = ((BindingProvider) getBio()).getBinding();
		((SOAPBinding) binding).setMTOMEnabled(true);

		Client cl = ClientProxy.getClient(Main.getBio());

		HTTPConduit http = (HTTPConduit) cl.getConduit();

		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		// one hour timeout
		httpClientPolicy.setConnectionTimeout(1000 * 60 * 60 * 1);
		httpClientPolicy.setReceiveTimeout(1000 * 60 * 60 * 60 * 1);

		http.setClient(httpClientPolicy);

	}

	public static void setUsername(String username) {
		Main.username = username;
	}

	public static void setPassword(String password) {
		Main.password = password;
	}

	public static String getPassword() {
		return password;
	}

	public static String getUsername() {
		return username;
	}

	public static Bio getBio() {
		return bio;
	}
}
