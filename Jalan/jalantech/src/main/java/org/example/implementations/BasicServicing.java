package org.example.implementations;

import org.example.enums.TypeOfCar;
import org.example.interfaces.IService;

import java.util.HashMap;

public class BasicServicing implements IService {
    private int total;
    private static HashMap<Enum, Integer> price = new HashMap<>();
    static{
        price.put(TypeOfCar.HATCHBACK,2000);
        price.put(TypeOfCar.SEDAN,4000);
        price.put(TypeOfCar.SUV,5000);
    }
    @Override
    public float getTotal(TypeOfCar car) {
        total+=price.get(car);
        return total;
    }
}
