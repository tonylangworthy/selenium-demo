package org.example;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddDeleteElementIT {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        //Setup
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(920, 155));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    void testingAddElement() {

        //Act
        driver.findElement(By.cssSelector("button")).click();

        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        Integer actualNumberDeleteButtons = elements.size();
        Integer expectedNumberDeleteButtons = 1;

        System.out.println("the number of added manually elements is:  " + elements.size());

        //verify
        assertEquals(expectedNumberDeleteButtons, actualNumberDeleteButtons);

        //Cleanup
        driver.close();
    }

    @Test
    void testingDeleteElement() {

        //Act
        driver.findElement(By.cssSelector("button")).click();

        driver.findElement(By.className("added-manually")).click();

        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        Integer actualNumberDeleteButtons = elements.size();

        Integer expectedNumberDeleteButtons = 0;
        //verify
        assertEquals(expectedNumberDeleteButtons, actualNumberDeleteButtons);

        //Cleanup
        driver.close();
    }
}

