let locTable = document.getElementById("table");
let result = "";

for(let i = 1; i <= 10; ++i){
    result += "<tr>";
    for(let j = 1; j <= 10; j++){
        result += "<td>" + (j*i) + "</td>";
    }
    result += "</tr>"
}

locTable.innerHTML = result;