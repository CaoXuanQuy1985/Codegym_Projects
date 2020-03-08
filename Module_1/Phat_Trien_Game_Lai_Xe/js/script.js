/* ----------------- Constructor Class and Object window --------------- */

function InitWindow(){
    this.locPage = document.getElementById("page");
    this.locScore = document.getElementById("score");
    this.map = null;
}

InitWindow.prototype = {
    constructor : InitWindow,
    init : function(){
        this.map = new Map();
        let mapObj = this.map.createMap();
        let vehicle =  mapObj.createVehicle(50, 20, 20, 10);
        let reward = mapObj.createReward(100, 20, 20, 10, vehicle);
        return vehicle;
    }
};

/*---------------------------------------------------------------------- */

/* ----------------- Constructor Class and Object Map --------------- */

function Map(){
    this.locCanvas = null;
}

Map.prototype = {
    constructor : Map,
    getLocCanvas : function(){
        return this.locCanvas;
    },
    createMap : function(){
        let map = "<canvas id=\"myCanvas\"></canvas>";
        initWindow.locPage.innerHTML = map;
        this.locCanvas = document.getElementById("myCanvas");
        return this;
    },
    createVehicle : function(corX, corY, width, height){
        return new Vehicle(corX, corY, width, height).generateVehicle(this);
    },
    createReward : function(corX, corY, width, height, vehicle){
        return new Reward(corX, corY, width, height, vehicle).generateReward(this);
    }
};

/*----------------- Constructor Class and Object Vehicle ---------------- */

function Vehicle(corX, corY, width, height){
    this.width = width;
    this.height = height;
    this.corX = corX;
    this.corY = corY;
    this.ctx = null;
    this.score = 0;
    this.reward = null;
    //this.oldObject = null;
}

Vehicle.prototype = {
    constructor : Vehicle,
    generateVehicle : function(map){
        this.ctx = map.getLocCanvas().getContext("2d");
        this.drawVehicle(this.corX, this.corY, this.width, this.height);

        return this;
    },
    moveRight : function(){
        let newReward = this.clearOldVehicle(this.corX, this.corY, this.width, this.height);
        this.corX += 1;
        this.drawVehicle(this.corX, this.corY, this.width, this.height);
        this.checkCollision(newReward);
    },
    moveLeft : function(){
        let newReward = this.clearOldVehicle(this.corX, this.corY, this.width, this.height);
        this.corX -= 1;
        this.drawVehicle(this.corX, this.corY, this.width, this.height);
        this.checkCollision(newReward);
    },
    moveUp : function(){
        let newReward = this.clearOldVehicle(this.corX, this.corY, this.width, this.height);
        this.corY -= 1;
        this.drawVehicle(this.corX, this.corY, this.width, this.height);
        this.checkCollision(newReward);
    },
    moveDown : function(){
        let newReward = this.clearOldVehicle(this.corX, this.corY, this.width, this.height);
        this.corY += 1;
        this.drawVehicle(this.corX, this.corY, this.width, this.height);
        this.checkCollision(newReward);
    },
    drawVehicle : function(corX, corY, width, height){
        this.ctx.beginPath();
        this.ctx.lineWidth = "1";
        this.ctx.strokeStyle = "red";
        this.ctx.rect(corX, corY, width, height);
        this.ctx.stroke();
    },
    clearOldVehicle : function(){
        this.ctx.clearRect(0,0,600,600);
        let reward = new Reward(100, 20, 20, 10, this);
        let rewardObj = reward.generateReward(initWindow.map);
        return rewardObj;
    },
    getScore : function(){

    },
    checkCollision : function(rewardObj){
        if(((this.corX >= rewardObj.corXC) && (this.corX <= rewardObj.widthC)) && ((this.corY >= rewardObj.corYC) && (this.corY <= rewardObj.heightC))){
            this.score++;
            initWindow.locScore.innerHTML = this.score;
        }
    }
};

/*---------------------------------------------------------------------- */

/* ---------------- Constructor Class and Object Reward --------------- */

function Reward(corX, corY, width, height, vehicle){
    this.corX = corX;
    this.corY = corY;
    this.width = width;
    this.height = height;
    this.vehicle = vehicle;
    this.corXC = this.corX - this.vehicle.width - 1;
    this.corYC = this.corY - this.vehicle.height - 1;
    this.widthC = this.corXC + this.width * 2 + 3;
    this.heightC = this.corYC + this.height * 2 + 3;
}

Reward.prototype = {
    constructor : Reward,
    generateReward : function(map){
        this.ctx = map.getLocCanvas().getContext("2d");
        this.drawReward(this.corX, this.corY, this.width, this.height);

        return this;
    },
    drawReward : function(corX, corY, width, height){
        this.ctx.beginPath();
        this.ctx.lineWidth = "1";
        this.ctx.strokeStyle = "green";
        this.ctx.rect(corX, corY, width, height);
        this.ctx.stroke();
    },
};

/* -------------------------------------------------------------------- */

/* ----------------- Flow Process of Application --------------- */

let initWindow = new InitWindow();
let test = initWindow.init();

window.addEventListener("keydown", function(event){
    if(event.keyCode === 39){
        test.moveRight();
    }else if(event.keyCode === 40){
        test.moveDown();
    }else if(event.keyCode === 37){
        test.moveLeft();
    }else if(event.keyCode === 38){
        test.moveUp();
    }
}, false);

/*---------------------------------------------------------------------- */

