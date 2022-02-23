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
public class C04_CheckBox {
    //https://the-internet.herokuapp.com/checkboxes
    //check1 ve check2 elementlerini locate ediniz
    //checkbox1 secili degilse onay kutusunu tiklayin
    //checkbox2 secili degilse onay kutusuna tiklayin
    static WebDriver driver;

    // before ve after class her method dan once calistirilir,
    // beforeclass ve afterclass ise class baslamadan once ve class bittikten sonra calistirilir
@Before
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
}
@Test
public void test1(){
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    WebElement checkBox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
    if (!checkBox1.isSelected()){
        checkBox1.click();
    }
    if (!checkBox2.isDisplayed()){
        checkBox2.click();
    }}
    @After
            public void tearDown(){
    driver.close();



}
        }

