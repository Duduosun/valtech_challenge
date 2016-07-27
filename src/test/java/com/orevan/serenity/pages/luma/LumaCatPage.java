package com.orevan.serenity.pages.luma;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaCatPage extends PageObject {
    /**
     * 2nd Level Cat
     3rd Level Cat
     Search Results
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

            //methods
        public void clickSecondCatINT(Integer tcat){
            List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
            withAction().moveToElement(sTopCatNodes.get(tcat)).perform();
            List<WebElement> sSecondCatNodes = thenReturnElementList(secondCatNodes);
            sSecondCatNodes.get(0).click();
        }
        public void clickSecondCat(String tcat, String scat){
            List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
            for (WebElement iTopCat : sTopCatNodes) {
                if (iTopCat.getText().equals(tcat)) {
                    withAction().moveToElement(iTopCat).perform();
                }
            }

            switch (scat) {
                case "Women Tops":
                element(womenTops).click();
                break;
                case "Women Bottoms":
                element(womenBottoms).click();
                break;

                case "Men Tops":
                    element(menTops).click();
                    break;
                case "Men Bottoms":
                    element(menBottoms).click();
                    break;

                case "Bags":
                    element(bags).click();
                    break;
                case "Fitness Equipment":
                    element(fitnessEquipment).click();
                    break;
                case "Watches":
                    element(watches).click();
                    break;

                case "Video Download":
                    element(videoDownload).click();
                    break;
            }
        }

        public Integer countProducts(){
            List<WebElement> sProductNodes = thenReturnElementList(productNodes);
            sProductNodes.get(2).isDisplayed();
            return sProductNodes.size();
        }
        public void verifyPLPGridView(){

        }
}

//evaluateJavascript("document.getElementById('firstname').focus()");
//withAction().moveToElement($("#item-tabs")).perform();
  //      $(".buy-button button").click();

//evaluateJavascript("$('#firstname').focus()");