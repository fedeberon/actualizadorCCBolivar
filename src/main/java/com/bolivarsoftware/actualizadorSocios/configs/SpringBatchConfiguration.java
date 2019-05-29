package com.bolivarsoftware.actualizadorSocios.configs;

import com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios.SocioDeudorProcessor;
import com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios.SocioDeudorReader;
import com.bolivarsoftware.actualizadorSocios.batch.notificacionDeSocios.SocioDeudorWriter;
import com.bolivarsoftware.actualizadorSocios.batch.socioDeudor.SocioWriter;
import com.bolivarsoftware.actualizadorSocios.batch.socioDeudor.SociosProcessor;
import com.bolivarsoftware.actualizadorSocios.batch.socioDeudor.SociosReader;
import com.bolivarsoftware.actualizadorSocios.domain.NotificacionSocio;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.Modelo;
import com.bolivarsoftware.actualizadorSocios.domainSoccam.SocioDeudor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Date;

/**
 * Created by Damian Saez on 22/5/2019.
 */

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchConfiguration implements BatchConfigurer {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private JobExecutionListener jobListener;

    @Autowired
    private SociosReader sociosReader;

    @Autowired
    private SociosProcessor sociosProcessor;

    @Autowired
    private SocioWriter socioWriter;

    @Autowired
    private SocioDeudorReader socioDeudorReader;

    @Autowired
    private SocioDeudorProcessor socioDeudorProcessor;

    @Autowired
    private SocioDeudorWriter socioDeudorWriter;

    @Autowired
    @Qualifier("mySqlDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("mySqlTransactionManager")
    private PlatformTransactionManager mySqlTransactionManager;

    @Bean
    public Step stepOne(){
        return steps.get("actualizarSociosDeudores")
                .<Modelo, NotificacionSocio> chunk(10)
                .reader(sociosReader)
                .processor(sociosProcessor)
                .writer(socioWriter)
                .build();

    }

    @Bean
    public Job actualizadorDeudaDeSociosJob(){
        return jobs.get("job")
                .start(stepOne())
                .listener(jobListener)
                .build();
    }


    @Bean
    public Job notificacionDeVencimientoJob(){
        return jobs.get("crearNotificacionDeVencimiento")
                .start(stepTwo())
                .listener(jobListener)
                .build();
    }

    private Step stepTwo() {
        return steps.get("notificarSociosDeudores")
                .<SocioDeudor, NotificacionSocio> chunk(10)
                .reader(socioDeudorReader)
                .processor(socioDeudorProcessor)
                .writer(socioDeudorWriter)
                .build();
    }


    @Scheduled(fixedDelay = 60000)
    public void schedule() throws Exception {
        getJobLauncher().run(actualizadorDeudaDeSociosJob(), new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters());
    }

    //@Scheduled(cron = "0 0 12 1 1/1 ? *")// First day of month
    @Scheduled(fixedDelay = 5000)
    public void scheduleFirstDayOfMonth() throws Exception {
        getJobLauncher().run(notificacionDeVencimientoJob(), new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters());
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
        JobExplorerFactoryBean factoryBean = new JobExplorerFactoryBean();
        factoryBean.setDataSource(this.dataSource);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }


}
