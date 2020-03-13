/* ------------------------------ Constructor for Class and Object Account ----------------------------- */

function Account(){
    this.username = null;
    this.password = null;
    this.money = 100000000;
}

Account.prototype = {
    constructor : Account,
    getUsername : function(){
        return this.username;
    },
    setUsername : function(username){
        this.username = username;
    },
    getPassword : function(){
        return this.password;
    },
    setPassword : function(password){
        this.password = password;
    }

}

/* ---------------------------------------------------------------------------------------------------------- */