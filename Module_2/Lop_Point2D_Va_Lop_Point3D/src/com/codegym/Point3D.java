package com.codegym;

class Point3D extends Point2D {
    private float zPos;

    public Point3D() {
        super();
        this.zPos = 0.0f;
    }

    public Point3D(float xPos, float yPos, float zPos) {
        super(xPos, yPos);
        this.zPos = zPos;
        this.getCordinate()[2] = zPos;
    }

    public float getZPos() {
        return this.zPos;
    }

    public void setZPos(float zPos) {
        this.zPos = zPos;
        this.getCordinate()[2] = zPos;
    }

    public String toString() {
        return "A Point3D with xPos = " + this.getXPos() + ", yPos = " + this.getYPos() + ", zPos = " + this.zPos + ", which is a subclass of Point2D " + super.toString();
    }
}