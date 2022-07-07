package br.com.jaiminho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JaiminhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaiminhoApplication.class, args);
	}

}
