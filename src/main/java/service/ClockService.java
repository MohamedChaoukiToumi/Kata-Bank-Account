package service;

import lombok.Builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
public class ClockService {
    public String now() {
        LocalDate now = getDate();
        return now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    protected LocalDate getDate() {
        return LocalDate.now();
    }
}
