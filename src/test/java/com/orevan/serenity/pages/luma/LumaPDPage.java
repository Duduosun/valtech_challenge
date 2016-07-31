package com.orevan.serenity.pages.luma;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaPDPage extends PageObject {
    /**
     * PDP
     */

    private By gallery = By.cssSelector(".gallery-placeholder");
    private By fotoramaNodes = By.cssSelector(".fotorama__img");
    private By productRHS = By.cssSelector(".product-info-main");
    private By base = By.cssSelector(".base");
    private By reviewBlock = By.cssSelector(".product-reviews-summary");
    private By priceInfoBlock = By.cssSelector(".product-info-price");
    private By swatchOptionsNodes = By.cssSelector(".swatch-opt>div");
    private By cartBoxBlock = By.cssSelector(".box-tocart");
    private By socialLinks = By.cssSelector(".product-social-links");
    private By tabListBlock = By.cssSelector(".product.data.items");


        //method
    public void verifyPDP(String eproduct){
        shouldBeVisible(gallery);
        shouldBeVisible(fotoramaNodes);
        shouldBeVisible(productRHS);
        shouldBeVisible(base);
        shouldBeVisible(reviewBlock);
        shouldBeVisible(priceInfoBlock);
        shouldBeVisible(cartBoxBlock); //out of stock product NA
        shouldBeVisible(socialLinks);
        shouldBeVisible(tabListBlock);
        element(base).getText().equals(eproduct);
    }

    public Integer countFotorama(){
        List<WebElement> sFotoramaNodes = thenReturnElementList(fotoramaNodes);
        sFotoramaNodes.get(0).isDisplayed();
        return sFotoramaNodes.size();
    }
    public Boolean simpleOrconfigurable(){
        if (isElementVisible(swatchOptionsNodes).equals(true)){
            return true;
        } else  {
            return false;
        }
    }
}
