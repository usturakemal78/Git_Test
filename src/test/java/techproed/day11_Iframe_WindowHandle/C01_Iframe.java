package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
    Bir HTML dökümanının içine yerletirilmiş başk bir HTML dökümanına inline frame yani IFRAME denir.
    Bir sayfada iframe varsa iframe içindeki web elementi handel edebilmek için swicTo() methodu ile ifram'e
    geçiş yapmamız gerekir . Eğer geçiş yapmassak nosuchelemetexception alırız.
        Aletr'ten farkı alert çıktığında hiçbir webelementi locate edemeyiz. Iframe olsada locate edereiz fakat
        handle edemeyiz.
     */

    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin = driver.findElement(By.xpath("//p[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));



        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//-->geçiş yapmazsak  Nosouchelementexception hatası alırız.
        String ApplicationListYazisi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(ApplicationListYazisi);
        Assert.assertEquals("Applications lists",ApplicationListYazisi);

        //Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz
        driver.switchTo().defaultContent();
        driver.get(driver.getCurrentUrl());// driver.navigate().refresh() de yapılabilirdi
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

        /*
        Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */

        //Son olarak sayfadaki iframe yazısının görünüt olduğunu test edin
        //driver.switchTo().defaultContent();
        //String poveredBy = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        //System.out.println(poveredBy);

    }
}
