/**
 * 
 */
package com.taiyear.dsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

/**
 * 测试时用于启用项目的Application
 * 
 * @author liul
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.taiyear.dsp" })
public class QuickStart extends SpringBootServletInitializer implements
		EmbeddedServletContainerCustomizer, WebApplicationInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(QuickStart.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(QuickStart.class);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setContextPath("/dsp");
		container.setPort(8080);
	}
}
