package org.testing.utilities;

import java.io.File;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportHandling {
	public static ExtentSparkReporter report() {
		String path=System.getProperty("user.dir")+"/reports";
		File f=new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		String fulpath=path+"/report.html";
		ExtentSparkReporter report=new ExtentSparkReporter(fulpath);
		return report;
	}

	

}
