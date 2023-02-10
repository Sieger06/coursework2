package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(Type type, String tittle, String description, LocalDateTime dateTime){
        super(type, tittle, description, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getMonth().equals(getDateTime().getMonth()) & localDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
