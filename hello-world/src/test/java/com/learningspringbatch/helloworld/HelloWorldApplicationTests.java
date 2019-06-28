package com.learningspringbatch.helloworld;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.learningspringbatch.helloworld.domain.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { HelloWorldApplication.class })
@Transactional
public class HelloWorldApplicationTests {
	@Autowired
	private Job job;

	@Test
	public void testingJobName() {
		assertEquals(Constants.JOB_NAME, job.getName());
	}
}