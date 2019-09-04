package br.com.poc.oauth2.client.service.authorize;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

public interface AuthorizeService {

	String authorize(String email) throws OAuth2Exception;
}
