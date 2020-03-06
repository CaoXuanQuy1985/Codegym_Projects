let Button = function () {
    this.status = false;
    this.turnOn = function () {
        this.status = true;
    };
    this.turnOff = function () {
        this.status = false;
    };
    this.connect = function (flagLam) {
        flagLam.status = this.status;
    }
};
let Flaglam = function () {
    this.status = false;
    this.activate = function () {
        if (this.status) {
            console.log('light');
        } else {
            console.log('notLight');
        }
    }
};
let button = new Button();
let flag = new Flaglam();

function changeStatus() {

    if (button.status ) {
        button.turnOff();
        button.connect(flag);
        flag.activate();
    } else {
        button.turnOn();
        button.connect(flag);
        flag.activate();
    }
}
