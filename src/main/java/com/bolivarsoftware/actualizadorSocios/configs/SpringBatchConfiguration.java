package com.bolivarsoftware.actualizadorSocios.configs;

import com.bolivarsoftware.actualizadorSocios.batch.SocioWriter;
import com.bolivarsoftware.actualizadorSocios.batch.SociosProcessor;
import com.bolivarsoftware.actualizadorSocios.batch.SociosReader;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.Modelo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Damian Saez on 22/5/2019.
 */

@Configuration
@EnableBatchProcessing
public class SpringBatchConfiguration implements BatchConfigurer {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private JobExplorer jobsExplorer;

    @Autowired
    private SociosReader sociosReader;

    @Autowired
    private SociosProcessor sociosProcessor;

    @Autowired
    private SocioWriter socioWriter;

    @Autowired
    @Qualifier("mySqlDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("mySqlTransactionManager")
    private PlatformTransactionManager mySqlTransactionManager;

    @Bean
    public Step stepOne(){
        return steps.get("actualizarSociosDeudores")
                .<Modelo, NotificacionSocio> chunk(100)
                .reader(sociosReader)
                .processor(sociosProcessor)
                .writer(socioWriter)
                .build();

    }

    @Bean
    public Job demoJob(){
        return jobs.get("job")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .build();
    }


    @Override
    public JobRepository getJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(getTransactionManager());
        factory.afterPropertiesSet();
        return  (JobRepository) factory.getObject();
    }

    @Override
    public PlatformTransactionManager getTransactionManager() throws Exception {
        return mySqlTransactionManager;
    }

    @Override
    public JobLauncher getJobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(getJobRepository());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;

    }

    @Override
    public JobExplorer getJobExplorer() throws Exception {
        return jobsExplorer;
    }

}
