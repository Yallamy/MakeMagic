package br.com.magicApi.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

/**
 * Classe que faz a configuração do circuit break
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 8 de set de 2020
 */
@Configuration
public class Resilience4JConfiguration {
	
	@Autowired
	private Propriedades propriedades;

	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {

		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(propriedades.getMagicApiConfig().getFailsafe().getFailureRateThreshold())
				.waitDurationInOpenState(Duration.ofMillis(propriedades.getMagicApiConfig().getFailsafe().getWaitDurationInOpenState()))
				.slidingWindowSize(propriedades.getMagicApiConfig().getFailsafe().getSlidingWindowSize())
				.build();

		TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
				.timeoutDuration(Duration.ofSeconds(propriedades.getMagicApiConfig().getFailsafe().getTimeoutDuration()))
				.build();

		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.timeLimiterConfig(timeLimiterConfig)
				.circuitBreakerConfig(circuitBreakerConfig)
				.build());
	}

}
