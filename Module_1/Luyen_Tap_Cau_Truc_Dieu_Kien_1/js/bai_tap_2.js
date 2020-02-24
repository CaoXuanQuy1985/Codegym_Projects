let locTuoi, locBtn_2, locResult_2;

window.onload = init();

function init(){
    locTuoi = document.getElementById("tuoi");
    locBtn_2 = document.getElementById("btn_2");
    locResult_2 = document.getElementById("result_2");
}

function check(tuoi){
    if(tuoi < 16){
        locResult_2.textContent = "Học sinh này " + tuoi + " và không đủ tuổi vào lớp 10";
    }else{
        if(tuoi >= 16 && tuoi <= 18) {
            locResult_2.textContent = "Học sinh này " + tuoi + " đã đủ tuổi vào lớp 10";
        }else{
            locResult_2.textContent = "Học sinh này " + tuoi + " đã quá tuổi vào lớp 10";
        }
    }
}

locBtn_2.addEventListener("click", function(){
    check(parseInt(locTuoi.value));
}, false);