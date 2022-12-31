package com.tests.smoketest;

import com.pages.DefaultPage;
import com.pages.HotelRoomPage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_C10_HotelRoomOlusturma {

    LoginPage loginpage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    HotelRoomPage hotelRoomPage = new HotelRoomPage();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        loginpage.advancedLink.click();
        loginpage.proceedLink.click();

        loginpage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginpage.password.sendKeys(ConfigReader.getProperty("manager_password"));

        loginpage.loginButton.click();

        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

    }

    @Test
    public void hotelRoomOlusturma(){

        defaultPage.
    }
}
