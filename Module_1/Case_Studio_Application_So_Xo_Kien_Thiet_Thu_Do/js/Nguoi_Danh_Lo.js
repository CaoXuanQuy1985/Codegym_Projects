/*------------- Xây dựng Lớp (Class) và Đối tượng (Object) Người Đánh Lô ----------------------*/

function Nguoi_Danh_Lo(){
    this.account;

    this.locInputKieuDanh = document.getElementsByName("kieu");
    this.locLo = document.getElementById("lo");
    this.locDe = document.getElementById("de");
    this.locInputCon = document.getElementById("input-con");
    this.locInputTien = document.getElementById("input-tien");
    this.locBaoBtn = document.getElementById("baoBtn");
    this.locTen = document.getElementById("ten");
    this.locMoney = document.getElementById("money");
}

Nguoi_Danh_Lo.prototype = {
    constructor : Nguoi_Danh_Lo,

    setAccount : function(account){
        this.account = account;
    },

    radioSelected : function(){
        for(let i = 0; i < this.locInputKieuDanh.length; i++){
            if(this.locInputKieuDanh[i].checked){
                this.kieu_danh = this.locInputKieuDanh[i].value;
                return i;
            }
        }
    },

    getDanh_Con : function(){
        return this.danh_con;
    },

    setDanh_Con : function(danh_con){
        this.danh_con = danh_con;
    },

    getTien_Danh : function(){
        return this.tien_danh;
    },

    setTien_Danh : function(tien_danh){
        this.tien_danh = tien_danh;
    },

    bao_chu_lo : function(chu_lo){
        chu_lo.nhan_tu_nguoi_danh(this);
    },
}

/*--------------------------------------------------------------------------------------------------------*/


