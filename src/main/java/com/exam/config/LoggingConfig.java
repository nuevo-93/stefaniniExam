package com.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class LoggingConfig {

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {

		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();

		filter.setIncludeClientInfo(true);
		filter.setIncludeQueryString(true);
		filter.setIncludeHeaders(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10000);

		filter.setBeforeMessagePrefix("");
		filter.setBeforeMessageSuffix("");

		filter.setAfterMessagePrefix("MS Petstore Request: ");
		filter.setAfterMessageSuffix("");

		return filter;
	}
	
}
