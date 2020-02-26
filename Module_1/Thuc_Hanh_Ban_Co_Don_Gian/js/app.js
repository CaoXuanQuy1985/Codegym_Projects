let locMyTable, locChangeValue;
let corX, corY, newValue;
let result = "";
let myArray;
let arrDIM;

window.onload = init();

function init(){
    locMyTable = document.getElementById("myTable");
    locChangeValue = document.getElementById("change");
    createChess();
}

function createChess(){
    let arr1 = [0,0,0,0,0];
    let arr2 = [0,0,0,0,0];
    let arr3 = [0,0,0,0,0];
    let arr4 = [0,0,0,0,0];

    arrDIM = [arr1, arr2, arr3, arr4];

    for(let i = 0; i < arrDIM.length; i++){
        result += "<tr>";
        for(let j = 0; j < arrDIM[i].length; j++){
            let test = arrDIM[i][j];
            result += "<td>" + arrDIM[i][j] + "</td>";
        }
        result += "</tr>";
    }

    locMyTable.innerHTML = result;
}

function draw(corX, corY, newValue){
    result = "";
    corX = prompt("Hãy nhập tọa độ X = ");
    corY = prompt("Hãy Nhập Tọa Độ Y = ");
    newValue = prompt("Hãy nhập 1 giá trị mới: ");

    for(let i = 0; i < arrDIM.length; i++){
        for(let j = 0; j < arrDIM[i].length; j++){
            if((i === parseInt(corX)) && (j === parseInt(corY))){
                arrDIM[i][j] = newValue;
            }
        }
    }

    for(let i = 0; i < arrDIM.length; i++){
        result += "<tr>";
        for(let j = 0; j < arrDIM[i].length; j++){
            result += "<td>" + arrDIM[i][j] + "</td>";
        }
        result += "</tr>";
    }

    locMyTable.innerHTML = result;
}

locChangeValue.addEventListener("click", function(){
        draw(corX, corY, newValue);
}, false);