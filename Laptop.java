package Final_Work;

import java.util.Objects;

public class Laptop {
    protected String brand;         // бренд
    protected double diagonal;      // диагональ
    protected int ram;              // ОЗУ
    protected int hdc;              // объем жесткого диска
    protected String operSystem;    // оперативная система
    protected String color;         // цвет

    public Laptop(String brand, double diagonal, int ram, int hdc, String operSystem, String color) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.ram = ram;
        this.hdc = hdc;
        this.operSystem = operSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public int getRam() {
        return ram;
    }

    public int getHdc() {
        return hdc;
    }

    public String getOperSystem() {
        return operSystem;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(diagonal, laptop.diagonal) == 0 && ram == laptop.ram && hdc == laptop.hdc && Objects.equals(brand, laptop.brand) && Objects.equals(operSystem, laptop.operSystem) && Objects.equals(color, laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, diagonal, ram, hdc, operSystem, color);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", diagonal=" + diagonal + "″ inches" +
                ", ram=" + ram + "GB" +
                ", hdc=" + hdc + "GB" +
                ", operSystem='" + operSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
