function add(operand_1, operand_2){
    return parseInt(operand_1) + parseInt(operand_2);
}
function sub(operand_1, operand_2){
    return parseInt(operand_1) - parseInt(operand_2);
}
function multi(operand_1, operand_2){
    return parseInt(operand_1) * parseInt(operand_2);
}
function div(operand_1, operand_2){
    return parseInt(operand_1) / parseInt(operand_2);
}

var locDropDown = document.getElementById("dropdown");
var typeOperator;

function showResult(operand_1, operand_2){
    typeOperator = locDropDown.value;
    var result;
    if(typeOperator === "+")
        result = add(operand_1, operand_2);
    else if (typeOperator === "-")
        result = sub(operand_1, operand_2);
    else if (typeOperator === "x")
        result = multi(operand_1, operand_2);
    else
        result = div(operand_1, operand_2);

    var locTextarea = document.getElementsByName("area");
    locTextarea[0].value = result;
}

var locInput_1 = document.getElementById("operand_1"),
    locInput_2 = document.getElementById("operand_2");

var locBtn = document.getElementById("btn");
locBtn.addEventListener("click", function() {
    showResult(locInput_1.value, locInput_2.value)
}, false);