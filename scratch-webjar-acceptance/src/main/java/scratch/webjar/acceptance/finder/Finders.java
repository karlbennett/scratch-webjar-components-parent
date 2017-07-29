package scratch.webjar.acceptance.finder;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * @author Karl Bennett
 */
@Component
public class Finders {

    private final WebDriver driver;
    private final Bys by;

    public Finders(WebDriver driver, Bys by) {
        this.driver = driver;
        this.by = by;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement findByClassName(String className) {
        return driver.findElement(by.className(className));
    }

    public String findTextByClassName(String className) {
        return findByClassName(className).getText();
    }

    public void clickByText(String text) {
        clickByText(driver, text);
    }

    public void clickByText(SearchContext context, String text) {
        context.findElement(by.text(text)).click();
    }

    public void enterTextByLabel(String label, String text) {
        final WebElement input = driver.findElement(by.id(driver.findElement(by.text(label)).getAttribute("for")));
        input.clear();
        input.sendKeys(text);
    }

    public void clickByValue(String value) {
        driver.findElement(by.value(value)).click();
    }
}
