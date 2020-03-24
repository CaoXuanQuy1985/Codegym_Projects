package app;

public class MyFan {
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }

    public boolean getOn(){
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MyFan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public String toString(){
        String result = (this.on) ?  "Information Fan: speed = " + this.speed + " color = " + this.color + " radius = " + this.color + " fan is on" : "Information Fan: color = " + this.color + " radius = " + this.radius + " fan is off";
        return result;
    }
}