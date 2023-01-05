package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelReservationPage {

    public HotelReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "ADD ROOM RESERVATION")
    public WebElement addRoomReservation ;

    @FindBy(id="IDUser")
    public  WebElement idFirstDropDown;

    @FindBy(id="IDHotelRoom")
    public  WebElement idSecondDropDown;

    @FindBy(id="Price")
    public  WebElement price;

    @FindBy(id="DateStart")
    public  WebElement dateStart;

    @FindBy(id="DateEnd")
    public  WebElement dateEnd;

    @FindBy(id="AdultAmount")
    public  WebElement adultAmount;

    @FindBy(id="ChildrenAmount")
    public  WebElement childrenAmount;

    @FindBy(id="ContactNameSurname")
    public  WebElement contactNameSurname;

    @FindBy(id="ContactPhone")
    public  WebElement contactPhone;

    @FindBy(id="ContactEmail")
    public  WebElement contactEmail;

    @FindBy(id="Notes")
    public  WebElement notes;

    @FindBy(id="uniform-Approved")
    public  WebElement approved;

    @FindBy(id="IsPaid")
    public  WebElement isPaid;

    @FindBy(id="btnSubmit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement popupText;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement ok;

    @FindBy(xpath = "(//div[@class='modal-footer'])[2]")
    public WebElement footer;

}
