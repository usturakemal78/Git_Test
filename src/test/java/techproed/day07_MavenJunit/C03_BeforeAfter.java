package techproed.day07_MavenJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver;
    @Before
    public void setUp() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void techproedTest2() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void amazonTest1() {
        driver.get("https://amazon.com");
    }//sıralamsına dikkat edelim çünkü sonuna sayısal değer verdim buna göre önce çalıştırır

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass her class dan önce birkez çalışır ");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass her class dan sonra birkez çalışır");

    }
}
