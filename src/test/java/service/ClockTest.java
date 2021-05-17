package service;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {

    @Test
    public void test_return_instant_date() {
        ClockService clockService = new TestableClock();
        String date = clockService.now();
        assertEquals("17/05/2021", date);
    }


    private class TestableClock extends ClockService {
        @Override
        protected LocalDate getDate() {
            return LocalDate.of(2021, 05, 17);
        }
    }

}
