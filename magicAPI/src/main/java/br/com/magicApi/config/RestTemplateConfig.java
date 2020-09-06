
package br.com.magicApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.com.magicApi.util.RestTemplateResponseErrorHandler;
import lombok.Getter;

/**
 * Classe que configura o RestTemplate  
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@Configuration
public class RestTemplateConfig {


	@Getter
	private RestTemplateBuilder restTemplateBuilder;

	//@Autowired
	//private Propriedades propriedades; //FIXME

	public RestTemplateConfig(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}

	@Bean
	public RestTemplate createRestTemplate() {

		return restTemplateBuilder
				//.setConnectTimeout(propriedades.getMagicApiConfig().getRest().getConnectionTimeout())
				//.setReadTimeout(propriedades.getMagicApiConfig().getRest().getReadTimeout())
				.errorHandler(new RestTemplateResponseErrorHandler())
				.build();
	}
}
