package com.github.chandrasekar246.spring.batch.demo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobInvokerController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("menuListJob")
	Job menuListJob;

	@GetMapping("/run-batch-job/{id}")
	public String handle(@PathVariable Long id) throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addLong("job-id", id).toJobParameters();
		jobLauncher.run(menuListJob, jobParameters);

		return "Batch job has been invoked";
	}
}