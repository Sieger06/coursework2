import enums.TaskPeriodicity;
import exceptions.IncorrectArgumentException;
import exceptions.TaskNotFoundException;
import tasks.InputUtils;
import tasks.TaskService;

import java.util.*;


public class Main {
    private static final TaskService taskService = new TaskService();
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.println("Пожалуйста выберите команду: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            add();
                            break;
                        case 2:
                            remove();
                            break;
                        case 3:
                            getAllByDate();
                            break;
                        case 4:
                            listTaskMap();
                            break;
                        case 5:
                            listRemovedTasks();
                            break;
                        case 6:
                            updateTitle();
                            break;
                        case 7:
                            updateDescription();
                            break;
                        case 8:
                            groupByDate();
                            break;
                        case 9:
                            findTask();
                            break;
                        case 0:
                            break label;
                        default:
                            System.out.println("Неизвестный пункт меню");
                    }
                } else {
                    scanner.next();
                    System.out.println("Пожалуйста, выберите пункт меню из списка!");
                }
            }
            System.out.println("Good bye!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getArgument());
        }
    }

    private static void printMenu() {
        System.out.println("Доступные команды: \n 1. Добавить задачу \n 2. Удалить задачу " +
                "\n 3. Получить задачу на указанную дату \n 4. Показать список задач \n 5. Показать список удалённых задач " +
                "\n 6. Изменить название задачи \n 7. Изменить описание задачи \n 8. Сгруппировать все задачи по дате " +
                "\n 9. Найти задачу \n 0. Выход");
    }

    private static void add() throws IncorrectArgumentException {
        System.out.println("Пожалуйста, выберите периодичность задачи: ");
        for (TaskPeriodicity taskPeriodicity : TaskPeriodicity.values()) {
            System.out.println(taskPeriodicity);
        }
        var strPeriodicity = InputUtils.askString("Your selection").toUpperCase();
        var periodicity = TaskPeriodicity.valueOf(strPeriodicity);
        taskService.add(periodicity);
    }

    private static void remove() throws TaskNotFoundException {
        int id = InputUtils.askInt("Введите ID задачи которую хотите удалить");
        taskService.remove(id);
    }

    private static void getAllByDate() throws TaskNotFoundException {
        var date = InputUtils.askDate("Введите дату");
        taskService.getAllByDate(date);
    }

    private static void listTaskMap() {
        taskService.listTaskMap();
    }

    private static void listRemovedTasks() {
        taskService.listRemovedTasks();
    }

    private static void updateTitle() {
        var id = InputUtils.askInt("Пожалуйста, введите ID задачи, заголовок которой вы хотите обновить");
        taskService.updateTittle(id);
    }

    private static void updateDescription() {
        var id = InputUtils.askInt("Пожалуйста, введите ID задачи, описание которой вы хотите обновить");
        taskService.updateDescription(id);
    }

    private static void groupByDate() {
        taskService.groupByDate();
    }

    private static void findTask() {
        var substr = InputUtils.askString("Enter substring to find");
        taskService.findTask(substr);
    }
}