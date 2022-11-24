package TestCases;

import Base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchTest extends BaseClass {
    public static WebDriver driver=new EdgeDriver();

    @Given("a web browser is at the home page")
    public void aWebBrowserIsAtTheHomePage() {
        driver.get(baseUrl);
    }


    @When("user write feeding bottle to search field")
    public void userWriteFeedingBottleToSearchField() {
        driver.findElement(By.id("txtSearchBox")).click();
        driver.findElement(By.id("txtSearchBox")).sendKeys("biberon");
    }

    @And("user search")
    public void userSearch() {
        {
            waiter(9).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-star-inserted:nth-child(1) > .has-media .name")));
        }
        driver.findElement(By.id("txtSearchBox")).sendKeys(Keys.ENTER);
    }

    @And("user click first item")
    public void userClickFirstItem() {
        {
            waiter(9).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-6:nth-child(1) .is-initialized > .ng-star-inserted")));
        }

        driver.findElement(By.cssSelector(".col-6:nth-child(1) .description")).click();
    }


    @And("user add item to cart")
    public void userAddItemToCart() {

        scroll();
        {

            waiter(9).until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPlus")));
        }

        driver.findElement(By.id("addToCartBtn")).click();}

    @And("user go to the cart")
    public void userGoToTheCart() {


        {
            waiter(9).until(ExpectedConditions.textToBe(By.cssSelector(".info-text"), "Ürün Sepetinizde"));
        }


        {
            waiter(9).until(ExpectedConditions.visibilityOfElementLocated(By.id("btnShowCart")));
        }
        driver.findElement(By.id("btnShowCart")).click();
    }

    @Then("user see item in the cart")
    public void userSeeItemInTheCart() {
        {
            waiter(9).until(ExpectedConditions.visibilityOfElementLocated(By.id("iconRemoveProduct")));
        }

        assertThat(driver.findElement(By.cssSelector(".my-basket-card-wrapper > h3")).getText(), is("Seçili Ürünler (1)"));
    }

    @And("user delete the item from the cart")
    public void userDeleteTheItemFromTheCart() {
        driver.findElement(By.id("iconRemoveProduct")).click();
    }

    @And("user redirected to the homepage")
    public void userRedirectedToTheHomepage() {
        driver.findElement(By.cssSelector("#logoEbebek > img")).click();
        last();
    }
}