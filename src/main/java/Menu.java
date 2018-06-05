import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Menu{
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",Menu.class.getResource("chromedriver.exe").getPath());
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
        ArrayList<String> links = new ArrayList<String>();
        List<WebElement> elementsAndLinks = driver.findElements(By.cssSelector("nav#nav-sidebar ul.menu>li>a"));
        for (WebElement el : elementsAndLinks) {
            String link = el.getAttribute("href");
            if (link != null) {
                links.add(link);
            }
        }

        for (String link : links) {
            driver.get(link);
            String title = driver.findElement(By.tagName("h2")).getText();
            System.out.println(title);
            driver.navigate().refresh();
            sleep(1000);
            if (!title.equals(driver.findElement(By.tagName("h2")).getText())) {
                System.out.println("Failed");
            }
        }
    }

    public static void sleep(int timeout) {

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static WebDriver initChromeDriver () {
        System.setProperty("webdriver.chrome.driver",Menu.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver ();
    }
}