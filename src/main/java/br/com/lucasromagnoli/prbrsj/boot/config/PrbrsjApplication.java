package br.com.lucasromagnoli.prbrsj.boot.config;

import br.com.lucasromagnoli.prbrsj.domain.model.PrbrsjUser;
import br.com.lucasromagnoli.prbrsj.domain.support.PrbrsjPropertiesSupport;
import br.com.lucasromagnoli.prbrsj.rest.controller.UserRestController;
import br.com.lucasromagnoli.prbrsj.security.config.OAuthSecurityConfig;
import br.com.lucasromagnoli.prbrsj.security.filter.RefreshTokenCookieFilter;
import br.com.lucasromagnoli.prbrsj.security.processor.RefreshTokenPostProcessor;
import br.com.lucasromagnoli.prbrsj.security.service.PrbrsjUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// TODO: Melhorar a forma em que essas configurações estão apresentadas
@EntityScan("br.com.lucasromagnoli.prbrsj.domain.model")
@EnableJpaRepositories("br.com.lucasromagnoli.prbrsj.domain.repository")
@SpringBootApplication(scanBasePackageClasses = {
		UserRestController.class,
		OAuthSecurityConfig.class,
		RefreshTokenPostProcessor.class,
		RefreshTokenCookieFilter.class,
		PrbrsjUser.class,
		PrbrsjUserDetailsService.class,
		PrbrsjPropertiesSupport.class})
public class PrbrsjApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrbrsjApplication.class, args);
	}

}
