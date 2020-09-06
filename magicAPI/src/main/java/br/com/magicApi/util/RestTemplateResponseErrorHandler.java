
package br.com.magicApi.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import org.springframework.web.client.UnknownHttpStatusCodeException;

import br.com.twsoftware.alfred.object.Objeto;

/**
 * Classe que controla os erros do RestTemplate.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	/**
	  * Método que verifica se ocorreu erro no RestTemplate.
	  * @param response - ClientHttpResponse
	  * @return boolean
	  * @author Yallamy Nascimento (yallamy@gmail.com)
	  * @since 6 de set de 2020 
	 */
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {

		int rawStatusCode = response.getRawStatusCode();

		for (HttpStatus statusCode : HttpStatus.values()) {
			if (statusCode.value() == rawStatusCode) {
				return hasError(statusCode);
			}
		}

		return false;
	}

	/**
	 * Método que verifica se ocorreu erro no RestTemplate.
	 * @param statusCode - HttpStatus
	 * @return boolean
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2020
	 */
	protected boolean hasError(HttpStatus statusCode) {

		return statusCode.series() == HttpStatus.Series.SERVER_ERROR 
				|| statusCode.series() == HttpStatus.Series.CLIENT_ERROR;
	}

	/**
	 * Método que controla se ocorreu erro no RestTemplate.
	 * @param response - ClientHttpResponse
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2020 
	 */
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {

		HttpStatus statusCode = getHttpStatusCode(response);

		switch (statusCode.series()) {

		case CLIENT_ERROR:
			throw new HttpClientErrorException(
					statusCode,
					response.getStatusText(),
					response.getHeaders(),
					getResponseBody(response),
					getCharset(response));

		case SERVER_ERROR:
			throw new HttpServerErrorException(
					statusCode,
					response.getStatusText(),
					response.getHeaders(),
					getResponseBody(response),
					getCharset(response));

		default:
			throw new UnknownHttpStatusCodeException(
					statusCode.value(),
					response.getStatusText(),
					response.getHeaders(),
					getResponseBody(response),
					getCharset(response));
		}
	}

	/**
	 * Método que retorna o statusCode no RestTemplate
	 * @param response - ClientHttpResponse
	 * @return HttpStatus
	 * @throws IOException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2020
	 */
	protected HttpStatus getHttpStatusCode(ClientHttpResponse response) throws IOException {

		try {
			return response.getStatusCode();
		} catch (IllegalArgumentException ex) {
			throw new UnknownHttpStatusCodeException(
					response.getRawStatusCode(),
					response.getStatusText(),
					response.getHeaders(),
					getResponseBody(response),
					getCharset(response));
		}
	}

	/**
	 * Método que retona o body no RestTemplate
	 * @param response - ClientHttpResponse
	 * @return byte[]
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2020
	 */
	protected byte[] getResponseBody(ClientHttpResponse response) {

		try {
			return FileCopyUtils.copyToByteArray(response.getBody());
		} catch (IOException ex) {
			return new byte[BigDecimal.ZERO.intValue()];
		}
	}

	/**
	 * Método que retona o charset no RestTemplate
	 * @param response - ClientHttpResponse
	 * @return Charset
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2020
	 */
	protected Charset getCharset(ClientHttpResponse response) {

		HttpHeaders headers = response.getHeaders();
		MediaType contentType = headers.getContentType();
		return (Objeto.notBlank(contentType) ? contentType.getCharset() : null);
	}
}
