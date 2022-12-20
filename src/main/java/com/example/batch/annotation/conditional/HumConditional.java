package com.example.batch.annotation.conditional;

import com.example.batch.annotation.job.HumHumJob;
import com.example.batch.annotation.job.HumJob;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(HumConditional.HumAnyNested.class)
public @interface HumConditional {

    @SuppressWarnings("unused")
    class HumAnyNested extends AnyNestedCondition {

        public HumAnyNested() {
            super(ConfigurationPhase.PARSE_CONFIGURATION);
        }

        @HumJob
        static class HumJobCondition {
        }

        @HumHumJob
        static class HumHumJobCondition {
        }
    }
}