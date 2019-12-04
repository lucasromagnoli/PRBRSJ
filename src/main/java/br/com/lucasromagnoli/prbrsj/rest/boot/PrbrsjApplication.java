package br.com.lucasromagnoli.prbrsj.rest.boot;

import br.com.lucasromagnoli.prbrsj.rest.config.AuthorizationServerConfig;
import br.com.lucasromagnoli.prbrsj.rest.config.OAuthSecurityConfig;
import br.com.lucasromagnoli.prbrsj.rest.config.ResourceServerConfig;
import br.com.lucasromagnoli.prbrsj.rest.controller.UserRestController;
import br.com.lucasromagnoli.prbrsj.rest.filter.RefreshTokenCookieFilter;
import br.com.lucasromagnoli.prbrsj.rest.processor.RefreshTokenPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan(basePackageClasses = {
		UserRestController.class,
		OAuthSecurityConfig.class,
		RefreshTokenPostProcessor.class,
		RefreshTokenCookieFilter.class})
@SpringBootApplication
public class PrbrsjApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrbrsjApplication.class, args);
	}

}
