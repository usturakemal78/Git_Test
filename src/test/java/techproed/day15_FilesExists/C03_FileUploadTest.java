package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
/*
        Eğer dosyaSec.click(); Eğer dosya sec butonuna basmaız istenirse ve otomasyon ile bu butona click yapmak istediğimzide
        exception alıyorsak direkt upload yapmak istediğimzi dosya yolunu alıp sendKeys() methodu ile
        dosyayı sayfaya upload yapabiliriz
        Eğer upload yada dosyaseç butonuna tıkladığınızda windows penceresi açılıyorsa, o web elemente
        sendKeys() methodu ile dosya gönderemeyebilirsiniz böyle bir durumla karşılaşırsanız
        Robot class'ıından obje ile methodlar kullanarak bunu aşabilirsiniz.
        */
        String dosyaYolu = "C:\\Users\\USER\\Desktop\\sen.txt";


        //dosyaSeç butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click();--> hata alır

        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);

        //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }

}
