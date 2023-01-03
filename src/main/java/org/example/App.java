package org.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

    }

    @Test
    public void verifyFreeTrialIsDisplayed(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://portal.mms.mckesson.com/contact-us");

        String expectedFullName = "Tony L";

        WebElement fullNameElement = driver.findElement(By.name("contactUsFullName"));
        fullNameElement.sendKeys(expectedFullName);

        System.out.println("Text: " + fullNameElement.getText());

        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("contactUsFullName")));

        String actualFullName = firstResult.getText();

        Assert.assertEquals(expectedFullName, actualFullName);
    }

    @Test
    public void verifyCoursePreviewIsDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='course-page-hero']//div[@class='ps-button section'][2]"))
                .isDisplayed());
    }

}
