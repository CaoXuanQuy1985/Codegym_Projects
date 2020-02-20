function check(){
    let locAnswer = document.getElementById("answer");
    let locResult = document.getElementById("result");
    let answer = locAnswer.value;

    let result = ((answer === "ECMAScript") ? "Right" : "Didn’t know? ECMAScript!");
    locResult.value = result;
}

document.getElementById("btn").addEventListener("click", check, false);

