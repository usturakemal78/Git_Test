package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEresmi extends TestBase {
    /*
    Bir Webelement'in resmini almak için önce web elementi locate edip bir webelement'e assing ederiz
    ve bu webeelementi direk getScreenShotAs() methodunu kullanarak resmini belirttiğimiz doyaya kaydederiz.
     */
    @Test
    public void test01() throws IOException {
        //amazon sayafasına gidelim
        driver.get("https://amazon.com");

        bekle(2);
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot"+tarih+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}
