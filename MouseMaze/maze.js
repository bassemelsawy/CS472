var wallHit = false;
var start = false;
var end = false;
$(document).ready(function () {
    $("#start").click(start);    
});

var move = function () {
    $(".boundary").addClass("youlose"); 
    $("#status").text("Sorry, you lost! :[");   
    wallHit = true;
};

var end = function () {  
    end = true;  
    if (start ) {        
        if (!wallHit) {
            $("#status").text("You won! :]");
            $(".boundary").removeClass("youlose");
            $(".boundary").off();
            
        } else {
            $("#status").text("Sorry, you lost! :[");
        }
    }
};

var start = function () {
    start = true;
    $("#status").text("Move the mouse without touching the walls!");
    $(".boundary").mouseover(move);
    $("#end").mouseover(end);
    $("#status").text("Move the mouse without touching the walls!");
    wallHit = false;
    $(".boundary").removeClass("youlose");
    
};