
package sensortracker;

import sensor.RadiationSensor;

public class RadiaionSensorAdapter implements Sensor {
    RadiationSensor radSenObj ;
    public RadiaionSensorAdapter(RadiationSensor radSenObj){
        this.radSenObj = radSenObj;
    }

    @Override
    
    public double getSensorValue() {
        return radSenObj.getRadiationValue();

    }

    @Override
    public String getSensorStatus() {
        return radSenObj.getStatusInfo();

    }

    @Override
    public String getSensorName() {
        return radSenObj.getName();
        
    }
    
}
