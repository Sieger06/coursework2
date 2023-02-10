package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private int id = idGenerator;
    private Type type;
    private String tittle;
    private String description;
    private LocalDateTime dateTime;

    //Конструкторы
    public Task(Type type, String tittle, String description, LocalDateTime dateTime){
        this.type = type;
        this.tittle = tittle;
        this.description = description;
        this.dateTime = dateTime;
        ++idGenerator;
    }

    //Методы Get и Set
    public Type getType(){
        return type;
    }
    public String getTittle(){
        return tittle;
    }
    public String getDescription(){
        return description;
    }
    public int getId(){
        return id;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setTittle(){
        this.tittle = tittle;
    }
    public void setDescription(){
        this.description = description;
    }

    //equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(type, task.type) && Objects.equals(tittle, task.tittle) && Objects.equals(description, task.description) && Objects.equals(dateTime, task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, tittle, description, dateTime);
    }

    // Метод toString
    @Override
    public String toString() {
        return "Task{" +
                "title='" + tittle + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

    // Метод appearsIn boolean
    public abstract boolean appearsIn (LocalDate localDate);

}