package com.codegym;

class Point {
    private float xPos;
    private float yPos;

    public Point() {
        this.xPos = 0.0f;
        this.yPos = 0.0f;
    }

    public Point(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public float getXPos() {
        return this.xPos;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public float getYPos() {
        return this.yPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    public void setXYPos(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public float[] getXYPos() {
        float[] cordinates = new float[2];

        cordinates[0] = this.xPos;
        cordinates[1] = this.yPos;

        return cordinates;
    }

    public String toString() {
        return "Point with cordinates: {" + this.xPos + ", " + this.yPos + "}";
    }
}