package edu.epam.figure.entity;

public class EllipseData {

    private double perimeter;
    private double square;

    public EllipseData(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public EllipseData() {

    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EllipseData)) return false;

        EllipseData that = (EllipseData) o;

        if (Double.compare(that.perimeter, perimeter) != 0) return false;
        return Double.compare(that.square, square) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(perimeter);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ellipse perimeter: ").append(perimeter)
                .append(" square: ").append(square);
        return sb.toString();
    }
}
