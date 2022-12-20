package com.example.batch.job;

import com.example.batch.annotation.job.HumJob;
import com.example.batch.tasklet.HumTasklet;
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
@HumJob
@Configuration
@RequiredArgsConstructor
public class HumJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final HumTasklet humTasklet;

    @Bean
    public Job humJob() {
        log.info("Create HumJob");
        return jobBuilderFactory.get("humJob")
                .start(humStep())
                .build();
    }

    @Bean
    @JobScope
    public Step humStep() {
        return stepBuilderFactory.get("humStep")
                .tasklet(humTasklet)
                .build();
    }
}
