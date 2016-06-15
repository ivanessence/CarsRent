/**
 * Created by Ivan on 05.06.2016.
 */

function valid()
{
    var pass1 = document.forms["registrationForm"]["password"].value;
    var pass2 = document.forms["registrationForm"]["password2"].value;
    if (pass1 != pass2) {
        alert("Passwords do not match.");
        return false;
    }
    var x = document.forms["registrationForm"]["fio"].value;
    if (x == null || x == "") {

        document.getElementById("xxx").innerHTML="Empty field";
        return false;
    }

    var y = document.forms["registrationForm"]["login"].value;
    if (y == null || y == "") {
        document.getElementById("yyy").innerHTML="Empty field";
        return false;
    }

    var w = document.forms["registrationForm"]["password"].value;
    if (w == null || w == "") {
        document.getElementById("www").innerHTML="Empty field";
        return false;
    }

    var z = document.forms["registrationForm"]["passport"].value;
    if (z == null || z == "") {
        document.getElementById("zzz").innerHTML="Empty field";
        return false;
    }

    var q = document.forms["registrationForm"]["password2"].value;
    if (q == null || q == "") {
        document.getElementById("qqq").innerHTML="Empty field";
        return false;
    }
    return  alert("You are successfully registered");
}