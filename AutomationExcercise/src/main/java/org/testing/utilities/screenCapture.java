package org.testing.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenCapture {
	ChromeDriver driver;
	public screenCapture(ChromeDriver driver) {
		this.driver=driver;
	}
   public String screenshot(String name) throws IOException {
	   String path=System.getProperty("user.dir")+"/screenshots";
	   File f=new File(path);
	   if(!f.exists()) {
		   f.mkdirs();
	   }
	   String fullpath=path+"/"+name+".png";
	   File file=driver.getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(file,new File(fullpath));
	   return fullpath;
   }
}
