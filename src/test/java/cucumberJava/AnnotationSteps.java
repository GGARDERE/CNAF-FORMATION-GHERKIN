package cucumberJava;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AnnotationSteps {

    WebDriver driver;

    @Given("I have opened a browser")
    public void I_have_opened_a_browser () throws Throwable{
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.fr");
 //       driver.findElement(By.id("L2AGLb")).click();
    }
    @And("I search for floorball France")
    public void i_search_for_floorball_France() throws Throwable {
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("France Floorball");
        driver.findElement(By.name("btnK")).submit();
    }

    @When("I click on the french floorball federation website")
    public void i_click_on_the_french_floorball_federation_website() throws Throwable {
        driver.findElement(By.xpath("//div/a[contains(@href,'www.floorball.fr')]/h3")).click();
    }

    @Then("the menu ou pratiquer is clickable")
    public void the_menu_is_clickable() throws Throwable {
        driver.findElement(By.xpath("//div[@id='colgauche']/div[2]/p[7]/a/img")).click();
    }





}
