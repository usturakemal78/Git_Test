package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01() {
        String filePath = "C:\\Users\\kemal\\Downloads\\b10 all test cases, code.docx";
        try{
            Files.delete(Paths.get(filePath));
        }catch (IOException e){
            System.out.println("Dosya Bulunamadı");

        /*
        Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
        burda dosyayı sildik
         */
        }

         //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//*[text()=.])[6]")).click();
        /*
        İndirmemizi istediği dosyayı locate edip tıkladık ve dosyamız indirilenler klasörüne indi
         */
        bekle(2);//--> İndrime süresini göz önünde bulundurarak bekle koyduk
        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\kemal\\Downloads\\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
