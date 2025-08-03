package org.testing.page;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	 ChromeDriver driver;
	    Properties p;
		public AddToCart(ChromeDriver driver,Properties p) {
			this.driver=driver;
			this.p=p;
		}
		
		public void addtocart() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));		    
		    WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("addcart"))));
		    addToCart.click();
		   Thread.sleep(2000);
		}

		public void viewcart() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));		    
		    WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(p.getProperty("viewcart"))));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);

		}
		 public int getquantity() {
		        WebElement qtyText = driver.findElement(By.xpath(p.getProperty("quantity-in-cart")));
		        String text= qtyText.getText();
		        String trimtext=text.trim();
		        int numericvalue=Integer.parseInt(trimtext);
		        return numericvalue;		    }

		    public int getunitprice() {
		        WebElement priceText = driver.findElement(By.xpath(p.getProperty("one-product-price")));
		       String pricetext= priceText.getText();
		       String pricevalue=pricetext.replaceAll("[^0-9]","");
		       int numericPrice= Integer.parseInt(pricevalue);
		       return numericPrice;
		    }

		    public int gettotalprice() {
		        WebElement totalText = driver.findElement(By.xpath(p.getProperty("total-price")));
                String totalpricetext= totalText.getText();
                String totalpricevalue=totalpricetext.replaceAll("[^0-9]","");
                int numerictotalprice=Integer.parseInt(totalpricevalue);
                return numerictotalprice;
		    }

		    public int calculateExpectedTotal() {
		        return getquantity() * getunitprice();
		    }

}
