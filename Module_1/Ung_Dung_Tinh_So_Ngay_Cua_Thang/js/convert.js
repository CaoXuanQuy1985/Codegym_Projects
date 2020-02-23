let locMonth, locBtn, locResult;
let monthValue;

window.onload = init();

function init(){
    locMonth = document.getElementById("month");
    locBtn = document.getElementById("btn");
    locResult = document.getElementById("result");
}

function calculate(month){
    if((month >= 1) && (month <= 12)){
        switch (month){
            case 4:
            case 6:
            case 9:
            case 11:
                locResult.textContent = "Tháng " + locMonth.value + " có 30 ngày";
                break;
            case 2:
                locResult.textContent = "Tháng " + locMonth.value + " có 28 hoặc 29 ngày";
                break;
            default:
                locResult.textContent = "Tháng " + locMonth.value + " có 31 ngày";
                break;
        }
    }else{
        locResult.textContent = "Tháng " + locMonth.value + " là tháng không hợp lệ, hãy nhập tháng khác từ 1 - 12";
    }
}

locBtn.addEventListener("click", function(){
    calculate(parseInt(locMonth.value));
}, false);