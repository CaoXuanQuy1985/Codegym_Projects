const pi = 3.14;

function Circle(radius, color){
    this.constantPi = pi;
    this.radius = radius;
    this.color = color;

    this.Circle = function(){
        return new Circle();
    };
    this.getRadius = function(){
        return this.radius;
    };
    this.setRadius = function(radius) {
        this.radius = radius;
    };
    this.getArea = function(){
        return this.constantPi * this.radius * this.radius;
    };
}

let obj_1 = new Circle();
alert(obj_1.getRadius());
obj_1.setRadius(56);
alert(obj_1.getRadius());
alert(obj_1.getArea());
