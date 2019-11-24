package com.azarenka.repository;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUsername("${JDBC_DATABASE_USERNAME}");
        dataSource.setUrl("${JDBC_DATABASE_URL}");
        dataSource.setPassword("${JDBC_DATABASE_PASSWORD}");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
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
}
