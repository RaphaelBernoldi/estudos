package br.com.poc.oauth2.client.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import br.com.poc.oauth2.client.http.RestClient;
import br.com.poc.oauth2.client.model.GoogleAuthotizationModel;

@Service
public class GoogleTokenService {

	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private String uriTest = "https://oauth2.googleapis.com/token";

	public TokenResponse test(GoogleAuthotizationModel authorization) {
		TokenResponse tokenResponse = new TokenResponse();
		try {
			GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(GoogleTokenService.class.getResourceAsStream("/credentials/client_secrets.json")));


			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			
			MultiValueMap<String, Object> requestParameters = new LinkedMultiValueMap<String, Object>();
			requestParameters.add("code", authorization.getCode());
			requestParameters.add("client_id", clientSecrets.getWeb().getClientId());
			requestParameters.add("client_secret", clientSecrets.getWeb().getClientSecret());
			requestParameters.add("redirect_uri", clientSecrets.getWeb().getRedirectUris().get(0));
			requestParameters.add("grant_type", "authorization_code");
			
			RestClient<String> rest = new RestClient<String>(String.class);
			String json = rest.post(uriTest, requestParameters, headers).getBody();
			
			ObjectMapper mapper = new ObjectMapper();
			@SuppressWarnings("unchecked")
			Map<String, Object> map = mapper.readValue(json, Map.class);
			tokenResponse = wrapperTokenResponse(map);;

			 return tokenResponse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tokenResponse;
	}
	
	private TokenResponse wrapperTokenResponse(Map<String, Object> map) {
		TokenResponse tokenResponse = new TokenResponse();
		tokenResponse.setAccessToken((String) map.get("access_token"));
		tokenResponse.setExpiresInSeconds(new Long((Integer)map.get("expires_in")));
		tokenResponse.setRefreshToken((String)map.get("refresh_token"));
		tokenResponse.setScope((String)map.get("scope"));
		tokenResponse.setTokenType((String)map.get("token_type"));
		tokenResponse.set("id_token", map.get((String)"id_token"));
		return tokenResponse;
	}
}
