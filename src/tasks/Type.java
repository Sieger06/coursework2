package tasks;

public enum Type {
    WORK("Рабочая задача"),
    PERSONAL("Личная задача");
    private final String type;
    Type (String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public String toString(){
        return type;
    }
}