package com.example.batch.annotation.job;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@ConditionalOnProperty(name = "job.name", havingValue = "humhumJob")
public @interface HumHumJob {
}