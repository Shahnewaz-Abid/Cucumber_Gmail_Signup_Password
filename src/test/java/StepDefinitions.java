import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.SignUp;

import java.time.Duration;

public class StepDefinitions {
    public WebDriver driver;
    SignUp signUp;

    @Given("user visits to signup page")
    public void user_visits_to_signup_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.com%2F%3Fhl%3Dbn&hl=en&dsh=S604501925%3A1650773815093805&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
    }
    @When("user inputs {string}")
    public void user_inputs(String short_password) {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        signUp.doSignUp(short_password);
    }
    @Then("user cannot signup")
    public void user_cannot_signup() {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        String text = signUp.firstWarningMessage();
        Assert.assertEquals(text,"Use 8 characters or more for your password");
        driver.close();
    }
    @When("user enters {string}")
    public void user_enters(String weak_password) {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        signUp.doSignUp(weak_password);
    }
    @Then("user cannot signup again")
    public void user_cannot_signup_again() {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp(driver);
        String text = signUp.secondWarningMessage();
        Assert.assertEquals(text, "Please choose a stronger password. Try a mix of letters, numbers, and symbols.");
        driver.close();
    }
}