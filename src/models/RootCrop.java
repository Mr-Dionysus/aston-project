package models;

public class RootCrop {
    private final String type;
    private final double weight;
    private final String color;

    RootCrop(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type.toLowerCase();
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color.toLowerCase();
    }

    @Override
    public String toString() {
        return "Type: " + this.type + " | Weight: " + this.weight + " | Color: " + this.color;
    }

    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }

}
