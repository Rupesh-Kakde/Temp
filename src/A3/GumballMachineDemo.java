//State Pattern

interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}



class GumballMachine {

    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State soldOutState;

    private State state;
    private int count;

    public GumballMachine(int numberOfGumballs) {

        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        count = numberOfGumballs;

        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void dispense() {
        state.dispense();
    }

    public void releaseBall() {

        System.out.println(
                "A gumball comes rolling out!");

        if (count > 0) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void printStatus() {

        System.out.println(
                "\nGumballs remaining: " + count);
    }
}



class NoQuarterState implements State {

    private GumballMachine machine;

    public NoQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {

        System.out.println(
                "You inserted a quarter.");

        machine.setState(
                machine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {

        System.out.println(
                "You haven't inserted a quarter.");
    }

    @Override
    public void turnCrank() {

        System.out.println(
                "You turned, but there's no quarter.");
    }

    @Override
    public void dispense() {

        System.out.println(
                "You need to pay first.");
    }
}



class HasQuarterState implements State {

    private GumballMachine machine;

    public HasQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {

        System.out.println(
                "You can't insert another quarter.");
    }

    @Override
    public void ejectQuarter() {

        System.out.println(
                "Quarter returned.");

        machine.setState(
                machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {

        System.out.println(
                "You turned the crank.");

        machine.setState(
                machine.getSoldState());
    }

    @Override
    public void dispense() {

        System.out.println(
                "No gumball dispensed.");
    }
}



class SoldState implements State {

    private GumballMachine machine;

    public SoldState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {

        System.out.println(
                "Please wait, we're already giving you a gumball.");
    }

    @Override
    public void ejectQuarter() {

        System.out.println(
                "Sorry, you already turned the crank.");
    }

    @Override
    public void turnCrank() {

        System.out.println(
                "Turning twice doesn't get you another gumball.");
    }

    @Override
    public void dispense() {

        machine.releaseBall();

        if (machine.getCount() > 0) {

            machine.setState(
                    machine.getNoQuarterState());

        } else {

            System.out.println(
                    "Oops, out of gumballs!");

            machine.setState(
                    machine.getSoldOutState());
        }
    }
}



class SoldOutState implements State {

    private GumballMachine machine;

    public SoldOutState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {

        System.out.println(
                "Sorry, the machine is sold out.");
    }

    @Override
    public void ejectQuarter() {

        System.out.println(
                "You can't eject a quarter.");
    }

    @Override
    public void turnCrank() {

        System.out.println(
                "You turned, but there are no gumballs.");
    }

    @Override
    public void dispense() {

        System.out.println(
                "No gumball dispensed.");
    }
}



public class GumballMachineDemo {

    public static void main(String[] args) {

        GumballMachine machine =
                new GumballMachine(2);

        machine.printStatus();

      
        machine.insertQuarter();
        machine.turnCrank();
        machine.dispense();

        machine.printStatus();

        
        machine.insertQuarter();
        machine.turnCrank();
        machine.dispense();

        machine.printStatus();

       
        machine.insertQuarter();
    }
}