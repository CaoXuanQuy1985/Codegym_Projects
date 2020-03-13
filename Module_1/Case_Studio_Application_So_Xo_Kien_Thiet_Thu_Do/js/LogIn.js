/* ------------------ Constructor Class and Object SignIn --------------------- */

function LogIn(arrayAccounts, arrayStatusLogin){
    this.username = document.getElementById("input-username").value;
    this.password = parseInt(document.getElementById("input-password").value);
    this.arrayAccounts = arrayAccounts;
    this.arrayStatusLogin = arrayStatusLogin;
    this.mark = null;

    this.locBtn = document.getElementById("submitBtn");
    this.locForm = document.getElementById("myForm");

}

LogIn.prototype = {
    constructor : LogIn,
    getMark : function(){
        return this.mark;
    },
    checkAuthenticate : function(event){
        for(let i = 0; i < this.arrayAccounts.length; i++){
            for(let j = 0; j < this.arrayAccounts[i].length - 1; j++){
                let test = this.arrayAccounts[i][j];
                let test2 = this.arrayAccounts[i][j + 1];
                if((this.username === this.arrayAccounts[i][j]) && (this.password === this.arrayAccounts[i][j + 1])){
                      this.arrayStatusLogin[i] = true;
                      alert("Xin chào " + test + " Chào mừng bạn đã đến với bộ môn \"SỔ XỐ KIẾN THIẾT THỦ ĐÔ\"");
                      document.getElementById("myForm").style.visibility = "hidden";
                      return;
                  }
            }
        }
        event.preventDefault();
        alert("Tài Khoản này không tồn tại trong database, hãy nhập tài khoản khác !!!");
    },
}

/* --------------------------------------------------------------------------------- */