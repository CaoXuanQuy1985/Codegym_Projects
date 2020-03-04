function InitWindow(){
    this.locCanvas = document.getElementById("myCanvas");
}

function Circle(x, y, radius){
    this.x = x;
    this.y = y;
    this.radius = radius;

    this.createCircle = function(){
        let ctx = initObj.locCanvas.getContext("2d");
        let newCircle = new Circle(100, 75, 50);
        ctx.beginPath();
        ctx.arc(newCircle.x, newCircle.y, newCircle.radius, 0,  2 * Math.PI);
        ctx.fill();
        //ctx.stroke();
    };

    this.createCircle2 = function(){
        let ctx = initObj.locCanvas.getContext("2d");
        let radius = Math.floor(Math.random() * 80);
        let newCircle = new Circle(200, 100, radius);
        ctx.beginPath();
        ctx.arc(newCircle.x, newCircle.y, newCircle.radius, 0, 2 * Math.PI);
        ctx.fill();
    };

    this.getRandomHex = function(){
        return Math.floor(Math.random() * 255);
    };

    this.getRandomColor = function(){
        let red = this.getRandomHex();
        let green = this.getRandomHex();
        let blue = this.getRandomHex();

        return "rgb(" + red + ", " + green + ", " + blue + ")";
    };

    this.createCircle3 = function(){
        let ctx = initObj.locCanvas.getContext("2d");
        let radius = Math.floor(Math.random() * 80);
        let color = this.getRandomColor();
        let x = Math.random() * window.innerWidth;
        let y = Math.random() * window.innerHeight;
        let circle= new Circle(x, y, radius);
        ctx.beginPath();
        ctx.arc(circle.x, circle.y, circle.radius, 0, 2 * Math.PI);
        ctx.fillStyle = color;
        ctx.fill();
    };

    this.createMultipleCircle = function() {
        for (let i = 0; i < 30; i++) {
            this.createCircle();
        }
    }
}

let initObj = new InitWindow();
let circleObj = new Circle(100, 75, 50);
circleObj.createCircle();

let circleObj2 = new Circle();
circleObj2.createCircle2();

let circleObj3 = new Circle(200, 200, 50);
circleObj3.createCircle3();

circleObj3.createMultipleCircle();


