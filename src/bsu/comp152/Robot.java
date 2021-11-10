package bsu.comp152;


import java.util.Random;
/**
 * Class Robot
 */
public class Robot {

    //
    // Fields
    //

    protected int powerLevel;
    private Sensor Sensor1;
    private Sensor Sensor2;
    private Manipulator robotArm;




    /**
     */
    public void getSensorData()
    {
        var sensor1Data = Sensor1.getSensorValue();
        var sensor2Data = Sensor2.getSensorValue();
        System.out.println("Got sensor data Sensor1: "+ sensor1Data + "\nSensor2: "+ sensor2Data);
    }


    /**
     */
    public void interactWithWorld()
    {
        getSensorData();
        robotArm.workInWorld();
    }


    /**
     * @return       Robot
     * @param        startingPower
     */
    public Robot(int startingPower)
    {
        powerLevel = startingPower;
        Sensor1 = new Sensor("Sonar Sensor");
        Sensor2 = new Sensor("Accelerometer");
        robotArm = new Manipulator("Robot Arm");
    }


    /**
     * @param        amount
     */
    public void recharge(int amount)
    {
        if( amount+ powerLevel < 100)
            powerLevel += amount;
        else
            System.out.println("Overcharge Error");
    }



}

class Sensor{
    String sensorName;
    Sensor(String name){
        sensorName = name;
    }

    public int getSensorValue(){
        //for exam random value
        var rand = new Random();
        return rand.nextInt(255);
    }

    public String toString(){
        return "Sensor of type " + sensorName + " and current value" + getSensorValue();
    }
}

class Manipulator{
    String type;
    Manipulator(String type){
        this.type = type;
    }

    public void workInWorld(){
        System.out.println("Now moving stuff in the real world");
    }

    public String toString(){
        return "Manipulator of type "+ type;
    }

}