let locInput, locCheck, locResult;
let test = 0;

window.onload = init();

function init(){
    locInput = document.getElementById("input-str");
    locCheck = document.getElementById("check");
    locResult = document.getElementById("result");
}

function checkSame(array, index_1, index_2){
    if((array[index_1--] === array[index_2++])){
        if(index_1 < 0){
            return 1;
        }
        return checkSame(array, index_1, index_2);
    }else{
        return 0;
    }
}

function isPalindrome(sourceStr){
    let array = sourceStr.split("");
    let lenStr = array.length;
    let index_1, index_2;

    if(lenStr === 1){
        return 1;
    }else if(lenStr === 2){
         return (array[0] === array[1]) ? 1 : 0;
    }else {
        if (lenStr % 2 === 0) {
            index_1 = lenStr / 2 - 1;
            index_2 = index_1 + 1;
        } else {
            index_1 = Math.floor(lenStr / 2 - 1);
            index_2 = Math.floor(lenStr / 2 + 1);
        }

        let value = checkSame(array, index_1, index_2);
        return value;
    }

}

locCheck.addEventListener("click", function(){
    if(locInput.value === ""){
        alert("Bạn chưa nhập số nào để kiểm tra tính đối xứng, hãy nhập rồi mới ấn button")
    }else {
        if (isPalindrome(locInput.value) === 1) {
            alert("Chuôi " + locInput.value + " là đối xứng đấy ^^");
        } else {
            alert("Chuỗi " + locInput.value + " không đối xứng rồi, rất tiếc !!!");
        }
    }
}, false);