package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(Type type, String tittle, String description, LocalDateTime dateTime){
        super(type, tittle, description, dateTime);
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(getDateTime().getDayOfWeek());
    }
}
