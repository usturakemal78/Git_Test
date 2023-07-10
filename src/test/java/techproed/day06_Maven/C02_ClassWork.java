package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. https://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //3. Login alanina "username" yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username", Keys.TAB);
        //4. Password alanina "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        password.sendKeys("password",Keys.TAB);
        //5. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
        driver.navigate().back();
        //6. Online banking kismi altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        //7. Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("50000",Keys.TAB);
        Thread.sleep(2000);
        //8. Tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10",Keys.TAB);
        Thread.sleep(2000);
        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
        //10."The payment was successfully submitted.
        WebElement result = driver.findElement(By.xpath("//*[@id='alert_content']"));
        System.out.println(result.isDisplayed());

    }


}
