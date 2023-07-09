package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);//sağ click yapabilmek için oncelikle actions classindan bir obje olusturmaliyiz.
        actions.contextClick(kutu).     //Sag clik yapma methodu kullandik
            perform();                 //actions objemizle yapacağımız işlemi uygulaması için veya sonlandırıması için



        //Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());
        //testbase deki methodu kullandık getTextAlert() --> driver.swichTo().alert().getTex()


        //Tamam diyerek alert’i kapatın
        acceptAlert();//-->TestBase deki methodu kullandık--> driver.switchTo().alert().accept()
    }
}
