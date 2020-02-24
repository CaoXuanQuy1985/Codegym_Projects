let locNum, locBtn, locResult;
let num, result = "";


window.onload = init();

function init(){
    locBtn = document.getElementById("btn");
    locResult = document.getElementById("result");
}

    do {
        num = parseFloat(prompt("Nhap cac so tu 1 -> 10: "));
        if(num > 10)break;
        result += num + ", ";
    } while(num >= 1 && num <= 10);

    locResult.innerHTML = "Cac so ban vua nhap vao la: " + result;

