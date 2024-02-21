package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BreedingCoursesPage extends AbsBasePage {

    private Logger logger = LogManager.getLogger(BreedingCoursesPage.class);
    public BreedingCoursesPage(WebDriver driver) {
        super(driver, "/catalog/courses");
    }
    @FindBy(xpath = "//section//div[not(@style)]/a[contains(@href, '/lessons/')][.//h6]")
    private List<WebElement> cardsCourses;




    public void cardsCoursesCountShouldBeSameAs(int count) {
        Assertions.assertEquals(
                count,
                cardsCourses.size(),
                String.format("Count cards courses should be %d", count)

        );
        logger.info("check count courses. Cards = 10");
    }

    public void clickRandomCardCourses() {
        faker.options().nextElement(cardsCourses).click();
        logger.info("check random card courses success");
    }
}
