
package sensortracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;

public class SensorTracker {

    public static Color getSensorColor(Sensor obj) {

        if (obj.getSensorStatus().equals("DANGER")) {
            return Color.red;

        } else if (obj.getSensorStatus().equals("CRITICAL")) {
            return Color.yellow;

        } else {
            return Color.GREEN;
        }
    }

    public static void setProgressBar(Sensor obj, JPanel panel) {
        panel.setBorder(new TitledBorder(obj.getSensorName()));
        panel.setLayout(new GridLayout(3, 0));

        double value =  obj.getSensorValue();

        JProgressBar progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        if (obj.getSensorName().equals("Pressure Sensor")) {
            progressBar.setMaximum(12);
        } else if (obj.getSensorName().equals("Radiation Sensor")) {
            progressBar.setMaximum(6);
        } else {
            progressBar.setMaximum(500);
        }
        progressBar.setValue((int)value);

        panel.add(new JLabel());
        progressBar.setForeground(getSensorColor(obj));
        panel.add(progressBar);
        JLabel progressLabel = new JLabel();
        progressLabel.setText(obj.getSensorStatus() + "--> " + value);
        progressLabel.setFont(new Font(progressLabel.getName(), Font.BOLD, 16));
        progressLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(progressLabel);

    }

    public static void main(String[] args) {
        RadiationSensor radSen = new RadiationSensor();
        TemperatureSensor tempSen = new TemperatureSensor();
        PressureSensor preSen = new PressureSensor();
        Sensor pressureObj = new PressureSensorAdapter(preSen);
        Sensor radiationObj = new RadiaionSensorAdapter(radSen);
        Sensor temperatureObj = new TemperatureSensorAdapter(tempSen);

        JFrame sensorTrackerWindow = new JFrame("Sensor Tracker");
        sensorTrackerWindow.setSize(800, 800);
        sensorTrackerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sensorTrackerWindow.setLayout(new GridLayout(3, 0));

        JPanel pressurePanel = new JPanel();
        JPanel radiationPanel = new JPanel();
        JPanel temperaturePanel = new JPanel();

        setProgressBar(pressureObj, pressurePanel);
        setProgressBar(radiationObj, radiationPanel);
        setProgressBar(temperatureObj, temperaturePanel);

        sensorTrackerWindow.add(pressurePanel);
        sensorTrackerWindow.add(radiationPanel);
        sensorTrackerWindow.add(temperaturePanel);

        sensorTrackerWindow.setVisible(true);

    }

}