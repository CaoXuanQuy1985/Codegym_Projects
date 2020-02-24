let locTable;
let result = "";

window.onload = init();

function init() {
    locTable = document.getElementById("bcc");
}

for(let i = 1; i <= 9; i++){
    result += "<tr>"
    for(let j = 1; j <= 9; j++){
        result += "<td>" + j + " x " + i + " = " + (j * i) + "</td>";
    }
    result += "</tr>";
}

locTable.innerHTML = result;
