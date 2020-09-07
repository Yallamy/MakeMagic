package br.com.magicApi.config;

import org.junit.Ignore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.Getter;
import lombok.Setter;


/**
 * Classe que armazena as propriedades do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@ConfigurationProperties(ignoreUnknownFields = true)
@Ignore
@Getter
@Setter
@EnableConfigurationProperties
public class Propriedades {

	public MagicApiConfig magicApiConfig = new MagicApiConfig();

	@Getter
	@Setter
	public class MagicApiConfig {

		public PotterApi potterApi = new PotterApi();

		@Getter
		@Setter
		public class PotterApi {

			public String url;

			public String key;
		}

		private Rest rest = new Rest();

		@Getter
		@Setter
		public class Rest {

			private int connectionTimeout;

			private int readTimeout;

		}

		private Failsafe failsafe = new Failsafe();

		@Getter
		@Setter
		public class Failsafe {

			private int failureNumber;

			private int successNumber;

			private int delayTimeSeconds;
		}
	}
}
