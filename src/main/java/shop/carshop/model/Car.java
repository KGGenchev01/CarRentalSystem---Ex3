package shop.carshop.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String brand;
    private Integer horsePower;
    private String color;
    private boolean availability = true;

    public Car() {}

    public Car(Long id, String brand, Integer horsePower, String color, boolean availability) {
        this.id = id;
        this.brand = brand;
        this.horsePower = horsePower;
        this.color = color;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setCarCode(String toString) {
    }

    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", horsePower='" + horsePower + '\'' +
                ", color='" + color + '\'' +
                 ", availability='" + availability + '\'' + '}';
    }
}

