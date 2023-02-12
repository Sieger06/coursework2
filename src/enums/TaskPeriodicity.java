package enums;


import tasks.*;

public enum TaskPeriodicity {
    ONETIME("Однократно") {
        @Override
        public Task createTask() {
            return new OneTimeTask();
        }
    },
    DAILY("Ежедневно") {
        @Override
        public Task createTask() {
            return new DailyTask();
        }
    },
    WEEKLY("Еженедельно") {
        @Override
        public Task createTask() {
            return new WeeklyTask();
        }
    },
    MONTHLY("Ежемесячно") {
        @Override
        public Task createTask() {
            return new MonthlyTask();
        }
    },
    YEARLY("Ежегодно") {
        @Override
        public Task createTask() {
            return new YearlyTask();
        }
    };

    private final String TaskPeriodicity;
    TaskPeriodicity(String TaskPeriodicity){
        this.TaskPeriodicity = TaskPeriodicity;
    }
    public String getTaskPeriodicity(){
        return TaskPeriodicity;
    }


    public abstract Task createTask();
}