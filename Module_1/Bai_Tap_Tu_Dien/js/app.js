let locEN, locVN, locTrans;
let locUpdateEn, locUpdateVN, locUpdate;
let arrayWords;

window.onload = init();

function Word(english, vietnamese){
    this.english = english;
    this.vietnamese = vietnamese;
    this.translate = function(){
        return this.vietnamese;
    }
}

function init(){
    locEN = document.getElementById("en");
    locVN = document.getElementById("vn");
    locTrans = document.getElementById("trans");
    locUpdateEn = document.getElementById("updateEN");
    locUpdateVN = document.getElementById("updateVN");
    locUpdate = document.getElementById("updateBtn");
    arrayWords = [];
    createWord("Home", "Ngôi Nhà");
    createWord("Dog", "Con Chó");
    createWord("Cat", "Con Mèo");
}

function createWord(english, vietnamese){
    let newWord = new Word(english, vietnamese);
    arrayWords.push(newWord);
}

function translate(enWord){
    let vietnamese = "";
    for(let word in arrayWords){
        let test = arrayWords[word];
        if(arrayWords[word].english === enWord){
            vietnamese = arrayWords[word].translate();
            locVN.value = vietnamese;
            break;
        }
        locVN.value = "Từ này không có trong từ điển";
    }
}

function updateNewWord(english, vietnamese){
    createWord(english, vietnamese);
    alert("Đã Cập nhật từ mới thành công");
}

locTrans.addEventListener("click", function(){
    translate(locEN.value)
}, false);

locUpdate.addEventListener("click", function(){
    updateNewWord(locUpdateEn.value, locUpdateVN.value)
}, false);