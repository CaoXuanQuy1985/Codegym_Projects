function convert() {
    let locAmount = document.getElementById("amount");
    let amount = parseInt(locAmount.value);
    let locSelect_1 = document.getElementById("select_1");
    let locSelect_2 = document.getElementById("select_2");
    let option_1 = locSelect_1.value;
    let option_2 = locSelect_2.value;
    let result;

    if(option_1 === "vn" && option_2 === "usd"){
        result = amount / 23000;
        document.getElementById("result").innerHTML = result + "USD";
    }else if(option_1 === "usd" && option_2 === "vn"){
        result = amount * 23000;
        document.getElementById("result").innerHTML = result + "VND";
    }else{
        document.getElementById("result").innerHTML = amount;
    }
}

document.getElementById("btn").addEventListener("click", convert, false);