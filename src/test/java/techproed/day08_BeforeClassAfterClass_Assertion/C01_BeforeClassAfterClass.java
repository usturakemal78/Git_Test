package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeCalss ve @AfterClass methodları static olmak zorundadır.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass her class dan önce birkez çalışır");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("@AfterClass her class'dan sonra birkez çalışır");
    }
    @Before
    public void setUp(){
        System.out.println("@Before her method'dan önce bir kez çalışır");
    }
    @After
    public void tearDown(){
        System.out.println("@After(tearDown) her method'dan sonra birkez çalışır)");
    }

    @Test
    public void test01() {
        System.out.println("@Test01 method'u çalıştı");
    }
    @Test
    public void test02() {
        System.out.println("@Test02 method'u çalıştı");
    }
    @Test
    public void test03() {
        System.out.println("@Test03 method'u çalıştı");
    }

}
