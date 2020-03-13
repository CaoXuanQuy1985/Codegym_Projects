/* --------------------- Processing of System ------------------------- */

function main(){
    let xhr = new XMLHttpRequest();
    let arrayAccounts = [];
    let arrayStatusLogin = [false, false, false]; 
   

xhr.onload = function(){
    if(xhr.status === 200){
        responseObject = JSON.parse(xhr.responseText);

        let content = "<table id=\"tableAccounts\">";
             content += "<tr><th>id</th><th>username</th><th>password</th><th>Status LogIn</th></tr>"
        for(let i = 0; i < responseObject.accounts.length; i++){
            arrayAccounts[i] = [];
            for(let j = 0; j < responseObject.accounts.length; j++){
                switch (j) {
                    case 0:
                        arrayAccounts[i][j] = responseObject.accounts[i].userName;
                        break;
                    case 1:
                        arrayAccounts[i][j] = responseObject.accounts[i].passWord;
                        break;
                    default:
                        arrayAccounts[i][j] = arrayStatusLogin[i];
                }
            }
            content += "<tr>" +
                                          "<td>" + (i + 1) + "</td>" + 
                                          "<td>" + responseObject.accounts[i].userName  +  "</td>" +
                                          "<td>" + responseObject.accounts[i].passWord + "</td>" +
                                          "<td>" +  arrayStatusLogin[i] + "</td>" +
                             "</tr>";
        }

        document.getElementById("containerDatabase").innerHTML = content;
    }
};

    xhr.open("GET", "../database/accounts.json", true);
    xhr.send(null);


    let account = new Account();

    let nguoi_danh_lo = new Nguoi_Danh_Lo(); 
    
    document.getElementById("myForm").addEventListener("submit", function(event){
    let logIn = new LogIn(arrayAccounts, arrayStatusLogin);
    logIn.checkAuthenticate(event);
    nguoi_danh_lo.locInputCon.value = "";
    nguoi_danh_lo.locInputTien.value = "";

    for(let i = 0; i < arrayStatusLogin.length; i++){
        if(arrayStatusLogin[i] === true){
        account.setUsername(arrayAccounts[i][0]);
        account.setPassword(arrayAccounts[i][1]);
        nguoi_danh_lo.setAccount(account); 

        //localStorage.clear();
        if(i === 0){
            if(localStorage.getItem("Account_1")){
                    nguoi_danh_lo.account = JSON.parse(localStorage.getItem("Account_1"));
            }else{
                    localStorage.setItem("Account_1", JSON.stringify(nguoi_danh_lo.account));
            }
        }else if(i === 1){
                if(localStorage.getItem("Account_2")){
                   nguoi_danh_lo.account = JSON.parse(localStorage.getItem("Account_2"));
                }else{
                   localStorage.setItem("Account_2", JSON.stringify(nguoi_danh_lo.account));
                }
        }else{
            if(localStorage.getItem("Account_3")){
                   nguoi_danh_lo.account = JSON.parse(localStorage.getItem("Account_3"));
            }else{
                  localStorage.setItem("Account_3", JSON.stringify(nguoi_danh_lo.account));
            }
        }

        document.getElementById("ten").innerHTML = nguoi_danh_lo.account.username;
        document.getElementById("money").innerHTML = nguoi_danh_lo.account.money;
    
        }
    }
    event.preventDefault();
    }, false);

    document.getElementById("logOut").addEventListener("click", function(){
        location.reload();
    }, false);

     nguoi_danh_lo.locBaoBtn.addEventListener("click", function(){
         for(let i = 0; i < arrayStatusLogin.length; i++){
             if(arrayStatusLogin[i] === true){
                document.getElementById("loi_phan_hoi").innerHTML = "";
                document.getElementById("table-result").innerHTML = "";
                
                if(nguoi_danh_lo.locInputCon.value === "" || nguoi_danh_lo.locInputTien.value === ""){
                    alert("Bạn chưa nhập số tiền với con số cần đánh")
                }else {
                    nguoi_danh_lo.radioSelected();
                    nguoi_danh_lo.setDanh_Con(parseInt(nguoi_danh_lo.locInputCon.value));
                    nguoi_danh_lo.setTien_Danh(parseInt(nguoi_danh_lo.locInputTien.value));
                    nguoi_danh_lo.bao_chu_lo(chu_lo);
                }
                return;
            }
        }
        alert("Bạn chưa đăng nhập nên không thể chơi !!!");
        return;
    }, false);

    let chu_lo = new Chu_Lo();
    let hdsx = new HDSX();
    chu_lo.getRotate().addEventListener("click", function(){
        if(chu_lo.locTienDanh.textContent){
            chu_lo.slide();
            hdsx.locTableResult.innerHTML = hdsx.createTableResult();
            $("#table-result").delay(5000).fadeIn(5000);
            hdsx.showArray();
            chu_lo.gui_hdsx(hdsx, nguoi_danh_lo);
            chu_lo.bao_ve_nguoi_danh_lo(hdsx, nguoi_danh_lo);
        }else{
            alert("Nạp Tiền Trước Rồi Đánh Sau !!!");
        }
    }, false);
}

main();

/* ------------------------------------------------------------------------ */