window.onload=function(){
    document.getElementsByName("pwd2").onkeyup=checkpwd();

}


function checkpwd() {
    var p1 = document.getElementsByName("pwd1").value;
    var p2 = document.getElementsByName("pwd2").value;
    if(p1 != p2){
        var msg = document.getElementById("msg");
        msg.innerHTML = "These passwords don't match. Try again?";
        msg.hidden = true;
        document.getElementById("submit").disable = true;
        return false;
    }
    document.getElementById("submit").disable = false;
    return true;
}