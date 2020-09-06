package config.mybatis;


import com.zaxxer.hikari.HikariDataSource;
import me.soomin.board.persistence.mappers.BoardMapper;
import me.soomin.comment.persistence.CommentMapper;
import me.soomin.user.persistence.mapper.SimpleMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@MapperScan(basePackageClasses = {SimpleMapper.class, BoardMapper.class, CommentMapper.class})
public class MyBatisConfig {


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(HikariDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("MyBatis/Mappers/BoardInfoMapper.xml"),
                new ClassPathResource("MyBatis/Mappers/CommentInfoMapper.xml"),
                new ClassPathResource("MyBatis/Mappers/UserInfoMapper.xml"),
                new ClassPathResource("MyBatis/Mappers/LikeCountUserMapper.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
