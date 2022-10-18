package com.juaracoding.selenium.pageobject;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import com.juaracoding.selenium.pageobject.pages.Login;
import com.juaracoding.selenium.pageobject.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
    public static WebDriver driver;
    private Login login;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        login = new Login();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        driver.quit();
    }

    // Yang di test ada 3 test case tetapi ada 12 step di class login

    @Test(priority = 3)
    public void testValidLogin() {
        delay(Constants.DETIK);
        login.login("Admin","admin123");
        Assert.assertEquals(login.getTxtEmployeeInformation(), "Employee Information");
        System.out.println("Test case valid login");
    }

    @Test(priority = 1)
    public void testInvalidLogin() {
        delay(Constants.DETIK);
        login.login("Admin1","admin123");
        Assert.assertEquals(login.gettxtInvalidCredentials(), "Invalid credentials");
        System.out.println("Test case invalid login");
    }

    @Test(priority = 2)
    public void testUsernamePasswordKosong() {
        delay(Constants.DETIK);
        login.login("","");
        Assert.assertEquals(login.getTxtRequired(), "Required");
        System.out.println("Test case username password kosong");
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


