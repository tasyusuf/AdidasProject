package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCart;

    public void navigateTo(String product, String category){
        Driver.get().findElement(By.linkText(category)).click();
        Driver.get().findElement(By.linkText(product)).click();
    }

    public void addToCart(){
        addToCart.click();
    }
}
