package models;

import strategy.BookReadFile;
import strategy.ReadFileStrategy;
import strategy.RootCropReadFile;

import java.util.List;

public class RootCrop {
    private String type;
    private double weight = 0.0;
    private String color;

    private static final ReadFileStrategy readFileStrategy = new RootCropReadFile();

    public RootCrop(RootCropBuilder rootCropBuilder) {
        type = rootCropBuilder.type;
        weight = rootCropBuilder.weight;
        color = rootCropBuilder.color;
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

    public static class RootCropBuilder {
        private String type;
        private double weight = 0.0;
        private String color;

        public RootCropBuilder(String type, double weight, String color) {
            this.type = type;
            this.weight = weight;
            this.color = color;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }

    public static List<RootCrop> ReadFile() {
        return readFileStrategy.ReadFile();
    }

    @Override
    public String toString() {
        return "RootCrop{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}