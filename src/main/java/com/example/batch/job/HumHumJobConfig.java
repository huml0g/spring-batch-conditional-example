package com.example.batch.job;

import com.example.batch.annotation.job.HumHumJob;
import com.example.batch.annotation.job.HumJob;
import com.example.batch.tasklet.HumHumTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@HumHumJob
@Configuration
@RequiredArgsConstructor
public class HumHumJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final HumHumTasklet humhumTasklet;

    @Bean
    public Job humhumJob() {
        log.info("Create HumHumJob");
        return jobBuilderFactory.get("humhumJob")
                .start(humhumStep())
                .build();
    }

    @Bean
    @JobScope
    public Step humhumStep() {
        return stepBuilderFactory.get("humhumStep")
                .tasklet(humhumTasklet)
                .build();
    }
}
