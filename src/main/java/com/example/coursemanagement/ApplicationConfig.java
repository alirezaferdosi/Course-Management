package com.example.coursemanagement;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Hibernate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@Configuration
@EnableJpaRepositories(basePackages = "com.example.coursemanagement.Repository")
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.example.coursemanagement"})
public class ApplicationConfig {
    @Bean
    public EmbeddedDatabase dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }


    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.example.coursemanagement.Model");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }


    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager txmanagement = new JpaTransactionManager();
        txmanagement.setEntityManagerFactory(entityManagerFactory());

        return  txmanagement;
    }
}