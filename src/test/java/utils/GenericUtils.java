package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	public void switchWindowToChild() {
		Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    String parentId = i1.next();
	    String childId = i1.next();
	    driver.switchTo().window(childId);
	}
}
