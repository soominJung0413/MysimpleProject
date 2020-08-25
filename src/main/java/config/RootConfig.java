package config;

import config.mybatis.MyBatisConfig;
import me.soomin.user.domain.validation.UserLoginRequestValidator;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceView;

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
        messageSource.setBasenames("message.main","message.modal","message.register","message.login");
        return messageSource;
    }


//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setBasenames("message.main","message.modal","message.register"
//
//        );
//        return messageSource;
//    }


}
