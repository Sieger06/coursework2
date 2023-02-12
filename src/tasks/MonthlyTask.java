package tasks;

import enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
