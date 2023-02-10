package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(Type type, String tittle, String description, LocalDateTime dateTime){
        super(type, tittle, description, dateTime);
    }
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(getDateTime().toLocalDate());
    }
}
