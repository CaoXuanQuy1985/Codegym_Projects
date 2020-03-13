let locInfor, locTable, locAddBtn, locSearch, locInputSearch, locGetFull;
let locNameInput, locDateInput, locCodeInput, locSourceInput;
let locOptionsAdd;
let arrayProductObj;
let count = 0;

function ProductObj(username, password) {
    this.username = username;
    this.password = password;
    this.money = 100000000;
}

window.onload = init();

function init(){
    locInfor = document.getElementById("information");
    locTable = document.getElementById("table-information");
    locNameInput = document.getElementById("name-input");
    locDateInput = document.getElementById("date-input");
    locCodeInput = document.getElementById("code-input");
    locSourceInput = document.getElementById("source-input");
    locAddBtn = document.getElementById("addBtn");
    locOptionsAdd = document.getElementById("optionsAdd");
    locSearch = document.getElementById("search");
    locInputSearch = document.getElementById("input-search");
    locGetFull = document.getElementById("getFull");
    initTable();
    showTableInformation();
}

function createProductObj(username, password){
    let newProduct = new ProductObj(username, password);
    return newProduct;
}

function createTHEAD(){
    let table = "";
    table += "<table id=\"table-information\">";
    table += "<thead>";
    table += "<tr>";
    table += "<th id=\"stt\">STT</th>";
    table += "<th id=\"name\">Tên Người Chơi</th>";
    table += "<th id=\"date\">Username</th>";
    table += "<th id=\"code\">Password</th>";
    table += "<th id=\"source\">Tiền Tài Khoản</th>";
    table += "<th id=\"edit\">Edit</th>";
    table += "<th id=\"update\">Update</th>";
    table += "<th id=\"delete\">Delete</th>";
    table += "</tr>";
    table += "</thead>";
    table += "<tbody>";

    return table;
}

function initTable(){
    locInfor.innerHTML = createTHEAD();
}

function getAllItemLocalStorage(localStorage){
    let arrayItems = [],
        keys = Object.keys(localStorage),
        i = keys.length;

    while ( i-- ) {
        arrayItems.push(localStorage.getItem(keys[i]) );
    }

    return arrayItems;
}

function showTableInformation(){
    //localStorage.clear();
    let table = createTHEAD();
    let arrayItems = getAllItemLocalStorage(localStorage);
    for(let i = 0; i < arrayItems.length; i++){
        table += "<tr>";
        table += "<td>" + (i + 1) + "</td>";
        table += "<td id=\"name-sp-" + (i) +"\">" + JSON.parse(arrayItems[i]).username +  "</td>";
        table += "<td id=\"date-sp-" + (i) +"\">" + JSON.parse(arrayItems[i]).username +  "</td>";
        table += "<td id=\"code-sp-" + (i) +"\">" + JSON.parse(arrayItems[i]).password + "</td>";
        table += "<td id=\"source-sp-" + (i) +"\">" + JSON.parse(arrayItems[i]).money + "</td>";
        table += "<td><button id=\"edit_" + i + "\" onclick=\"edit(this.id.substring(this.id.length - 1))\">Edit</button></td>";
        table += "<td><button id=\"update_" + i + "\" onclick=\"update(this.id.substring(this.id.length - 1))\">Update</button></td>";
        table += "<td><button id=\"remove_" + i + "\" onclick=\"remove(this.id.substring(this.id.length - 1))\">Remove</button></td>";
        table += "</tr>";
    }
    table += "</tbody>";
    table += "</table>";

    locInfor.innerHTML = table;
}

function add(username, password){
    let newProduct = createProductObj(username, password);
    let objConvert = JSON.stringify(newProduct);
    localStorage.setItem(username, objConvert);
    showTableInformation();
    reset();
}

function edit(id){
    toggleDomElem(id);
}

function update(id){
    if(confirm("Bạn có chắc chắn là muốn chỉnh sửa lại thông tin như trên chứ ???")) {
        toggleDomElemBack(id);
    }else{
        toggleDomElem(id);
    }
}

