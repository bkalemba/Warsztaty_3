package pl.coderslab.warsztaty3.models;

public class Vehicle {
    //    Model
//            Marka
//    Rok produkcji
//    Numer rejestracyjny
//    Data kolejnego przeglądu technicznego

    private static final int ID_NOT_SET = 0;

    private int id = ID_NOT_SET;
    private String brand;
    private String model;
    private int year;
    private String licensePlate;
    private String nextReview;
    private Customer customer;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int year, String licensePlate, String nextReview, Customer customer) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.nextReview = nextReview;
        this.customer = customer;
    }

    public Vehicle(int id, String brand, String model, int year, String licensePlate, String nextReview, Customer customer) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.nextReview = nextReview;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getNextReview() {
        return nextReview;
    }

    public void setNextReview(String nextReview) {
        this.nextReview = nextReview;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
