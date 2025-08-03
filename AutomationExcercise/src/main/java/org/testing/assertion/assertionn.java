package org.testing.assertion;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class assertionn {
public static void varifyUrl(String actual,String expected) {
	 Assert.assertEquals(actual, expected,"url not matched.");
}
public static void varifytotalproice(int actual,int expected) {
	 Assert.assertEquals(actual, expected,"price does not matched.");
}
public static void varifytitle(String actual,String expected) {
	 Assert.assertEquals(actual, expected,"title not matched.");
}
public static void verifyProductvVisible(WebElement element,String msg) {
	Assert.assertTrue(element.isDisplayed(),msg);
}
}
