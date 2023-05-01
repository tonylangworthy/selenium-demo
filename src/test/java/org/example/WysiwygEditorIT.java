package org.example;

import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WysiwygEditorIT {

    private static WebDriver driver;

    @BeforeAll
    static void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/tinymce");
    }

    @AfterAll
    static void teardown() {

        //Cleanup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();
        driver.quit();
    }

    @Test
    void testingWysiwygEditorVerifiesThatContentIsAdded(){

        // Act
        String expectedContent = "Here is some content!";

        driver.switchTo().frame(0);

        WebElement wysiwygElement = driver.findElement(By.id("tinymce"));
        wysiwygElement.clear();
        wysiwygElement.sendKeys(expectedContent);

        String actualContent = driver.findElement(By.id("tinymce")).getText();

        // Verify
        assertEquals(expectedContent, actualContent);
    }
}
