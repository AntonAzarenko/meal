package com.azarenka.repository.testinteg;

import com.azarenka.repository.*;
import liquibase.integration.spring.SpringLiquibase;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.postgresql.Driver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Configuration for embedded postgres database.
 * <p>
 * Copyright (C) 2018 epam.com
 * <p>
 * Date: Nov 30, 2018
 *
 * @author Anton Azarenka
 */

@Configuration
public class EmbeddedPostgresConfig {

    private static final String HOST = "localhost";
    private static final int PORT = 31666;
    private static final String DB_NAME = "postgres";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private String url;

    @Bean(destroyMethod = "stop")
    public EmbeddedPostgres embeddedPostgres() throws IOException {
        EmbeddedPostgres postgres = new EmbeddedPostgres(Version.V9_6_11);
        url = postgres.start(HOST, PORT, DB_NAME, USER, PASSWORD);
        return postgres;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:common_test_data.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }

    @DependsOn("embeddedPostgres")
    @Bean
    public DataSource dataSource() {
        return new SimpleDriverDataSource(new Driver(), url);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:com.azarenka.mapper/*.xml"));
        sqlSessionFactory.setTypeAliasesPackage("com.azarenka.domain");
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis.xml"));
        sqlSessionFactory.afterPropertiesSet();

        return sqlSessionFactory;
    }

    @Bean
    public MapperFactoryBean<UserRepository> userRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<UserRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(UserRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }

    @Bean
    public MapperFactoryBean<DayRepository> dayRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<DayRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(DayRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }

    @Bean
    public MapperFactoryBean<FoodRepository> foodRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<FoodRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(FoodRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }

    @Bean
    public MapperFactoryBean<MealRepository> mealRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<MealRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(MealRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }

    @Bean
    public MapperFactoryBean<MenuRepository> menuRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<MenuRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(MenuRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }

    @Bean
    public MapperFactoryBean<UsersRoleMapRepository> userRoleMapRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<UsersRoleMapRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(UsersRoleMapRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }
}
