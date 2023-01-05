package org.vehicle;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSuccessIT {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        //Setup
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(920, 155));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://dms.webbdealer.com/login");
        System.out.println("dummy");
    }

    @AfterAll
    static void teardown() {

        //Cleanup
        driver.close();
    }

    @Test
    void testingCheckBoxOperations() {

        //Act

        driver.findElement(By.name("email")).sendKeys("tony@webbdealer.com");
        driver.findElement(By.name("password")).sendKeys("Acura21");

        driver.findElement(By.cssSelector(".btn-primary")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Boolean isSuccessful = driver.findElement(By.linkText("Log Out")).;

        List<WebElement> numLogOuts = driver.findElements(By.linkText("Log Out"));

        List<WebElement> logOutbyClass = driver.findElements(By.className("dropdown-toggle"));

        int actualNumberLogElements = 0;
        for (WebElement oneElement : logOutbyClass) {
            System.out.println("one element is:  " + oneElement);
            System.out.println("and its text is:  " + oneElement.getText());
            if (oneElement.getText().equals("Tony Langworthy")) {
                actualNumberLogElements = 1;
            }
        }

        System.out.println("logOUtbyClass is:  " + logOutbyClass);
        int expectedNumberLogElements = 1;

        //verify
        assertEquals(expectedNumberLogElements, actualNumberLogElements);


    }


}
