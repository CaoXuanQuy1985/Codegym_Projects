$(function(){
    let format = "<table id=\"tb_3\">";
    let white_cell = "<td class=\"white\">";
    let black_cell = "<td class=\"black\">";
    let countNum = 0;
    let countLetter = "A";

    for(let row = 0; row < 10; ++row){
        format += "<tr>";
        for(let col = 0; col < 10; ++col){
            if(row === 0){
                format += "<td class=\"number\">" + countNum++ + "</td>";
                continue;
            }
            if(col === 0){
                if(countNum === 0){
                    format += "<td class=\"letter\"></td>";
                }
                format += "<td class=\"letter\">" + countLetter + "</td>";
                countLetter = String.fromCharCode(countLetter.charCodeAt(0) + 1);
            }

            if((row % 2) === 0){
                if(col === 9){
                    break;
                }
                if(((col % 2) === 0)){
                    format += white_cell + "</td>"
                }else{
                    format += black_cell + "</td>";
                }
            }else{
                if(((col % 2) === 0)){
                    format += black_cell + "</td>"
                }else{
                    format += white_cell + "</td>";
                }
            }
        }
        format += "</tr>";
    }

    format += "</table>";

    $("#page").append(format);
});