package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.DriverNotFoundException;
import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    public static final String SEARCHVALUE = "_nkw";

    public static void main(String[] args) {
        try {
            WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
            driver.get("https://www.ebay.com/");

            WebElement searchField = driver.findElement(By.name(SEARCHVALUE));
            searchField.sendKeys("Laptop");
            searchField.submit();
        } catch (DriverNotFoundException e) {
            System.out.println(e);
        }
    }
}
