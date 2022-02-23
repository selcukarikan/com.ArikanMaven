package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_YoutubeAssertions {

   static WebDriver driver;

    @BeforeClass

    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://www.youtube.com");
    }
    @Test
    public void titleTest(){
     String actualTitle= driver.getTitle();
     String expectedTitle="YouTube";
        Assert.assertEquals("sayfa basligi Youtube dan farkli ",expectedTitle,actualTitle);

    }
    @Test
    public void imageTest(){
        WebElement imageYoutube= driver.findElement(By.xpath("(//a[@class='yt-simple-endpoint style-scope ytd-topbar-logo-renderer'])[1]"));
    Assert.assertTrue("youtube logosu gorunmuyor", imageYoutube.isDisplayed());
    }
    @Test
    public void searchBox(){
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='search_query']"));
        Assert.assertTrue("search kutusu erisilmiyor", searchBox.isEnabled());
    }
    @Test
    public void wrongTitle(){
        String istenmeyenTitle= "youtube";
        String actualTitle=driver.getTitle();
        Assert.assertFalse("sayfa basligi youtube",istenmeyenTitle.equals(actualTitle));
    }
@AfterClass
    public static void tearDown(){
        driver.close();
}


}
