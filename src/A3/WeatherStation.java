//Observer Pattern
import java.util.Observable;
import java.util.Observer;


class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}


class CurrentConditionsDisplay implements Observer {

    @Override
    public void update(Observable observable, Object arg) {

        WeatherData weatherData = (WeatherData) observable;

        System.out.println("Current Weather Conditions");
        System.out.println("Temperature: " + weatherData.getTemperature() + " C");
        System.out.println("Humidity: " + weatherData.getHumidity() + " %");
        System.out.println("Pressure: " + weatherData.getPressure() + " hPa");
        System.out.println("-----------------------------");
    }
}


public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay display =
                new CurrentConditionsDisplay();

        weatherData.addObserver(display);

        weatherData.setMeasurement(30.5f, 65.0f, 1012.5f);

        weatherData.setMeasurement(32.0f, 70.0f, 1010.2f);

        weatherData.setMeasurement(28.5f, 60.0f, 1015.8f);
    }
}