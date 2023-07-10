package techproed.day14__Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //Given user is on https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        /*
        drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
         */
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to destination Drop here
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']")); //--> birinci drag
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']")); //--> ikinci drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

        /*
        Eğer bir hareketli web elementitutup başka bir web elementin üzerine bırakmak istersek
        sürüklemek istediğimiz web elementi alıp üzerine bırakacağımız webelemntin locatini de alarak
        dragAndDrop()kaynak,hedef) methodun ile işlemi gerçekleştirebiliriz.
         */

    }

    @Test
    public void test02() {

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basılı tuttuk
                moveToElement(drop).//--> Bu method ile basılı tuttuğumuz webelemnti diğer webelementin üzerine götürdük
                release().//-->Bu method ile basılı tuttuğumuz webelementi serbest bıraktık
                perform();//-->işlemi sonlandırdık

    }

    @Test
    public void test03() {
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(160,30).//-->Belirtmiş olduğumuz kordinatlara webelemeti taşır
                release().perform();

    }
}
