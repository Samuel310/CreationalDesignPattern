package com.dp.Factory_Method;
import java.util.Scanner;

enum VehicleType {
    VT_TwoWheeler,    VT_ThreeWheeler,    VT_FourWheeler
}

abstract class Vehicle {
    abstract void printVehicle();
    static Vehicle Create(VehicleType type) {
        if (type == VehicleType.VT_TwoWheeler)
            return new TwoWheeler();
        else if (type == VehicleType.VT_ThreeWheeler)
            return new ThreeWheeler();
        else if (type == VehicleType.VT_FourWheeler)
            return new FourWheeler();
        else return null;
    }
}

class TwoWheeler extends Vehicle {
    @Override
    public void printVehicle() {
        System.out.println("I am two wheeler");
    }
}

class ThreeWheeler extends Vehicle {
    @Override
    public void printVehicle() {
        System.out.println("I am three wheeler" );
    }
}

class FourWheeler extends Vehicle {
    @Override
    public  void printVehicle() {
        System.out.println("I am four wheeler");
    }
}

class Main {
    public static void main(String ar[]) {
        //Scanner s=new Scanner(System.in);
        //String str=s.next();
        //VehicleType type = VehicleType.valueOf(str);
        Vehicle  pVehicle = Vehicle.Create(VehicleType.VT_TwoWheeler);
        pVehicle.printVehicle();
    }
}
