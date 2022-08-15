import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class Practice_Form {
    WebDriver driver;
    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void writeText() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement txtFirstName= driver.findElement(By.id("firstName"));
        txtFirstName.sendKeys("Masum");
        WebElement txtLastName= driver.findElement(By.id("lastName"));
        txtLastName.sendKeys("Hasan");
        WebElement txtEmail= driver.findElement(By.id("userEmail"));
        txtEmail.sendKeys("masum@gmail.com");

        Actions actions = new Actions(driver);
        WebElement rdbutton = driver.findElement(By.id("gender-radio-1"));
        actions.moveToElement(rdbutton).click().build().perform();
        Thread.sleep(1000);

        WebElement txtNumber= driver.findElement(By.id("userNumber"));
        txtNumber.sendKeys("01458792565");

        WebElement txtDate = driver.findElement(By.id("dateOfBirthInput"));
        txtDate.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(1000);
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("07 Jul 2022");
        txtDate.sendKeys(Keys.ENTER);

        WebElement txtSubject = driver.findElement(By.id("subjectsInput"));
        txtSubject.sendKeys("English");
        Thread.sleep(1000);
        txtSubject.sendKeys(Keys.ENTER);
        txtSubject.sendKeys("Chemistry");
        Thread.sleep(1000);
        txtSubject.sendKeys(Keys.ENTER);
        txtSubject.sendKeys("Economics");
        txtSubject.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement ckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        actions.moveToElement(ckbox).click().build().perform();
        Thread.sleep(1000);
        WebElement ckbox2 = driver.findElement(By.xpath("//label[text()='Reading']"));
        actions.moveToElement(ckbox2).click().build().perform();
        Thread.sleep(1000);

        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\User\\Desktop\\images.jpg");
        WebElement txtAddress = driver.findElement(By.id("currentAddress"));
        txtAddress.sendKeys("Road number 11, Banani, Dhaka");
        Thread.sleep(1000);

        //driver.findElement(By.xpath("//div[contains(text(), 'NCR')]")).click();
        //WebElement dpdown = driver.findElement(By.xpath("//div[contains(text(), 'Select City')]"));
        //actions.moveToElement(dpdown).click().build().perform();
        //driver.findElement(By.xpath("//div[contains(text(), 'Delhi')]")).click();
        WebElement sb = driver.findElement(By.id("submit"));
        actions.moveToElement(sb).click().build().perform();
    }
    @After
    public void closeDriver(){
        //driver.close();
    }
}
