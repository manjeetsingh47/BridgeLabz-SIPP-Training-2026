package oops_practice.scenario_based_problems;

abstract class Vehicle {

    String vehicleNo;

    Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    abstract double fuelCost(double km);

    void display() {
        System.out.println("Vehicle No: " + vehicleNo);
    }
}

class Car extends Vehicle {

    Car(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    double fuelCost(double km) {
        return km * 8;
    }
}

class Bus extends Vehicle {

    Bus(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    double fuelCost(double km) {
        return km * 20;
    }
}

class Bike extends Vehicle {

    Bike(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    double fuelCost(double km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {

    ElectricCar(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    double fuelCost(double km) {
        return km * 2;
    }
}

public class TransportCompany {

    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car("CAR101"),
                new Bus("BUS201"),
                new Bike("BIKE301"),
                new ElectricCar("EV401")
        };

        double distance = 100;

        for (Vehicle v : fleet) {

            v.display();

            System.out.println("Fuel Cost for " + distance +
                    " km = ₹" + v.fuelCost(distance));

            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println("This is a Car.");
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println("This is a Bus.");
            } else if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println("This is a Bike.");
            } else if (v instanceof ElectricCar) {
                ElectricCar e = (ElectricCar) v;
                System.out.println("This is an Electric Car.");
            }

            System.out.println("----------------------");
        }
    }
}