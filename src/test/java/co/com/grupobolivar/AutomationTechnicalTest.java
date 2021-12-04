package co.com.grupobolivar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTechnicalTest {

    private String url = "https://demoqa.com/";
    WebDriver driver;

    @BeforeTest
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test(priority = 1)
    public void titleTest(){
        Assert.assertEquals(driver.getTitle(),"ToolsQA");
    }

    @Test(priority = 2)
    public void urlTest(){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(priority = 3)
    public void clickInForms(){
        driver.findElement(By.className("banner-image")).click();

        //Thread.sleep(5000);

    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }

}
