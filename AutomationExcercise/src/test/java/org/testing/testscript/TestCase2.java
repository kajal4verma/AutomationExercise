package org.testing.testscript;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testing.assertion.assertionn;
import org.testing.base.base;
import org.testing.page.AddToCart;
import org.testing.page.HomePage;
import org.testing.page.products;
import org.testing.utilities.logCapture;
import org.testing.utilities.screenCapture;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends base {
    @Test
    public void tc2() throws IOException {
        test = report.createTest("test case 2");
        screenCapture sc = new screenCapture(driver);
        logCapture.logs(getClass(), "info", "Test Case2 started..Add product to cart and verify price/quantity/total");
        System.out.println("testcase 2 started...Add product to cart and verify price/quantity/total");

        try {
            HomePage home = new HomePage(driver, p);
            home.home();
              logCapture.logs(getClass(), "info", "Navigated to Home Page successfully");
            String path = sc.screenshot("Home_naviagtion_pass");
            System.out.println("Navigated to home page");
            test.pass("Navigated to Home Page successfully.");
             String url = driver.getCurrentUrl();
             logCapture.logs(getClass(),"info","current url is "+url);
            System.out.println(url);
            logCapture.logs(getClass(),"info","verifying current url" );

             assertionn.varifyUrl(url, "https://www.automationexercise.com/products");
             logCapture.logs(getClass(),"info","sycessfully verify current url" );
            test.pass("Verified Home Page URL: https://www.automationexercise.com/products");
             test.addScreenCaptureFromPath(path);
        } 
        catch (Exception e) {
            String path = sc.screenshot("Home_naviagtion_fail");
             logCapture.logs(getClass(), "error", "Home Page navigation failed: " + e.getMessage());
                System.out.println("Home page navigation failed: " + e.getMessage());
            test.pass("Home Page navigation failed");
             test.addScreenCaptureFromPath(path);
        }

        products product=null;
        
        try 
        {
          product = new products(driver, p);
            product.searchBox("tshirt");
             logCapture.logs(getClass(), "info", "Entered 'tshirt' in the search box");
            test.pass("Entered 'tshirt' in the search box.");
            System.out.println("Searched for 'tshirt'");
        }  catch (Exception e) {
            logCapture.logs(getClass(), "error", "Product search failed: " + e.getMessage());
             System.out.println("Product search failed: " + e.getMessage());
            test.fail("user not able to search ");
           
        }

        try {
              product.clickOnSearchButton();
            logCapture.logs(getClass(), "info", "Clicked on Search button");
            String path = sc.screenshot("search_ button_pass");
            test.pass("Search results displayed successfully for 'tshirt'.");
               String url2 = driver.getCurrentUrl();
               logCapture.logs(getClass(),"info","current url is "+url2 );
            String title = driver.getTitle();
            logCapture.logs(getClass(),"info","current title is "+title );
            System.out.println(url2);
            logCapture.logs(getClass(),"info","verifying current url" );
            assertionn.varifyUrl(url2, "https://www.automationexercise.com/products?search=tshirt");
            logCapture.logs(getClass(),"info","successfully verified current url" );
              test.pass("Verified Search Results URL: https://www.automationexercise.com/products?search=tshirt");
            System.out.println(title);
            logCapture.logs(getClass(),"info","verifying title" );
            assertionn.varifytitle(title, "Automation Exercise - All Products");
            logCapture.logs(getClass(),"info","successfully verified title" );
            test.pass("Verified page title: Automation Exercise - All Products");
              test.addScreenCaptureFromPath(path);
        }
        catch (Exception e) {
               String path = sc.screenshot("search_button_fail");
            logCapture.logs(getClass(), "error", "Search button or verification failed: " + e.getMessage());
             System.out.println("Search button click failed: " + e.getMessage());
             test.fail("not able to clicked on the search button");
            test.fail("url verification failed " + e.getMessage());
            test.fail("Title verification failed " + e.getMessage());
            test.addScreenCaptureFromPath(path);
        }

        WebElement singleProduct;
        
        try {
            singleProduct = product.getProduct();
            String path = sc.screenshot("product_visibility_pass");
             assertionn.verifyProductvVisible(singleProduct, "Product not visible");
            singleProduct.click();
               logCapture.logs(getClass(), "info", "Product is visible and clicked");
            test.pass("Searched product is visible in the results.");
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            String path = sc.screenshot("product_visibility_fail");
            logCapture.logs(getClass(), "error", "Product not visible or stale element error: " + e.getMessage());
               System.out.println("Product click failed: " + e.getMessage());
            test.fail("Searched product not visible in result");
            test.addScreenCaptureFromPath(path);
        }

        try {
              WebElement increasequantity = product.increaseProductquantity("2");
            String path = sc.screenshot("increase_quantity_pass");
            test.pass("Increased product quantity to 2.");
            String value2 = increasequantity.getAttribute("value");
            logCapture.logs(getClass(), "info", "Increased quantity value: " + value2);
            System.out.println("value 2 =>" + value2);
                 assertEquals(value2, "2", "Product quantity is not equal to 2");
            test.pass("Verified that product quantity is correctly updated to 2.");
            System.out.println("product quantity is 2");
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            String path = sc.screenshot("increase_quantity_fail");
               logCapture.logs(getClass(), "error", "Failed to increase product quantity: " + e.getMessage());
            System.out.println("Product quantity is not equal to 2" + e.getMessage());
             test.fail("Product quantity not updated");
            test.addScreenCaptureFromPath(path);
        }

        try {
               AddToCart cart = new AddToCart(driver, p);
            cart.addtocart();
            String path = sc.screenshot("addToCart_pass");
            logCapture.logs(getClass(), "info", "Add to cart button clicked");
            test.pass("Clicked on 'Add to Cart' button.");
              System.out.println("add product to cart");
            test.pass("Popup appeared after adding product to cart");
            cart.viewcart();
            String path1 = sc.screenshot("View_addToCart_pass");
                test.pass("Clicked on 'View Cart' from popup");
            System.out.println("navigate to cart page");
            test.pass("Navigated to Cart Page successfully.");
            test.pass("Fetched quantity, unit price, and total price from cart");
                 int expected = cart.calculateExpectedTotal();
              test.pass("Calculated expected total: quantity * unit price");
               int actual = cart.gettotalprice();
             logCapture.logs(getClass(), "info", "Expected: " + expected + " | Actual: " + actual);
             System.out.println("verify total price, actual price =>" + actual + " expected is =>" + expected);
            assertionn.varifytotalproice(actual, expected);
            test.pass("Verified actual total price matches expected total");
                System.out.println("product price matched");
            test.pass("Product added to cart successfully and total price is correct");
            test.addScreenCaptureFromPath(path);
              test.addScreenCaptureFromPath(path1);
        } catch (Exception e) {
             String path = sc.screenshot("AddToCart_fail");
            logCapture.logs(getClass(), "error", "Add to cart or total price failed: " + e.getMessage());
               System.out.println("Add to cart navigation failed");
            test.fail("Product does not add in cart and total price is not correct");
              test.addScreenCaptureFromPath(path);
        }
    }
}
