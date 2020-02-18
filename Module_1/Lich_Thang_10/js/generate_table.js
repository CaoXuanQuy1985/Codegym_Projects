$(function(){
    let day_positive = 1;
    let day_negative = 13;

    /* --------------- Algorithm Creating Table -------------------*/
    let format = "<table>" +
        "            <tr id=\"first\">" +
        "                <td id=\"cn\">C.Nhật</td>" +
        "                <td class='yellow'>T.HAI</td>" +
        "                <td class='yellow'>T.BA</td>" +
        "                <td class='yellow'>T.TƯ</td>" +
        "                <td class='yellow'>T.NĂM</td>" +
        "                <td class='yellow'>T.SÁU</td>" +
        "                <td id=\"tb\">T.BẢY</td>" +
        "            </tr>" +
        "            <tr id=\"second\">" +
        "                <td id=\"sun\">SUN</td>" +
        "                <td >MON</td>" +
        "                <td>TUE</td>" +
        "                <td>WED</td>" +
        "                <td>THU</td>" +
        "                <td>FRI</td>" +
        "                <td id=\"sat\">SAT</td>" +
        "            </tr><tr>";

    let color_red = "<td class=\"red\">", color_blue = "<td class=\"blue\">";
    for(let i = 0; i < 5; ++i) {
        for(let j = 0; j < 7; ++j){
            if((i === 0) && (j <= 3)) {
                format += "<td></td>";
            }else{
                if ((day_positive === 4) || (day_positive === 11) || (day_positive === 18) || (day_positive === 25)){
                    format += color_red;
                }else if((day_positive === 3) || (day_positive === 10) || (day_positive === 17) || (day_positive === 24) || (day_positive === 31)){
                    format += color_blue;
                }else{
                    format += "<td>";
                }
                format += day_positive + "<sub>" + day_negative + "</sub>" + "</td>";
                day_positive++;
                day_negative++;
                if(day_negative === 30){
                    day_negative = 1;
                }
            }
        }
        format += "</tr><tr>";
    }
    format += "</table>";

    $("h1").after(format);

});