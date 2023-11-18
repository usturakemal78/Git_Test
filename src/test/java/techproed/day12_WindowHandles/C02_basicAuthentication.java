package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_basicAuthentication extends TestBase {

    @Test
    public void test01() {

         /*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Başarılı girişi doğrulayın.
     */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);
        //Başarılı bir girişten sonra Congratulations! yazısının çıktığını doğrulayın
        WebElement text = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations!"));


        //Elemental Selenium yazısına tıklayalım
       driver.findElement(By.xpath("(//a)[2]")).click();
       driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//--> Açılan yeni pencereye geçtik

        //Başlığın Elemetal Selenium olmadığını doğrulayalım
        System.out.println("Sayfa Başlığı : "+driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());


        //Dropdown menüden java seçelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");
        //selectVisibleText(ddm,"Java"); method ile

    }
}
