package com.bolivarsoftware.actualizadorSocios.configs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Created by federicoberon on 28/05/2019.
 */
@Component
public class JobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.print("before job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.print("after job");
    }
}
