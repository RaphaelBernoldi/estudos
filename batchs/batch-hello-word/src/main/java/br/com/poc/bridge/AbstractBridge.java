package br.com.poc.bridge;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


/**
 * 
 * @author rbernoldi
 * Classe a realizar requisicoes para qualquer aplicacao (abstracao da bridge).
 */
public abstract class AbstractBridge {
	

	/**
	 * Metodo indicado a ser utilizado quando a requisição for get e </br>
	 * o retorno é uma colecao </br>
	 * 
	 * @param url
	 * @param parameter
	 * @return
	 */
	 public <T> T get(String url, ParameterizedTypeReference<T> parameter, Boolean isHttps){
		 return restTemplate(isHttps)
				 		.exchange(url,
				 				HttpMethod.GET, 
				 				  null,
				 				 parameter)
				 		.getBody();
	 }
	 
	 /**
	  * Metodo indicado a utilizar quando quiser realizar um get e o retorno </br>
	  * for uma entidade sozinha, um objeto unico.
	  * 
	  * @param url
	  * @param clazz
	  * @return
	  */
	 @SuppressWarnings("all")
	 public <T> T get(String url, Class<T> clazz, Boolean isHttps) {
		 return restTemplate(isHttps)
				 		.exchange(url, 
				 				  HttpMethod.GET, 
				 				  null, 
				 				  clazz, 
				 				  clazz.getDeclaredFields())
				 		.getBody();
	 }
	 
	 public <T> T post(String url, T body, Class<T> responseType, Boolean isHttps) {
		 HttpEntity<T>requestEntity = new HttpEntity<T>(body);
		 return restTemplate(isHttps)
				 		.exchange(url
				 				, HttpMethod.POST
				 				, requestEntity
				 				, responseType)
				 		.getBody();
	 }
	 
	 @SuppressWarnings("all")
	 public <T> T put(String url, T body, Class<T> clazz, Boolean isHttps) {
		 HttpEntity<T>requestEntity = new HttpEntity<T>(body);

		 return restTemplate(isHttps)
				 		.exchange(url, 
				 				  HttpMethod.PUT, 
				 				  requestEntity, 
				 				  clazz, 
				 				  clazz.getDeclaredFields())
				 		.getBody();
	 }
	 
	 public String mensagemErroDefault(String message, String endPoint) {
		 return "Erro message: " + message + " URL: " + endPoint;
	 }
	 
	 private RestTemplate restTemplate(Boolean isHttps) {
		 return isHttps ? new RestTemplate(sslSupport()) :  new RestTemplate();
	 }
	 
	 private HttpComponentsClientHttpRequestFactory sslSupport() {
			CloseableHttpClient httpClient = HttpClients
												.custom()
												.setSSLHostnameVerifier(new NoopHostnameVerifier())
												.build();
			HttpComponentsClientHttpRequestFactory useApacheHttpClient = new HttpComponentsClientHttpRequestFactory();
			useApacheHttpClient
				.setHttpClient(httpClient);
			return useApacheHttpClient;
		}
}
