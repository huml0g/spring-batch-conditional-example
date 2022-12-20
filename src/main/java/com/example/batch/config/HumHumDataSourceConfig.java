package com.example.batch.config;

import com.example.batch.annotation.job.HumHumJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@HumHumJob
@Configuration
public class HumHumDataSourceConfig {

    public HumHumDataSourceConfig() {
        log.info("Create HumHumDataSourceConfig");
    }
}