package ru.agk13145.projects.htmlpageanalyzer.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringJDBCConfiguration {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "app.db.worker.driver";
    private static final String PROPERTY_NAME_DATABASE_URL = "app.db.worker.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "app.db.worker.username";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "app.db.worker.password";

    @Resource
    private Environment env;


    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSourceBuilder.url(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSourceBuilder.username(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSourceBuilder.password(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        return dataSourceBuilder.build();
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return namedParameterJdbcTemplate;
    }

}
