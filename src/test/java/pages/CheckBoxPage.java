package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBoxPage {
    private final WebDriver driver;

    @FindBy(css = "button.rct-collapse-btn")
    private List<WebElement> toggleButtons;

    @FindBy(css = "span.rct-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(id = "result")
    private WebElement resultBlock;

    @FindBy(css = "span.rct-title")
    private List<WebElement> checkboxLabels;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://demoqa.com/checkbox");
    }

    public void toggleAllFolders() {
        toggleButtons.forEach(WebElement::click);
    }

    public void selectCheckboxByLabel(String label) {
        for (int i = 0; i < checkboxLabels.size(); i++) {
            if (checkboxLabels.get(i).getText().equals(label)) {
                checkboxes.get(i).click();
                break;
            }
        }
    }

    public boolean isResultDisplayedFor(String item) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(resultBlock))
                .getText().contains(item.toLowerCase());
    }
}
