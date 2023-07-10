package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_Deneme {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void facebook() {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //(//*[@type='radio'])[2]
        WebElement adi = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        adi.sendKeys("Kasım",Keys.TAB,"Kasımbıyık",Keys.TAB);

       // WebElement soyadi = driver.findElement(By.xpath("(//*[@name='lastname']"));
       // soyadi.sendKeys("Kasımbıyık");

        WebElement cep = driver.findElement(By.xpath("//*[@name='reg_email__']"));
        cep.sendKeys("05355435453",Keys.TAB);

        WebElement sifre = driver.findElement(By.xpath("//*[@autocomplete='new-password']"));
        sifre.sendKeys("1876Ke!*");

        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));
        gun.sendKeys("16");

        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        gun.sendKeys("11");

        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        gun.sendKeys("1976");


    }
}
