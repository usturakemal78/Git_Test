package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Deneme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung headphones", Keys.ENTER);
        WebElement sonucyazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String[] sonucSayisi = sonucyazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sonucSayisi[2]);
        WebElement ilkElement = driver.findElement(By.xpath("(//h2//a)[1]"));
        ilkElement.click();
        List<WebElement> tumBasliklar = driver.findElements(By.xpath("//h1 |//h2|//h3|//h4|//h5|//h6"));
        tumBasliklar.forEach(t-> System.out.println(t.getText()));
        System.out.println("****************************************");
        List<WebElement> ustBasliklar = driver.findElements(By.xpath("(//*[@class='nav-a  '])[1] | (//*[@class='nav-a  '])[2] | (//*[@class='nav-a  '])[3]|(//*[@class='nav-a  '])[4]|(//*[@class='nav-a  '])[5]"));
        ustBasliklar.forEach(t-> System.out.println(t.getText()));



    }
}

