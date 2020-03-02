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
        if(index_1 === 0){
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
    if(lenStr % 2 === 0) {
        index_1 = lenStr / 2 - 1;
        index_2 = index_1 + 1;
    }else{
        index_1 = Math.floor(lenStr / 2 - 1);
        index_2 = Math.floor(lenStr / 2 + 1);
    }

    let value = checkSame(array, index_1, index_2);
    return value;

}

if(isPalindrome("123456789AH987654321") === 1){
    alert("Chuoi doi xung");
}else{
    alert("Chuoi khong doi xung");
}