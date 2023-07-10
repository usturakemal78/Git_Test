package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertionClassWork {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver= new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    // Aşağıdaki adları kullanarak 4 adet test methodu oluşturun ve gerekli testleri yapın

    // title Test => Sayfa başlığının "Amazon" kelimesi içerip içermediğini test edin
    @Test
    public void title() {
    String actualTitle = driver.getTitle();
    String expectedTitle = "Amazon"; //"amazon yazarsak failed verir
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    //image test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void image() {
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());
    }
    //Search Box'in erişilebilir olduğunu test edin (isEnabled())
    @Test
    public void searchBoxTest() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());

    }
    // o wrongTitleTest=> Sayfa başlığının "amazon" içermediğini doğrulayın
    @Test
    public void wrongTitleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon"; //"Amazon yazarsak failed verir çünkü içermediğini test ediyoruz
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
