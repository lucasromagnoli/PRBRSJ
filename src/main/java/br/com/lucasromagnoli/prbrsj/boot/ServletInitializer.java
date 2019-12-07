package br.com.lucasromagnoli.prbrsj.boot;

import br.com.lucasromagnoli.prbrsj.boot.config.PrbrsjApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PrbrsjApplication.class);
	}

}
