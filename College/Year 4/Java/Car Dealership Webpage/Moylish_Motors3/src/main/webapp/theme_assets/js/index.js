
const passwordID = "password";
const confirmPasswordID = "confirm_password";
const buttonID = "submitBtn";

// disabling buttin at start
disableButton(buttonID);

document.getElementById(passwordID).onkeyup = function () {
    matchPassword();
};

document.getElementById(confirmPasswordID).onkeyup = function () {
    matchPassword();
};

function matchPassword() {
    if ($("#" + passwordID).val() == $("#" + confirmPasswordID).val() && $("#" + passwordID).val() != "" && $("#" + confirmPasswordID).val() != "") {
        enableButton(buttonID);
    } else {
        disableButton(buttonID);
    }
}

function disableButton(id) {
    $("#" + id).css({
        "pointer-events": "none",
        "opacity": "0.5"
    })
}

function enableButton(id) {
    $("#" + id).css({
        "pointer-events": "auto",
        "opacity": "1"
    });
}

// ajax call for user registration 

$(document).on("submit", "#login-form", function (event) {
    var $form = $(this);
    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            window.location.replace("adminDashboard");
        } else if (response == "3") {
            window.location.replace("userDashboard");
        } else {
            $("#error-msg").css({"visibility": "visible"});
            setTimeout(function () {
                $("#error-msg").css({"visibility": "hidden"});
            }, 2000);
        }
    });

    event.preventDefault();
});

$(document).on("submit", "#signup-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            $("#signup_modal").modal("toggle");
            showSweetAlert("Welcome to Moylish Motors", "User has been successfully registered. Please login and see your dream cars", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred. Why don't you try some other username", "error", "Okay");
        }
    });
    event.preventDefault();
});

$(document).on("submit", "#update-user-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            showSweetAlertandReload("Great", "The following user has been successfully updated", "success", "Perfect", "./../admin-dashboard.jsp");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});

function showSweetAlert(title, text, icon, btnText) {
    Swal.fire({
        title: "<b>" + title + "</b>",
        html: text,
        icon: icon,
        confirmButtonText: btnText
    });
}

function goToIDbyScrolling(id){
     $('html,body').animate({
        scrollTop: $("#"+id).offset().top},
        'slow');
}






