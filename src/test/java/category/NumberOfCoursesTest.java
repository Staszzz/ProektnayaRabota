package category;

import data.CoursesCategoryData;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.BreedingCoursesPage;
import pages.DetailedCardCoursePage;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCoursesTest {
    private BreedingCoursesPage breedingCourses = null;

    private WebDriver driver;

    @BeforeEach
    public void init() {
        this.driver = new DriverFactory().create();

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.format("categories=%s", CoursesCategoryData.TESTING.name().toLowerCase()));

        this.breedingCourses = new BreedingCoursesPage(driver);
        breedingCourses.open(queryParams);
    }

    @AfterEach
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * @literal проверяем количество карточек курсов
     */
    @Test
    @Order(1)
    public void checkCountCourses() {
        breedingCourses.cardsCoursesCountShouldBeSameAs(10);
    }
    /**
     *@literal проверяем одну карточку курсов
     */
    @Test
    @Order(2)
    public void checkDataCardCourse() {
        breedingCourses.clickRandomCardCourses();
        DetailedCardCoursePage detailedCardCoursePage = new DetailedCardCoursePage(driver, "");
        detailedCardCoursePage.checkTitleCourse();
        detailedCardCoursePage.checkDescriptionCourse();
        detailedCardCoursePage.checkCourseDuration();
        detailedCardCoursePage.checkCourseFormat("Онлайн");
        }
}

