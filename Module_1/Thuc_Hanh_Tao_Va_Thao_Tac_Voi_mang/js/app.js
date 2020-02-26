let locNewElem, locAdd, locDisplay, locResult;
let newArray;
let value;

window.onload = init();

function init(){
    locNewElem = document.getElementById("newElem");
    locAdd = document.getElementById("add");
    locDisplay = document.getElementById("display");
    locResult = document.getElementById("result");
}

function createArray(){
    newArray = [];
}

createArray();

function add(newItem){
    if(locNewElem.value === ""){
        return;
    }else {
        newArray.push(newItem);
        locNewElem.value = "";
    }
}

function display(){
    let result = "";
    //document.getElementById("resultTable").remove();
    if(document.getElementById("resultTable")){
        document.getElementById("resultTable").remove();
    }
    let newTable = document.createElement("table");
    newTable.setAttribute("id", "resultTable");
    document.getElementById("page").appendChild(newTable);

    for(let i = 0; i < newArray.length; i++){
        result += "<tr>";
        result += "<td>" + "Element[" + i + "] = " + newArray[i] + "</td>";
        result += "</tr>";
    }
    document.getElementById("resultTable").innerHTML = result;

    alert(newArray);

}

locAdd.addEventListener("click", function(){
    add(locNewElem.value);
}, false);

locDisplay.addEventListener("click", display, false);