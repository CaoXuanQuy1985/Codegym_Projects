/*------------- Xây dựng Lớp (Class) và khởi tạo Đối tượng (Object) Chủ Lô ----------------------*/

function Chu_Lo(){
    this.locRotate = document.getElementById("rotate");
    this.locKieuDanh = document.getElementById("kieu_danh");
    this.locDanhCon = document.getElementById("con");
    this.locTienDanh = document.getElementById("tien_danh");
    this.locKQ = document.getElementById("loi_phan_hoi");
}

Chu_Lo.prototype = {
    constructor : Chu_Lo,

    getDanhCon : function(){
        return this.locDanhCon.textContent;
    },

    getRotate : function(){
        return this.locRotate;
    },

    slide : function(){
        $("#clip").delay(100).show().animate({opacity: 1, top:"50px"},'slow');
        $('#clip').slideToggle(5000);
    },

    nhan_tu_nguoi_danh : function(nguoi_danh){
        this.locKieuDanh.innerHTML = nguoi_danh.kieu_danh;
        if(nguoi_danh.getDanh_Con() < 10){
            this.locDanhCon.innerHTML = "0" + nguoi_danh.getDanh_Con();
        }else{
            this.locDanhCon.innerHTML = nguoi_danh.getDanh_Con();
        }
        this.locTienDanh.innerHTML = this.formatNumber(parseInt(nguoi_danh.getTien_Danh())) + " VND";
    },

    gui_hdsx : function(hdsx, nguoi_danh_lo){
        let result = hdsx.nhan_tu_chu_lo(nguoi_danh_lo);
        return result;
    },

    bao_ve_nguoi_danh_lo : function(hdsx, nguoi_danh_lo){
        if(this.gui_hdsx(hdsx, nguoi_danh_lo)){
            let result = "";
            if(nguoi_danh_lo.radioSelected() === 0){
                result += "Xin Chúc Mừng Bạn Đã Trúng Lô<br/>" +
                              "Số tiền bạn trúng được là: " + this.formatNumber(nguoi_danh_lo.getTien_Danh() * 4) + " VND";
                              this.locKQ.innerHTML = result;

                nguoi_danh_lo.account.money = (nguoi_danh_lo.account.money - nguoi_danh_lo.getTien_Danh()) + (nguoi_danh_lo.getTien_Danh() * 4);

                if(nguoi_danh_lo.account.username === "anonymous.vn1985"){
                    localStorage.setItem("Account_1", JSON.stringify(nguoi_danh_lo.account));
                }else if(nguoi_danh_lo.account.username === "hacker.vn1985"){
                    localStorage.setItem("Account_2", JSON.stringify(nguoi_danh_lo.account));
                }else {
                    localStorage.setItem("Account_3", JSON.stringify(nguoi_danh_lo.account));
                }
                document.getElementById("money").innerHTML = nguoi_danh_lo.account.money;
            }else{
                result += "Xin Chúc Mừng Bạn Đã Trúng ĐỀ<br/>" +
                              "Số tiền bạn trúng được là: " + this.formatNumber(nguoi_danh_lo.getTien_Danh() * 70) + " VND";
                              this.locKQ.innerHTML = result;

                nguoi_danh_lo.account.money = (nguoi_danh_lo.account.money - nguoi_danh_lo.getTien_Danh()) + (nguoi_danh_lo.getTien_Danh() * 70);
                if(nguoi_danh_lo.account.username === "anonymous.vn1985"){
                    localStorage.setItem("Account_1", JSON.stringify(nguoi_danh_lo.account));
                }else if(nguoi_danh_lo.account.username === "hacker.vn1985"){
                    localStorage.setItem("Account_2", JSON.stringify(nguoi_danh_lo.account));
                }else {
                    localStorage.setItem("Account_3", JSON.stringify(nguoi_danh_lo.account));
                }
                document.getElementById("money").innerHTML = nguoi_danh_lo.account.money;
            }
            this.locKQ.innerHTML = result;
            $("#loi_phan_hoi").delay(5000).fadeIn(5000);
        }else{
            this.locKQ.innerHTML = "Bạn trượt lô mất rồi";
            $("#loi_phan_hoi").delay(5000).fadeIn(5000);

            nguoi_danh_lo.account.money = nguoi_danh_lo.account.money - nguoi_danh_lo.getTien_Danh();
            if(nguoi_danh_lo.account.username === "anonymous.vn1985"){
                localStorage.setItem("Account_1", JSON.stringify(nguoi_danh_lo.account));
            }else if(nguoi_danh_lo.account.username === "hacker.vn1985"){
                localStorage.setItem("Account_2", JSON.stringify(nguoi_danh_lo.account));
            }else {
                localStorage.setItem("Account_3", JSON.stringify(nguoi_danh_lo.account));
            }
            document.getElementById("money").innerHTML = nguoi_danh_lo.account.money;
        }
    },

    formatNumber : function(number){
        return number.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
    }
}

/* ------------------------------------------------------------------------------------------------------- */