"use strict";

window.onload = dashboard;
var interval;

/*--
Dashboard() - called when page is loaded
---*/
function dashboard() {
    var start = document.getElementById("start");
    var stop = document.getElementById("stop");
    var size = document.getElementById("size");
    var speed = document.getElementById("speed");
    var animation = document.getElementById("animation");       
    
    start.onclick = startAnimation;
    animation.onchange = setAnimation;
    stop.onclick = stopAnimation;
    
}

/* Starts the animation when animation button pressed */
function startAnimation() {
    document.getElementById("start").disabled = true;
    document.getElementById("stop").disabled = false;
    document.getElementById("animation").disabled = true;
    document.getElementById("animationText").readOnly = true;
    var count = 0;
    var flag = false;
    var frames = document.getElementById("animationText").value.split("=====\n");
    setAnimationSpeed(frames, count, document.getElementById("speed").checked?50:250, flag);
}

/**
 * Sets animation speed and frames
 * @param {1} frames 
 * @param {2} count 
 * @param {3} speed 
 * @param {4} flag 
 */
function setAnimationSpeed(frames, count, speed, flag){
    interval = setInterval(function () {        
        document.getElementById("animationText").value = frames[count];
        if (count === frames.length - 1) {
            count = 0;
        } else {
            count++;
        }
        var size = document.getElementById("size");
        var speed = document.getElementById("speed");
        size.onchange = setSize();
        flag = speed.onclick = setTurboMode();  
        if(flag) {
            flag = false;            
            clearInterval(interval);
            setAnimationSpeed(frames, count, document.getElementById("speed").checked?50:250, flag);
            return;
        }        
        
    }, speed);
}

/**
 * Stop animation
 */
function stopAnimation() {
    clearInterval(interval);
    setAnimation();
    document.getElementById("start").disabled = false;
    document.getElementById("stop").disabled = true;
    document.getElementById("animation").disabled = false;
    document.getElementById("animationText").readOnly = false;
}

/**
 * Set the size of animation field
 */
function setSize() {
    document.getElementById("animationText").style.fontSize = size.options[size.selectedIndex].value + "pt";
}

/**
 * Set turbo mode on
 */
function setTurboMode() {
    return true;
}

/**
 * Set the proper animation variables
 */
function setAnimation() {
    var animationText = document.getElementById("animationText");
    animationText.value = ANIMATIONS[document.getElementById("animation").value];
}