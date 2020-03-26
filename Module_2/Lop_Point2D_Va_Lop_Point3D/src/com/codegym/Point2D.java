package com.codegym;

class Point2D {
    private float xPos;
    private float yPos;
    private float[] cordinate;

    public Point2D() {
        this.cordinate = new float[3];
        this.setCordinate(0.0f, 0.0f, 0.0f);
        this.xPos = this.cordinate[0];
        this.yPos = this.cordinate[1];
    }

    public Point2D(float xPos, float yPos) {
        this.cordinate = new float[3];
        this.setCordinate(xPos, yPos, 0.0f);
        this.xPos = this.cordinate[0];
        this.yPos = this.cordinate[1];
    }

    public float getXPos() {
        return this.xPos;
    }

    public void setXPos(float xPos) {
        this.cordinate[0] = this.xPos;
        this.xPos = xPos;
    }

    public float getYPos() {
        return this.yPos;
    }

    public void setYPos(float yPos){
        this.cordinate[1] = this.yPos;
        this.yPos = yPos;
    }

    public float[] getCordinate() {
        return this.cordinate;
    }

    public void setCordinate(float xPos, float yPos, float zPos) {
        this.cordinate[0] = xPos;
        this.cordinate[1] = yPos;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String toString() {
        return "This is a Point2D {" + this.cordinate[0] + ", " + this.cordinate[1] + "}";
    }
}