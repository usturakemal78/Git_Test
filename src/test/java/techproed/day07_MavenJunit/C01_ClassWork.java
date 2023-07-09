package techproed.day07_MavenJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

            //2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

            //3.Login alanine "username" yazdirin, Password alanine "password" yazdirin
           // Sign in buttonuna tiklayin
        WebElement loginPassword = driver.findElement(By.cssSelector("input#user_login"));
        loginPassword.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();

            //4.Online Banking altında Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        /*
        Bu şekilde text() ile aldığımız xpath 'de text değişse de biz o webelementi handle edebiliriz.
         */
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

            //5.amount kismina yatirmak istediginiz herhangi bir miktari yazin
            //6.tarih kismina "2020-09-10" yazdirin
        WebElement amaount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amaount.sendKeys("50000",Keys.TAB,"2023-07-09",Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(2000);

            //7.Pay buttonuna tiklayin
        WebElement payButonu = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        payButonu.submit();

            //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement sonucyazisi = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        System.out.println("Sonuç Yazısı : "+sonucyazisi.getText());
        if(sonucyazisi.getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        /*
        Webelementin görünür olup olmadığını test ettik
         */
        if (sonucyazisi.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");


        //sayfayı kapatınız annotation
        driver.close();
    }

}
