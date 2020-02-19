function calculate() {
    let locLength = document.getElementById("length");
    let locWidth = document.getElementById("width");
    let area;
    let locResult = document.getElementById("Result");

    area = parseInt(locLength.value) * parseInt(locWidth.value);

    locResult.innerHTML = "<b>" + area + "</b>";
}