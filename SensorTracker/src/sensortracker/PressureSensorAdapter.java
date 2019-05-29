
package sensortracker;

import sensor.PressureSensor;

public class PressureSensorAdapter implements Sensor{
    PressureSensor preSenObj;
    
    public PressureSensorAdapter(PressureSensor preSenObj){
        this.preSenObj = preSenObj;
    }

    @Override
    public double getSensorValue() {
        return preSenObj.readValue();
    }

    @Override
    public String getSensorStatus() {
        return preSenObj.getReport();
    }

    @Override
    public String getSensorName() {
        return preSenObj.getSensorName();
    }
}
