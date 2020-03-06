function calcTip() {
	var subtotalElem = document.getElementById("subtotal").value;
	var tipElem = document.getElementById("tip").value;
	var totalElem = document.getElementById('total');
	var subtotal = parseFloat(subtotalElem);
	var tip = parseFloat(tipElem);
    var total =  subtotal + subtotal*tip/100;
    totalElem.innerHTML = '$' + total;
    
}