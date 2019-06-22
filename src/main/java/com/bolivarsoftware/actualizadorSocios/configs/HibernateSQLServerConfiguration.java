package com.bolivarsoftware.actualizadorSocios.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fede Beron on 19/8/2016.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = { "com.bolivarsoftware.actualizadorSocios.persistSoccam" },
        entityManagerFactoryRef = "sqlServerEntityManagerFactory",
        transactionManagerRef = "sqlServerTransactionManager")
public class HibernateSQLServerConfiguration {
    @Bean(name = "sqlServerDataSource")
    public DataSource sqlServerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=soccam");
        dataSource.setUsername("eTurnos");
        dataSource.setPassword("eTurnos");

//        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=soccamSQL");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
        return dataSource;
    }

    @Bean(name = "sqlServerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sqlServerEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("sqlServerDataSource") DataSource sqlServerDataSource) {
        return builder
                .dataSource(sqlServerDataSource)
                .packages("com.bolivarsoftware.actualizadorSocios.domainSoccam")
                .persistenceUnit("sqlServerEntityManager")
                .properties(jpaProperties())
                .build();
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        return props;
    }


    @Bean(name = "sqlServerTransactionManager")
    public PlatformTransactionManager sqlServerTransactionManager(
            @Qualifier("sqlServerEntityManagerFactory") EntityManagerFactory sqlServerEntityManagerFactory) {
        return new JpaTransactionManager(sqlServerEntityManagerFactory);
    }
}
