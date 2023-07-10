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

public class C04_CheckBoxClassWork {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void checkBox() throws InterruptedException {

    //Verilen web sayfasına gidin
    //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    //Checkbox1 ve ceheckbox2 elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input)[2]"));
        Thread.sleep(2000);
    //Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()||checkBox1.isSelected()){//seçili değilse
            checkBox1.click();//checkbox click yap
        }
        Thread.sleep(2000);
    //Checkbıx2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2.isSelected()||checkbox2.isSelected()){
            checkbox2.click();
            Thread.sleep(2000);
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
