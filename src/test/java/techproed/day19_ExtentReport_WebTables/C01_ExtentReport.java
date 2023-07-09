package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
    EXTENTREPORT;
       1- ExtentReport(aventstack) kullanabilmek için mvn adresinden 4.0.9 version numaralı
        dependency'i pom.xml dosyamıza ekleriz.
        2- ExtentReports class'ından class seviyesinde obje oluştururuz.
        3-ExtentHtmlReporter class'ından class seviyesinde obje oluştururuz.
        4-ExtentTest class'ından class seviyesinde oble oluştururuz.
     */
    ExtentReports extendtReports;//-->raporlamayı başlatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter;//--> Raporu HTMl formatında düzenler
    ExtentTest extentTest;//-->Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz.
    @Test
    public void test01() {
        extendtReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extendtReports.attachReporter(extentHtmlReporter);//-->HTML formatında raporlamayı başlatacak

        //raporda dözükmesini istediğimiz bilgiler için
        extendtReports.setSystemInfo("Browser","Chrome");
        extendtReports.setSystemInfo("Tester","Kemal");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest=extendtReports.createTest("ExtentTest","Test Raporu");

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");
        extentTest.info("Başlığın Amazon İçerdiği Test Edildi");

        //başlığın Amazon içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");
        //sonuc yazısını konsola yazdıralım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi"+sonucYazisi.getText());
        extentTest.pass("Sonuc Yazisi Konsola Yazdirildi");
        extentTest.pass("Sayfa Kapatildi");
        /*
        extentTest objesi ile info() methodu kullanarak her step'de ne yaptığımızıla alakalı bilgi yazabiliriz.
        En sonunda testimizin bittiğini ifade eden pass() methodu ile testimizi ile alakalı son bilgiyi ekleyebiliriz.
        ve son olarak actions da ki perform methodu gibi ecxtentReport objesi ile flush(9 methodu kullanarak
        sonlandırırız.
        */
        extendtReports.flush();//-->bunu kullanmaz isek raporumuz oluşmaz
    }
}
