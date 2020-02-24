let locSN, locBtn_3, locResult_3;

window.onload = init();

function init(){
    locSN = document.getElementById("sn");
    locBtn_3 = document.getElementById("btn_3");
    locResult_3 = document.getElementById("result_3");
}

function check(sn){
    if(sn < 0){
        locResult_3.textContent = "Số " + sn + " < 0";
    }else{
        if(sn === 0) {
            locResult_3.textContent = "Số " + sn + " = 0";
        }else{
            locResult_3.textContent = "Số " + sn + " > 0";
        }
    }
}

locBtn_3.addEventListener("click", function(){
    check(parseInt(locSN.value));
}, false);