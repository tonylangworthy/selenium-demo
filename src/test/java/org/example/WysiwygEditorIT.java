package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WysiwygEditorIT {

    private static WebDriver driver;

    @BeforeAll
    static void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/tinymce");
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
