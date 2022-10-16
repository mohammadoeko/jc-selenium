package com.juaracoding.selenium.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTwo {
    public static void main(String[] args) {
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/checkbox";
        driver.get(url);

        int detik = 1;

        WebElement titleMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div"));
        System.out.println("Title Menu: " + titleMenu.getText());

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[3]")).click();
        System.out.println("Home Checklist");

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        System.out.println("Button Toggle Clicked");

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[3]")).click();
        System.out.println("Desktop UnChecklist");

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[3]")).click();
        System.out.println("Documents UnChecklist");

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[3]")).click();
        System.out.println("Downloads UnChecklist");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // Menu Radio Button
        driver.findElement(By.id("item-2")).click();

        delay(detik);
        WebElement titleMenuTwo = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div"));
        System.out.println("Title Menu: " + titleMenuTwo.getText());

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")).click();
        System.out.println("Yes Radio Clicked");

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).click();
        System.out.println("Impressive Radio Clicked");

        // radio button dengan js executor
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
        js.executeScript("arguments[0].click();", yesRadio);
        System.out.println("Yes Radio Clicked use JavascriptExecutor");
        js.executeScript("arguments[0].click();", impressiveRadio);
        System.out.println("Impressive Radio Clicked use JavascriptExecutor");

        driver.get("https://www.google.com");
        System.out.println("Google");
        WebElement inputSearch = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        delay(detik);
        inputSearch.sendKeys("Wikipedia");
        delay(detik);
        inputSearch.sendKeys(Keys.ENTER);       //Keyboard event

        driver.navigate().back();
        System.out.println("Navigate Back");

        driver.get("https://demoqa.com/select-menu");
        System.out.println("Select Menu");
        js.executeScript("window.scrollBy(0,500)");
        delay(detik);
        WebElement elementSelect = driver.findElement(By.id("oldSelectMenu"));
        Select oldSelectMenu = new Select(elementSelect);

        // 3 cara untuk test select
        oldSelectMenu.selectByIndex(1);
        delay(detik);
        oldSelectMenu.selectByValue("10");
        delay(detik);
        oldSelectMenu.selectByVisibleText("Magenta");

        delay(3);
        driver.quit();
    }

        static void delay(int detik) {
            // delay
            try {
                Thread.sleep(1000 * detik);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}