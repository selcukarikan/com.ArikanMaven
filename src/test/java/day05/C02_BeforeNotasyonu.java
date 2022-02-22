package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeNotasyonu {
    //amazon sayfasina gidip 3 farkli test methodu hazirlayiniz
    //her methodda farkli adimlar yapalim

        static WebDriver driver;
    WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));

    @BeforeClass

    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");

    }
    @Test
    public void test1(){
        searchBox.clear();
        searchBox.sendKeys("lIGE WATCH"+ Keys.ENTER);
    }
    @Test
    public void test2(){
        searchBox.clear();

        searchBox.sendKeys("swatch watch"+ Keys.ENTER);
    }
    @Test
    public void test3(){
        searchBox.clear();
        searchBox.sendKeys("momentus WATCH"+ Keys.ENTER);
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
