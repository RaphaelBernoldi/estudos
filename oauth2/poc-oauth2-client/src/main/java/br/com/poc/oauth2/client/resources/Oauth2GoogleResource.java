package br.com.poc.oauth2.client.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.poc.oauth2.client.service.authorize.AuthorizeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/oauth2/google")
public class Oauth2GoogleResource {
	
	@Autowired
	@Qualifier("googleAuthorizeService")
	private AuthorizeService authorizeService;
	
	
	@GetMapping(value = "/authorize/{email}")
	public RedirectView authorize(@PathVariable String email) {
		return new RedirectView(authorizeService.authorize(email));
	}
}
