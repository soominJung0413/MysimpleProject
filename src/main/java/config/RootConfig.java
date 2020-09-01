package config;

import config.mybatis.MyBatisConfig;
import me.soomin.board.service.BoardService;
import me.soomin.user.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Import({DbcpConfig.class, MyBatisConfig.class})
@ComponentScan(basePackageClasses = {UserService.class, BoardService.class})
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
        messageSource.setBasenames("message.main","message.modal","message.register","message.login","message.list","message.readBoardContent"
        ,"message.write","message.aside","message.modify");
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