function search(nameStr){
        let table = createTHEAD();
        for (let i = 0; i < arrayProductObj.length; i++) {
            if (arrayProductObj[i].name.includes(nameStr)) {
                table += "<tr>";
                table += "<td>" + (i + 1) + "</td>";
                table += "<td id=\"name-sp-" + (i) + "\">" + arrayProductObj[i].name + "</td>";
                table += "<td id=\"date-sp-" + (i) + "\">" + arrayProductObj[i].date + "</td>";
                table += "<td id=\"code-sp-" + (i) + "\">" + arrayProductObj[i].code + "</td>";
                table += "<td id=\"source-sp-" + (i) + "\">" + arrayProductObj[i].source + "</td>";
                table += "<td><button id=\"edit_" + i + "\" onclick=\"edit(this.id.substring(this.id.length - 1))\">Edit</button></td>";
                table += "<td><button id=\"update_" + i + "\" onclick=\"update(this.id.substring(this.id.length - 1))\">Update</button></td>";
                table += "<td><button id=\"remove_" + i + "\" onclick=\"remove(this.id.substring(this.id.length - 1))\">Remove</button></td>";
                table += "</tr>";
            }
        }
        table += "</tbody>";
        table += "</table>";

        locInfor.innerHTML = table;
}

let arrayKeys = [];
let keyChanged;
function toggleDomElem(id){
    let arrayItems = getAllItemLocalStorage(localStorage);
    arrayKeys = [];
    arrayKeys = Object.keys(localStorage);
    document.getElementById("name-sp-" + id).innerHTML = "<td><input id=\"name-toggle-" + id + "\" value=\"" + JSON.parse(arrayItems[id]).username + "\"/></td>";
    document.getElementById("date-sp-" + id).innerHTML = "<td><input id=\"date-toggle-" + id + "\" value=\"" + JSON.parse(arrayItems[id]).username + "\"/></td>";
    document.getElementById("code-sp-" + id).innerHTML = "<td><input id=\"code-toggle-" + id + "\" value=\"" + JSON.parse(arrayItems[id]).password + "\"/></td>";
    document.getElementById("source-sp-" + id).innerHTML = "<td><input id=\"source-toggle-" + id + "\" value=\"" + JSON.parse(arrayItems[id]).money + "\"/></td>";
 
    keyChanged = "";
    keyChanged = JSON.parse(arrayItems[id]).username;
}

function toggleDomElemBack(id){
    let locNameToggle =  document.getElementById("name-toggle-" + id),
        locDateToggle = document.getElementById("date-toggle-" + id),
        locCodeToggle = document.getElementById("code-toggle-" + id),
        locSourceToggle = document.getElementById("source-toggle-" + id);

    let newNameToggle = locNameToggle.value,
        newDateToggle = locDateToggle.value,
        newCodeToggle = locCodeToggle.value,
        newSourceToggle = locSourceToggle.value

    let newObject = createProductObj(newDateToggle, newCodeToggle);

    let arrayItems = getAllItemLocalStorage(localStorage);
    let objConvert = JSON.stringify(newObject);
    for(let i = 0; i < arrayKeys.length; i++){
         if(arrayKeys[i] === keyChanged){
              localStorage.removeItem(arrayKeys[i]);
              localStorage.setItem(newDateToggle, objConvert);
         }
    }
    showTableInformation();
}


function remove(id){
    if(confirm("Bạn có chắc chắn muốn xóa user này không ?")) {
        let arrayItems = getAllItemLocalStorage(localStorage);
        let checkusername;
        for(let i = 0; i < arrayItems.length; i++){
            if (id == (i)){
                checkusername = JSON.parse(arrayItems[i]).username;
                break;
            }
        }
        localStorage.removeItem(checkusername);
        showTableInformation();
    }
}

function reset(){
    locCodeInput.value = "";
    locSourceInput.value = "";
}

function getFull(){
    showTableInformation();
}

locAddBtn.addEventListener("click", function(){
    add(locCodeInput.value, locSourceInput.value)
}, false);

locSearch.addEventListener("click", function(){
}, false);

locInputSearch.addEventListener("keypress", function(){
    search(locInputSearch.value.trim())
}, false);

locGetFull.addEventListener("click", getFull, false);









