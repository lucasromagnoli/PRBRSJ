package br.com.lucasromagnoli.prbrsj.domain.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:/br/com/lucasromagnoli/prbrsj/prbrsj-messages.properties", encoding = "UTF-8")
@PropertySource(value = "classpath:/br/com/lucasromagnoli/prbrsj/prbrsj-jwt.properties", encoding = "UTF-8")
public class PrbrsjPropertiesSupport {

    @Autowired
    private Environment environment;

    public String getProperty(String key) {
        return environment.getProperty(key);
    }

    public <T> Object getProperty(String key, Class<T> clazz) {

        if (clazz == Integer.class) {
            try {
                return Integer.parseInt(environment.getProperty(key));
            } catch (NumberFormatException e) { // TODO: Validar uma melhor forma de lidar com properties que não seja String
                e.printStackTrace();
                return 0;
            }
        }

        if (clazz == Boolean.class) {
            return Boolean.parseBoolean(environment.getProperty(key));
        }

        //TODO: Melhor maneira de lidar com as classes que não foram mapeadas
        return environment.getProperty(key);
    }

    public int getIntegerProperty(String key) {
        try {
            return Integer.parseInt(environment.getProperty(key));
        } catch (NumberFormatException e) {
            // TODO: Adicionar log
            e.printStackTrace();
            return 0;
        }
    }

    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(environment.getProperty(key));
    }
}
