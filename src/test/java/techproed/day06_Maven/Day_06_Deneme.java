package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day_06_Deneme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://amazon.com/ sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //"Samsung headphones" ile arama yapalım
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayısını yazdıralım
        WebElement sonucYazısı = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String []sonucSayısı = sonucYazısı.getText().split(" ");
        System.out.println("Sonuc Sayısı = "+sonucSayısı[2]);

        //ilk ürüne tıklayalım
        WebElement ilkUrun = driver.findElement(By.xpath("(//h2//a)[1]"));
        ilkUrun.click();

        //Sayfadaki tüm başlıkları yazdıralım
        List<WebElement> sayfaBaşlıkları = driver.findElements(By.xpath("//h1 | //h2 | //h3 | //h4 | //h5 | //h6"));
        sayfaBaşlıkları.forEach(t-> System.out.println(t.getText()));

    }
}
