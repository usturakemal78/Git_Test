package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {
    /*
    Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu pencereye sağ tik
    yapıp locate alamıyorsak, bu bir js Alert'tür
    js Alert'ü handle edebilmek için driver'imizi o pencereye geçirmemiz gerekir. Bunun için;
    driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
    accept() yada dismis() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız.
        accept()  --> onaylar
        dismiss() --> iptal eder
     */

    @Test
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin
        //Bir method oluşturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK bıtonuna tıklayın ve result mesajını " you seccessfully clicked an alert" olduğunu test edin
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(3);
        driver.switchTo().//geçmek için kullanılan method
                alert().//alert'e geçiş yapar
                accept();//çıkan alert'te ok ya da tamam butonuna tıklar
        bekle(2);
        WebElement resultMessage = driver.findElement(By.xpath("//*[@id='result']"));
        String istenenYazi ="You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());

    }

    @Test
    public void dismissAlert() {
         //Bir method oluşturun : dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajını seccessfully" içermediğini test edin
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
        driver.switchTo().
                alert().
                dismiss();//js Alert'teki iptal butonuna basar
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));//You clicked: Cancel
        String istenenMetin ="successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenMetin));
        bekle(2);
        driver.close();
    }

    @Test
    public void sendKeysAlert() {
        //Bir method oluşturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazın OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("Kemal");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));//You entered: Kemal
        String girilenMetin ="Kemal";
        Assert.assertTrue(resultMessage.getText().contains(girilenMetin));
        bekle(2);
            //Aşağıdaki kod ise contains ile equal arasındaki farkı anlamak için yaptım
        WebElement resultMessage1 = driver.findElement(By.xpath("(//p)[2]"));//You entred: Kemal
        String istenilenMetin ="You entered: Kemal";
        Assert.assertEquals(istenilenMetin,resultMessage1.getText());
        bekle(2);


    }
}

