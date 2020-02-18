/*------------ Su dung thuoc tinh gan su kien tranh loi phat sinh cho phan tu Dom -------------------*/
function clickBtn() {
    alert("Hướng Dẫn Khi nhúng mã javascript vào thẻ HTML, ta nên đặt the link chua javascript vào phần cuối thân body, bởi vif nếu đặt vào the head dễ phát sinh ra lõi do phần tử DOM chưa được load nên javascript sẽ phát sinh ra lỗi do tác động vào cái chưa có.");
}
var locBtn = document.getElementById("btn");
locBtn.addEventListener("click", clickBtn, false);