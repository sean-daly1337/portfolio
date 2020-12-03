
if (sessionStorage["clickTabID"]) {
    $("#" + sessionStorage.getItem("clickTabID")).click();
}

// changing password

// disabling buttin at start
disableButton("changePassBtn");

document.getElementById("changePassword").onkeyup = function () {
    matchPassword($("#changePassword").val(), $("#changeConfirmPassword").val(), "changePassBtn");
};

document.getElementById("changeConfirmPassword").onkeyup = function () {
    matchPassword($("#changePassword").val(), $("#changeConfirmPassword").val(), "changePassBtn");
};


function matchPassword(password1, password2, btnID) {
    if (password1 == password2 && password1 != "" && password2 != "") {
        enableButton(btnID);
    } else {
        disableButton(btnID);
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

$(document).ready(function () {
    $('#myTable').DataTable();
    $("#favCarsTable").DataTable();
    $("#traded-cars-table").DataTable();
});


$(document).on("submit", "#update-profile-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            sessionStorage.setItem("clickTabID", "profile-tab");
            showSweetAlertandReload("Great", "Your profile has been successfully updated", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});

function showSweetAlertandReload(title, text, icon, btnText) {
    Swal.fire({
        title: "<b>" + title + "</b>",
        html: text,
        icon: icon,
        confirmButtonText: btnText
    }).then(function () {
        window.location.reload();
    });
}

$(document).on("submit", "#signup-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            $("#add_new_user_modal").modal("toggle");
            sessionStorage.setItem("clickTabID", "user");
            showSweetAlertandReload("User Regis", "User has been successfully registered.", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred. Why don't you try some other username", "error", "Okay");
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


$(document).on("submit", "#change-password-form", function (event) {
    var $form = $(this);
    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            sessionStorage.setItem("clickTabID", "profile-tab");
            $("#currentPassword,#changeConfirmPassword,#changePassword").val("");
            showSweetAlert("Done", "Your password has been successfully updated.", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});
