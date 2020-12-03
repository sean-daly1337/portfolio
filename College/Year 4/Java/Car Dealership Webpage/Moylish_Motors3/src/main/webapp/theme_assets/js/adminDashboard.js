
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

// disabling buttin at start
disableButton("submitBtn");

document.getElementById("password").onkeyup = function () {
    matchPassword($("#password").val(), $("#confirm_password").val(), "submitBtn");
};

document.getElementById("confirm_password").onkeyup = function () {
    matchPassword($("#password").val(), $("#confirm_password").val(), "submitBtn");
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
    $("#sold-cars-table").DataTable();
    $("#traded-cars-table").DataTable();
    $("#usersTable").DataTable();
});

function updateUserModal(username, name, email, phone, address, fax) {
    $("#usernameUpdateForm").val(username);
    $("#nameUpdateForm").val(name);
    $("#emailUpdateForm").val(email);
    $("#phoneUpdateForm").val(phone);
    $("#addressUpdateForm").val(address);
    $("#faxUpdateForm").val(fax);
    $("#update_user_modal").modal("toggle");
}


$(document).on("submit", "#update-user-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            sessionStorage.setItem("clickTabID", "user");
            showSweetAlertandReload("Great", "The following user has been successfully updated", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
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

function deleteUserModal(username) {
    $("#usernameDeleteForm").val(username);
    $("#delete_user_modal").modal("toggle");
}

$(document).on("submit", "#delete-user-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            $("#delete_user_modal").modal("toggle");
            sessionStorage.setItem("clickTabID", "user");
            showSweetAlertandReload("Done", "The following user has been successfully deleted", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});

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


function deleteCarModal(listing) {
    $("#deleteCarListingInputField").val(listing);
    $("#delete_car_modal").modal("toggle");
}


$(document).on("submit", "#delete-car-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            $("#delete_car_modal").modal("toggle");
            sessionStorage.setItem("clickTabID", "all-cars");
            showSweetAlertandReload("Done", "The following car has been successfully deleted", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});



function saleCarModal(listing, listPrice) {
    $("#listingNumber").val(listing);
    $("#listingPrice").val(listPrice);
    $("#sale_car_modal").modal("toggle");
}


$(document).on("submit", "#sale-car-form", function (event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            $("#sale_car_modal").modal("toggle");
            sessionStorage.setItem("clickTabID", "all-cars");
            showSweetAlertandReload("Done", "The following car has been successfully sold", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});


var price;
var selectedCarListing;
function tradeCarModal(listing, listPrice) {
    $("#selectedCarListingForTrade").val(listing);
    price = listPrice;
    selectedCarListing = listing;
    $("#trade_car_modal").modal("toggle");
}

$("#userCarDropdown").change(function () {
    var car = $(this).children("option:selected").val();
    var arr = car.split(",");
    if(arr[0]==selectedCarListing){
        alert("You can not select the same car, please change the car");
        disableButton("trade-car-btn");
    }
    else{
        enableButton("trade-car-btn");
    }
    $("#userCarListingForTrade").val(arr[0]);
    $("#tradingCost").val(price-arr[1]);
});

$(document).on("submit", "#trade-car-form", function (event) {

    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            $("#trade_car_modal").modal("toggle");
            sessionStorage.setItem("clickTabID", "all-cars");
            showSweetAlertandReload("Done", "The following car has been successfully traded", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});