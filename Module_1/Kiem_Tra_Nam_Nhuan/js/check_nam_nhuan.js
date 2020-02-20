function checkNamNhuan() {
    let locResult = document.getElementById("result");
    let year = parseInt(prompt("Nhập 1 năm để kiểm tra xem có phải là năm nhuận hay không: "));
    let check = ((year % 4) === 0),
        check2 = ((year % 100) === 0),
        check3 = ((year % 400) === 0);

    const valueTrue = "Đây đúng là năm nhuận",
          valueFalse = "Đây không phải là năm nhuận";

    if(year != null)
    {
        if(year < 0){
            locResult.innerHTML = "Error !!! year have must be greater than 0, reinput ....";
        }else{
            if(check){
                if(check2){
                    if(check3){
                        locResult.innerHTML = valueTrue;
                    }else{
                        locResult.innerHTML = valueFalse;
                    }
                }else{
                    locResult.innerHTML = valueTrue;
                }
            }else{
                locResult.innerHTML = valueFalse;
            }
        }
    }
}
