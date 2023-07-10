package techproed.day14__Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import javax.swing.*;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        //   driver.findElement(By.xpath("//i[@class='eicon-close'")).click(); //--> reklam çıktığında kullanabilirsin
        //   bekle(2);
        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        bekle(2);

        //sayfanin ustune dogru gdelim
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        //driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); //--> reklam kapatmak için kullandık.
        bekle(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(2);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).perform();
      //actions.sendKeys(Keys.HOME).build().perform(); //--> bu şekilde de yapabiliriz yukarıdaki performu yazmasak da olur.
        //build()--> methodu action'ları birleştirmek için kullanılan methodtur. Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar.
        //relase() --> methodu mouse'u bırakır.

    }

    @Test
    public void test03() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,2500);
        bekle(3);
        //sayfanın en üstüne scroll yapalım
        actions.scrollByAmount(0,-2500).build().perform();
    }
}
