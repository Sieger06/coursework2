import tasks.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        int optionGeneralMenu;

        do {
            System.out.println("********************************  \n" +
                    "1 - Добвляем новую задачку  \n" +
                    "2 - Получить план на день\n" +
                    "3 - Удалить задачку \n" +
                    "0 - Выйти из приложения");
            System.out.print("Введите номер операции - ");
            Scanner generalMenu = new Scanner(System.in);
            optionGeneralMenu = generalMenu.nextInt();
            if (optionGeneralMenu == 1) {

                Type type = null;
                String title = null;
                String description = null;
                LocalDateTime localDateTime = null;

                System.out.println(
                        "_______________ \n" +
                                "1 - Рабочая задача  \n" +
                                "2 - Личная задача");
                System.out.print("Выбери тип задачи - ");
                Scanner typeMenu = new Scanner(System.in);
                int tm = typeMenu.nextInt();
                switch (tm) {
                    case 1:
                        type = Type.WORK;
                        break;
                    case 2:
                        type = Type.PERSONAL;
                        break;
                }

                System.out.println("_______________ \n" +
                        "Введите название задачи:");
                Scanner titleMenu = new Scanner(System.in);
                title = titleMenu.nextLine();

                System.out.println("_______________ \n" +
                        "Введите описание задачи:");
                Scanner descriptionMenu = new Scanner(System.in);
                description = descriptionMenu.nextLine();

                System.out.print("_______________ \n" +
                        "Введите дату в формате (ДД.ММ.ГГГГ чч:мм) - ");
                Scanner dateMenu = new Scanner(System.in);
                String dataM = dateMenu.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                localDateTime = LocalDateTime.parse(dataM, dtf);
                System.out.println("_______________ \n" +
                        "0 - Однократная задача  \n" +
                        "1 - Ежедневная задача  \n" +
                        "2 - Еженедельная задача  \n" +
                        "3 - Ежемесячная задача  \n" +
                        "4 - Ежегодная задача");
                System.out.print("Выберите периодичность задачи - ");
                Scanner addMenu = new Scanner(System.in);
                int addMenuOption = addMenu.nextInt();
                switch (addMenuOption){
                    case 0:
                        TaskService.addTask(new OneTimeTask(type, title, description, localDateTime));
                        break;
                    case 1:
                        TaskService.addTask(new DailyTask(type, title, description, localDateTime));
                        break;
                    case 2:
                        TaskService.addTask(new WeeklyTask(type, title, description, localDateTime));
                        break;
                    case 3:
                        TaskService.addTask(new MonthlyTask(type, title, description, localDateTime));
                        break;
                    case 4:
                        TaskService.addTask(new YearlyTask(type, title, description, localDateTime));
                        break;
                }
            }

            if (optionGeneralMenu == 2) {
                System.out.print("Введите дату в формате (ДД.ММ.ГГГГ) - ");
                Scanner getTaskMenu = new Scanner(System.in);
                String gtMenu = getTaskMenu.nextLine();
                DateTimeFormatter gtm = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate taskDate = LocalDate.parse(gtMenu, gtm);
                for (Task task : TaskService.getAllByDate(taskDate)) {
                    System.out.println(task);
                }
            }

            if (optionGeneralMenu == 3) {
                System.out.print("Введите ID задачи - ");
                Scanner removeTaskById = new Scanner(System.in);
                Integer idTask = removeTaskById.nextInt();
                TaskService.removed(idTask);
            }
        } while (optionGeneralMenu != 0);



    }
}