/**
 * 
 */
package com.taiyear.dsp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author liul
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.taiyear.dsp" })
public class Application extends SpringBootServletInitializer implements
		EmbeddedServletContainerCustomizer, WebApplicationInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setContextPath("/dsp");
		// container.setPort(8080);
	}

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
	}
}
