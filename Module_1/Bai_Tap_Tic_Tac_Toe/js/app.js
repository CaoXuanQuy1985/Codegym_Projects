let chessArray;
let locPage;
let player1 = 0, player2 = 0;

window.onload = init();

function init(){
    locPage = document.getElementById("page");
    chessArray = [];
    createChessTable();
}

function switchPlayer1(){
    player1 = 1;
    player2 = 0;
}
function switchPlayer2(){
    player2 = 1;
    player1 = 0;
}

function createChessTable(){
    let chessTable = "";
    for(let i = 0; i < 15; i++){
        chessArray[i] = new Array(15);
    }

    for(let i = 0; i < 15; i++){
        for(let j = 0; j < 15; j++){
            chessArray[i][j] = "";
        }
    }

    chessTable += "<table id='ban_co'>";
    for(let i = 0; i < chessArray.length; i++){
        chessTable += "<tr>";
        for(let j = 0; j < chessArray[i].length; j++){
            chessTable += "<td onclick=\"clickCell(this)\">" + chessArray[i][j] + "</td>";
        }
        chessTable += "</tr>";
    }
    chessTable += "</table>";

    locPage.innerHTML = chessTable;
}

function checkWin(){
    for(let i = 0; i < chessArray.length; i++){
        for(let j = 0; j < chessArray[i].length; j++){
            if((chessArray[i][j] === "X") && (chessArray[i][j] === chessArray[i][j + 1]) && (chessArray[i][j + 1] === chessArray[i][j + 2])){
                setTimeout(function(){
                    alert(" Quân Xanh Thắng !!!");
                    resetArray(chessArray);
                    createChessTable();
                }, 300);
            }
            if((chessArray[i][j] === "X") && (chessArray[i][j] === chessArray[i + 1][j]) && (chessArray[i + 1][j] === chessArray[i + 2][j])){
                setTimeout(function(){
                    alert(" Quân Xanh Thắng !!!");
                    resetArray(chessArray);
                    createChessTable();
                }, 300);
            }
            if((chessArray[i][j] === "X") && (chessArray[i][j] === chessArray[i + 1][j + 1]) && (chessArray[i + 1][j + 1] === chessArray[i + 2][j + 2])){
                setTimeout(function(){
                    alert(" Quân Xanh Thắng !!!");
                    resetArray(chessArray);
                    createChessTable();
                }, 300);
            }
            if((chessArray[i][j] === "O") && (chessArray[i][j] === chessArray[i][j + 1]) && (chessArray[i][j + 1] === chessArray[i][j + 2])){
                setTimeout(function(){
                    alert(" Quân Đỏ Thắng !!!");
                    resetArray(chessArray);
                    createChessTable();
                }, 300);
            }
            if((chessArray[i][j] === "O") && (chessArray[i][j] === chessArray[i + 1][j]) && (chessArray[i + 1][j] === chessArray[i + 2][j])){
                setTimeout(function(){
                    alert(" Quân Đỏ Thắng !!!");
                    resetArray(chessArray);
                    createChessTable();
                }, 300);
            }
            if((chessArray[i][j] === "O") && (chessArray[i][j] === chessArray[i + 1][j + 1]) && (chessArray[i + 1][j + 1] === chessArray[i + 2][j + 2])){
                setTimeout(function(){
                    alert(" Quân Đỏ Thắng !!!");
                    resetArray(chessArray);
                    createChessTable();
                }, 300);
            }
        }
    }
}

function resetArray(array){
    for(let i = 0; i < array.length; i++){
        for(let j = 0; j < array[i].length; j++){
            array[i][j] = "";
        }
    }
}


function clickCell(cell){
    if(player1 === 0 && player2 === 0){
        alert("Hãy click vào button để chọn người choi");
        return;
    }
     if(player1 === 1) {
         cell.style.backgroundColor = "green";
         chessArray[cell.parentNode.rowIndex][cell.cellIndex] = "X";
     }else{
         cell.style.backgroundColor = "red";
         chessArray[cell.parentNode.rowIndex][cell.cellIndex] = "O";
     }
     checkWin();
}

document.getElementById("ban_co").addEventListener("click", clickCell, false);

document.getElementById("user_1").addEventListener("click", switchPlayer1, false);

document.getElementById("user_2").addEventListener("click", switchPlayer2, false);



