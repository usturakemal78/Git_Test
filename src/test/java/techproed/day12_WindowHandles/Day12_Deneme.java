package techproed.day12_WindowHandles;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.Set;

public class Day12_Deneme extends TestBase {
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfayHandle = driver.getWindowHandle();
        System.out.println(ilkSayfayHandle);
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        driver.findElement(By.xpath("(//a)[2]")).click();
        bekle(3);
        Set<String> pencereler = driver.getWindowHandles();
        for (String w:pencereler
             ) {
            System.out.println(w);
            if (!w.equals(ilkSayfayHandle)){
                driver.switchTo().window(w);
            }

        }
        String actualNewWindow= driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualNewWindow);
        String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println(ikinciSayfaHandle);
        driver.switchTo().window(ilkSayfayHandle);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);
        driver.switchTo().window(ilkSayfayHandle);



    }

    @Test
    public void test02() {

    }
}
