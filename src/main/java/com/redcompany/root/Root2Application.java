package com.redcompany.root;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Root2Application {//extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		TrustManager[] trustAllCerts = new TrustManager[]{
				new X509TrustManager() {
				    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				        return null;
				    }
				    public void checkClientTrusted(
				        java.security.cert.X509Certificate[] certs, String authType) {
				    }
				    public void checkServerTrusted(
				        java.security.cert.X509Certificate[] certs, String authType) {
				    }
				}
		};

	    try {
	    	SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	    } catch (Exception e) { }
		 	
	    System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");
	    
		SpringApplication.run(Root2Application.class, args);
	}

}
