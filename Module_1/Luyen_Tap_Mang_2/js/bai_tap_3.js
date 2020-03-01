let locGenArr, locDimension, locArray3, locBtn, locResult3;
let arr2Dim = [];

window.onload = init();

function init(){
    locGenArr = document.getElementById("genArr");
    locDimension = document.getElementById("dimension");
    locArray3 = document.getElementById("array3");
    locBtn = document.getElementById("btn");
    locResult3 = document.getElementById("result3");
}

function genArr1Dim(){
    let array = [];
    let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let charactersLength = characters.length;

    for (let i = 0; i < 6; i++ ) {
        array.push(characters.charAt(Math.floor(Math.random() * charactersLength)));
    }

    return array;
}

function genArr2Dim(length){
    let newArr2Dim = [];
    for(let i = 0; i < length; i++){
        newArr2Dim.push(genArr1Dim());
    }

    return newArr2Dim;
}

function countNumber(array2Dim){
    let count = 0;

    for(let i = 0; i < array2Dim.length; i++){
        for(let j = 0; j < array2Dim[i].length; j++){
            count = (!isNaN(parseInt(array2Dim[i][j]))) ? count + 1 : count;
        }
    }

    return count;
}

function showArr2Dim(array2Dim){
    let arr2DimString = "";
    let table = "<table>";
    for(let i = 0; i < array2Dim.length; i++){
        table += "<tr>";
        for(let j = 0; j < array2Dim[i].length; j++){
            arr2DimString += array2Dim[i][j] + " ";
            table += "<td>" + array2Dim[i][j] + "</td>";
        }
        table += "</tr>";
        arr2DimString += "<br/>";
    }
    table += "</table>";

    locArray3.innerHTML = table;
}

locGenArr.addEventListener("click", function(){
    arr2Dim = genArr2Dim(parseInt(locDimension.value));
    showArr2Dim(arr2Dim)
}, false);

locBtn.addEventListener("click", function(){
    locResult3.innerHTML = "Tổng số kí tự là số trong mảng là: " + countNumber(arr2Dim);
}, false);
