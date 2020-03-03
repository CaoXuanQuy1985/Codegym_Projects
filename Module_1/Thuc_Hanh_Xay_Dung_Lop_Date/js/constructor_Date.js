/* ----------- Construcor Date object ----------------*/

function Date(day, month, year){
    this.day = day;
    this.month = month;
    this.year = year;

    this.getDay = function(){
        return this.day;
    };
    this.getMonth = function(){
        return this.month;
    };
    this.getYear = function(){
        return this.year;
    };
    this.setDay = function(day){
        this.day = day;
    };
    this.setMoth = function(month){
        this.month = month;
    };
    this.setYear = function(year){
        this.year = year;
    };
    this.setDate = function(day, month, year){
        this.day = day;
        this.month = month;
        this.year = year;
    };
    this.toString = function(){
        return "Information of Date object is: day = " + this.day + ", month = " + this.month + ", year = " + this.year;
    };
}

let date_1 = new Date("25", "12", "2020"),
    myBirthDay = new Date("21", "01", "1985");

alert("Ngày sinh nhật của tôi là: " + myBirthDay.getDay() + "/ " + myBirthDay.getMonth() + "/ " + myBirthDay.getYear());

alert("Trước khi gọi phương thức setDay() của object date_1, day = " + date_1.getDay());
date_1.setDay("10");
alert("Sau khi gọi phương thức setDay() của object day_1, day = " + date_1.getDay());

/*------------- Su dung method toString() -----------------*/
alert("Sử dụng method toString() để lấy thông tin:");
alert("Sử dụng method toString(): " + myBirthDay.toString());