package org.testing.testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testing.assertion.assertionn;
import org.testing.base.base;
import org.testing.page.HomePage;
import org.testing.page.products;
import org.testing.utilities.dataprovider;
import org.testing.utilities.logCapture;
import org.testing.utilities.screenCapture;
import org.testng.annotations.Test;


public class TestCase1 extends  base {
	@Test(dataProvider = "testdata", dataProviderClass = dataprovider.class)
	
	public void tc1(String productname) throws InterruptedException, IOException {
         screenCapture sc=new screenCapture(driver);
         test=report.createTest("test case 1");
         
		System.out.println("testcase 1 started...verifying product detail and visibility");
		logCapture.logs(getClass(), "info", "test case 1 started..verifying product detail and visibility");
        try {
            HomePage home = new HomePage(driver, p);
            home.home();
            String path=sc.screenshot("homepage_navigation_pass");
            logCapture.logs(getClass(), "info", " Navigated to Home page");
            String url=driver.getCurrentUrl();
            logCapture.logs(getClass(), "info", "current url is "+url);
            System.out.println(url);
            logCapture.logs(getClass(), "info", " verifying current url");
            assertionn.varifyUrl(url,"https://www.automationexercise.com/products");
            logCapture.logs(getClass(), "info", "url sucessfully verified");
            test.pass("Verified Home Page URL: https://www.automationexercise.com/products");
            System.out.println("Navigated to home page");
            logCapture.logs(getClass(), "info", "sucessfully Navigate to Home page");
            test.pass("Navigate to home page");
            test.addScreenCaptureFromPath(path);
        }
        catch (Exception e) 
        {
            logCapture.logs(getClass(), "error", "failed to Navigate to Home page");
            System.out.println("Home page navigation failed: " + e.getMessage());
            System.out.println("URL assertion failed: " + e.getMessage());
            logCapture.logs(getClass(), "error", " url not matched ");
            test.fail("Home page navigation failed");
            String path = sc.screenshot("homepage_navigation_fail");
            test.addScreenCaptureFromPath(path);
         }
        products product=null;
        try {
            logCapture.logs(getClass(), "info", " Navigated to product page");
            product = new products(driver, p);
            test.pass("Entered tshirt in the search box.");
            logCapture.logs(getClass(), "info", "Entered "+ productname + " in search box");
            product.searchBox(productname);
            System.out.println("Searched for 'tshirt'");
            test.pass("Search functionality is working correctly for the input 'tshirt");
        } catch (Exception e) {
            logCapture.logs(getClass(), "error", " Navigated to product page failed and not able to search product");
            System.out.println("Product search failed: " + e.getMessage());
            test.pass("Search functionality is not working");
            String path = sc.screenshot("not_able_to_write");
            test.addScreenCaptureFromPath(path);
            
        }
		
		try {
            logCapture.logs(getClass(), "info", "click on search button");
			product.clickOnSearchButton();
			String path = sc.screenshot("search_button_pass");
			
			String title=driver.getTitle();
            logCapture.logs(getClass(), "info", "current title is "+title);			
            logCapture.logs(getClass(), "info", " sucessfully verify url");		
			System.out.println(title);
			logCapture.logs(getClass(), "info", " verifying title");
			assertionn.varifytitle(title,"Automation Exercise - All Products");	
            logCapture.logs(getClass(), "info", "successfully verify title");
			test.pass("User able to click on search button.");
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
            logCapture.logs(getClass(), "error", " not able to click on search button");
            logCapture.logs(getClass(), "error", " verifying title failed");
			String path = sc.screenshot("search_button_fail");
            System.out.println("Search button click failed: " + e.getMessage());
            System.out.println("URL or title assertion failed: " + e.getMessage());
			test.fail("User not able to click on search button.");
			test.addScreenCaptureFromPath(path);
			
		}
		 WebElement singleProduct ;
		 try {
			  singleProduct = product.getProduct();
			  String path = sc.screenshot("product_visibility_pass");
			  logCapture.logs(getClass(), "info", "check product is visible after search");
			 assertionn.verifyProductvVisible(singleProduct, "Product not visible");
			  logCapture.logs(getClass(), "info", "product is visible after search");

			 singleProduct.click();//stale elmnt
				test.pass("Product is visible after search");
				test.addScreenCaptureFromPath(path);

			
		} catch (Exception e)
		 {
			logCapture.logs(getClass(), "error", "Product not visible ");
			String path = sc.screenshot("product_visibility_fail");
			System.out.println("Product click failed: " + e.getMessage());
			
			test.pass("Product is not visible after search");
			test.addScreenCaptureFromPath(path);

		 }
		 try {
			 logCapture.logs(getClass(), "info", "check product name is visible");
				assertionn.verifyProductvVisible( product.checkProductName(),"Product name is not visible");
				System.out.println("Product name is visible");
				 logCapture.logs(getClass(), "info", "product name is visible");
				 logCapture.logs(getClass(), "info", "check product price is visible");
				assertionn.verifyProductvVisible(product.checkProductprice(),"Product price is not visible");
				 logCapture.logs(getClass(), "info", "product price is visible");
				System.out.println("Product price is visible");
				 logCapture.logs(getClass(), "info", "check default product quantity is 1");
	            WebElement quantity=product.checkProductquantity();
	            String value=quantity.getAttribute("value");
	            System.out.println("value 1 =>"+value);
	            assertEquals(value, "1","default quantity is not eqaul to 1");
				 logCapture.logs(getClass(), "info", "default quantity is 1");
	            System.out.println("product quantity is 1");
	            test.pass("default quantity of product is eqaul to 1");
				 logCapture.logs(getClass(), "info", "check product availability is visible");
	            assertionn.verifyProductvVisible( product.checkavailability(),"Product availability is not visible");
				 logCapture.logs(getClass(), "info", "product is available");
				System.out.println("Product availability is visible");
				 logCapture.logs(getClass(), "info", "check product condition is visible");
				assertionn.verifyProductvVisible( product.checkProductcondition(),"Product condition is not visible");
				 logCapture.logs(getClass(), "info", "product is new ");
				System.out.println("Product condition is visible");
				 logCapture.logs(getClass(), "info", "check product brand is visible");
				assertionn.verifyProductvVisible( product.checkProductbrand(),"Product brand is not visible");
				 logCapture.logs(getClass(), "info", "product brand is visible");
				System.out.println("Product brand is visible");
       			test.pass("Product details like brand,product name,availability,condition,price are visible on the product page.");
       			String path = sc.screenshot("product_details_visibility_pass");
       			test.addScreenCaptureFromPath(path);

			} 
			 catch (Exception e) {
				 String path = sc.screenshot("product_details_visibility_fail");
			System.out.println("Product name is not visible"+e.getMessage());	
			 logCapture.logs(getClass(), "error", "product name is not visible");
			System.out.println("Product price is not visible"+e.getMessage());	
			 logCapture.logs(getClass(), "error", "product price is not visible");
			System.out.println("Product quantity is not equal to 1"+e.getMessage());
			 logCapture.logs(getClass(), "error", "product default quantity is not equal to 1");
			 logCapture.logs(getClass(), "error", "product availability is not visible");
			 logCapture.logs(getClass(), "error", "product brand is not visible");
			 logCapture.logs(getClass(), "error", "product condition is not visible");
			 test.fail("default quantity of product is nnot equal to 1");
            test.fail("Product details like brand,product name,availability,condition,price are not visible on the product page");
            test.addScreenCaptureFromPath(path);
			}


	}

}
