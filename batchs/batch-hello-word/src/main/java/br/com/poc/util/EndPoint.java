package br.com.poc.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:endpoint.properties")
@ConfigurationProperties
public class EndPoint {

	private String criaMonitoracao;


	public String getCriaMonitoracao() {
		return criaMonitoracao;
	}

	public void setCriaMonitoracao(String criaMonitoracao) {
		this.criaMonitoracao = criaMonitoracao;
	}
}
