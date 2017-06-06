package com.valtech.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by tolaf on 05/06/2017.
 */
public class ValtechHomePage extends PageObject {

    private String valtechUrl = "https://www.valtech.com/";
    private String valtechHomePageTitle = "Where Experiences are Engineered - Valtech";


    @FindBy(css = ".headblock__mediabanner.media-banner.fixed-height.video")
    private WebElementFacade latestNews;

    public void gotoValtech(){
        openAt(valtechUrl);
    }

    public String expectedValtechHomePage(){
        return valtechHomePageTitle;
    }

    public void verifyLatestNewsBanner(){
        shouldBeVisible(latestNews);
    }

}
