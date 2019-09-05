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

/**
 * @author rbernoldi.mazzatech </br>
 * 
 * 
 * Método destinado a solicitar autorizacao ao usuario para acessar seus recursos privados </br>
 * @param email </br>
 * Para tirar maiores dúvidas referente a parametros ou fluxos, consulte a documentação disponibilizada no link abaixo </br>
 * <a href="https://developers.google.com/identity/protocols/OAuth2WebServer">Documentação</a>
 * 
 */
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
			googleBrowserClientRequestUrl.put("login_hint", email); //email do cliente
			googleBrowserClientRequestUrl.put("prompt", "consent");//Sempre mostra tela de consentimento
			googleBrowserClientRequestUrl.put("access_type", "offline");//Mão atualiza o token quando usuario não estiver presente
			googleBrowserClientRequestUrl.put("state", "valid");//Esse campo serve apenas para validar lá no cllback, se é igual, assim garantindo que não há "intrusos"
			googleBrowserClientRequestUrl.setResponseTypes(Arrays.asList("code"));

			return googleBrowserClientRequestUrl.build();
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new OAuth2Exception("Falha ao se autenticar com google ERRO: " + e.getMessage());
		}
				
	}

}
