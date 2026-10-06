interface Command {

    void execute();

    void undo();
}



class Light {

    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}



class Fan {

    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}



class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}



class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}



class FanOnCommand implements Command {

    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}



class FanOffCommand implements Command {

    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on();
    }
}



class RemoteControl {

    private Command[] commands;

    public RemoteControl() {
        commands = new Command[4];
    }

    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }

    public void pressButton(int slot) {
        commands[slot].execute();
    }

    public void pressUndoButton(int slot) {
        commands[slot].undo();
    }
}



public class RemoteControlDemo {

    public static void main(String[] args) {

    
        Light light = new Light();
        Fan fan = new Fan();

        
        Command lightOn =
                new LightOnCommand(light);

        Command lightOff =
                new LightOffCommand(light);

        Command fanOn =
                new FanOnCommand(fan);

        Command fanOff =
                new FanOffCommand(fan);

       
        RemoteControl remote =
                new RemoteControl();

       
        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);
        remote.setCommand(2, fanOn);
        remote.setCommand(3, fanOff);

        System.out.println("===== REMOTE CONTROL TEST =====");

     
        remote.pressButton(0);

      
        remote.pressButton(2);

        
        remote.pressButton(1);

      
        System.out.println("Undoing Light OFF...");
        remote.pressUndoButton(1);

       
        remote.pressButton(3);

     
        System.out.println("Undoing Fan OFF...");
        remote.pressUndoButton(3);
    }
}