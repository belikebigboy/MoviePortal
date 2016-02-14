package io.spring.movieportal.configuration;

import io.spring.movieportal.beans.SampleBean;
import io.spring.movieportal.beans.SampleBeanImpl;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;


/**
 * Created by BiggieBig on 2/12/2016.
 */
@Configuration
@EnableScheduling
@EnableAsync
@EnableCaching
@ComponentScan("io.spring.movieportal")
public class ApplicationConfiguration {

    @Bean
    public SampleBean sampleBean() {
        SampleBeanImpl sampleBean = new SampleBeanImpl();
        sampleBean.setMyType("I am the doer");
        return sampleBean;
    }

    @Bean
    public DataSource sqlLiteDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite:MoviePortal.db");
        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(sqlLiteDataSource());
        return jdbcTemplate;
    }

}
