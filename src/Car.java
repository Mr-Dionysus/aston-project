public class Car {
    private int power = 0;
    private String model;
    private int year;

    public Car(int power, String model, int year) {
        this.power = power;
        this.model = model;
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
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
}
