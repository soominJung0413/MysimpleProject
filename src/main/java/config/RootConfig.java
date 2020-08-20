package config;

import config.mybatis.MyBatisConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Import({DbcpConfig.class, MyBatisConfig.class})
public class RootConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setFileEncoding("UTF-8");
        configurer.setLocation(new ClassPathResource("properties/dbcp.properties"));
        return configurer;
    }


    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("message.label");
        return messageSource;
    }


}
