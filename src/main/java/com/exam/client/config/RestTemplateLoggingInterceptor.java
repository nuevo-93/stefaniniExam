package com.exam.client.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

		log.info("BK Petstore Request - method={}, uri={}, body={}", request.getMethod(), request.getURI(), new String(body, StandardCharsets.UTF_8));

		ClientHttpResponse response = execution.execute(request, body);
		String responseBody = StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8);

		log.info("BK Petstore Response - statusCode={}, statusText={}, body={}", response.getStatusCode(), response.getStatusText(), responseBody);

		return response;
	}
	
}
