"use strict";

var gamePiece;

var ypos;
var xpos;
$(function () {
    gamePiece = $("#puzzlearea > div");
    gamePiece.each(function (i) {
        var x = (i % 4) * 100;
        var y = parseInt(i / 4) * 100;
        $(this).addClass("puzzlepiece");
        $(this).css("left", (i % 4) * 100 + "px");
        $(this).css("top", parseInt(i / 4) * 100 + "px");
        $(this).css("background-position", -x + 'px ' + (-y) + 'px');
        xpos = "300px";
        ypos = "300px";

        $(this).click(function () {
            if (canMove(parseInt($(this).html()))) {
                swap($(this).html() - 1);
                return;
            }
        });
        $(this).mouseover(function () {
            if (canMove(parseInt($(this).html()))) {
                $(this).css("border", "3px solid red");
                $(this).css("color", "red");
            } else {
                $(this).css("border", "3px solid black");
            }
        });
        $(this).mouseout(function () {
            $(this).css("border", "5px solid black");
            $(this).css("color", "black");
        });

    });

    $("#shufflebutton").click(shuffle);
});

function shuffle() {
    for (var i = 0; i < 100; i++) {
        var rand = parseInt(Math.random() * 100) % 4; //generates a random number for shuffling each piece
        switch (rand) {
            case 0:
                var temp = move(xpos, ypos, 3);
                if (temp != -1) {
                    swap(temp);
                }
                break;
            case 1:
                var temp = move(xpos, ypos, 4);
                if (temp != -1) {
                    swap(temp);
                }
                break;
            case 2:
                var temp = move(xpos, ypos, 1);
                if (temp != -1) {
                    swap(temp);
                }
                break;
            case 3:
                var temp = move(xpos, ypos, 2);
                if (temp != -1) {
                    swap(temp);
                }
                break;
            default:
                break;
        }
    }
}

function canMove(position) {
    var emptySpace = [move(xpos, ypos, 1), move(xpos, ypos, 2), move(xpos, ypos, 3), move(xpos, ypos, 4)];
    if (emptySpace.includes(position - 1)) {
        return true;
    }
}

function move(x, y, direction) {
    var x = parseInt(x);
    var y = parseInt(y);
    switch (direction) {
        case 1:
            if (x > 0) {
                for (var i = 0; i < gamePiece.length; i++) {
                    if (parseInt(gamePiece[i].style.left) + 100 == x && parseInt(gamePiece[i].style.top) == y) {
                        return i;
                    }
                }
            }
            else {
                return -1;
            }
            break;
        case 2:
            if (x < 300) {
                for (var i = 0; i < gamePiece.length; i++) {
                    if (parseInt(gamePiece[i].style.left) - 100 == x && parseInt(gamePiece[i].style.top) == y) {
                        return i;
                    }
                }
            }
            else {
                return -1;
            }
            break;
        case 3:
            if (y > 0) {
                for (var i = 0; i < gamePiece.length; i++) {
                    if (parseInt(gamePiece[i].style.top) + 100 == y && parseInt(gamePiece[i].style.left) == x) {
                        return i;
                    }
                }
            }
            else {
                return -1;
            }
            break;
        case 4:
            if (y < 300) {
                for (var i = 0; i < gamePiece.length; i++) {
                    if (parseInt(gamePiece[i].style.top) - 100 == y && parseInt(gamePiece[i].style.left) == x) {
                        return i;
                    }
                }
            }
            else {
                return -1;
            }
            break;
        default:
            return -1;
    }
}

function swap(position) {
    var temp = gamePiece[position].style.top;
    gamePiece[position].style.top = ypos;
    ypos = temp;
    temp = gamePiece[position].style.left;
    gamePiece[position].style.left = xpos;
    xpos = temp;
}