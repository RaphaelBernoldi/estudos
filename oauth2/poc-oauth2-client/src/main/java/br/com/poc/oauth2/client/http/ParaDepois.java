package br.com.poc.oauth2.client.http;

import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;

import br.com.poc.oauth2.client.model.GoogleAuthotizationModel;
import br.com.poc.oauth2.client.service.GoogleTokenService;

public class ParaDepois {

	public TokenResponse test(GoogleAuthotizationModel authorization) {
		TokenResponse tokenResponse = new TokenResponse();
		
			/*GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(GoogleTokenService.class.getResourceAsStream("/credentials/client_secrets.json")));
			
			BaseOAuth2ProtectedResourceDetails resource =new BaseOAuth2ProtectedResourceDetails() ;
			resource.setClientId(clientSecrets.getWeb().getClientId());
			resource.setClientSecret(clientSecrets.getWeb().getClientSecret());
			resource.setAccessTokenUri(clientSecrets.getWeb().getRedirectUris().get(0));
			resource.setGrantType("authorization_code");
			
			DefaultOAuth2ClientContext context = new DefaultOAuth2ClientContext();
			OAuth2AccessToken accessToken = new DefaultOAuth2AccessToken(authorization.getCode());
			context.setAccessToken(accessToken);
			
			OAuth2RestTemplate oauth2RestTemplate = new OAuth2RestTemplate(resource, context);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
			HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
			ResponseEntity<Object> exchange = oauth2RestTemplate.exchange(uriTest, HttpMethod.POST , requestEntity, Object.class);
			System.out.println(exchange.getBody());
			
			tokenResponse.setTokenType(accessToken.getTokenType());
			tokenResponse.setAccessToken(accessToken.getValue());
			tokenResponse.setExpiresInSeconds(Integer.valueOf(accessToken.getExpiresIn()).longValue());
			
			*/
			
			
		
		
		return tokenResponse;


	}
}
