
package sensortracker;

import sensor.TemperatureSensor;

public class TemperatureSensorAdapter implements Sensor{
    TemperatureSensor temSenObj;
    public TemperatureSensorAdapter(TemperatureSensor temSenObj){
        this.temSenObj = temSenObj;
    }

    @Override
    public double getSensorValue() {
        return temSenObj.senseTemperature();
    }

    @Override
    public String getSensorStatus() {
        return temSenObj.getTempReport();
    }

    @Override
    public String getSensorName() {
        return temSenObj.getSensorType();
    }
    
}
