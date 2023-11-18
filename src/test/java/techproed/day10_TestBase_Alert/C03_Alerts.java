package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alerts extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Clikc Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);

        //Çıkan Alert'te You clicked a button yazısının çıktını doğrulayalım
        System.out.println("Alert üzerindeki yazı : " +getTextAlert());//-->TestBAse class'ında oluşturduğumuz method
        Assert.assertEquals("You clicked a button",getTextAlert());
        bekle(2);

        //Alert'ü kapatalım
        acceptAlert();//-->TestBAse class'ında oluşturduğumuz method
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşısnındaki butona basalım
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);

        //Çıkan alert'te iptale basalım
        dismissAlert();

        //sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);

    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");

        //On button click, promt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.id("promtButton")).click();
        bekle(2);

        //çıkan alerte ismimizi girelim
        sendKeysAlert("Kemal");
        bekle(2);
        acceptAlert();

        //isimimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("Kemal"));

    }
}
