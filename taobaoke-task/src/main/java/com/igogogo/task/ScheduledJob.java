package com.igogogo.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduledJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String name = context.getJobDetail().getKey().getName();
		String group = context.getJobDetail().getKey().getGroup();
		String triggername = context.getTrigger().getKey().getName();
		logger.info("name:" + name + " group:" + group + " triggername:" + triggername);
	}

}
