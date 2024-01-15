package com.example.advancedworking;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int manYear;
    private boolean isWorkk;
    private UsageT usageT;
    private String carModel;

    public Car(){

    }

    public Car(long id, String name, int manYear, boolean isWorkk, UsageT usageT, String carModel) {
        this.id = id;
        this.name = name;
        this.manYear = manYear;
        this.isWorkk = isWorkk;
        this.usageT = usageT;
        this.carModel = carModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManYear() {
        return manYear;
    }

    public void setManYear(int age) {
        this.manYear = age;
    }

    public boolean isWorkk() {
        return isWorkk;
    }

    public void setFemale(boolean female) {
        isWorkk = female;
    }

    public UsageT getUsageT() {
        return usageT;
    }

    public void setUsageT(UsageT usageT) {
        this.usageT = usageT;
    }

    public String getcarModel() {
        return carModel;
    }

    public void setcarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && manYear == car.manYear && isWorkk == car.isWorkk && Objects.equals(name, car.name) && usageT == car.usageT && Objects.equals(carModel, car.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manYear, isWorkk, usageT, carModel);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + manYear +
                ", isWorkk=" + isWorkk +
                ", ageTime=" + usageT +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}