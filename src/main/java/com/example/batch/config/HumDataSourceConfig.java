package com.example.batch.config;

import com.example.batch.annotation.HumConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@HumConfiguration
public class HumDataSourceConfig {

    public HumDataSourceConfig() {
        log.info("Create HumDataSourceConfig");
    }
}
