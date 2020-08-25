package config;

import EventHandlers.RegisterContextPathHandler;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RootConfig.class,WebMvcConfig.class})
@ComponentScan(basePackageClasses = {RegisterContextPathHandler.class}
,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Aspect.class})}
)
public class ApplicationConfig {

}
