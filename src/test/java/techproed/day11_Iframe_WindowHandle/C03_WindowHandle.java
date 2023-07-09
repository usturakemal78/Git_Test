package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        /*
        Eğer sayfaya gittikten sonra yeni sekme ya da yeni bir pencereyle başka sayfaya gittikten sonra
        tekrar ilk açtığınız sayfaya dönmek isterseniz ilk sayfaya driver.get() methoduyle gittikten sonra
        String bir değişkene handle değerini assing ederseniz tekrar ilk açılan sayfaya dönmek istediğinizde
        driver.swtichTo().window(ilksayfaHandelDeğeri) ile geçiş yapabilirsinzi
         */

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");


        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        String tecproedWindowHandle = driver.getWindowHandle();
        Assert.assertEquals(expectedTitle,actualTitle);


        //Window 2'de yenibir pencerede https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW); //-->yenibir pencereye driveri i taşır
        //WindowType.TAB --> Yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeWinowHandle = driver.getWindowHandle();




        //Window 3'te yeni bir pencerede https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWinowHandle = driver.getWindowHandle();



        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(tecproedWindowHandle);


        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWinowHandle);
        
        
        
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWinowHandle);
    }

    @Test
    public void test01() {
    }
}
