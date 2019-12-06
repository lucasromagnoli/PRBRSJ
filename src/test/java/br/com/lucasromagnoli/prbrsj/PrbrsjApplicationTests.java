package br.com.lucasromagnoli.prbrsj;

import br.com.lucasromagnoli.prbrsj.rest.boot.ServletInitializer;
import br.com.lucasromagnoli.prbrsj.rest.boot.config.PrbrsjApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = PrbrsjApplication.class)
class PrbrsjApplicationTests {

	@Test
	void contextLoads() {
	}

}
