package br.com.magicApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.magicApi.config.Propriedades;
import br.com.magicApi.config.SwaggerConfiguration;

@SpringBootApplication
@EnableConfigurationProperties({ Propriedades.class })
//@Import( SwaggerConfiguration.class )
@EnableScheduling
@EnableCaching
//@EnableAutoConfiguration
public class MagicAPI {

	public static void main(String[] args) {
		
		SpringApplication.run(MagicAPI.class, args);
	}

}
