package calendar;

import data.EventTypeData;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CalendarEventsPage;

public class CalendarEventsTest {

    private WebDriver driver;
    private CalendarEventsPage calendarEventsPage;

    @BeforeEach
    public void init() {
        this.driver = new DriverFactory().create();

        this.calendarEventsPage = new CalendarEventsPage(driver);
        calendarEventsPage.open();
    }

    @AfterEach
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }

    }
    /**
     * @literal даты проведения мероприятий больше или равны текущей дате
     */
    @Test
    @Order(1)
    public void validationDateEvents() {
        calendarEventsPage
                .checkVisibilityCardsEvent()
                .checkStartDateEvent();
    }
    /**
     * @literal сортируем мероприятия по типу 'Открытые вебинары'
     */
    @Test
    @Order(2)
    public void selectEventsOfType() {
        calendarEventsPage
                .selectSortedEventsType(EventTypeData.OPEN)
                .checkEventsType(EventTypeData.OPEN);
    }
}
