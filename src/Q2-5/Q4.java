interface Car {
    void showDetails();
}

class NorthAmericaCar implements Car {
    public void showDetails() {
        System.out.println("North America Car: SUV, Left-hand drive");
    }
}

class EuropeCar implements Car {
    public void showDetails() {
        System.out.println("Europe Car: Hatchback, Right-hand drive");
    }
}

interface CarSpecification {
    void showSpecification();
}

class NorthAmericaSpecification implements CarSpecification {
    public void showSpecification() {
        System.out.println("North America specification");
    }
}

class EuropeSpecification implements CarSpecification {
    public void showSpecification() {
        System.out.println("Europe specification");
    }
}

interface CarFactory {
    Car createCar();
    CarSpecification createSpecification();
}

class NorthAmericaFactory implements CarFactory {
    public Car createCar() {
        return new NorthAmericaCar();
    }

    public CarSpecification createSpecification() {
        return new NorthAmericaSpecification();
    }
}

class EuropeFactory implements CarFactory {
    public Car createCar() {
        return new EuropeCar();
    }

    public CarSpecification createSpecification() {
        return new EuropeSpecification();
    }
}

public class Q4 {
    public static void main(String[] args) {
        CarFactory northAmerica = new NorthAmericaFactory();
        northAmerica.createCar().showDetails();
        northAmerica.createSpecification().showSpecification();

        System.out.println();

        CarFactory europe = new EuropeFactory();
        europe.createCar().showDetails();
        europe.createSpecification().showSpecification();
    }
}
