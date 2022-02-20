package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) throws InterruptedException {
        //https://www.wallmart.com/ adresine gidiniz
        //browseri tamsayfa yapiniz
        //sayfayi refresh yapiniz
        //sayfa basliginin "save ifadesi icerdigini kontrol ediniz
        //sayfa basliginin " " oldugunu kontrol ediniz
        //url nin wallmart oldugunu test edeiniz
        //hdmi kabel aratiniz
        //kac sonuc oldugunu yaziniz
        //sayfayi kapatiniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wallmart.com/");
        Thread.sleep(3456);
        WebElement cookies= driver.findElement(By.xpath("//button[@id='details-button']"));
        cookies.click();
        WebElement cookies2= driver.findElement(By.linkText("Weiter zu www.wallmart.com (unsicher)"));
        cookies2.click();
        WebElement cookies3= driver.findElement(By.xpath("//button[@class='w_HJ']"));
        cookies3.click();
        Thread.sleep(1234);
        WebElement cookies4= driver.findElement(By.xpath("//i[@class='ld ld-Close']"));
        cookies4.click();
        driver.get("https://www.wallmart.com/");
        driver.navigate().refresh();
        String actualTitle= driver.getTitle();
        String suchtWort="Save";
        if (actualTitle.contains(suchtWort)){
            System.out.println("title"+suchtWort+"kelimesini iceriyor");
             }


    }
}
