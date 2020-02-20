let locUsername = document.getElementById("username");
let locPassword = document.getElementById("pass");
let locCheckUsername = document.getElementById("checkUsername");
let locCheckPassword = document.getElementById("checkPassword");
let locButton = document.getElementById("btn");

locUsername.addEventListener("input", checkUsername, false);
locButton.addEventListener("click", checkPassword, false);

function checkUsername() {
    let username = locUsername.value;
    if (username === "Admin") {
        let listHiddenClass = $(".hidden");
        for(let i = 0; i < listHiddenClass.length; ++i){
            $(".hidden")[i].style.visibility = "visible";
        }
    } else if (username === "") {
        locCheckUsername.innerHTML = "canceled";
    } else {
        locCheckUsername.innerHTML = "I don't know you";
    }
}

function checkPassword(){
    let password = locPassword.value;
    if(password === "TheMaster"){
        locCheckPassword.innerHTML = "Welcome";
    }else if(password === ""){
        locCheckPassword.innerHTML = "Canceled";
    }else{
        locCheckPassword.innerHTML = "Wrong Password";
    }
}