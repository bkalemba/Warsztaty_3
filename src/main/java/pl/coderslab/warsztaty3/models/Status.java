package pl.coderslab.warsztaty3.models;

public class Status {
    private static final int ID_NOT_SET = 0;

    private int id = ID_NOT_SET;
    private String description;

    public Status() {
    }

    public Status(String description) {
        this.description = description;
    }

    public Status(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
