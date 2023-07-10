package techproed.day13_Cookies_Actions;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class day13_Deneme extends TestBase {
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).perform();
        Assert.assertEquals("You selected a context menu",getTextAlert());
        acceptAlert();
    }
}
