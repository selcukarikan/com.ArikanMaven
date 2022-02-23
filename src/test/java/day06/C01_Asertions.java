package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Asertions {

    //Bestbuy sitesine gidiniz
    //sayfa url nin https://www.bestbuy.com a esit oldugunu gosteriniz
    //titleTest sayfa basliginin "Rest" icermedigini test edin
    //logoTest BestBuy logosunun goruntulendigini test edin
    // FrancaisLinkTest  Fransizca linkin goruntulendigini test edin
   static WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void urlTest(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("istenen url bulunamadi",expectedUrl,actualUrl);
    }
    @Test
    public void titleTest() {
        St
    }
        @Test
        public void FrancaisTest(){
    }}
        @Test
        public void logoTest(){
}

        }
