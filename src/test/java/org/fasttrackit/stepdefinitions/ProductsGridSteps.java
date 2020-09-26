package org.fasttrackit.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fasttrackit.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import webviews.ProductsGrid;

import java.util.ArrayList;
import java.util.List;

public class ProductsGridSteps extends TestBase {

    private ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

    @When("I select the option {string} in the Sort By list")
    public void iSelectTheOptionInTheSortByList(String sortCriteria) {
        productsGrid.getSortByList().selectByVisibleText(sortCriteria);
    }

    @And("I sort the products in ascending direction")
    public void iSortTheProductsInAscendingDirection() {
        if (productsGrid.getSortDirectionButton().getAttribute("class").contains("--desc")) {
            productsGrid.getSortDirectionButton().click();
        }

    }

    @And("I sort the products in descending direction")
    public void iSortTheProductsInDescendingDirection() {
        if (productsGrid.getSortDirectionButton().getAttribute("class").contains("--asc")) {
            productsGrid.getSortDirectionButton().click();
        }
    }

    @Then("the products are ordered by price in descending order")
    public void theProductsAreOrderedByPriceInDescendingOrder() {

        List<Double> prices = new ArrayList<>();

        for (WebElement priceContainer : productsGrid.getProductPrices()) {
            String priceText = priceContainer.getText();

            double price = Double.parseDouble(priceText.split());
        }
    }
}
