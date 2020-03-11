window.onload = eventHandler;
var accountInfoList = [];

function Account(name, deposit) {
    this.name = name;
    this.deposit = deposit;
}

function eventHandler() {      
    var create = document.getElementById("createNewAccount");
    var myFunc = acc();
    create.onclick = myFunc.createAccount;   
}

var acc = function() {
    var account = "";
    var deposit = "";    
    
    return {
        createAccount: function() { 
            var details = "";               
            this.account = document.getElementById("accountName").value;
            this.deposit = document.getElementById("deposit").value;
            let account = new Account();
            account.name = this.account;
            account.deposit = this.deposit;
            accountInfoList.push(account);                
            for(let i = 0; i < accountInfoList.length; i++) {
                details += "Account name: " + accountInfoList[i].name + " Balance: " + accountInfoList[i].deposit + "\n";
            }  
            
            document.getElementById("details").value = details;             
        }
    };        
};    


