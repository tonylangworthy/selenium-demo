package org.example;

import java.time.Duration;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WysiwygEditorFT {

    @Test
    public void verifyFreeTrialIsDisplayed(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/tinymce");

        String expectedContent = "Here is some content!";

        WebElement fullNameElement = driver.findElement(By.id("tinymce"));
        fullNameElement.sendKeys(expectedContent);

        System.out.println("Text: " + fullNameElement.getText());

//        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

//        String actualFullName = firstResult.getText();

//        assertEquals(expectedContent, actualFullName);
    }
}
