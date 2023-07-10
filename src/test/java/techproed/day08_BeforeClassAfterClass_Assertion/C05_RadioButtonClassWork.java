package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButtonClassWork {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void radioButton() {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //"Create an Account" button'una basın
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //"Radio buttons" elementlerini locate edin
        WebElement kadın = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        //Seçili değilse cinsiyet butonundan size uygun olanı seçin
        if(!erkek.isSelected()){
            erkek.click();
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
