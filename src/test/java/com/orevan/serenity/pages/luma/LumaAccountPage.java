package com.orevan.serenity.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaAccountPage extends PageObject {
    /**
     * My Account Dashboard
     Account Information
     Address Book
     Add New Address
     Edit Address
     My Downloadable Products
     My Orders
     Newsletter Subscription
     Billing Agreements
     My Product Reviews
     My Wish List
     View Order
     Wish List Sharing
     */

    private String accountPage = "My Account";
    private String accountBody = ".account.customer-account-index.page-layout-2columns-left";
    private String myDashboard = "My Dashboard";
    private String messageThanks = "Thank you for registering with Main Website Store";
    private String dashboardMain = ".column.main";

    private By message = By.cssSelector(".message-success.success.message");

    public void myAccountPage(){
        waitForTitleToAppear(accountPage);
        waitForTextToAppear(myDashboard);
    }
    @FindBy(css =".column.main") WebElementFacade sMyDashboard;
    public void newAccountDashboard(String ruser){
        waitForTitleToAppear(accountPage);
        waitForTextToAppear(myDashboard);
        waitForTextToAppear(messageThanks);
        waitForAnyTextToAppear(sMyDashboard, ruser);
    }
    public void myAccountDashboard(String ruser) {
        waitForTitleToAppear(accountPage);
        waitForTextToAppear(myDashboard);
        waitForAnyTextToAppear(sMyDashboard, ruser );
    }

}
