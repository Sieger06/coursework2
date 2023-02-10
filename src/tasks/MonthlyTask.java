package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(Type type, String tittle, String description, LocalDateTime dateTime){
        super(type, tittle, description, dateTime);
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDateTime().getDayOfMonth();
    }
}
