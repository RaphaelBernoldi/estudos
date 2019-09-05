package br.com.poc.oauth2.client.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * 
 * @author rbernoldi.mazzatech
 *
 * @param <T>
 * 
 */
public class RestClient<T> {
	
	  private RestTemplate rest;
	  private Class<T>clazz;


	  public RestClient(Class<T>clazz) {
	    this.rest = new RestTemplate();
	    this.clazz = clazz;
	  }

	  public ResponseEntity<T> get(String uri, HttpHeaders headers, Object... uriVariables) {
		  
	    HttpEntity<T> requestEntity = new HttpEntity<T>(headers);
	    ResponseEntity<T> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, clazz, uriVariables);
	    return responseEntity;
	    
	  }

	  public ResponseEntity<T> post(String uri, MultiValueMap<String, Object> map, HttpHeaders headers) {   
	    HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
	    return rest.postForEntity( uri, request , clazz);
	  }
	  
	  public ResponseEntity<T> post(String uri, HttpHeaders headers, Object... uriVariables) {   
		    HttpEntity<T>requestEntity = new HttpEntity<T>(headers);
		    return rest.exchange(uri, HttpMethod.POST, requestEntity, clazz, uriVariables);
		  }


	  public ResponseEntity<T> put(String uri, T body, HttpHeaders headers) {
	    HttpEntity<T> requestEntity = new HttpEntity<T>(body, headers);
	    return  rest.exchange(uri, HttpMethod.PUT, requestEntity, clazz);

	  }

	  public ResponseEntity<T> delete(String uri, HttpHeaders headers) {
	    HttpEntity<T> requestEntity = new HttpEntity<T>(headers);
	    return rest.exchange(uri, HttpMethod.DELETE, requestEntity, clazz);

	  }

	 
}
