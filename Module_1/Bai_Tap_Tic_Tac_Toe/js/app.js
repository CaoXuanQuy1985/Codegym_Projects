let chessTable;
let chessArray;
let locPage;
let player1 = 0, player2 = 0;
let countRed = 0, countGreen = 0;
let arrCorXUser_1 = [], arrCorXUser_2 = [];
let arrCorYUser_1 = [], arrCorYUser_2 = [];

window.onload = init();

function init(){
    locPage = document.getElementById("page");
    chessTable = "";
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
    /*let arrRow = [], arrCol = [];
    for(let i = 0; i < 15; i++){
        arrRow[i] = ".";
        arrCol[i] = ".";
    }
    chessArray.push(arrRow);
    chessArray.push(arrCol);*/

    for(let i = 0; i < 15; i++){
        chessArray[i] = new Array(15);
    }

    for(let i = 0; i < 15; i++){
        for(let j = 0; j < 15; j++){
            chessArray[i][j] = ".";
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




//function checkWin(array2DIM){
    /*bool win(char board[3][3], string &result) {
        for (int i = 0; i < 3; ++ i) {
            if ((board[i][0] != 0) && (board[i][0] == board[i][1])
                && (board[i][1] == board[i][2])) {
                result = board[i][0];
                return true;
            }
            if ((board[0][i] != 0) && (board[0][i] == board[1][i])
                && (board[1][i] == board[2][i])) {
                result = board[0][i];
                return true;
            }
        }
        if ((board[1][1] != 0) && (board[0][0] == board[1][1])
            && (board[1][1] == board[2][2])) {
            result = board[1][1];
            return true;
        }
        if ((board[1][1] != 0) && (board[0][2] == board[1][1])
            && (board[1][1] == board[2][0])) {
            result = board[1][1];
            return true;
        }
        return false;
    }*/
//}

function checkWin(array2Dimension){
    for(let i = 0; i < 5; i++) {
        if ((array2Dimension[i][0] !== 0) && (array2Dimension[i][0] === array2Dimension[i][1]) && (array2Dimension[i][1] === array2Dimension[i][2])) {
            return true;
        }
        if ((array2Dimension[0][i] !== 0) && (array2Dimension[0][i] === array2Dimension[1][i]) && (array2Dimension[1][i] === array2Dimension[2][i])) {
            return true;
        }
    }
        if((array2Dimension[1][1] !== 0) && (array2Dimension[0][0] === array2Dimension[1][1]) && (array2Dimension[1][1] === array2Dimension[2][2])){
            return true;
        }
        if((array2Dimension[1][1] !== 0) && (array2Dimension[0][2] === array2Dimension[1][1]) && (array2Dimension[1][1] === array2Dimension[1][1])){
            return true;
        }
        return false;
}

function clickCell(cell){
     //alert("clicked cell at: (" + cell.parentNode.rowIndex + ", " + cell.cellIndex + ") ");

     //let valueCellClicked = cell.innerHTML;
     //alert(valueCellClicked);
     if(player1 === 1) {
         cell.style.backgroundColor = "green";
         arrCorXUser_1.push(cell.parentNode.rowIndex);
         arrCorYUser_1.push(cell.cellIndex);
         chessArray[cell.parentNode.rowIndex][cell.cellIndex] = "X";
         //alert(cell.parentNode.rowIndex);
     }else{
         cell.style.backgroundColor = "red";
         arrCorXUser_2.push(cell.parentNode.rowIndex);
         arrCorYUser_2.push(cell.cellIndex);
         chessArray[cell.parentNode.rowIndex][cell.cellIndex] = "O";
         //alert(cell.parentNode.rowIndex);
     }

     /*let result = checkWin(chessArray);
     if(result){
         alert("OK");
     }else{
         alert("Not OK");
     }*/

     testCheckWin();

     //alert(arrCorXUser_1);
     //alert(arrCorXUser_2);

     /*--------------- Testing -------------------*/
    /*let ban_co = document.getElementById("ban_co");
    let listRows = ban_co.rows;
    alert(listRows[0][1].style.backgroundColor);
    let listCols = ban_co.cols;
    let checkContinue;*/

    /*for(let i = 0; i < listRows; i++){
        //alert(listRows.style.backgroundColor);
        //alert(listRows[i + 1].style.backgroundColor);
        if(listRows[i].style.backgroundColor === listRows[i + 1].style.backgroundColor){
            checkContinue++;
            if(checkContinue === 3){
                alert("You Win");
            }
        }
    }*/
}

document.getElementById("ban_co").addEventListener("click", clickCell, false);

document.getElementById("user_1").addEventListener("click", switchPlayer1, false);

document.getElementById("user_2").addEventListener("click", switchPlayer2, false);

/*-------------------------------------------------------------------------*/

let n = 5;
/*public class TripleT {

    enum State{Blank, X, O};

int n = 3;
State[][] board = new State[n][n];
int moveCount;

void Move(int x, int y, State s){
    if(board[x][y] == State.Blank){
        board[x][y] = s;
    }
    moveCount++;

    //check end conditions

    //check col
    for(int i = 0; i < n; i++){
        if(board[x][i] != s)
            break;
        if(i == n-1){
            //report win for s
        }
    }

    //check row
    for(int i = 0; i < n; i++){
        if(board[i][y] != s)
            break;
        if(i == n-1){
            //report win for s
        }
    }

    //check diag
    if(x == y){
        //we're on a diagonal
        for(int i = 0; i < n; i++){
            if(board[i][i] != s)
                break;
            if(i == n-1){
                //report win for s
            }
        }
    }

    //check anti diag (thanks rampion)
    if(x + y == n - 1){
        for(int i = 0; i < n; i++){
            if(board[i][(n-1)-i] != s)
                break;
            if(i == n-1){
                //report win for s
            }
        }
    }

    //check draw
    if(moveCount == (Math.pow(n, 2) - 1)){
        //report draw
    }
}
}*/


function testCheckWin(){
    for(let i = 0; i < chessArray.length; i++){
        for(let j = 0; j < chessArray[i].length; j++){
            if((chessArray[i][j] !== ".") && (chessArray[i][j] === chessArray[i][j + 1]) && (chessArray[i][j + 1] === chessArray[i][j + 2])){
                alert("WIN !!!");
            }
            if((chessArray[i][j] !== ".") && (chessArray[i][j] === chessArray[i + 1][j]) && (chessArray[i + 1][j] === chessArray[i + 2][j])){
                alert("WIN !!!");
            }
            if((chessArray[i][j] !== ".") && (chessArray[i][j] === chessArray[i + 1][j + 1]) && (chessArray[i + 1][j + 1] === chessArray[i + 2][j + 2])){
                alert("WIN");
            }
        }
    }
}

