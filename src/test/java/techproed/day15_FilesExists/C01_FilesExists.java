package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
             /*
            Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
        kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
        için;
            Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
        Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
        assing ederiz.
         */
        //"C:/Users/USER/Desktop/TOKAL.pdf"
        String dosyaYolu = "C:/Users/USER/Desktop/TOKAL.pdf";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//--> Dosya varsa true yoksa false döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        String dosyayolu2 = "C:/metinbelgesi.txt";
        System.out.println(Files.exists(Paths.get(dosyayolu2)));
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu2)));
    }

    @Test
    public void test03() {
        /*
        Bir server'da farklı işletim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
        daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemini alır sonra
        her işletim sisteminin kullanıcı yolu farklı olacağından System.getProperty("user.home") bilgisayarımızda ki
        kullanıcı yolunu bu şekilde alıp String bir değişkene farklı yol ismi ile System.getProperty("os.name")
        atayarak her seferinde farklı yolları almayla uğraşmamış oluruz. Dosya diğelim ki masaüstünde ve her işletim
        sisteminde bize aynı yolu vereceği için bunu da ortsk yol olarak bir Stringe assing ederiz.
         */
        String farkliYol = "";
        String isletimSistemiAdı = System.getProperty("os.name");
        System.out.println(isletimSistemiAdı);//İşletim sistemimizin adını verir
        System.out.println((System.getProperty("user.home")));//--> bilgisayrımızdaki yolu verir
        if(isletimSistemiAdı.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 11/-->

        }else if(isletimSistemiAdı.contains("mac")){
            farkliYol = "/user/aycapolatkamali";//--> mac işletim sistemi yolu
        }
        String ortakYol = "/Desktop/TOKAL.pdf";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));
        }catch (IOException e){
            System.out.println("Dosya Bulunamadı");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));

        //Sildiğimiz dosyayı tekrar oluşturalım
        try{
            Files.createFile(Paths.get(dosyaYolu));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
        yukardaki delete işlemini kullanabiliriz
         */
    }

    @Test
    public void test04() {
        /*
        Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
        Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
        */
        String dosyayolu = "C:/Users/USER/Desktop/silinecek dosya";
        File file = new File(dosyayolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
