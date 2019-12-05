package br.com.lucasromagnoli.prbrsj.domain.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:/br/com/lucasromagnoli/prbrsj/prbrsj-messages.properties", encoding = "UTF-8")
public class PrbrsjPropertiesSupport {

    @Autowired
    private Environment environment;

    public String getProperty(String key) {
        return environment.getProperty(key);
    }
}
