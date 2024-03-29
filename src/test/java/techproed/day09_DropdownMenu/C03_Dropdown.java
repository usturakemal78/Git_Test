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

public class C03_Dropdown {
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
    public void test01() throws InterruptedException {
        //programing languages ddm den istediğiniz 4 seceneği seçiniz
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //Eğer sadece seçili olan option'ları yani seçenekleri yazdırmak istersek;
        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));//-->Lambda ile

        System.out.println("-------------------------------");
        //for ile
        for (WebElement w:select.getAllSelectedOptions()) {
            System.out.println(w.getText());
        }
        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //Seçtiğimiz seçeneklerden ilkini yazdiralim, ilk seçeneğin Java olduğunu doğrulayalım
        System.out.println("-----------------------------");
        System.out.println("Seçilen Seçeneklerden İlki = "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        //Seçtiğimiz seçeneklerin hepsini kaldırlaım
        select.deselectAll();

        //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
        //diller.sendKeys("C#");
        bekle(2);

        //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectVisibleText(diller,"Java");
        bekle(2);
        //index olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectIndex(diller,2);
        bekle(2);
        //value olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectValue(diller,"js");


    }

    @After
    public void tearDown() throws Exception {
        bekle(2);
        driver.close();
    }

    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}