let locGenerate7, locArray7, locDelElem7, locResult7;
let locInputElem7;
let newArrayInt7, arrayIndexResult7;
let deleted = false;

function include7(file) {

    let script  = document.createElement('script');
    script.src  = file;
    script.type = 'text/javascript';
    script.defer = true;

    document.getElementsByTagName('head').item(0).appendChild(script);

}

window.onload = init();

function init(){
    include7("js/bai_tap_1.js");
    include7("js/bai_tap_6.js");
    locGenerate7 = document.getElementById("generate7");
    locArray7 = document.getElementById("array7");
    locDelElem7 = document.getElementById("deleteElem7");
    locResult7 = document.getElementById("result7");
    locInputElem7 = document.getElementById("input-Elem7");
    newArrayInt7 = [];
    arrayIndexResult7 = [];
}

function deleteElem(array, elem){
    deleted = false;
    let newArray = [];
    let count = 0;
    for(let i = 0; i < array.length; i++){
        if(array[i] === elem){
            deleted = true;
            while(array[++i] === elem){
                count++;
            }
            if(i !== (array.length)){
                newArray.push(array[--i + 1]);
            }
            i++;
            count++;
        }else {
            newArray.push(array[i]);
        }
    }

    for(let i = 0; i < count; i++){
        newArray.push(0);
    }

    return newArray;
}

locGenerate7.addEventListener("click", function(){
    newArrayInt7 = createIntArr();
    showArray(getArrayStr(newArrayInt7), locArray7);
}, false);

locDelElem7.addEventListener("click", function(){
    let newArray = deleteElem(newArrayInt7, parseInt(locInputElem7.value));
    if(deleted){
        locResult7.innerHTML = "Tôi đã tìm ra phần tử mà bạn muốn xóa, sau khi xóa mảng trở thành: " + newArray;
    }else{
        locResult7.innerHTML = "Phần tử mà bạn muốn xóa không xuất hiện trong mảng, hãy chọn số khác";
    }
}, false);