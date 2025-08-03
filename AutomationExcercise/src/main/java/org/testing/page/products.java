package org.testing.page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class products {

	 ChromeDriver driver;
	    Properties p;
		public products(ChromeDriver driver,Properties p) {
			this.driver=driver;
			this.p=p;
		}
		public void searchBox(String productname) throws InterruptedException {
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement serachbox=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("searchbox"))));
			serachbox.sendKeys(productname);
			
		}
		public void clickOnSearchButton() {
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement searchBtn=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("searchbtn"))));
			searchBtn.click();
								
		}
		public WebElement getProduct() throws InterruptedException {
		    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		      WebElement singleProduct = w.until(ExpectedConditions.visibilityOfElementLocated(
		       By.xpath(p.getProperty("productlist"))));
 
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,500)");
//		    singleProduct.click();
		    return singleProduct;
		}
       public WebElement checkProductName() {
    	   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement productname=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("productname"))));
			return productname;
       }
       public WebElement checkProductprice() {
    	   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement productprice=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("price"))));
			return productprice;
       }
       public WebElement checkProductquantity() {
    	   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement productquantity=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("quantity"))));
			return productquantity;
       }
       public WebElement increaseProductquantity(String value) {
    	   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement increasequnatity=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("quantity"))));
			increasequnatity.clear();
			increasequnatity.sendKeys(value);
			return increasequnatity;
       }
       
       public WebElement checkavailability() {
    	   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement productavailability=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("availability"))));
			return productavailability;
       }
       public WebElement checkProductcondition() {
    	   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement productcondition=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("condition"))));
			return productcondition;
       }
       public WebElement checkProductbrand() {
    	   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(3));
			WebElement productbrand=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("brand"))));
			return productbrand;
       }


}
