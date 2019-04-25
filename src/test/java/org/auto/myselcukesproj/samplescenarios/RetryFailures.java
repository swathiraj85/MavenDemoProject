package org.auto.myselcukesproj.samplescenarios;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailures implements IRetryAnalyzer{
  int min_retry_cnt = 0,max_retry_count = 2;		  
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		if(arg0.getStatus() == ITestResult.FAILURE && min_retry_cnt<= max_retry_count)		
		{
			System.out.println("retrying the failure" + arg0.getStatus());
			min_retry_cnt++;
			return true;
		}
		return false;
	}

}
