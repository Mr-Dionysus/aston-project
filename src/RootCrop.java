public class RootCrop {
    private String type;
    private double weight = 0.0;
    private String color;

    public RootCrop(String type, double weight, String color) {
        this.type = type;
        this.weight = weight;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
