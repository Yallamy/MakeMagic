package br.com.magicApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.magicApi.config.Propriedades;

@SpringBootApplication
@EnableConfigurationProperties({ Propriedades.class })
@EnableScheduling
@EnableCaching
public class MagicAPI {

	public static void main(String[] args) {
		
		SpringApplication.run(MagicAPI.class, args);
	}

}
