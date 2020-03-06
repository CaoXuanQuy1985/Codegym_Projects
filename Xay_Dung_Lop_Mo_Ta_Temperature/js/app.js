function WindowLoad(){
    this.locC = document.getElementById("c");
    this.locCFBtn = document.getElementById("CFBtn");
    this.locResultCF = document.getElementById("resultCF");
    this.locCKBtn = document.getElementById("CKBtn");
    this.locResultCK = document.getElementById("resultCK");
}

let windowObj = new WindowLoad();

function EngineTemperature(celcius){
    this.celcius = celcius;
    this.convertCToF = function(){
        return (this.celcius * 1.8) + 32;
    };
    this.convertCToK = function(){
        return this.celcius + 273.15;
    };
    this.checkC = function(){
        if(this.celcius < -273){
            alert("Celcius < -273, so it has been set to -273");
            this.celcius = -273;
        }
    };
    this.getCelcius = function(){
        return this.celcius;
    }
}

let engineObj = new EngineTemperature(25);

windowObj.locCFBtn.addEventListener("click", function(){
    engineObj.convertCToF();
    windowObj.locResultCF.innerHTML = "Convert Celcius to Fahenreit: " + engineObj.convertCToF();
}, false);

windowObj.locCKBtn.addEventListener("click", function(){
    engineObj.convertCToK();
    windowObj.locResultCK.innerHTML = "Convert Celcius to Kevin: " + engineObj.convertCToK();
}, false);


