package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(name = "Passwd")
    WebElement passWd;
    @FindBy(name = "ConfirmPasswd")
    WebElement confirmPassWord;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement btnNext;
    @FindBy(xpath = "//span[contains(text(),'Use 8 characters or more for your password')]")
    WebElement firstWarning;
    @FindBy(xpath = "//span[contains(text(),'Please choose a stronger password. Try a mix of letters, numbers, and symbols.')]")
    WebElement secondWarning;

    public SignUp(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void doSignUp(String password) {
        firstName.sendKeys("Shahnewaz");
        lastName.sendKeys("Abid");
        userName.sendKeys("shahnewazabid000");
        passWd.sendKeys(password);
        confirmPassWord.sendKeys(password);
        btnNext.click();
    }

    public String firstWarningMessage() {
        return firstWarning.getText();
    }

    public String secondWarningMessage() {
        return secondWarning.getText();
    }
}
