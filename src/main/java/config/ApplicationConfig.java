package config;

import EventHandlers.RegisterContextPathHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RootConfig.class,WebMvcConfig.class})
@ComponentScan(basePackageClasses = {RegisterContextPathHandler.class})
public class ApplicationConfig {

}
