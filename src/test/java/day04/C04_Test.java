package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C04_Test {
    public static void main(String[] args) {
        //        //1. http://zero.webappsecurity.com sayfasina gidin
        //sign in butonuna tiklayiniz
        //login alanina "username"
        //passwort alanina "password yaziniz
        //sign in butonuna tiklayiniz
        //online banking yazisina tiklayiniz
        //pay bills sayfasina gidiniz
        //amount kismina 500 miktarini giriniz
        //tarih kismina 2023-02-02 giriniz
        //pay butonuna tiklayiniz
        //"The payment was successfully submitted." mesajinin goruldugunu kontrol ediniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://zero.webappsecurity.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("signin_button")).click();

        WebElement user= driver.findElement(By.xpath("//input[@id='user_login']"));
        user.sendKeys("username");

        WebElement pass= driver.findElement(By.xpath("//input[@id='user_password']"));
        pass.sendKeys("password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        WebElement amount= driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("500");

        WebElement date= driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2023.03.25");

        driver.findElement(By.xpath("//input[@value='Pay']")).click();

        WebElement actualSucces=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        String actualSucces2=actualSucces.getText();
        String expectedSucces="The payment was successfully submitted.";

        if (actualSucces2.equals(expectedSucces)){
            System.out.println("expected succes title ile actual succes title esittir. Test PASS");
        } else{
            System.out.println("expected succes title ile actual succes title esit degil. Test FAILED");
        }
        System.out.println(actualSucces2);
        System.out.println(expectedSucces);

    }
}
