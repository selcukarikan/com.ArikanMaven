package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {
    //https://www.facebook.com adresine gidiniz
    //"Create an Account" butonuna basiniz
    //"radio buttons"elementlerini locate ediniz
    //cinsiyet secili degilse size ait olani seciniz
    static WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }
    @Test
    public void faceTest(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@title='Alle Cookies gestatten']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        WebElement radioButton= driver.findElement(By.xpath("(//label[@class='_58mt])[2]"));

        if (!radioButton.isSelected()){
            radioButton.click();

        }
    }

@After
    public void tearDown(){
        driver.close();
}
}
