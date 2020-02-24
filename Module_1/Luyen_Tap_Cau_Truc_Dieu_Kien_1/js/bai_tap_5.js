let locKT, locGK, locCK, locBtn_5, locResult_5;

window.onload = init();

function init(){
    locKT = document.getElementById("kt");
    locGK = document.getElementById("gk");
    locCK = document.getElementById("ck");
    locBtn_5 = document.getElementById("btn_5");
    locResult_5 = document.getElementById("result_5");
}

function check(kt, gk, ck){
    let sum  = kt + gk + ck;
    let result = "";
    if(sum >= 100){
        result = "Xuat sac"
    }else{
        if(sum >= 75){
            result = "Gioi";
        }else{
            if(sum >= 60){
                result = "Kha"
            }else{
                if(sum >= 45){
                    result = "Trung Binh";
                }else{
                    result = "Yeu";
                }
            }
        }
    }
    locResult_5.textContent = result;
}

locBtn_5.addEventListener("click", function(){
    check(parseFloat(locKT.value), parseFloat(locGK.value), parseFloat(locCK.value));
}, false);