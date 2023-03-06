package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatingElements {
    public static void main(String[] args) {
        //tell your project where the webdriver is located
        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");

        //create an instance of WebDriver
        WebDriver driver=new ChromeDriver();

        //to open up facebook.com
        driver.get("https://www.facebook.com/");

        //send in the username
        driver.findElement(By.id("email")).sendKeys("moazzam");//send-keys is to send info to write in username box

        //send the password
        driver.findElement(By.name("pass")).sendKeys("abracadabra");

        //click on the button create new account
       // driver.findElement(By.linkText("Create new account")).click();

        //click on forgotten password
        driver.findElement(By.partialLinkText("password?")).click();

        driver.quit();




    }

}
