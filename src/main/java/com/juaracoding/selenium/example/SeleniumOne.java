package com.juaracoding.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOne {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");

        // Instantiate a ChromeDriver class
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //Supaya jendela maximal

        String url = "https://demoqa.com/text-box";



        driver.get(url);

        String titleName = driver.getTitle();
        System.out.println(titleName);

        //inisialisasi
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
//        driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("JuaraCoding");

        WebElement userName = driver.findElement(By.xpath("//*[@id='userName']"));
        userName.sendKeys("JuaraCoding");
        System.out.println("Input userName");
        driver.findElement(By.id("userEmail")).sendKeys("info@juaracoding.com");
        System.out.println("Input userEmail");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        System.out.println("Input currentAddress");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        System.out.println("Input permanentAddress");

        // scroll vertical 1000 pixel
        js.executeScript("window.scrollBy(0,1000)");

        driver.findElement(By.id("submit")).click();

        //Delay
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Jika banyak ingin close bisa pakai driver.quit() sebaliknya pakai close()
        driver.quit();
    }
}