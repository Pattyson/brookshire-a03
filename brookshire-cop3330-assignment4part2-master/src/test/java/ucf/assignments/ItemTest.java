package ucf.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class ItemTest {
    //Field date of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    Item item = new Item("description", LocalDate.of(2021, Month.JULY, 11), Boolean.TRUE);

    @Test
    void testToString() {
        String result = item.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetCompletedBoolean() {
        String result = item.getCompletedBoolean(Boolean.TRUE);
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

