let locYes, locNo;

window.onload = init();

function init(){
    locYes = document.getElementById("yes");
    locNo = document.getElementById("no");
}

locYes.addEventListener("click", function(){
    alert("<3");
}, false);
locNo.addEventListener("mouseover", function(){
    locNo.style.top = (Math.random() * 300) + "px";
    locNo.style.bottom = (Math.random() * 300) + "px";
    locNo.style.left = (Math.random() * 300) + "px";
    locNo.style.right = (Math.random() * 300) + "px";
},false);