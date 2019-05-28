package com.bolivarsoftware.actualizadorSocios.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = { "com.bolivarsoftware.actualizadorSocios.persist"},
        entityManagerFactoryRef = "mySqlEntityManagerFactory",
        transactionManagerRef = "mySqlTransactionManager")
public class HibernateConfiguration {

    @Primary
    @Bean(name = "mySqlDataSource")
    public DataSource sqlServerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eturnos");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        return dataSource;
    }


    @Primary
    @Bean(name = "mySqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mySqlDataSource") DataSource mySqlDataSource) {
        return builder
                .dataSource(mySqlDataSource)
                .packages("com.bolivarsoftware.actualizadorSocios.domain")
                .persistenceUnit("mySqlEntityManager")
                .properties(jpaProperties())
                .build();
    }


    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");

        return props;
    }

    @Primary
    @Bean(name = "mySqlTransactionManager")
    public PlatformTransactionManager mySqlTransactionManager(
            @Qualifier("mySqlEntityManagerFactory") EntityManagerFactory mySqlEntityManagerFactory) {
        return new JpaTransactionManager(mySqlEntityManagerFactory);
    }

}