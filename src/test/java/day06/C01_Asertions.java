package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Asertions {

    //Bestbuy sitesine gidiniz
    //sayfa url nin https://www.bestbuy.com a esit oldugunu gosteriniz
    //titleTest sayfa basliginin "Rest" icermedigini test edin
    //logoTest BestBuy logosunun goruntulendigini test edin
    // MexicosLinkTest  Mexico linkin goruntulendigini test edin
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
        Assert.assertEquals("istenen url bulunamadi",actualUrl,expectedUrl);
    }
    @Test
    public void titleTest() {
     String istenmeyenKelime="Rest";
     String actualTitle=driver.getTitle();
        Assert.assertFalse("istenmeyen kelime title da var",actualTitle.contains(istenmeyenKelime) );
    }
        @Test
        public void MexicosTest(){
        WebElement mexico= driver.findElement(By.xpath("(//img[@src='https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/mexico.svg'])[1]"));
        Assert.assertTrue("mexico logosu goruldu", mexico.isDisplayed());
    }
        @Test
        public void logoTest(){
        WebElement actualLogo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(actualLogo.isDisplayed());


    }
    @After
    public void tearDown(){
        driver.close();
    }
    }
