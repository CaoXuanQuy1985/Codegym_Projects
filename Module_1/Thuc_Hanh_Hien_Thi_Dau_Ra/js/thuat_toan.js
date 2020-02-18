/*-----------Using function alert()-----------------*/
function usingAlert() {
    alert("Xin Chào Tên Tôi là Cao Xuân Quý");
}
var locBtn = document.getElementById("btnAlert");
locBtn.addEventListener("click", usingAlert, false);

/*-----------Using tag HTML ---------------------*/
function usingHTML() {
    var locHTML = document.getElementById("input_text");
    locHTML.value = "Xin Chào Tên Tôi Là Cao Xuân Quý";
}
var locBtn2 = document.getElementById("btnHTML");
locBtn2.addEventListener("click", usingHTML, false);

/*------------Using document.write()------------------*/
function usingWrite() {
    document.write("Xin Chào Tên Tôi là Cao Xuân Quý");
}
var locBtn3 = document.getElementById("btnWrite");
locBtn3.addEventListener("click", usingWrite, false);

/*--------------Using console.log()------------------*/
function usingConsoleLog() {
    console.log("Xin Chaof Tôi Đang ở trong phần debug console");
}
var btnLog = document.getElementById("btnLog");
btnLog.addEventListener("click", usingConsoleLog, false);

