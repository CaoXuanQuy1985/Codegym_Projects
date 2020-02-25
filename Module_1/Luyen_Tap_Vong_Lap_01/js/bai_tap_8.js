let locBtn, locResult, result;

window.onload = init();

function init(){
    locBtn = document.getElementById("btn");
    locResult = document.getElementById("result");
}

function play(){
    let count = 0;
        let min = prompt("Nhập vào giá trị min trong khoảng của bạn:");
        let max = prompt("Nhập vào giá trị max trong khoảng của bạn:");

        let randomInt = getRandomInt(parseInt(min), parseInt(max));
        alert("Giá trị random là: " + randomInt);

        for(let i = 0; i < 3; i++) {
            let valueUser = prompt("Nhập vào giá trị mà bạn đoán:");
            if (randomInt === parseInt(valueUser)) {
                alert("Xin Chúc Mừng");
                break;
            }
            if (parseInt(valueUser) > randomInt) {
                alert("Giá trị bạn chọn đã lớn hơn giá trị ngẫu nhiên, hãy chọn lại");
                continue;
            }
            if (parseInt(valueUser) > randomInt) {
                alert("Gía trị bạn chọn đã nhỏ hơn giá trị ngẫu nhiên, hãy chọn lại");
                continue;
            }
        }
}

function getRandomInt(min, max){
    min = Math.ceil(min);
    max = Math.floor(max);

    return Math.floor(Math.random() * (max - min)) + min;
}

locBtn.addEventListener("click", play, false);