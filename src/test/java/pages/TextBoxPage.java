package pages;

import models.TextBoxFormModel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage {
    private WebDriver driver;
    @FindBy(id = "userName")
    private WebElement fullNameInput;
    @FindBy(id = "userEmail")
    private WebElement emailInput;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "output")
    private WebElement outputDiv;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fillForm(TextBoxFormModel form) {
        fullNameInput.sendKeys(form.getFullName());
        emailInput.sendKeys(form.getEmail());
        currentAddressInput.sendKeys(form.getCurrentAddress());
        permanentAddressInput.sendKeys(form.getPermanentAddress());
    }

    public void submitForm() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isOutputDisplayed() {
        return outputDiv.isDisplayed();
    }

    public String getOutputText() {
        return outputDiv.getText();
    }
}
