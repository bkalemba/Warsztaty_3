package pl.coderslab.warsztaty3.models;

public class Order {
    private static final int ID_NOT_SET = 0;

    private int id = ID_NOT_SET;
    private Vehicle vehicle;
    private Employee employee;
    private Status status;
    private String created;
    private String expectedStart;
    private String actualStart;
    private String customerDescription;
    private String employeeDescription;
    private double finalCost;
    private double partsCost;
    private double workHours;

    public Order() {
    }

    public Order(Vehicle vehicle, Employee employee, Status status, String created) {
        this.vehicle = vehicle;
        this.employee = employee;
        this.status = status;
        this.created = created;
    }

    public Order(Vehicle vehicle, Employee employee, Status status, String created, String expectedStart, String actualStart, String customerDescription, String employeeDescription, double finalCost, double partsCost, double workHours) {
        this.vehicle = vehicle;
        this.employee = employee;
        this.status = status;
        this.created = created;
        this.expectedStart = expectedStart;
        this.actualStart = actualStart;
        this.customerDescription = customerDescription;
        this.employeeDescription = employeeDescription;
        this.finalCost = finalCost;
        this.partsCost = partsCost;
        this.workHours = workHours;
    }

    public Order(int id, Vehicle vehicle, Employee employee, Status status, String created, String expectedStart, String actualStart, String customerDescription, String employeeDescription, double finalCost, double partsCost, double workHours) {
        this.id = id;
        this.vehicle = vehicle;
        this.employee = employee;
        this.status = status;
        this.created = created;
        this.expectedStart = expectedStart;
        this.actualStart = actualStart;
        this.customerDescription = customerDescription;
        this.employeeDescription = employeeDescription;
        this.finalCost = finalCost;
        this.partsCost = partsCost;
        this.workHours = workHours;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getExpectedStart() {
        return expectedStart;
    }

    public void setExpectedStart(String expectedStart) {
        this.expectedStart = expectedStart;
    }

    public String getActualStart() {
        return actualStart;
    }

    public void setActualStart(String actualStart) {
        this.actualStart = actualStart;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    public String getEmployeeDescription() {
        return employeeDescription;
    }

    public void setEmployeeDescription(String employeeDescription) {
        this.employeeDescription = employeeDescription;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }
}
