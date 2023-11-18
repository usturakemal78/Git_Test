package techproed.day11_Iframe_WindowHandle;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C04_Deneme extends TestBase {
    @Test
    public void text01() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String editorYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editorYazisi.contains("Editor"));
        System.out.println(editorYazisi);

       //WebElement kalinYazi = driver.findElement(By.xpath("//h3"));
       //String expectedKalinYazi = "TinyMCE WYSIWYG Editor";
       //Assert.assertTrue(kalinYazi.getText().contains(expectedKalinYazi));

        driver.switchTo().frame("mce_0_ifr");
        WebElement silinecekYazi = driver.findElement(By.xpath("//p"));
        silinecekYazi.clear();
        silinecekYazi.sendKeys("Bugün havası baya baya bi soğudu ne yapacağız bilmiyorum doğalgaz faturası da gelmeye başlayacak.");

        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        String actualelementalSelenium = driver.findElement(By.xpath("(//a)[3]")).getText();
        Assert.assertEquals("Elemental Selenium",actualelementalSelenium);





























    }
}
