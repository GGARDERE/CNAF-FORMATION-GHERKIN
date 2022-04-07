package cucumberJava;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class JPetStoreSteps {

WebDriver driver;


    @Given("J'instancie le navigateur {string}")
    public void j_instancie_le_navigateur(String navigateur) {
        if (navigateur.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

            driver = new ChromeDriver();
        }
        else {

            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }



    @When("j'arrive sur l'url  {string}")
    public void j_arrive_sur_l_url(String string) {

        driver.get(string);
        // Write code here that turns the phrase above into concrete actions

    }



    @When("J'accede à la page de connexion")
    public void j_accede_à_la_page_de_connexion() {
    driver.findElement(By.xpath("//a[.=\"Sign In\"]")).click();

    }



    @When("je me connecte avec l'identifiant {string} et le password {string}")
    public void je_me_connecte_avec_l_identifiant_et_le_password(String string1, String string2) {
        WebElement champUsername= driver.findElement(By.name("username"));
        WebElement champPassword=driver.findElement(By.name("password"));
        champUsername.clear();
                champUsername.sendKeys(string1);
        champPassword.clear();
                champPassword.sendKeys(string2);

                driver.findElement(By.name("signon")).click();
    }


    @Then("je verifie que je suis connecté en tant que l'utilsateur {string}")
    public void je_verifie_que_je_suis_connecté_en_tant_que_l_utilsateur_ABC(String nom) {
        WebElement messageBienvenu = driver.findElement(By.id("WelcomeContent"));

        Assert.assertTrue(messageBienvenu.getText().equalsIgnoreCase("Welcome "+nom+"!"));

    }




}
