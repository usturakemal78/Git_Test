package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day09_Deneme {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));

        Select object = new Select(yil);
        object.selectByIndex(5);

        Select object1 = new Select(ay);
        object1.selectByValue("6");

        Select object2 = new Select(gun);
        object2.selectByVisibleText("15");


    }

    @Test
    public void test02() {
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        List<WebElement> eyaletler2 = driver.findElements(By.xpath("(//select)[5]"));
        eyaletler2.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void test03() {
        WebElement state = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(state);
        String seciliOlanSecenek = select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State",seciliOlanSecenek);
        Assert.assertTrue(seciliOlanSecenek.equals("Select a State"));
        Assert.assertTrue(seciliOlanSecenek.contains("State"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
