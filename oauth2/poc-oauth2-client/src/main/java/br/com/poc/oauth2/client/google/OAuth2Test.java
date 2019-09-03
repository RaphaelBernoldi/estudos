package br.com.poc.oauth2.client.google;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Tokeninfo;
import com.google.api.services.oauth2.model.Userinfoplus;

import br.com.poc.oauth2.client.ServerReceiver;

public class OAuth2Test {

	private static final String APPLICATION_NAME = "";

	/** Global instance of the HTTP transport. */
	private static HttpTransport httpTransport;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** OAuth 2.0 scopes. */
	private static final List<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/userinfo.profile",
			"https://www.googleapis.com/auth/userinfo.email");

	private static Oauth2 oauth2;
	private static GoogleClientSecrets clientSecrets;


	private static Credential authorize() throws Exception {
		// load client secrets
		clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
				new InputStreamReader(OAuth2Test.class.getResourceAsStream("/credentials/client_secrets.json")));

		GoogleBrowserClientRequestUrl googleBrowserClientRequestUrl = new GoogleBrowserClientRequestUrl(clientSecrets,
				clientSecrets.getWeb().getRedirectUris().get(0), SCOPES);
		googleBrowserClientRequestUrl.put("login_hint", "evaldonc@gmail.com");
		googleBrowserClientRequestUrl.setResponseTypes(Arrays.asList("code"));
		System.out.println(googleBrowserClientRequestUrl.build());

		httpTransport.createRequestFactory().buildGetRequest(googleBrowserClientRequestUrl);

		System.out.println("Depois");

		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY,
				clientSecrets, SCOPES).build();

		Map<String, String> paramsUrl = new HashMap<String, String>();
		paramsUrl.put("login_hint", "evaldonc@gmail.com");
		AuthorizationCodeInstalledApp authorizationCodeInstalledApp = new AuthorizationCodeInstalledApp(flow,
				new ServerReceiver("localhost", "8080"));

		System.out.println(authorizationCodeInstalledApp);
		System.exit(0);
		return null;
		// authorize
		/*
		 * return new AuthorizationCodeInstalledApp(flow, new
		 * ServerReceiver("localhost", "8080")) .authorize("evaldonc@gmail.com");
		 * //.authorize("raphaelbernoldi@gmail.com");
		 */
	}

	public static void main(String[] args) {
		try {
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();

			// authorization
			Credential credential = authorize();

			// set up global Oauth2 instance
			oauth2 = new Oauth2.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
					.build();

			// run commands
			tokenInfo(credential.getAccessToken());
			userInfo();
			// success!
			return;
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.exit(1);
	}

	private static void tokenInfo(String accessToken) throws IOException {
		header("Validating a token");
		Tokeninfo tokeninfo = oauth2.tokeninfo().setAccessToken(accessToken).execute();
		System.out.println(tokeninfo.toPrettyString());
		if (!tokeninfo.getAudience().equals(clientSecrets.getDetails().getClientId())) {
			System.err.println("ERROR: audience does not match our client ID!");
		}
	}

	private static void userInfo() throws IOException {
		header("Obtaining User Profile Information");
		Userinfoplus userinfo = oauth2.userinfo().get().execute();
		System.out.println(userinfo.toPrettyString());
	}

	static void header(String name) {
		System.out.println();
		System.out.println("================== " + name + " ==================");
		System.out.println();
	}

}
