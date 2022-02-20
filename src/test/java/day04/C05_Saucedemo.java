package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Saucedemo {
    public static void main(String[] args) {



        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

        //“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
            WebElement eklenenUrun= driver.findElement(By.className("cart_item_label"));
            if (eklenenUrun.isDisplayed()){
                System.out.println("sepete eklenen urun goruldu: TEST PASS");
            }else{
                System.out.println("sepete eklenen urun gorulmedi:TEST FAILED");

            }
        //9. Sayfayi kapatin
        driver.close();

    }

}
