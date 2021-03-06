package br.com.poc.oauth2.client.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.auth.oauth2.TokenResponse;

import br.com.poc.oauth2.client.model.GoogleAuthotizationModel;
import br.com.poc.oauth2.client.service.GoogleTokenService;


@CrossOrigin
@RestController
@RequestMapping(value = "/callback")
public class CallBackResource {

	@Autowired
	private GoogleTokenService tokenService;
	/**
	 * @RequestParam("client_id") String clientId , @RequestParam("login_hint")
	 * String loginHint ,
	 */
	@GetMapping(value = "/google")
	public void callBackGoogle(@RequestParam("code") String code
							 , @RequestParam("scope") String scope
							 , @RequestParam("authuser") String authuser
							 , @RequestParam("session_state") String sessionState
							 , @RequestParam("prompt") String prompt
							 , @RequestParam("state") String state) {
		
		System.out.println("Iniciando callBack");
		
		GoogleAuthotizationModel authorization = new GoogleAuthotizationModel(code, scope, authuser, sessionState, prompt, state);
		TokenResponse tokenResponse = tokenService.test(authorization);
		
		//http://localhost:8080/callback/google?code=4/qgG5ZYZsY4YMX14RsZM2IrV5vniNfnkZ328uowK96Z3-UdAPhchU60P12w7UnrbG8gRXr4XM7QcvhwIcmzPj5dQ&scope=email+profile+https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile&authuser=0&session_state=9359fa593ea75d6380795c0422fb28721b5f0a22..f0f6&prompt=none
		System.out.println(tokenResponse);
	}
}
