/* ---------------- Constructor Class and Obj InitWindow ------------*/

function InitWindow(){
    this.locContainer = document.getElementById("container");
    this.remoteContainer = document.getElementById("remoteContainer");
    this.tiviContainer = document.getElementById("tiviContainer");
    this.locTivi = document.getElementById("tivi");
    this.locIFrame = document.getElementById("myFrame");
    this.remote = document.getElementById("remote");
}

InitWindow.prototype = {
    constructor : InitWindow,
    init : function(){
        let remoteObj = new Remote();
        remoteObj.drawThemeRemote();
        remoteObj.generateButton();

        return remoteObj;
    }
};

/*--------------------------------------------------------------------*/

/* ------------------- Constructor Class and Object Remote ----------------*/

function Remote(){
    const initThemeRemote = "";
    const Energy = 100;
    this.themeRemote = initThemeRemote;
    this.arrayButtonObj = [];
    this.locTable = null;
    this.locOnOff = null;
    this.on = false;
    this.battery = Energy;
}

Remote.prototype = {
    constructor: Remote,
    drawThemeRemote : function(){
        this.themeRemote += "<table id=\"tableRemote\">";
        for(let i = 0; i < 6; i++){
            this.themeRemote += "<tr>";
            for(let j = 0; j < 3; j++){
                switch (i){
                    case 0:
                        this.themeRemote += "<td><button id=\"" + (j + 1) + "\" class=\"btn\"></button></td>";
                        break;
                    case 1:
                        let count_1 = j + 4;
                        this.themeRemote += "<td><button id=\"" + (count_1) + "\" class=\"btn\"></button></td>";
                        break;
                    case 2:
                        let count_2 = j + 7;
                        this.themeRemote += "<td><button id=\"" + (count_2) + "\" class=\"btn\"></button></td>";
                        break;
                    case 3:
                        if(j !== 1) {
                            this.themeRemote += "<td><button class=\"btn\"></button></td>";
                        }else{
                            this.themeRemote += "<td><button id=\"0\" class=\"btn\"></button></td>";
                        }
                        break;
                    case 4:
                        if(j === 0){
                            this.themeRemote += "<td><button id=\"+\" class=\"btn\"></button></td>";
                        }
                        break;
                    default:
                        if(j === 0){
                            this.themeRemote += "<td><button id=\"-\" class=\"btn\"></button></td>";
                        }
                        break;
                }

            }
            this.themeRemote += "</tr>";
        }
        this.themeRemote += "</table>";

        initWindowObj.remote.innerHTML = this.themeRemote;
        this.locTable = document.getElementById("tableRemote");
        this.locOnOff = document.getElementById("on-off-btn");
    },
    generateButton : function(){
        let count = 1;
        for(let i = 0; i < 6; i++){
            this.arrayButtonObj[i] = [];
            for(let j = 0; j < 3; j++){
                if(count !== 10 && count !== 13 && count !== 12 && count !== 16 && count !== 11) {
                    this.arrayButtonObj[i][j] = new Button(count++);
                }else if(count === 11 || count === 13 || count === 16){
                    switch (count){
                        case 11:
                            count++;
                            this.arrayButtonObj[i][j] = new Button(0);
                            break;
                        case 13:
                            count++;
                            this.arrayButtonObj[i][j] = new Button("+");
                            break;
                        case 16:
                            count++;
                            this.arrayButtonObj[i][j] = new Button("-");
                            break;
                    }
                }else{
                    count++;
                }
            }
        }
    },
    switchChannel : function(event){
        if(this.battery > 0) {
            let targetBtn = event.target;
            let idBtn = targetBtn.id;

            initWindowObj.locIFrame.src= "https://www.youtube.com/embed/" + tvObject.getListChannel()[idBtn - 1] + "?autoplay=1";
            this.battery--;
        }else {
            alert("Remote has no Energy, please charge remote");
        }
    },
    on : function(){
        if(this.battery > 0) {
            this.on = (!this.on);
            this.battery--;
        }else{
            alert("Remote has no Energy, please charge remote");
        }
    },
    chargeBattery : function(){
        this.battery = 100;
    }
};

/*--------------------------------------------------------------*/

/* -------------- Constructor Class and Object Button -------------- */

function Button(value){
    this.value = value;
}

Button.prototype = {
    constructor : Button,
    getValue : function(){
        return this.value;
    }
};

/* ----------------------------------------------------------------- */

/* -------------- Constructor Class and Object Television ------------------- */

function Television(){
    this.listChannel = [
                         "-jHbFC9E0zY",
                         "OBbKpbFxfqU",
                         "J066UDUfUMs",
                         "4_3gg9OsUTg"
                       ]
}

Television.prototype = {
    getListChannel : function(){
        return this.listChannel;
    }
};

let tvObject = new Television();

/* ------------------------------------------------------------------------- */

/* -------------- Flow Execute of Application ----------------- */

let initWindowObj = new InitWindow();
let remoteObj = initWindowObj.init();
window.onload = remoteObj;

remoteObj.locTable.addEventListener("click", function(event){
    remoteObj.switchChannel(event);
}, true);

remoteObj.locOnOff.addEventListener("click", function(event){
    remoteObj.on(event)
}, false);



/* ------------------------------------------------------------ */
