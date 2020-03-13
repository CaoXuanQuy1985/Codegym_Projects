/*------------- Xây dựng Lớp (Class) và khởi tạo Đối tượng (Object) Hội Đồng Sổ Xố ----------------------*/

function HDSX(){
    this.locTableResult = document.getElementById("table-result");
    this.arrayResult = [];
}

HDSX.prototype = {
    constructor : HDSX,

    createTableResult : function(){
        this.arrayResult = [];
        let result;
        let table = "<table>";
        for(let i = 0; i < 9; ++i){
            switch (i){
                case 0:
                    table += "<tr id=\"special\"><td>Giải Đặc Biệt</td>";
                    break;
                case 1:
                    table += "<tr><td>Giải Nhất</td>";
                    break;
                case 2:
                    table += "<tr><td>Giải Nhì</td>";
                    break;
                case 3:
                    table += "<tr><td>Giải Ba</td>";
                    break;
                case 4:
                    table += "<tr><td>Giải Tư</td>";
                    break;
                case 5:
                    table += "<tr><td>Giải Năm</td>";
                    break;
                case 6:
                    table += "<tr><td>Giải Sáu</td>";
                    break;
                case 7:
                    table += "<tr><td>Giải Bảy</td>";
                    break;
                default:
                    table += "<tr><td>Giải Tám</td>";
                    break;
            }
            for(let j = 0; j < 4; j++) {
                if(i === 0 && j === 1){
                    result = this.getRandomInt(0, 99);
                    this.arrayResult.push(result);
                    table += "<td colspan=\"4\">" + this.formatResult(result) + "</td>";
                    break;
                }
                if ((i === 0 || i === 1) && j === 0) {
                    result = this.getRandomInt(0, 99);
                    this.arrayResult.push(result);
                    table += "<td colspan=\"4\">" + this.formatResult(result) + "</td>";
                    break;
                } else if (i === 2) {
                    if (j === 0) {
                        result = this.getRandomInt(0, 99);
                        this.arrayResult.push(result);
                        table += "<td colspan=\"2\">" + this.formatResult(result) + "</td>";
                    }
                    if (j === 1) {
                        result = this.getRandomInt(0, 99);
                        this.arrayResult.push(result);
                        table += "<td colspan=\"2\">" + this.formatResult(result) + "</td>";
                        break;
                    }
                } else if (i === 3 || i === 4 || i === 7) {
                    if (j === 1) {
                        result = this.getRandomInt(0, 99);
                        this.arrayResult.push(result);
                        table += "<td>" + this.formatResult(result) + "</td>";
                    }
                    if (j === 2) {
                        result = this.getRandomInt(0, 99);
                        this.arrayResult.push(result);
                        table += "<td colspan=\"2\">" + this.formatResult(result) + "</td>";
                    }
                    if (j === 3) {
                        result = this.getRandomInt(0, 99);
                        this.arrayResult.push(result);
                        table += "<td colspan=\"2\">" + this.formatResult(result) + "</td>";
                        break;
                    }
                }
                else{
                    result = this.getRandomInt(0, 99);
                    this.arrayResult.push(result);
                    table += "<td>" + this.formatResult(result) + "</td>";
                }
            }
            table += "</tr>";
        }
        table += "</table>";

        return table;
    },

    showArray : function(){
        console.log(this.arrayResult);
    },

    getRandomInt : function(min, max){
        min = Math.ceil(min);
        max = Math.floor(max);

        let result = Math.floor(Math.random() * (max - min)) + min;

        return result;
    },

    formatResult : function(number){
        if(number >= 0 && number <= 10){
            return ("0" + number).slice(-2);
        }else{
            return number;
        }
    },

    nhan_tu_chu_lo : function(nguoi_danh_lo){
        let so_danh = nguoi_danh_lo.getDanh_Con();

        return this.checkWin(so_danh);
    },

    checkWin : function(so_danh){
        for(let i = 0; i < this.arrayResult.length; i++){
            if (parseInt(so_danh) === this.arrayResult[i]){
                return true;
            }
        }
        return false;
    }
}

/* -------------------------------------------------------------------------------------------------- */