package hei.tp03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "hei.tp03.service")
public class AppConfig {

    @Bean
    public Properties dbProperties(){
        Properties properties = new Properties();
        properties.setProperty("driverClass","org.postgresql.Driver");
        properties.setProperty("jdbcUrl","jdbc:postgresql://localhost:5432/hei_tp03");
        properties.setProperty("username","postgres");
        properties.setProperty("password","czx368");
        return properties;
    }



}
