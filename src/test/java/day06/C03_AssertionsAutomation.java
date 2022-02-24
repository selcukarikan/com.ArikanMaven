package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionsAutomation {

    //https://automationpractice.com/index.php sayfasina gidinniz
    //Sign in butonuna basalim
    //Email kutusuna @ isareti olmayan bir mail yazip enter a bastigimizda
    //"Invalid email address " uyarisi ciktigini test edelim.

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get("https://automationpractice.com/index.php");

    }
    @Test
    public void invalidEmail() throws InterruptedException {
        driver.findElement(By.className("login")).click();
        Thread.sleep(2340);
        WebElement email=driver.findElement(By.id("email_create"));
        email.sendKeys("tursucuhursit"+ Keys.ENTER);
        Thread.sleep(3456);
        WebElement invalidEmailAlert= driver.findElement(By.id("create_account_error"));
        Assert.assertTrue( "Invalid email adress. yazisi gorulmedi",invalidEmailAlert.isDisplayed());

    }
}
