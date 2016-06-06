/**
 * Created by Ivan on 05.06.2016.
 */

function validate() {
    var x = document.forms["registrationForm"]["fio"].value;
    if (x == null || x == "") {
        document.getElementById("fio").innerHTML;
        return false;
    }

    var y = document.forms["registrationForm"]["login"].value;
    if (y == null || y == "") {
        document.getElementById("login").innerHTML;
        return false;
    }

    var z = document.forms["registrationForm"]["passport"].value;
    if (z == null || z == "") {
        document.getElementById("passport").innerHTML;
        return false;
    }

    var w = document.forms["registrationForm"]["password"].value;
    if (w == null || w == "") {
        document.getElementById("password").innerHTML;
        return false;
    }
}

function checkPass()
{
    var pass1 = document.forms["registrationForm"]["password"].value;
    var pass2 = document.forms["registrationForm"]["password2"].value;
    if (pass1 != pass2) {
        alert("Passwords do not match.");
        return false;
    }
    return alert("You are successfully registered");

}