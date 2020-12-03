
if (sessionStorage["clickTabID"]) {
    $("#" + sessionStorage.getItem("clickTabID")).click();
}
function showSweetAlert(title, text, icon, btnText) {
    Swal.fire({
        title: "<b>" + title + "</b>",
        html: text,
        icon: icon,
        confirmButtonText: btnText
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


function removeFavListingModal(listing) {
    $("#removeFavlisting").val(listing);
    $("#remove-from-favourites").modal("toggle");
}

$(document).on("submit", ".addFavForm", function (event) {
    var $form = $(this);
    $.post($form.attr("action"), $form.serialize(), function (response) {
        if (response == "2") {
             $("#remove-from-favourites").modal("toggle");
            sessionStorage.setItem("clickTabID", "favourite-cars");
            showSweetAlertandReload("Great", "Car has been successfully removed from your favourites", "success", "Perfect!");
        } else if (response == "1") {
            showSweetAlert("Great", "Car has been successfully added to your favourites", "success", "Perfect!");
        } else if (response == "0") {
            showSweetAlert("Oops!", "Looks like you haven't signed in. Please login/signup firts", "info", "Okay");
        } else {
            showSweetAlert("Oops!", "An error occurred.You might have already liked this car", "error", "Okay");
        }
    });

    event.preventDefault();
});

function submitFavouriteForm(listNum, addOrRem) {
    $.ajax({
        type: "POST",
        url: "addToFavourites",
        data: {listing: listNum, removeOrAdd: addOrRem},
        cache: false,
        success: function (response) {
             if (response == "2") {
            sessionStorage.setItem("clickTabID", "favourite-cars");
            showSweetAlertandReload("Great", "Car has been successfully removed from your favourites", "success", "Perfect!");
        } else if (response == "1") {
            showSweetAlert("Great", "Car has been successfully added to your favourites", "success", "Perfect!");
        } else if (response == "0") {
            showSweetAlert("Oops!", "Looks like you haven't signed in. Please login/signup firts", "info", "Okay");
        } else {
            showSweetAlert("Oops!", "An error occurred.You might have already liked this car", "error", "Okay");
        }
        }
    });
}

