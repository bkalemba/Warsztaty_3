package pl.coderslab.warsztaty3.models;

public class Employee {
    private static final int ID_NOT_SET = 0;

    private int id = ID_NOT_SET;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String note;
    private double hourCost;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String address, String phone, String note, double hourCost) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.hourCost = hourCost;
    }

    public Employee(int id, String firstName, String lastName, String address, String phone, String note, double hourCost) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.hourCost = hourCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getHourCost() {
        return hourCost;
    }

    public void setHourCost(double hourCost) {
        this.hourCost = hourCost;
    }
}
