package techproed.day17_Exeptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION
            -Bir Webelementin locatini yalnış aldığımızda elemanı bulamayacağı için bu
            exception'i alırız
         */

        //techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        //eğer hatalı bir şekilde //*[@type='ssearch'] yazssa idik yani fazladan bir (s) eklendi
        // NoSuchException alırdık dene ve gör
        //NosuchException aldığımızda hangi satıda olduğumuzu gösteriyor.
        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığınınn qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@type='search']"));
        /*
        org.openqa.seleniumInvalidSelectorException: xpath ile aldığımız bir webelementin locat'ini
        cssSelector ile kullanırsak bu exception'ı alırız. Dolayısyla bunu handle etmek
        için doğru locator'ı kullanmamız gerekir.
         */

        //sayfa başlığınınn qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }
}
