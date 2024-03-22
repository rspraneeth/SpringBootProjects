package com.rsp.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db1EntityManagerFactory",
                        transactionManagerRef = "db1TransactionManager",
                        basePackages = {"com.rsp.model", "com.rsp.repo"})
public class Db1Config {
    //DataSource
    @Bean
    @ConfigurationProperties(prefix = "db1.datasource")
    public DataSource db1DataSource(){

        return DataSourceBuilder.create().build();
    }

    //EntityManager
    @Bean
    public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder emfb){
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.showsql", "true");
        properties.put("hibernate.format_sql", "true");

        return emfb.dataSource(db1DataSource())
                .packages("com.rsp.model")
                .properties(properties)
                .persistenceUnit("schema3")
                .build();

    }


    //TransactionManagement
    @Bean
    public PlatformTransactionManager db1TransactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory factory){

        return new JpaTransactionManager(factory);
    }

}
