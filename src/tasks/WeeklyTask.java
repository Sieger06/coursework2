package tasks;

import enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(getDateTime().getDayOfWeek());
    }
}
