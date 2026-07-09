package com.exam.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResponseLoggingFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

		try {
			filterChain.doFilter(request, responseWrapper);
		} finally {
			
			String responseBody = new String(responseWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
			log.info("MS Petstore Response: {}, {}, {}, {}", request.getMethod(), request.getRequestURI(), responseWrapper.getStatus(), 
					responseBody);
			
			responseWrapper.copyBodyToResponse();
		}
	}
	
}
