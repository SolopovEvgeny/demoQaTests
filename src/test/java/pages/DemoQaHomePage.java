package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQaHomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы
    private final By cardsLocator = By.xpath("//div[@class='card mt-4 top-card']");
    private final By cardElementsLocator = By.xpath(".//div[contains(@class, 'card-body')]");

    public DemoQaHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://demoqa.com");
    }

    public List<WebElement> getAllCards() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardsLocator));
    }

    public void clickCard(String cardName) {
        List<WebElement> cards = getAllCards();
        for (WebElement card : cards) {
            if (card.findElement(cardElementsLocator).getText().equals(cardName)) {
                card.click();
                break;
            }
        }
    }

    public boolean isCardClickable(String cardName) {
        try {
            List<WebElement> cards = getAllCards();
            for (WebElement card : cards) {
                if (card.findElement(cardElementsLocator).getText().equals(cardName)) {
                    return card.isEnabled() && card.isDisplayed();
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
