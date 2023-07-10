package techproed.day19_ExtentReport_WebTables;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C04_Deneme extends TestBase {
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement tablo1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1 = "+tablo1.getText());

        WebElement ucuncuSatirVerileri = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("************");
        System.out.println(ucuncuSatirVerileri.getText());

    }
}

