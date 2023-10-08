package com.ucm.diningservice.config;

import com.ucm.diningservice.model.TableReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    @ConfigurationProperties(prefix = "tablereservation")
    public TableReservation dining(){
        return new TableReservation();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
