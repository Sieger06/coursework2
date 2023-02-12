package tasks;

import enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getMonth().equals(getDateTime().getMonth()) & localDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
