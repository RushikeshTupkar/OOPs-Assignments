package org.example.implementations;

import org.example.enums.TypeOfCar;
import org.example.interfaces.IService;

import java.util.HashMap;

public class EngineFixing implements IService {
    private int total;
    private static HashMap<Enum, Integer> price = new HashMap<>();
    static{
        price.put(TypeOfCar.HATCHBACK,5000);
        price.put(TypeOfCar.SEDAN,8000);
        price.put(TypeOfCar.SUV,10000);
    }
    @Override
    public float getTotal(TypeOfCar car) {
        total+=price.get(car);
        return total;
    }
}
