package techproed.day14__Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //Arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tusunu serbest bırakararak
        WebElement aramakaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramakaKutusu, Keys.SHIFT).//-->Arama kutusunda shift tuşuna bastık
                sendKeys("selenium").//Selenium metnini shift tusunu basılı kalldığı için büyük harfle yazdık.
                keyUp(Keys.SHIFT).//shift tuşunu serbest bıraktık
                sendKeys("-java",Keys.ENTER).//--> Bu kısmı shift i serbest bıraktığımız için küçük yazdı
                perform();
    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tusunu serbest bırakararak
        WebElement aramakaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
        /*
        Mause işlemleri için actions class'ını kullanmamız gerkir. Fakat bir metin kutusunda ki klavye işlemleri için
        actions class'ına sendKeys() methodu il de istediğimiz bir metni büyük yazdırılabilir,
        hatta birden fazla klavye tuşlarına bastırabiliriz. Yukarıdaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
        sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harfle yazdırdı.
         tekrar Keys.SHIFT kullanarak shift tuşunu serbest bırakmış olduk.
         */

    }

    @Test
    public void test03() {
        //Google sayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusuna "Selnium" yazın ve enter tuşuna basın
        WebElement aramakaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakaKutusu.sendKeys("Selenium",Keys.ENTER);

        //Sayfayı bekleyin
        bekle(4);

        //Arattığınız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"a");//metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//-->Seçilen metni ctrl+x ile kestik
        bekle(2);

        //Tekrar google sayfasına girip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//-->Kestiğimiz metni ctrl+v tuşu ile tekrar arama kutusuna yapıştırdık ve arattık.
    }
}
