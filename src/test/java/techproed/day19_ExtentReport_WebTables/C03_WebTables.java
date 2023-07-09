package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {
    /*
    WEBTABLE;
        <table> tagı ile başlar
            <thead> başlıklar için bu tag ile devam eder
                <tr> başlıkların satırı
                    <th> table head
                    <td> başlıktaki veriler
                <tbody> başlıklar altındaki verileri temsil eder
                        <tr> table row(satır)
                            <td> table data (tablodaki veri)

     */
    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*********************************************");
        System.out.println(ucuncuSatir.getText());

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        //last() --> istenilene göre son satir yada sütün bilgilerini verir
        System.out.println("1. Tablo Son Satir Bilgileri : "+sonSatir.getText());

        //    Task 4 : 5. Sütun verilerini yazdırın
        System.out.println("**********************************");
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText());//-->5. sütun başlığı
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));

        //    Task 5 : 3. satirdaki 1. ve 2. sütun bilgileriniz yazdiriniz
        System.out.println("**********************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatirr.forEach(t-> System.out.print(t.getText()+"\t"));


        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData



        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println("****************************");
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));
        printdata(2,3);
    }

    private void printdata(int satir, int sutun) {
        WebElement satirSutun =driver.findElement(By.xpath("//tbody[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }
}