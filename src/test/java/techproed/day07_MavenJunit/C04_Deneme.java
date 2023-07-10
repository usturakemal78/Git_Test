package techproed.day07_MavenJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Deneme {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void techproedTest() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Before");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("After");

    }
}

