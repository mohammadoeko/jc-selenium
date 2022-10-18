package com.juaracoding.selenium.pageobject;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import com.juaracoding.selenium.pageobject.pages.LoginSiloam;
import com.juaracoding.selenium.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginSiloam {
    public static WebDriver driver;
    private LoginSiloam loginSiloam;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        loginSiloam = new LoginSiloam();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        driver.quit();
    }

    // Menggunakan attribut required pada saat login tanpa ada text Required
    @Test(priority = 1)
    public void testUsernamePasswordKosong() {
        delay(Constants.DETIK);
        loginSiloam.login("", "");
        Assert.assertEquals(loginSiloam.getTxtUsernameRequired(), "true");
        Assert.assertEquals(loginSiloam.getTxtPasswordRequired(), "true");
        System.out.println("Test case username password kosong use GetAttribute");
    }

    static void delay(int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
