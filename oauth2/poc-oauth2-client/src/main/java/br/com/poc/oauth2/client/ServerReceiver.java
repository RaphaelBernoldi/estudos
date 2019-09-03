package br.com.poc.oauth2.client;

import java.io.IOException;

import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;

public class ServerReceiver implements VerificationCodeReceiver {

	private String host;
	private String port;
	
	public ServerReceiver(String host, String port) {
		this.host = host;
		this.port = port;
	}


	@Override
	public String getRedirectUri() throws IOException {
		
	 	    return "http://" + host + ":" + port ;
	}

	@Override
	public String waitForCode() throws IOException {
		return "code";
	}

	@Override
	public void stop() throws IOException {
		// TODO Auto-generated method stub

	}

}
