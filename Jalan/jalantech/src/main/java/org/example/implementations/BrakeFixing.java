package org.example.implementations;

import org.example.enums.TypeOfCar;
import org.example.interfaces.IService;

import java.util.HashMap;

public class BrakeFixing implements IService {
    private int total;
    private static HashMap<Enum, Integer> price = new HashMap<>();
    static{
        price.put(TypeOfCar.HATCHBACK,1000);
        price.put(TypeOfCar.SEDAN,1500);
        price.put(TypeOfCar.SUV,2500);
    }
    @Override
    public float getTotal(TypeOfCar car) {
           total+=price.get(car);
           return total;
    }
}
