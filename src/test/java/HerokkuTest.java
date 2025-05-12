import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HerokkuTest extends BaseTest {
    @Test
    public void passedLoginTest() {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
        browser.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        boolean loginSuccessful = browser.findElement(By.xpath("//*[text()='Welcome to the Secure Area. When you are done click logout below.']")).isDisplayed();
        assertTrue(loginSuccessful);
    }

    @Test
    public void failedLoginTest() {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.xpath("//*[@id='username']")).sendKeys("123");
        browser.findElement(By.xpath("//*[@id='password']")).sendKeys("123");
        browser.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        String error = browser.findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]")).getText().replace("×", "").trim();
        assertEquals(error, "Your username is invalid!");
    }

    @Test
    public void logout(){
        passedLoginTest();
        browser.findElement(By.xpath("//*[@href=\"/logout\"]")).click();
        String message = browser.findElement(By.xpath("//div[contains(text(), 'You logged out of the secure area!')]")).getText().replace("×", "").trim();
        assertEquals(message, "You logged out of the secure area!");
    }
}