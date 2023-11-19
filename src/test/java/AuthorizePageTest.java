import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class AuthorizePageTest {
    WebDriver driver;

    @Before
    public void openCon() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://code-basics.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void shouldLoginSuccess() {
        driver.findElement(By.xpath("//a[contains(text(),'Вход')]")).click();
        driver.findElement(By.xpath("//*[@data-testid='email']")).sendKeys("avtotest.petrovich@mail.ru");

        driver.findElement(By.xpath("//*[@data-testid='password']")).sendKeys("88AvtoP!");
        driver.findElement(By.xpath("//*[@data-testid='submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='bi bi-person-circle']")).isDisplayed());

    }

    @After
    public void closeCon() {
        driver.close();
    }

}

