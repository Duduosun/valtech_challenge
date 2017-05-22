package com.orevan.serenity.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 *
 */
public class GuineaAppEntryPage extends PageObject{

    /**
     * Guinea Entry Page
     * Office Links
     * Contact Us
     */

    private String guineaApp = "http://guineaapplication";

    private String guineaEntryPoint = "Page";
    private String officeLinks = "Office What's New";
    private String contactUsPage = "Contact Office";

    //header
    private By panelHeader = By.cssSelector(".panel.header");
    private By headerContent = By.cssSelector(".header.content");
    private By ledsLogo = By.cssSelector(".logo>img");

    //footer
    private By footerContent = By.cssSelector(".footer.content");
    private By footerLinks = By.cssSelector(".nav.item>a");

    //Body
    private By homeBody = By.cssSelector(".cms-home.cms-index");

}
