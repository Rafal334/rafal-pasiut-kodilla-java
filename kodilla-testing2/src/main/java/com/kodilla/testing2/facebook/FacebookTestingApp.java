package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.DriverNotFoundException;
import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String BIRTH_ROOT = "//div[@id=\"reg_form_box\"]/div[@class=\"_58mq _5dbb\"]/div[2]/span/span/";
    public static final String DAY = "select[@id=\"day\"]";
    public static final String MONTH = "select[@id=\"month\"]";
    public static final String YEAR = "select[@id=\"year\"]";

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
            driver.get("https://www.facebook.com/");

            WebElement selectDay = driver.findElement(By.xpath(BIRTH_ROOT + DAY));
            WebElement selectMonth = driver.findElement(By.xpath(BIRTH_ROOT + MONTH));
            WebElement selectYear = driver.findElement(By.xpath(BIRTH_ROOT + YEAR));
            setOption(selectDay,12);
            setOption(selectMonth,1);
            setOption(selectYear,29);
        } catch (DriverNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void setOption(WebElement element, int value){
        Select selectBoard = new Select(element);
        selectBoard.selectByIndex(value);
    }
}
