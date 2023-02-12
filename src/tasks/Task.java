package tasks;

import enums.Type;
import exceptions.IncorrectArgumentException;

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
    public Task(){
        idGenerator++;
        id = idGenerator;
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
    public void setTittle(String taskTittle){
        this.tittle = tittle;
    }
    public void setDescription(String taskDescription){
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
        return String.format("id: %d, type: %s, title: %s, description: %s, date and time: %s", id, type, tittle,
                description, InputUtils.dateTimeToString(dateTime));
    }

    public void askData() throws IncorrectArgumentException {
        System.out.println("Please select task type:");
        for (Type taskType : Type.values()) {
            System.out.println(taskType);
        }
        type = Type.valueOf(InputUtils.askString("Ваш выбор").toUpperCase());
        tittle = InputUtils.askString("Title");
        if (tittle == null || tittle.isBlank() || tittle.isEmpty()) {
            throw new IncorrectArgumentException("Введите правильное название");
        }
        description = InputUtils.askString("введите описание");
        if (description == null || description.isBlank() || description.isEmpty()) {
            throw new IncorrectArgumentException("Введите правильное описание");
        }
        dateTime = InputUtils.askDateTime("Введите дату и время");
    }

    public abstract boolean appearsIn(LocalDate localDate);

    public boolean contains(String substr) {
        var strId = String.valueOf(id);
        var strType = String.valueOf(type);
        return strId.contains(substr)
                || tittle.toLowerCase().contains(substr)
                || strType.toLowerCase().contains(substr)
                || InputUtils.dateTimeToString(dateTime).toLowerCase().contains(substr)
                || description.toLowerCase().contains(substr);
    }
}