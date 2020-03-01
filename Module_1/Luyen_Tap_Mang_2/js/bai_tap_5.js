let locInputStr1, locInputStr2, locCompareBtn, locResult5;

window.onload = init();

function init(){
    locInputStr1 = document.getElementById("inputStr1");
    locInputStr2 = document.getElementById("inputStr2");
    locCompareBtn = document.getElementById("compareBtn");
    locResult5 = document.getElementById("result5");
}

function compareStr(str1, str2){
    let arr1 = str1.trim().split(""), arr2 = str2.trim().split("");
    if(arr1.length !== arr2.length){
        return false;
    }else{
        for(let i = 0; i < arr1.length; i++){
            if(arr1[i] !== arr2[i]){
                return false;
            }
        }
        return true;
    }
}

locCompareBtn.addEventListener("click", function(){
    locResult5.innerHTML = (compareStr(locInputStr1.value, locInputStr2.value)) ? "2 Chuỗi bạn vừa nhập vào là giống nhau" : "2 Chuỗi bạn vừa nhập vào là khác nhau";
}, false);