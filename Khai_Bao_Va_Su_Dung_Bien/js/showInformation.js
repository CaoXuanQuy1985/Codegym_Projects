function bai_tap_1() {
    let i = 10;
    let f = 20.5;
    let b = true;
    let s = "Ha Noi";

    document.write("i = " + i + "<br/>");
    document.write("f = " + f + "<br/>");
    document.write("b = " + b + "<br/>");
    document.write("s = " + s + "<br/>");
}

//bai_tap_1();

function bai_tap_2(){
    let width = 10;
    let height = 20;

    let area = width * height;
    document.write("area = " + area);
}

//bai_tap_2();

function bai_tap_3() {
    let a_input = prompt("Please input the number a: ", "a = ");
    let a, b;
    if(a_input != null){
        a = a_input;
    }
    let b_input = prompt("Please input the number b: ", "b = ");
    if(b_input != null){
        b = b_input;
    }
    let numA = parseInt(a);
    let numB = parseInt(b);

    if((numA % numB) === 0){
        alert(a + " là bội số của " + b);
    }else{
        alert(a + " không là bội số của " + b);
    }
}
