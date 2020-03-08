/*------------- Xây dựng Lớp (Class) và khởi tạo Đối tượng (Object) Window Load ----------------------*/

function MyWindow(){
    this.locInputKieuDanh = document.getElementsByName("kieu");
    this.locLo = document.getElementById("lo");
    this.locDe = document.getElementById("de");
    this.locInputCon = document.getElementById("input-con");
    this.locInputTien = document.getElementById("input-tien");
    this.locBaoBtn = document.getElementById("baoBtn");

    this.init = function(){
    };
}

let initWindowObj = new MyWindow();
initWindowObj.init();


/*------------- Xây dựng Lớp (Class) và khởi tạo Đối tượng (Object) Người Đánh Lô ----------------------*/

function Nguoi_Danh_Lo(kieu_danh, danh_con, tien_danh){
    this.kieu_danh = kieu_danh;
    this.danh_con = danh_con;
    this.tien_danh = tien_danh;

    this.radioSelected = function(){
        for(let i = 0; i < initWindowObj.locInputKieuDanh.length; i++){
            if(initWindowObj.locInputKieuDanh[i].checked){
                this.kieu_danh = initWindowObj.locInputKieuDanh[i].value;
                return i;
            }
        }
    };
    this.getDanh_Con = function(){
        return this.danh_con;
    };
    this.setDanh_Con = function(danh_con){
        this.danh_con = danh_con;
    };
    this.getTien_Danh = function(){
        return this.tien_danh;
    };
    this.setTien_Danh = function(tien_danh){
        this.tien_danh = tien_danh;
    };

    this.locBaoBtn = document.getElementById("baoBtn");

    this.bao_chu_lo = function(chu_lo){
        chu_lo.nhan_tu_nguoi_danh(this);
    }
}

let nguoi_danh_lo = new Nguoi_Danh_Lo();
nguoi_danh_lo.locBaoBtn.addEventListener("click", function(){
    if(initWindowObj.locInputCon.value === "" || initWindowObj.locInputTien.value === ""){
        alert("Ban chưa nhập số tiền với con số cần đánh")
    }else {
        nguoi_danh_lo.radioSelected();
        nguoi_danh_lo.setDanh_Con(parseInt(initWindowObj.locInputCon.value));
        nguoi_danh_lo.setTien_Danh(parseInt(initWindowObj.locInputTien.value));
        nguoi_danh_lo.bao_chu_lo(chu_lo);
    }
}, false);

/*------------- Xây dựng Lớp (Class) và khởi tạo Đối tượng (Object) Chủ Lô ----------------------*/

let hdsx = new HDSX();
let chu_lo = new Chu_Lo();

function Chu_Lo(){
    this.locRotate = document.getElementById("rotate");
    this.locKieuDanh = document.getElementById("kieu_danh");
    this.locDanhCon = document.getElementById("con");
    this.locTienDanh = document.getElementById("tien_danh");
    this.locKQ = document.getElementById("loi_phan_hoi");

    this.getDanhCon = function(){
        return this.locDanhCon.textContent;
    };

    this.getRotate = function(){
        return this.locRotate;
    };
    this.slide = function(){
        $("#clip").delay(100).show().animate({opacity: 1, top:"50px"},'slow');
        $('#clip').slideToggle(5000);
    };

    this.nhan_tu_nguoi_danh = function(nguoi_danh){
        this.locKieuDanh.innerHTML = nguoi_danh.kieu_danh;
        if(nguoi_danh.getDanh_Con() < 10){
            this.locDanhCon.innerHTML = "0" + nguoi_danh.getDanh_Con();
        }else{
            this.locDanhCon.innerHTML = nguoi_danh.getDanh_Con();
        }
        this.locTienDanh.innerHTML = this.formatNumber(parseInt(nguoi_danh.getTien_Danh())) + " VND";
    };
    this.gui_hdsx = function(hdsx){
        let result = hdsx.nhan_tu_chu_lo(this);
        return result;
    };

    this.bao_ve_nguoi_danh_lo = function(nguoi_danh_lo){
        if(this.gui_hdsx(hdsx)){
            let result = "";
            if(nguoi_danh_lo.radioSelected() === 0){
                result += "Xin Chúc Mừng Bạn Đã Trúng Lô<br/>" +
                         "Số tiền bạn trúng được là: " + this.formatNumber(nguoi_danh_lo.getTien_Danh() * 4) + " VND";
            }else{
                result += "Xin Chúc Mừng Bạn Đã Trúng ĐỀ<br/>" +
                    "Số tiền bạn trúng được là: " + this.formatNumber(nguoi_danh_lo.getTien_Danh() * 70) + " VND";
            }
            this.locKQ.innerHTML = result;
            $("#loi_phan_hoi").delay(5000).fadeIn(5000);
        }else{
            this.locKQ.innerHTML = "Bạn trượt lô mất rồi";
            $("#loi_phan_hoi").delay(5000).fadeIn(5000);
        }
    };

    this.formatNumber = function(number){
        return number.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
    };
}



chu_lo.getRotate().addEventListener("click", function(){
    if(chu_lo.locTienDanh.textContent){
        chu_lo.slide();
        hdsx.locTableResult.innerHTML = hdsx.createTableResult();
        $("#table-result").delay(5000).fadeIn(5000);
        hdsx.showArray();
        chu_lo.gui_hdsx(hdsx);
        chu_lo.bao_ve_nguoi_danh_lo(nguoi_danh_lo);
    }else{
        alert("Nạp Tiền Trước Rồi Đánh Sau !!!");
    }
}, false);

/*------------- Xây dựng Lớp (Class) và khởi tạo Đối tượng (Object) Hội Đồng Sổ Xố ----------------------*/

function HDSX(){
    this.locTableResult = document.getElementById("table-result");
    this.arrayResult = [];

    this.createTableResult = function(){
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
    };
    this.showArray = function(){
        console.log(this.arrayResult);
    };
    this.getRandomInt = function(min, max){
        min = Math.ceil(min);
        max = Math.floor(max);

        let result = Math.floor(Math.random() * (max - min)) + min;

        return result;
    };
    this.formatResult = function(number){
        if(number >= 0 && number <= 10){
            return ("0" + number).slice(-2);
        }else{
            return number;
        }
    };

    this.nhan_tu_chu_lo = function(chu_lo){
        let so_danh = nguoi_danh_lo.getDanh_Con();

        return this.checkWin(so_danh);
    };

    this.checkWin = function(so_danh){
        for(let i = 0; i < this.arrayResult.length; i++){
            if (parseInt(so_danh) === this.arrayResult[i]){
                return true;
            }
        }
        return false;
    }
}
