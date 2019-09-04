package br.com.poc.oauth2.client.service.authorize;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import br.com.poc.oauth2.client.OAuth2Test;

@Service("googleAuthorizeService")
public class GoogleAuthorizeService implements AuthorizeService {

	private final List<String> SCOPES = Arrays
											.asList("https://www.googleapis.com/auth/userinfo.profile"
												  , "https://www.googleapis.com/auth/userinfo.email");
	
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	@Override
	public String authorize(String email) throws OAuth2Exception{
	
		try {
			
			GoogleClientSecrets clientSecrets;
			clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(OAuth2Test.class.getResourceAsStream("/credentials/client_secrets.json")));
			
			GoogleBrowserClientRequestUrl googleBrowserClientRequestUrl = new GoogleBrowserClientRequestUrl(clientSecrets, clientSecrets.getWeb().getRedirectUris().get(0), SCOPES);
			googleBrowserClientRequestUrl.put("login_hint", email);
			googleBrowserClientRequestUrl.setResponseTypes(Arrays.asList("code"));

			return googleBrowserClientRequestUrl.build();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new OAuth2Exception("Falha ao se autenticar com google ERRO: " + e.getMessage());
		}
				
	}

}
