package com.ecodeuo.jdbc.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ob_cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", length = 30)
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(unique = true)
    private String licensePlate;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Double price;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // Constructor vacío (Hibernate lo necesita)
    private Car() {}

    // Constructor lleno
    public Car(Long id, String brand, String model, String licensePlate, Integer year, Double price, Boolean available, LocalDate registrationDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
        this.price = price;
        this.available = available;
        this.registrationDate = registrationDate;
    }

    // Getters y Setters
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", available=" + available +
                ", registrationDate=" + registrationDate +
                '}';
    }
}

