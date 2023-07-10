package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Day10_Deneme extends TestBase {
/*
    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        WebElement jsAlert = driver.findElement(By.xpath("(//button)[1]"));
        jsAlert.click();
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(1);

        WebElement actualText = driver.findElement(By.xpath("(//p)[2]"));
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText,actualText.getText());

    }

    @Test
    public void dismisAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(1);
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("(//p)[2]"));
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(expectedResult,result.getText());

    }

    @Test
    public void sendKeys() {
        //Bir method oluşturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazın OK butonuna (//button)[3]
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[3]")).click();
        driver.switchTo().alert().sendKeys("Kemal Yavuz çok çalışıyor inşaallah karşılığını alır");
        driver.switchTo().alert().accept();
        WebElement actualKemal = driver.findElement(By.xpath("(//p)[2]"));
        String expectedKemal = "Kemal";
        Assert.assertTrue(actualKemal.getText().contains(expectedKemal));

        WebElement actualKemal1= driver.findElement(By.xpath("(//p)[2]"));
        String expectedKemal1 = "You entered: Kemal Yavuz çok çalışıyor inşaallah karşılığını alır";
        Assert.assertEquals(expectedKemal1,actualKemal1.getText());


        }

*/

    @Test
    public void test01() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("(//button)[2]")).click();
        System.out.println(getTextAlert());
        Assert.assertEquals("You clicked a button",getTextAlert());
        bekle(2);
        acceptAlert();
    }
}


