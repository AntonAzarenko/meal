package com.azarenka.repository;

import liquibase.integration.spring.SpringLiquibase;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.SQLException;

import javax.sql.DataSource;

@Configuration
@PropertySource({"application.properties"})
public class Config {

   /* @Value("${spring.datasource.driver-class-name}")
    Driver driverClassName;*/
    @Value("${spring.datasource.url}")
    String url ;//"jdbc:postgresql://localhost:5432/postgres";
    @Value("${spring.datasource.username}")
    String username;// "root";
    @Value("${spring.datasource.password}")
    String password ;//= "root";

    @Bean
    public DataSource dataSource() throws SQLException {
        Driver driver = new Driver();
        DataSource dataSourceBuilder = new SimpleDriverDataSource(driver, url, username, password);

        return dataSourceBuilder;
    }

    @Bean
    public SpringLiquibase getLiquibase() throws SQLException {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource());
        springLiquibase.setChangeLog("classpath:changelog.xml");
        return springLiquibase;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis.xml"));
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath:com.azarenka.mapper/*.xml"));
        sessionFactory.setTypeAliasesPackage("com.azarenka.domain");
        sessionFactory.afterPropertiesSet();
        return sessionFactory;
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
        MapperFactoryBean<MenuRepository> uR = new MapperFactoryBean<>();
        uR.setMapperInterface(MenuRepository.class);
        uR.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return uR;
    }

    @Bean
    public MapperFactoryBean<UsersRoleMapRepository> userRoleMapRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<UsersRoleMapRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(UsersRoleMapRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }

    @Bean
    public MapperFactoryBean<BookerRepository> bookerRepository(ApplicationContext applicationContext) throws Exception {
        MapperFactoryBean<BookerRepository> repository = new MapperFactoryBean<>();
        repository.setMapperInterface(BookerRepository.class);
        repository.setSqlSessionFactory(sqlSessionFactory(applicationContext).getObject());
        return repository;
    }
}
