disableButton("submitBtnSalesman");

document.getElementById("salesman_password").onkeyup = function () {
    matchPassword($("#salesman_password").val(), $("#salesman_confirm_password").val(), "submitBtnSalesman");
};

document.getElementById("salesman_confirm_password").onkeyup = function () {
    matchPassword($("#salesman_password").val(), $("#salesman_confirm_password").val(), "submitBtnSalesman");
};

disableButton("submitBtnUser");

document.getElementById("user_password").onkeyup = function () {
    matchPassword($("#user_password").val(), $("#user_confirm_password").val(), "submitBtnUser");
};

document.getElementById("user_confirm_password").onkeyup = function () {
    matchPassword($("#user_password").val(), $("#user_confirm_password").val(), "submitBtnUser");
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


function showSweetAlert(title, text, icon, btnText) {
    Swal.fire({
        title: "<b>" + title + "</b>",
        html: text,
        icon: icon,
        confirmButtonText: btnText
    });
}


$(document).on("submit", "#add_salesman_form", function (event) {
    var $form = $(this);
    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            showSweetAlertandReload("Done", "New salesman has been successfully added to Moylish Motors.", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});

$(document).on("submit", "#add_user_form", function (event) {
    var $form = $(this);
    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "1") {
            showSweetAlertandReload("Done", "New user has been successfully added to Moylish Motors.", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
    });
    event.preventDefault();
});

$(document).ready(function () {
    $('#addNewCar').submit(function (event) {
        event.preventDefault();
        // Calling AJAX
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: new FormData(this),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            success: function (response) {
                if (response == "1") {
                    sessionStorage.setItem("clickTabID", "all-cars");
                    showSweetAlertandGoToPage("Done", "New car has been successfully added to Moylish Motors.", "success", "Perfect", "adminDashboard");
                } else {
                    showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
                }
            },
        });

        return false;
    });

});


function showSweetAlertandGoToPage(title, text, icon, btnText, path) {
    Swal.fire({
        title: "<b>" + title + "</b>",
        html: text,
        icon: icon,
        confirmButtonText: btnText
    }).then(function () {
        window.location.replace(path);
    });
}

//showSweetAlertandGoToPage("Done", "New car has been successfully added to Moylish Motors.", "info", "Perfect", "admin-dashboard.jsp");

document.getElementById("buy-price").onkeyup = function () {
    var buyPrice = $("#buy-price").val();
    buyPrice = parseInt(buyPrice);
    var listPrice = buyPrice * 1.08;
    $("#list-price").val(listPrice);
};


function deleteCarImage(id) {
    $.ajax({
        type: "POST",
        url: "deleteImage",
        data: {imageToDelete: id},
        cache: false,
        success: function (response) {
             if (response == "1") {
            showSweetAlertandReload("Done", "Image has been deleted.", "success", "Perfect");
        } else {
            showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
        }
        }
    });
}


$(document).ready(function () {
    $('#updateCarForm').submit(function (event) {
        event.preventDefault();
        // Calling AJAX
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: new FormData(this),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            success: function (response) {
                if (response == "1") {
                    sessionStorage.setItem("clickTabID", "all-cars");
                    showSweetAlertandGoToPage("Done", "Car has been successfully Updated.", "success", "Perfect", "adminDashboard");
                } else {
                    showSweetAlert("Oops!", "An error occurred.", "error", "Okay");
                }
            },
        });
        return false;
    });

});
