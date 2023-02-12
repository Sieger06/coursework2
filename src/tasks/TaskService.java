package tasks;

import enums.TaskPeriodicity;
import exceptions.IncorrectArgumentException;
import exceptions.TaskNotFoundException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final Set<Task> removedTasks = new HashSet<>();

    public void add(TaskPeriodicity taskPeriodicity) throws IncorrectArgumentException {
        var tp = taskPeriodicity.createTask();
        tp.askData();
        taskMap.putIfAbsent(tp.getId(), tp);
        System.out.println("Task created: " + tp);
    }

    public void remove(int id) throws TaskNotFoundException {
        Task task = taskMap.get(id);
        removedTasks.add(task);
        taskMap.values().removeIf(t -> t.getId() == id);
        System.out.printf("Задача '%s' была удалена и помещена в архив \n", task);
        if (task == null) {
            throw new TaskNotFoundException("Нет задачи с этим идентификатором: " + id);
        }
    }

    public void getAllByDate(LocalDate localDate) throws TaskNotFoundException {
        for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
            LocalDate taskDate = taskMap.getValue().getDateTime().toLocalDate();
            if (taskDate.equals(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            }
            else if (localDate.isAfter(taskDate) && taskMap.getValue().appearsIn(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            } else throw new TaskNotFoundException("На эту дату нет ни одной задачи");
        }
    }

    public void listTaskMap() {
        System.out.println("Актуальный список задач: ");
        for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
            System.out.println(taskMap.getKey() + " " + taskMap.getValue());
        }
    }

    public void listRemovedTasks() {
        System.out.println("Удалить список задач: ");
        removedTasks.forEach(System.out::println);
        if (removedTasks.size() == 0) {
            System.out.println("Нет удаленных задач");
        }
    }

    public void updateTittle(int id) {
        var taskTittle = InputUtils.askString("Введите новое название");
        taskMap.get(id).setTittle(taskTittle);
        System.out.printf("Название задачи с ID: %d было изменено на: %s \n",
                id, taskMap.get(id).getTittle());
    }

    public void updateDescription(int id) {
        var taskDescription = InputUtils.askString("Введите новое описание");
        taskMap.get(id).setDescription(taskDescription);
        System.out.printf("Описание задачи с ID: %d было изменено на: %s \n",
                id, taskMap.get(id).getDescription());
    }

    public void groupByDate() {
        System.out.println("Доступные задачи, сгруппированные по дате: ");
        Comparator<Map.Entry<Integer, Task>> myComparator = Comparator.comparing(o -> o.getValue().getDateTime());
        Map<Integer, Task> sortedMap = taskMap.entrySet().stream()
                .sorted(myComparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        sortedMap.entrySet().forEach(System.out::println);
    }

    public void findTask(String substr) {
        var tmp = substr.toLowerCase();
        taskMap.values().stream()
                .filter(task -> task.contains(tmp))
                .forEach(System.out::println);
    }
}
