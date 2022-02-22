package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Before_After {

    //***************TestNG isim sirasina gore, JUNIT ise rasgele calistirir*******

    //uc test methodu yaziniz
    //1.method Https://www.arikanbilgisayar.com
    //2.method https://asvennes.de/
    //3.method https://www.amazon.de gitsin

    //her test methodu icin yeni bir sayfa acilsin ve test methodu sonunda kapansin
    //istiyorsak @Before ve @After notasyonlari kullanilmali
    static WebDriver driver;

    @Before
   public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void arikanTest(){
        driver.get("https://www.arikanbilgisayar.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void asvennesTest(){
        driver.get("https://asvennes.de/");
        System.out.println(driver.getTitle());

        }
        @Test
    public void amazonTest(){
        driver.get("https://www.amazon.de");
    System.out.println(driver.getTitle());

}
    @After
    public void tearDown(){
        driver.close();
}
}
