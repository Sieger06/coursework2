package tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();
    public static void addTask(Task task){
        taskMap.put(task.getId(), task);
    }
    public static void removed(Integer id){
        taskMap.remove(id);
    }
    public static ArrayList<Task> getAllByDate (LocalDate localDate){
        ArrayList <Task> allTaskByDate = new ArrayList<>();
        for (Task task : taskMap.values()) {
            if (task.appearsIn(localDate)){
                allTaskByDate.add(task);
            }
        }
        return allTaskByDate;
    }

    public static void getAllTask (){
        for (Task t :taskMap.values()) {
            System.out.println(t);
        }
    }

}
