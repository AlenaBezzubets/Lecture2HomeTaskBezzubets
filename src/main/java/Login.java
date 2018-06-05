import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login{
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",Login.class.getResource("chromedriver.exe").getPath());
        WebDriver driver = initChromeDriver();
        driver.get ("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement fieldLogin = driver.findElement(By.id("email"));
        fieldLogin.sendKeys( "webinar.test@gmail.com");
        WebElement fieldPass = driver.findElement(By.id("passwd"));
        fieldPass.sendKeys( "Xcg7299bnSmMuRLp9ITw");
        WebElement button = driver.findElement(By.name("submitLogin"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        button.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement icon = driver.findElement(By.id("employee_infos"));
        icon.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

    }
    public static WebDriver initChromeDriver () {
        System.setProperty("webdriver.chrome.driver",Login.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver ();
    }
}