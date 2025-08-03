package org.testing.page;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    ChromeDriver driver;
    Properties p;
	public HomePage(ChromeDriver driver,Properties p) {
		this.driver=driver;
		this.p=p;
	}
	public void home() {
		  WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
	   WebElement product= w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("product"))));
		product.click();
		}
	
}
