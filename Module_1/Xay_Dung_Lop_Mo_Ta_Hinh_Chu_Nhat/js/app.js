function Rectangle(length, width) {
    this.locCanvas = document.getElementById("myCanvas");
    this.length = length;
    this.width = width;
}

Rectangle.prototype = {
    constructor: Rectangle,

    getWidth : function(){
        return this.width;
    },
    setWidth : function(width){
        this.width = width;
    },
    getHeight : function(){
        return this.height;
    },
    setHeight : function(height){
        this.height = height;
    },

    calculateArea: function(){
        return this.length * this.width;
    },
    calculatePerimeter : function(){
        return (this.width + this.length) * 2;
    },
    drawItSelf : function(ox, oy){
        let ctx = this.locCanvas.getContext("2d");
        ctx.beginPath();
        ctx.rect(ox, oy, this.width, this.length);
        ctx.stroke();
    }
};

let rect_1 = new Rectangle(150, 130);
alert("C1 = " + rect_1.calculatePerimeter() + " S1 = " + rect_1.calculateArea());
rect_1.drawItSelf(100, 100);
rect_1.setWidth(100);
rect_1.setHeight(80);
alert("C2 = " + rect_1.calculatePerimeter() + " S2 = " + rect_1.calculateArea());
rect_1.drawItSelf(70, 70);