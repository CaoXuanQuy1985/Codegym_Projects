let locNum, locResult, result = "";

window.onload = init();

function init(){
    locNum = document.getElementById("num");
    locResult = document.getElementById("result");
}

function showNumbers(){
    let count = 0, num = 1, sum = 0;

    while(count < 30){
            if((num % 7) === 0) {
                if(count === 29){
                    result += num
                }else {
                    result += num + ", ";
                }
                sum += num;
                count++;
            }
            num++;
    }

    locNum.innerHTML = result;

    return sum;
}

locResult.innerHTML = showNumbers();

