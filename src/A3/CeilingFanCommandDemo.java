//Command Pattern
interface Command {
    void execute();
    void undo();
}

class CeilingFan {

    private String location;
    private int speed;

    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    public CeilingFan(String location) {
        this.location = location;
        this.speed = OFF;
    }

    public void low() {
        speed = LOW;
        System.out.println(location + " Ceiling Fan is on LOW speed");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " Ceiling Fan is on MEDIUM speed");
    }

    public void high() {
        speed = HIGH;
        System.out.println(location + " Ceiling Fan is on HIGH speed");
    }

    public void off() {
        speed = OFF;
        System.out.println(location + " Ceiling Fan is OFF");
    }

    public int getSpeed() {
        return speed;
    }
}

class CeilingFanHighCommand implements Command {

    private CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {

        if (previousSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        }
        else if (previousSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        }
        else if (previousSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        }
        else {
            ceilingFan.off();
        }
    }
}

class CeilingFanOffCommand implements Command {

    private CeilingFan ceilingFan;
    private int previousSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {

        if (previousSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        }
        else if (previousSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        }
        else if (previousSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        }
        else {
            ceilingFan.off();
        }
    }
}

class RemoteControl {

    private Command command;
    private Command lastCommand;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        lastCommand = command;
    }

    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}

public class CeilingFanCommandDemo {

    public static void main(String[] args) {

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanHighCommand highCommand = new CeilingFanHighCommand(ceilingFan);

        CeilingFanOffCommand offCommand = new CeilingFanOffCommand(ceilingFan);

        RemoteControl remote = new RemoteControl();

        
        remote.setCommand(highCommand);
        remote.pressButton();

        
        remote.setCommand(offCommand);
        remote.pressButton();

        
        System.out.println("Undoing last command...");
        remote.pressUndo();
    }
}