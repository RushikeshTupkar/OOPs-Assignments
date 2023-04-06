package org.example.station;

import org.example.enums.TypeOfCar;
import org.example.implementations.*;

import java.util.*;

public class ServiceStation {
    static List<String>servicesAvailable = new ArrayList<>();
    static {
        servicesAvailable.add("BS01 for Basic Servicing");
        servicesAvailable.add("EF01 for Engine Fixing");
        servicesAvailable.add("CF01 for Clutch Fixing");
        servicesAvailable.add("BF01 for Brake Fixing");
        servicesAvailable.add("GF01 for Gear Fixing");
    }
    Scanner sc = new Scanner(System.in);

    public Map<String,Float> getBill(String cartype, ArrayList<String> service){
           TypeOfCar car = getCarType(cartype);
           Map<String,Float> out = new HashMap<>();
        for(String ser:service){
            float price = getPrice(ser,car);
            out.put(ser,price);
        }
        return out;
    }
    public TypeOfCar getCarType(String cartype){
        cartype = cartype.toUpperCase();
        switch(cartype){
            case "HATCHBACK": return TypeOfCar.HATCHBACK;
            case "SUV":       return TypeOfCar.SUV;
            case "SEDAN":     return TypeOfCar.SEDAN;
            default:return null;
        }
    }

    public float getPrice(String code, TypeOfCar car){
        switch(code){
            case "BS01" : return new BasicServicing().getTotal(car);
            case "EF01" : return new EngineFixing().getTotal(car);
            case "CF01":  return new ClutchFixing().getTotal(car);
            case "BF01" : return new BrakeFixing().getTotal(car);
            case "GF01" : return new GearFixing().getTotal(car);
            default:return 0.00f;
        }
    }

    public void generateBill(){
                System.out.println("Please select car type - > SEDAN, SUV, HATCHBACK");
                String cartype = sc.next();
                ArrayList<String> services = new ArrayList<>();
                System.out.println("SELECT SERVICE CODE");
            for(String ele:servicesAvailable){
                System.out.println(ele);
       }        System.out.println("Select x to generate bill");
            while(true){
            String code = sc.next();
            if(code.equals("X")|| code.equals("x")){
                 System.out.println("--------------------------------------------------------------------------------");
                 Map<String,Float> map = new ServiceStation().getBill(cartype,services);
                 float total = 0;
            for(Map.Entry<String,Float>ele:map.entrySet()){
                 System.out.println(ele.getKey()+" -> "+ele.getValue());
                 total+=ele.getValue();
            }
            if(total>=1000){
                 System.out.println("Complimentry Cleaning -> Free ");
                }System.out.println("--------------------------------------------------------------------------------");
                 System.out.println("Total Bill = "+total);
                 System.out.println("--------------------------------------------------------------------------------");
                 break;
            }else{
                 services.add(code);
            }

        }
    }
}
