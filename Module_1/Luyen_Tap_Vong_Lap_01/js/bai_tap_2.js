let locTB;

window.onload = init();

function init(){
    locTB = document.getElementById("tb");
}

temp = parseFloat(prompt("Hãy Nhập nhiệt độ hiện tại: "));
if (temp !== null) {
    if(temp > 100) {
        locTB.innerHTML = "Nhiệt đô trên 100 độ, hãy giảm nhiệt độ xuống";
    }
    else if(temp < 20) {
        locTB.innerHTML = "Nhiệt đô dưới 20 độ, hãy tăng nhiệt độ lên";
    }
    else {
        locTB.innerHTML = "Nhiệt độ đã ổn định";
    }
}


