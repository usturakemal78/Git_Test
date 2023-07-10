package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    /*
    Assertionlarda eşitlik için expected, actual olarak kullanılır
     */
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test1 başarılı bir şekilde çalıştı");
    }
    @Test
    public void test02() {
        Assert.assertEquals(3,3);
        System.out.println("Test2 başarılı bir şekilde çalıştı");
    }

    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("Test3 başarılı bir şekilde çalıştı");
    }

    @Test
    public void test04() {
        String actualName ="kemal";
        String expected ="KEMAL";
        Assert.assertEquals(expected,actualName);
        System.out.println("Test4 başarılı bir şekilde çalıştı");
    }

    @Test
    public void test05() {
        int yas = 50;
        int emeklilikyas = 65;
        Assert.assertTrue(emeklilikyas<yas);
        System.out.println("Test05 başarılı bir şelilde çalıştı");
    }

    @Test
    public void test06() {
        int yas = 50;
        int emeklilikyas = 65;
        Assert.assertFalse(emeklilikyas<yas);
        System.out.println("Test06 başarılı bir şelilde çalıştı");
    }
}
