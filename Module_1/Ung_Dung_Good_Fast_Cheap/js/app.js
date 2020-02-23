let locGood, locCheap, locFast;
let good = false,
    cheap = false,
    fast = false;

window.onload = init();

function init(){
    locGood = document.getElementById("good");
    locCheap = document.getElementById("cheap");
    locFast = document.getElementById("fast");
}

locGood.addEventListener("click", function() {
    if (!(locGood.checked === true)) {
        good = false;
    } else {
        good = true;
        if (fast && cheap) {
            fast = false;
            locFast.checked = false;
        }
    }
});

locCheap.addEventListener("click", function() {
    if (!(locCheap.checked === true)) {
        cheap = false;
    } else {
        cheap = true;
        if (fast && good) {
            good = false;
            locGood.checked = false;
        }
    }
});

locFast.addEventListener("click", function() {
    if (!(locFast.checked === true)) {
        fast = false;
    } else {
        fast = true;
        if (cheap && good) {
            cheap = false;
            locCheap.checked = false;
        }
    }
});

/*---------------- Testing ------------------*/