let locInfor, locTable, locAddBtn, locSearch, locInputSearch, locGetFull;
let locNameInput, locDateInput, locCodeInput, locSourceInput;
let locOptionsAdd;
let arrayProductObj;
let count = 0;

function ProductObj(name, date, code, source) {
    this.name = name;
    this.date = date;
    this.code = code;
    this.source = source;
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

function createProductObj(name, date, code, source){
    let newProduct = new ProductObj(name, date, code, source);
    return newProduct;
}

function createTHEAD(){
    let table = "";
    table += "<table id=\"table-information\">";
    table += "<thead>";
    table += "<tr>";
    table += "<th id=\"stt\">STT</th>";
    table += "<th id=\"name\">Tên SP</th>";
    table += "<th id=\"date\">Ngày Nhập</th>";
    table += "<th id=\"code\">Mã SP</th>";
    table += "<th id=\"source\">Nguồn Gốc</th>";
    table += "<th id=\"edit\">Edit</th>";
    table += "<th id=\"update\">Update</th>";
    table += "<th id=\"delete\">Delete</th>";
    table += "</tr>";
    table += "</thead>";
    table += "<tbody>";

    return table;
}

function initTable(){
    arrayProductObj = [];
    let obj1 = createProductObj("Giày Nike", "12/09/2019", "C123", "Italia");
    let obj2 = createProductObj("Áo Sơmi", "09/10/2018", "D6543", "Việt Nam");
    let obj3 = createProductObj("Quần Kaki", "21/10/2017", "E3322", "Mỹ");
    arrayProductObj.push(obj1);
    arrayProductObj.push(obj2);
    arrayProductObj.push(obj3);
    locInfor.innerHTML = createTHEAD();
}

function showTableInformation(){
    let table = createTHEAD();
    for(let i = 0; i < arrayProductObj.length; i++){
        table += "<tr>";
        table += "<td>" + (i + 1) + "</td>";
        table += "<td id=\"name-sp-" + (i) +"\">" + arrayProductObj[i].name + "</td>";
        table += "<td id=\"date-sp-" + (i) +"\">" + arrayProductObj[i].date + "</td>";
        table += "<td id=\"code-sp-" + (i) +"\">" +  arrayProductObj[i].code + "</td>";
        table += "<td id=\"source-sp-" + (i) +"\">" + arrayProductObj[i].source + "</td>";
        table += "<td><button id=\"edit_" + i + "\" onclick=\"edit(this.id.substring(this.id.length - 1))\">Edit</button></td>";
        table += "<td><button id=\"update_" + i + "\" onclick=\"update(this.id.substring(this.id.length - 1))\">Update</button></td>";
        table += "<td><button id=\"remove_" + i + "\" onclick=\"remove(this.id.substring(this.id.length - 1))\">Remove</button></td>";
        table += "</tr>";
    }
    table += "</tbody>";
    table += "</table>";

    locInfor.innerHTML = table;
}

function add(name, date, code, source, optionAdd){
    let newProduct = createProductObj(name, date, code, source);
    if(optionAdd === "top"){
        arrayProductObj.unshift(newProduct);
    }else{
        arrayProductObj.push(newProduct);
    }
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

function toggleDomElem(id){
    document.getElementById("name-sp-" + id).innerHTML = "<td><input id=\"name-toggle-" + id + "\" value=\"" + arrayProductObj[id].name + "\"/></td>";
    document.getElementById("date-sp-" + id).innerHTML = "<td><input id=\"date-toggle-" + id + "\" value=\"" + arrayProductObj[id].date + "\"/></td>";
    document.getElementById("code-sp-" + id).innerHTML = "<td><input id=\"code-toggle-" + id + "\" value=\"" + arrayProductObj[id].code + "\"/></td>";
    document.getElementById("source-sp-" + id).innerHTML = "<td><input id=\"source-toggle-" + id + "\" value=\"" + arrayProductObj[id].source + "\"/></td>";
}

function toggleDomElemBack(id){
    let locNameToggle =  document.getElementById("name-toggle-" + id),
        locDateToggle = document.getElementById("date-toggle-" + id),
        locCodeToggle = document.getElementById("code-toggle-" + id),
        locSourceToggle = document.getElementById("source-toggle-" + id);

    let newNameToggle = locNameToggle.value,
        newDateToggle = locDateToggle.value,
        newCodeToggle = locCodeToggle.value,
        newSourceToggle = locSourceToggle.value;

    arrayProductObj[id].name = newNameToggle;
    arrayProductObj[id].date = newDateToggle;
    arrayProductObj[id].code = newCodeToggle;
    arrayProductObj[id].source = newSourceToggle;

    locNameToggle.parentNode.innerHTML = "<td id=\"name-sp-" + id +"\">" + newNameToggle + "</td>";
    locDateToggle.parentNode.innerHTML = "<td id=\"date-sp-" + id +"\">" + newDateToggle + "</td>";
    locCodeToggle.parentNode.innerHTML = "<td id=\"code-sp-" + id +"\">" + newCodeToggle + "</td>";
    locSourceToggle.parentNode.innerHTML = "<td id=\"source-sp-" + id +"\">" + newSourceToggle + "</td>";
}


function remove(id){
    if(confirm("Bạn có muốn chắc chắn xóa sản phẩm này không ?")) {
        arrayProductObj.splice(id, 1);
        showTableInformation();
    }
}

function reset(){
    locNameInput.value = "";
    locDateInput.value = "";
    locCodeInput.value = "";
    locSourceInput.value = "";
}

function getFull(){
    showTableInformation();
}

locAddBtn.addEventListener("click", function(){
    add(locNameInput.value, locDateInput.value, locCodeInput.value, locSourceInput.value, locOptionsAdd.options[locOptionsAdd.selectedIndex].value)
}, false);

locSearch.addEventListener("click", function(){
    //search(locInputSearch.value)
}, false);

locInputSearch.addEventListener("keypress", function(){
    search(locInputSearch.value.trim())
}, false);

locGetFull.addEventListener("click", getFull, false);









