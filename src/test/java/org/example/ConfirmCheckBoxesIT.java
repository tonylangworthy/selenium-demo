package org.example;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfirmCheckBoxesIT {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        //Setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(920, 155));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @AfterAll
    static void teardown() {

        //Cleanup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();
        driver.quit();
    }

    @Test
    void testingCheckBoxOperations() {

        //Act

        //starting off, the first box is unchecked, but second is checked

        List<WebElement> inputTag = driver.findElement(By.tagName("form")).findElements(By.tagName("input"));
        System.out.println("Number of input tags is :  " + inputTag.size());

        System.out.println("First Input tag (checkbox) is:  " + inputTag.get(0));
        System.out.println("First Input tag's (checkbox) state is: " + inputTag.get(0).isSelected());

        //below checks the first box
        inputTag.get(0).click();
        Boolean expectedStateFirstBox = true;
        System.out.println("First Input tag's (checkbox) new state is: " + inputTag.get(0).isSelected());
        Boolean actualStateFirstBox = inputTag.get(0).isSelected();

        //Now operating on the second box which is currently checked
        System.out.println("Second Input tag (checkbox) is" + inputTag.get(1));
        System.out.println("Second Input tag's (checkbox) state is: " + inputTag.get(1).isSelected());

        //now unchecking that second box:
        inputTag.get(1).click();
        Boolean expectedStateSecondBox = false;
        System.out.println("Second Input new tag's (checkbox) state is: " + inputTag.get(1).isSelected());
        Boolean actualStateSecondBox = inputTag.get(1).isSelected();

        //verify
        assertEquals(expectedStateFirstBox, actualStateFirstBox);
        assertEquals(expectedStateSecondBox, actualStateSecondBox);
    }
}

