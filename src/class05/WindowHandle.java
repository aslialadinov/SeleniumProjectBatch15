package class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/InteractiveLogin/signinchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowEntry=ServiceLogin&flowName=GlifWebSignIn&service=mail&ifkv=AWnogHfLS5V6Gzjm0mMrtbwS2IpCUJpjqnhJP6lGnfgngcYfEDS_53brVvCp9QbuPoDNCplcw8YpyQ");
                driver.findElement(By.xpath("//a[text()='Help']")).click();
        //click on privacy
        driver.findElement(By.xpath("//a[text()='Privacy']")).click();
        //get the window handle of the parent window
        String parentWindowHandle=driver.getWindowHandle();
        System.out.println(parentWindowHandle);
        //get all window handles of all the windows that have been opened up
        Set<String> windowsHandle=driver.getWindowHandles();
        //print all window handles
        for(String wh:windowsHandle){
            //switch the focus of the driver to help window
            driver.switchTo().window(wh);
            //check the title of the window to which our focus is right now
            String title=driver.getTitle();
            if(title.equalsIgnoreCase("Privacy & Terms – Google")){
                break; //if title name is the desire one , we should break the loop
            }
        }
        // to verify we switched to the right wimdow
        System.out.println(driver.getTitle());
        //switch back to parent window
        driver.switchTo().window(parentWindowHandle);
    }
}
