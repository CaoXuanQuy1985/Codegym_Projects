let locResult, result = "", number, sum = 0;

window.onload = init();

function init(){
    locResult = document.getElementById("result");

    do {
        number = prompt("Nhập vào 1 số để tính tổng: ");
        if(parseFloat(number) === -1){
            locResult.innerHTML = "Bạn đẫ nhập vào giá trị -1, chương trình sẽ thoát";
            break;
        }
        sum += parseFloat(number);
        result += number + ", ";
    }while((number !== null) && (parseFloat(number) !== -1));

    locResult.innerHTML = "Các giá trị vừa được nhập vào là: " + result + " sum = " + sum;
}

