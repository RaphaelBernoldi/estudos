package br.com.poc.oauth2.client.model;

public class GoogleAuthotizationModel {

	private String code;
	private String scope;
	private String authUser;
	private String sessionState;
	private String prompt;
	private String state;
	

	public GoogleAuthotizationModel(String code, String scope, String authUser, String sessionState, String prompt,
			String state) {

		this.code = code;
		this.scope = scope;
		this.authUser = authUser;
		this.sessionState = sessionState;
		this.prompt = prompt;
		this.state = state;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getAuthUser() {
		return authUser;
	}
	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}
	public String getSessionState() {
		return sessionState;
	}
	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
