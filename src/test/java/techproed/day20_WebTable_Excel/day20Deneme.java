package techproed.day20_WebTable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class day20Deneme {
    /*
        Excel dosyasından veri okuyabilmek için pom.xml dosyamıza poi.ooxml dependecy'lerinini
        yüklememiz gerekir
        Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techproed>resources packge'i içine
        koyyarız.
         */
    @Test
    public void test01() throws IOException {
        //1 - Dosya yolunu alırız
        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        //2- Dosyayı okuyabilmemiz için Javada akışa almamız gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3 - Java ortamında bir excel dosyası oluşturabilmemiz için
        Workbook workbook = WorkbookFactory.create(fis);//-->Akışa aldığımız dosyayı okuyoruz

        //4 - Oluşturuğumuz excel'den sayfa(sheet) seçmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");

        //5 - Bellirtiğimiz sayfadaki satır (row) seçmemiz gerekir
        Row row = sheet.getRow(0);//--Satır da index 0 sıfıdan başladığı için satırı getirir

        //6 - Bellirttiğimiz satırdaki hücre bilgisini seçmemiz gerekir
        Cell cell = row.getCell(0);

        // Son olarak cell bilgisini sout ile yazdırıp excel deki 1. satır 1. hücredeki veriyi görebiliriz.
        System.out.println(cell);

    }

    @Test
    public void test02() throws IOException {
        //1. satır ve 1. sutundaki verileri yazdıralım
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println("1. Satir 1 Sutun Bilgisi : "+satir1Sutun1);
    }

    @Test
    public void test03() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));
        String satir3Sutun1= workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. satir 1. sutun bilgisi"+satir3Sutun1);
        Assert.assertEquals("France",satir3Sutun1);
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());
    }
}
