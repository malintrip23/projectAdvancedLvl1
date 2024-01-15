package com.example.advancedworking;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(Long id){
        super(String.format("Car not found with id: %s",id));
    }

}
