package co.com.grupobolivar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AutomationTest {

    private String url = "https://www.vivaair.com/#/co/es";
    WebDriver driver;

    @BeforeTest
    public void setBaseUrl() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test(priority = 1)
    public void titleTest() throws InterruptedException {

        //Elements
        WebElement tabOneWay = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div/div/app-ibe/div/div/div[1]/app-custom-checkbox/div/span[2]"));
        WebElement station = driver.findElement(By.xpath("//*[@id=\"station\"]"));
        WebElement stationSecond = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div/div/app-ibe/div/div/div[2]/div[1]/app-station[2]/div"));
        WebElement button = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div/div/app-ibe/div/div/div[2]/button"));

        //Actions
        tabOneWay.click();
        station.click();
        Thread.sleep(3000);
        WebElement stationSelected = driver.findElement(By.xpath(".//span[text()='Barranquilla']"));
        stationSelected.click();
        stationSecond.click();
        Thread.sleep(3000);
        WebElement stationSecondSelected = driver.findElement(By.xpath(".//span[text()='Bogotá']"));
        stationSecondSelected.click();
        Thread.sleep(4000);
        WebElement dateSelected = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-home/div/div/div/app-ibe/div/div/div[2]/lib-date-picker/div[2]/lib-date-picker-calendar/div/div[2]/div[1]/div[3]/div[16]"));
        dateSelected.click();
        button.click();
        Thread.sleep(4000);

        List<WebElement> results = driver.findElements(By.className("flight"));

        Integer position = 0;
        for(WebElement element: results){
            position++;
            if(position == 2){
                element.click();
                WebElement child = element.findElement(By.className("details__flight-number"));
                System.out.println("Vuelo seleccionado: "+child.getText());
            }
        }

        Thread.sleep(3000);

        Assert.assertEquals("Viva Air | tiquetes baratos","Viva Air | tiquetes baratos");
    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }

}
