package scratch.webjar.acceptance.finder;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

/**
 * @author Karl Bennett
 */
@Component
public class Bys {

    public By id(String id) {
        return By.id(id);
    }

    public By className(String className) {
        return By.className(className);
    }

    public By text(String text) {
        return By.xpath(format(".//*[contains(text(),'%s')]", text));
    }

    public By value(String value) {
        return By.xpath(format(".//input[@value='%s']", value));
    }
}
