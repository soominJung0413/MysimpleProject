package config;

import EventHandlers.RegisterContextPathHandler;
import me.soomin.aop.LoggingAdvice;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.*;

@Configuration
@Import({RootConfig.class,WebMvcConfig.class})
@ComponentScan(basePackageClasses = {RegisterContextPathHandler.class, LoggingAdvice.class}
,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Aspect.class})}
)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationConfig {

}
