package techproed.day07_MavenJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    /*
        Notasyonlara sahip methodlar oluşturabilmek için mause+sağtik+gererate(kısayol alt+insert) yaparak
        after methodu için teardown'u seçeriz
        before methodu için setup'ı seçeriz
        test methodu için de test'i seçeriz
            junit frameworkunde testlerimizi sıralama yapabilmek için ekstra bir notasyon yoktur
            Eğer belli bir sırlalamada çalıştırmak istersek method isimlerini alfabetik ve sayıl olarak belirmemiz gerekir.
            aşağıda test sıralamsı sıralama değiştiği için bakabillirsin...
         */
    @After
    public void tearDown() {
        System.out.println("After her test methodundan sonra bir kez çalışır");

    }
    @Before
    public void setUp(){
        System.out.println("Before her test methodundan önce bir kez çalışır");
    }
    @Test
    public void test1() {
        System.out.println("Test1 methodu çalıştı");
    }
    @Test
    public void test3() {
        System.out.println("Test3 methodu çalıştı");
    }
    @Test
    public void test2() {
        System.out.println("Test2 methodu çalıştı");
    }
}
