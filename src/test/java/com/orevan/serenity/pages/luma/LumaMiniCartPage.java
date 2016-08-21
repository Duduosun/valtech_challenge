package com.orevan.serenity.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by tolaf on 20/08/2016.
 */
public class LumaMiniCartPage extends PageObject {

    private By miniCart = By.cssSelector("#ui-id-1");
    private By emptyCart = By.cssSelector(".subtitle.empty>span");
    private By miniCartItems = By.cssSelector(".minicart-items-wrapper");
    private By miniProductNodes = By.cssSelector("#ui-id-1>div>div>div>ol>li>div>div>strong>a");
    private By miniEditNodes = By.cssSelector("#ui-id-1>div>div>div>ol>li>div>div>div>div>a.action.edit");
    private By miniDeleteNodes = By.cssSelector("#ui-id-1>div>div>div>ol>li>div>div>div>div>a.action.delete");
    private By miniCheckout = By.cssSelector("#top-cart-btn-checkout");
    private By viewEditCart = By.cssSelector(".action.viewcart>span>span");
    private By miniClose = By.cssSelector("#btn-minicart-close");
    private By showMiniCart = By.cssSelector(".action.showcart");
    private By removePopupOkay = By.cssSelector(".action-primary.action-accept");
    private By miniCounter = By.cssSelector(".action.showcart>span.counter.qty");
    private By minQTY = By.cssSelector(".details-qty.qty>input");


    //methods
    public String miniCartProducts(){
        return element(miniCart).waitUntilVisible().getText();
    }


    public void emptyMiniCart(){
        shouldBeVisible(miniCart);
        shouldBeVisible(emptyCart);
        Assert.assertTrue(element(emptyCart).getText().contains("You have no items in your shopping cart"));
    }
    public void verifyMiniCart(){
        shouldBeVisible(miniCart);
        shouldBeVisible(viewEditCart);
        shouldBeVisible(miniCheckout);
    }
    @FindBy(css = ".action.showcart") private WebElementFacade sShowMiniCart;
    public void openMiniCart(){
        clickOn(sShowMiniCart);
    }
    @FindBy(css = "#btn-minicart-close") private WebElementFacade sMiniClose;
    public void closeMiniCart(){
        clickOn(sMiniClose);
    }
    public void goToCheckout(){
        clickOn(element(miniCheckout));
    }
    public void goToBasket(){
        clickOn(element(viewEditCart));
    }
    public void noMiniCart(){
        shouldNotBeVisible(miniCart);
        shouldNotBeVisible(miniCheckout);
    }

}

