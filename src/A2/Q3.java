interface Workshop {
    void work();
}


class Produce implements Workshop {
    public void work() {
        System.out.println("Vehicle Produced");
    }
}


class Assemble implements Workshop {
    public void work() {
        System.out.println("Vehicle Assembled");
    }
}


abstract class Vehicle {

    protected Workshop produce;
    protected Workshop assemble;

    public Vehicle(Workshop produce, Workshop assemble) {
        this.produce = produce;
        this.assemble = assemble;
    }

    abstract void manufacture();
}


class Car extends Vehicle {

    public Car(Workshop produce, Workshop assemble) {
        super(produce, assemble);
    }

    public void manufacture() {
        System.out.println("Car:");
        produce.work();
        assemble.work();
    }
}


class Bike extends Vehicle {

    public Bike(Workshop produce, Workshop assemble) {
        super(produce, assemble);
    }

    public void manufacture() {
        System.out.println("Bike:");
        produce.work();
        assemble.work();
    }
}

public class Q3 {

    public static void main(String[] args) {

        Vehicle car = new Car(new Produce(), new Assemble());

        Vehicle bike = new Bike(new Produce(), new Assemble());

        car.manufacture();

        System.out.println();

        bike.manufacture();
    }
}