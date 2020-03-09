function showDecorations() {
    setInterval(startDec, 500);
}

function startDec() {
    var mytext = document.getElementById("myText");
    if (mytext.value != "") {
        var size = window.getComputedStyle(mytext).fontSize;
        size = parseInt(size);
        size += 2;
        mytext.style.fontSize = size + "pt";
    }
}

function showBling() {

    var myText = document.getElementById("myText");
    if (document.getElementById("myCheckbox").checked) {
        myText.style.fontWeight = "bold";
        myText.style.color = "green";
        myText.style.textDecoration = "underline";
        document.body.style.backgroundImage =
            "url('www.cs.washington.edu/education/courses/190m/CurrentQtr/labs/6/hundred-dollar-bill.jpg')";
    }
    else {
        myText.style.fontWeight = "normal";
        myText.style.color = "black";
        myText.style.textDecoration = "none";
        document.body.style.backgroundImage = "none";
    }
}

function malkovitch() {
    let regex = /(\b\w{5,}\b)/;

    var mytext = document.getElementById("myText");
    var res = mytext.value.split(" ");
    for (var i = 0; i < res.length; i++) {
        if (regex.test(res[i])) {
            res[i] = "Malkovich";
        }
    }

    mytext.value = res.join(" ");

}