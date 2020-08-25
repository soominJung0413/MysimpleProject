package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DbcpConfig {
    @Value("${dbcp.driver}")
    private String driver;
    @Value("${dbcp.url}")
    private String url;
    @Value("${dbcp.user}")
    private String username;
    @Value("${dbcp.password}")
    private String password;
    @Value("${dbcp.max}")
    private int max;
    @Value("${dbcp.min}")
    private int min;
    @Value("${dbcp.timeout}")
    private int timeout;
    @Value("${dbcp.sql}")
    private String validationSql;

    @Bean
    public HikariConfig hikariConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driver);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setMinimumIdle(min);
        hikariConfig.setMaximumPoolSize(max);
        hikariConfig.setIdleTimeout(timeout);
        hikariConfig.setConnectionTestQuery(validationSql);
        return hikariConfig;
    }
    @Bean(destroyMethod = "close")
    public HikariDataSource hikariDataSource(HikariConfig hikariConfig){
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(HikariDataSource hikariDataSource){
        return new DataSourceTransactionManager(hikariDataSource);
    }

}
