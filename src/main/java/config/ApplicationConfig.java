package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RootConfig.class,WebMvcConfig.class})
public class ApplicationConfig {

}
