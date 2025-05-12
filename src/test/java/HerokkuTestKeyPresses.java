import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import parent.BaseTest;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class HerokkuTestKeyPresses extends BaseTest {
    public String[] keyPressed = {"1", "b", "y", "r"};
    @Test
    public void keyPressesTest() {
        browser.get("https://the-internet.herokuapp.com/key_presses");
        for (int i = 0; i < keyPressed.length; i++) {
            browser.findElement(By.xpath("//*[@id='target']")).sendKeys(keyPressed[i]);
            String res = browser.findElement(By.xpath("//*[@id='result']")).getText();
            assertEquals(res, "You entered: "+keyPressed[i].toUpperCase(Locale.ROOT));
            browser.findElement(By.xpath("//*[@id='target']")).sendKeys(Keys.CONTROL + "A");
            browser.findElement(By.xpath("//*[@id='target']")).sendKeys(Keys.BACK_SPACE);
        }
    }
}

// не уверен что правильно. но тест проходит. не смог придумать как реализовать это с нажатием кнопки альт и т.д. как это в массив записать?