package com.orevan.serenity.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaCatPage extends PageObject {
    /**
     * 2nd Level Cat
     * 3rd Level Cat
     * Search Results
     */

    private By topCatNodes = By.cssSelector("#ui-id-2>li>a");
    private By secondCatNodes = By.cssSelector("#ui-id-2>li>ul>li>a");
    private By womenTops = By.cssSelector("#ui-id-9");
    private By womenBottoms = By.cssSelector("#ui-id-10");
    private By menTops = By.cssSelector("#ui-id-17");
    private By menBottoms = By.cssSelector("#ui-id-18");
    private By bags = By.cssSelector("#ui-id-25");
    private By fitnessEquipment = By.cssSelector("#ui-id-26");
    private By watches = By.cssSelector("#ui-id-27");
    private By videoDownload = By.cssSelector("#ui-id-28");
    private By productNodes = By.cssSelector(".product-item-info");
    private By productLinkNodes = By.cssSelector(".product-item-link");
    private By breadcrumbsNodes = By.cssSelector(".breadcrumbs>ul>li");
    private By pageHeading = By.cssSelector(".base");
    private By shoppingOptions = By.cssSelector(".block-subtitle.filter-subtitle");
    private By filterOptionNodes = By.cssSelector(".filter-options-title");
    private By productToolbarNodes = By.cssSelector(".toolbar.toolbar-products");
    private By activeGridSwitchNodes = By.cssSelector(".modes-mode.active.mode-grid");
    private By inactiveGridSwitchNodes = By.cssSelector("#mode-grid");
    private By activeListSwitchNodes = By.cssSelector(".modes-mode.active.mode-list");
    private By inactiveListSwitchNodes = By.cssSelector("#mode-list");
    private By colorSwatchNodes = By.cssSelector(".swatch-attribute.color");
    private By sizeSwatchNodes = By.cssSelector(".swatch-attribute.size");
    private By searchProduct = By.cssSelector("#search");
    private By emptySearchNotice = By.cssSelector(".message.notice");


    //methods
    public void clickSecondCatINT(Integer tcat) {
        List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
        withAction().moveToElement(sTopCatNodes.get(tcat)).perform();
        List<WebElement> sSecondCatNodes = thenReturnElementList(secondCatNodes);
        sSecondCatNodes.get(0).click();
    }

    public void clickSecondCat(String tcat, String scat) {
        List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
        for (WebElement iTopCat : sTopCatNodes) {
            if (iTopCat.getText().equals(tcat)) {
                withAction().moveToElement(iTopCat).perform();
            }
        }

        switch (scat) {
            case "Women Tops":
                String wtop = element(womenTops).getText();
                element(womenTops).click();
                element(pageHeading).getText().equals(wtop);
                break;
            case "Women Bottoms":
                String wbottom = element(womenBottoms).getText();
                element(womenBottoms).click();
                element(pageHeading).getText().equals(wbottom);
                break;

            case "Men Tops":
                String mtop = element(menTops).getText();
                element(menTops).click();
                element(pageHeading).getText().equals(mtop);
                break;
            case "Men Bottoms":
                String mbottom = element(menBottoms).getText();
                element(menBottoms).click();
                element(pageHeading).getText().equals(mbottom);
                break;

            case "Bags":
                String bag = element(bags).getText();
                element(bags).click();
                element(pageHeading).getText().equals(bag);
                break;
            case "Fitness Equipment":
                String fitness = element(fitnessEquipment).getText();
                element(fitnessEquipment).click();
                element(pageHeading).getText().equals(fitness);
                break;
            case "Watches":
                String watch = element(watches).getText();
                element(watches).click();
                element(pageHeading).getText().equals(watch);
                break;

            case "Video Download":
                String video = element(videoDownload).getText();
                element(videoDownload).click();
                element(pageHeading).getText().equals(video);
                break;
        }
    }

    public Integer countProducts() {
        List<WebElement> sProductNodes = thenReturnElementList(productNodes);
        sProductNodes.get(2).isDisplayed();
        return sProductNodes.size();
    }

    public Integer countBreadcrumbs() {
        List<WebElement> sBreadcrumbsNodes = thenReturnElementList(breadcrumbsNodes);
        sBreadcrumbsNodes.get(1).isDisplayed();
        return sBreadcrumbsNodes.size();
    }

    public Integer countFilterOptions() {
        shouldBeVisible(shoppingOptions);
        List<WebElement> sFilterOptionNodes = thenReturnElementList(filterOptionNodes);
        sFilterOptionNodes.get(1).isDisplayed();
        return sFilterOptionNodes.size();
    }

    public Integer countToolbarNodes() {
        List<WebElement> sToolbarNodes = thenReturnElementList(productToolbarNodes);
        sToolbarNodes.get(0).isDisplayed();
        sToolbarNodes.get(1).isDisplayed();
        return sToolbarNodes.size();
    }

    public void verifyPLPGridView() {
        List<WebElement> sActiveGridSwitch = thenReturnElementList(activeGridSwitchNodes);
        List<WebElement> sInactiveListSwitch = thenReturnElementList(inactiveListSwitchNodes);
        shouldBeVisible(sActiveGridSwitch.get(0));
        shouldNotBeVisible(inactiveGridSwitchNodes);
        shouldBeVisible(sInactiveListSwitch.get(0));
        shouldNotBeVisible(activeListSwitchNodes);
    }

    public void verifyPLPListView() {
        List<WebElement> sActiveListSwitch = thenReturnElementList(activeListSwitchNodes);
        List<WebElement> sInactiveGridSwitch = thenReturnElementList(inactiveGridSwitchNodes);
        shouldBeVisible(sActiveListSwitch.get(0));
        shouldNotBeVisible(inactiveListSwitchNodes);
        shouldBeVisible(sInactiveGridSwitch.get(0));
        shouldNotBeVisible(activeGridSwitchNodes);
    }

    public void switchToListView() {
        clickOn(element(inactiveListSwitchNodes));
    }

    public void switchToGridView() {
        clickOn(element(inactiveGridSwitchNodes));
    }

    public String verifySimpleProduct(String sproduct) {
        shouldNotBeVisible(colorSwatchNodes);
        shouldNotBeVisible(sizeSwatchNodes);

        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        String espot = null;
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().equals(sproduct)) {
                espot = iProduct.getText();
            }
        }
        return espot;
    }

    public String verifyConfigurableProduct(String cproduct) {
        shouldBeVisible(colorSwatchNodes);
        shouldBeVisible(sizeSwatchNodes);

        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        String espot = null;
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().equals(cproduct)) {
                espot = iProduct.getText();
            }
        }
        return espot;
    }

    public void clickProduct(String eproduct) {
        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().equals(eproduct)) {
                iProduct.click();
                break;
            }
        }
    }

    @FindBy (css = ".base") WebElementFacade sBase;
    public void searchProduct(String search){
        String searchConstant = "Search results for:";
        element(searchProduct).sendKeys(search);
        element(searchProduct).sendKeys(Keys.ENTER);
        waitForTextToAppear(sBase, searchConstant + " " + "'" + search + "'");
        waitForTitleToAppear(searchConstant + " " + "'" + search + "'");
    }
    @FindBy (css = ".message.notice") WebElementFacade sEmptySearchNotice;
    public void emptyResultMessage(String message){
        shouldBeVisible(emptySearchNotice);
        shouldNotBeVisible(productLinkNodes);
        shouldNotBeVisible(productNodes);
        shouldNotBeVisible(productToolbarNodes);
        waitForTextToAppear(sEmptySearchNotice, message);
    }

}

//evaluateJavascript("document.getElementById('firstname').focus()");
//withAction().moveToElement($("#item-tabs")).perform();
  //      $(".buy-button button").click();

//evaluateJavascript("$('#firstname').focus()");