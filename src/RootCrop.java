public class RootCrop {
    private String type;
    private double weight;
    private String color;

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

    @Override
    public String toString() {
        return "\nType:   " + this.type + "\nWeight: " + this.weight + "\nColor:  " + this.color;
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
}
