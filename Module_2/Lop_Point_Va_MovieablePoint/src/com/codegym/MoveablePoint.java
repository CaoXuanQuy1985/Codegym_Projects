package com.codegym;

class Moveable extends Point{
    private float xSpeed;
    private float ySpeed;

    public Moveable() {
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public Moveable(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public Moveable(float xPos, float yPos, float xSpeed, float ySpeed) {
        super(xPos, yPos);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return this.xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return this.ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getXYSpeed() {
        float[] speeds = new float[2];

        speeds[0] = this.xSpeed;
        speeds[1] = this.ySpeed;

        return speeds;
    }

    public void setXYSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public Moveable move() {
        float xPos, yPos;

        xPos = this.getXPos();
        yPos = this.getYPos();
        xPos = xPos + this.xSpeed;
        yPos = yPos + this.ySpeed;

        this.setXPos(xPos);
        this.setYPos(yPos);

        return this;
    }

    public String toString() {
        return "A Moveable with {" + this.getXPos() + ", " + this.getYPos() + "}, speeds{ " + this.xSpeed + ", " + this.ySpeed + "} and is subclass of " + super.toString();
    }
}