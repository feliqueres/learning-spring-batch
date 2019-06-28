package com.learningspringbatch.helloworld.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learningspringbatch.helloworld.domain.Constants;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	private static final Logger LOG = LoggerFactory.getLogger(JobConfiguration.class);

	@Bean
	public Job getJob() {
		return jobBuilderFactory.get(Constants.JOB_NAME).start(step()).build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get(Constants.STEP_NAME).tasklet((contribution, chunkContext) -> {
			LOG.info("Hello, World!");
			return RepeatStatus.FINISHED;
		}).build();
	}
}