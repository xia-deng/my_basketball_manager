package com.lindeng.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class InitConfig {

    @Value("${basketball.dbPath}")
    private String dbPath;

    @Bean
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.sqlite.JDBC");
        hikariDataSource.setJdbcUrl(dbPath);
        return hikariDataSource;
    }

}
