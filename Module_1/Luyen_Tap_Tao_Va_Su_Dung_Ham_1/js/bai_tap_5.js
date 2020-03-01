let locNgoiSao, locChomSao, locResult;
let arrayNgoiSao, arrayChomSao;
let inputUser = null;

window.onload = init();

function init(){
    locNgoiSao = document.getElementById("ngoi_sao");
    locChomSao = document.getElementById("chom_sao");
    locResult = document.getElementById("result");
    createNgoiSao();
    createChomSao();
}

function createNgoiSao(){
    arrayNgoiSao = ["Polaris", "Aldebaran", "Deneb", "Vega", "Altair", "Dubhe", "Regulus"];
    locNgoiSao.innerHTML = arrayNgoiSao;
}

function createChomSao(){
    arrayChomSao = ["Ursa Minor", "Tarurus", "Cygnus", "Lyra", "Aquila", "Ursa Major", "Leo"];
    locChomSao.innerHTML = arrayChomSao;
}

setTimeout(function() {
    inputUser = prompt("Hãy nhập vào tên ngôi sao mà bạn thích:");
    if(inputUser !== null) {
        checkNgoiSao(inputUser);
    }
}, 1000);

function checkNgoiSao(ngoisao){
    let indexNS = arrayNgoiSao.indexOf(ngoisao);
    let referenceCS = arrayChomSao[indexNS];

    if(indexNS !== -1){
        locResult.innerHTML = "Chòm sao tương ứng của ngôi sao: " + ngoisao + " là: " + referenceCS;
    }else{
        locResult.innerHTML = "Ngôi sao mà bạn nhập vào không tồn tai";
    }
}

