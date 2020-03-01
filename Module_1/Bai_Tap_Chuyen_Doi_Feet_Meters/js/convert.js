let locFeet, locTemp, locMeter, locConvert, locResult;

window.onload = init();

function init(){
    locFeet = document.getElementById("feet");
    locTemp = document.getElementById("temp");
    locMeter = document.getElementById("meter");
    locConvert = document.getElementById("convert");
    locResult = document.getElementById("result");
}

function convertFeetToMeter(valueFeet){
    return (0.305 * valueFeet).toFixed(3);
}

function convertMeterToFeet(valueMeter){
    return (3.279 * valueMeter).toFixed(3);
}

locConvert.addEventListener("click", function(){
    if(locTemp.value === "feet-Meters"){
        locMeter.value = convertFeetToMeter(parseFloat(locFeet.value));
    }else{
        locFeet.value = convertMeterToFeet(parseFloat(locMeter.value));
    }
}, false);