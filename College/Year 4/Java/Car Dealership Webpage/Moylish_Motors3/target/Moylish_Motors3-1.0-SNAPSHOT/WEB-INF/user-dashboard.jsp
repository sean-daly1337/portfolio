<%@page import="Model.User"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <%
        User userObj = (User) session.getAttribute("loggedInUser");
        if (userObj == null) {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "./index.jsp");
        } else if (userObj.getRoleId() != 3) {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "./index.jsp");
        }
    %>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Moylish Motors </title>
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,600,700" rel="stylesheet">
        <!-- inject:css-->
        <link rel="stylesheet" href="vendor_assets/css/bootstrap/bootstrap.css">
        <link rel="stylesheet" href="vendor_assets/css/brands.css">
        <link rel="stylesheet" href="vendor_assets/css/fontawesome.min.css">
        <link rel="stylesheet" href="vendor_assets/css/jquery-ui.css">
        <link rel="stylesheet" href="vendor_assets/css/jquery.mCustomScrollbar.css">
        <link rel="stylesheet" href="vendor_assets/css/line-awesome.min.css">
        <link rel="stylesheet" href="vendor_assets/css/magnific-popup.css">
        <link rel="stylesheet" href="vendor_assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="vendor_assets/css/select2.min.css">
        <link rel="stylesheet" href="vendor_assets/css/slick.css">
        <link rel="stylesheet" href="style.css">
        <!-- endinject -->
        <link rel="icon" type="image/png" sizes="32x32" href="img/fevicon.png">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>
    <%
        String getImageUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + "/Moylish_Motors3/getImage?imagePathID=";
    %>
    <body>
        <section class="header-breadcrumb bgimage overlay overlay--dark">
            <div class="bg_image_holder"><img src="img/breadcrumb1.jpg" alt=""></div>
                <%@ include file ="../shared/navbarLoggedIn.jsp" %>
            <!-- ends: .mainmenu-wrapper -->
            <div class="breadcrumb-wrapper content_above">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h1 class="page-title">Dashboard</h1>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">My Dashboard</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ends: .breadcrumb-wrapper -->
        </section>
        <section class="dashboard-wrapper section-bg p-bottom-70">
            <div class="dashboard-nav">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="dashboard-nav-area">
                                <ul class="nav" id="dashboard-tabs" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="all-sold-cars" data-toggle="tab" href="#soldCars" role="tab" aria-controls="listings" aria-selected="true">My purchased Cars</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="all-traded-cars" data-toggle="tab" href="#tradedCars" role="tab" aria-controls="listings" aria-selected="true">My Traded Cars</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="favourite-cars" data-toggle="tab" href="#favorite" role="tab" aria-controls="favorite" aria-selected="false">Favorite Cars</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">My Profile</a>
                                    </li>
                                </ul>
                                <div class="nav_button">
                                    <a href="" class="btn btn-secondary">Log Out</a>
                                </div>
                            </div>
                        </div>
                        <!-- ends: .col-lg-12 -->
                    </div>
                </div>
            </div>
            <!-- ends: .dashboard-nav -->
            <div class="tab-content p-top-100" id="dashboard-tabs-content">
                <div class="tab-pane fade show active" id="soldCars" role="tabpanel" aria-labelledby="all-sold-cars">
                    <div class="container">
                        <div class="col-lg-12">
                            <div class="atbd_author_module">
                                <div class="atbd_content_module">
                                    <div class="atbd_content_module__tittle_area">
                                        <div class="atbd_area_title">
                                            <h3><span class="la la-car"></span>&nbsp; My Purchased cars</h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cars-table">
                                <table id="myTable" class="display  text-center">
                                    <thead>
                                        <tr>
                                            <th>Car</th>
                                            <th>Listing</th>
                                            <th>Reg</th>
                                            <th>Make</th>
                                            <th>Model</th>
                                            <th>Color</th>
                                            <th>Engine</th>
                                            <th>Buy Price</th>
                                            <th>View</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${soldCars}" var="car">

                                            <tr id="${car.getListing()}">
                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getListing()}' target="_blank">
                                                        <img class="car-thumbnail" src="<%= getImageUrl%>${car.getThumbnailID()}"  alt="Car Img">
                                                    </a>
                                                </td>
                                                <td>${car.getListing()}</td>
                                                <td>${car.getReg()}</td>
                                                <td>${car.getMake()}</td>
                                                <td>${car.getModel()}</td>
                                                <td>${car.getColor()}</td>
                                                <td>${car.getEngine()}</td>
                                                <td>${car.getSoldPrice()}</td>
                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getListing()}' target="_blank">
                                                        <span class="color-success">
                                                            <i class="la la-eye icon-medium">

                                                            </i>
                                                        </span>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tab-pane fade" id="tradedCars" role="tabpanel" aria-labelledby="all-cars">
                    <div class="container">
                        <div class="col-lg-12">
                            <div class="atbd_author_module">
                                <div class="atbd_content_module">
                                    <div class="atbd_content_module__tittle_area">
                                        <div class="atbd_area_title">
                                            <h3><span class="la la-car"></span>&nbsp; Traded Cars</h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cars-table">
                                <table id="traded-cars-table" class="display  text-center">
                                    <thead>
                                        <tr>
                                            <th>Old Car</th>
                                            <th>Listing</th>
                                            <th>Make</th>
                                            <th>View</th>
                                            <th>New Car</th>
                                            <th>Listing</th>
                                            <th>Make</th>
                                            <th>View</th>
                                            <th>Trade Cost</th>
                                            <th>Trade Person</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${tradedCars}" var="car">
                                            <tr>
                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getOldListing()}' target="_blank">
                                                        <img class="car-thumbnail" src="<%= getImageUrl%>${car.getOldThumbnail()}"  alt="Car Img">
                                                    </a>
                                                </td>
                                                <td>${car.getOldListing()}</td>
                                                <td>${car.getOldMake()}</td>
                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getOldListing()}' target="_blank">
                                                        <span class="color-success">
                                                            <i class="la la-eye icon-medium">
                                                            </i>
                                                        </span>
                                                    </a>
                                                </td>

                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getNewListing()}' target="_blank">
                                                        <img class="car-thumbnail" src="<%= getImageUrl%>${car.getNewThumbnail()}"  alt="Car Img">
                                                    </a>
                                                </td>
                                                <td>${car.getNewListing()}</td>
                                                <td>${car.getNewMake()}</td>
                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getNewListing()}' target="_blank">
                                                        <span class="color-success">
                                                            <i class="la la-eye icon-medium">
                                                            </i>
                                                        </span>
                                                    </a>
                                                </td>

                                                <td>$ ${car.getTradedCost()}</td>
                                                <td>
                                                    <span class="color-success">
                                                        ${car.getTradeUsername()}
                                                        <i class="las la-user icon-medium"></i>
                                                    </span>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- ends: .tab-pane -->
                <div class="tab-pane fade p-bottom-30" id="favorite" role="tabpanel" aria-labelledby="favourite-cars">
                    <div class="container">

                        <div class="col-lg-12">
                            <div class="atbd_author_module">
                                <div class="atbd_content_module">
                                    <div class="atbd_content_module__tittle_area">
                                        <div class="atbd_area_title">
                                            <h3><span class="la la-car"></span>&nbsp; My Favourite cars</h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cars-table">
                                <table id="favCarsTable" class="display  text-center">
                                    <thead>
                                        <tr>
                                            <th>Car</th>
                                            <th>Listing</th>
                                            <th>Reg</th>
                                            <th>Make</th>
                                            <th>Model</th>
                                            <th>Color</th>
                                            <th>Price</th>
                                            <th>Remove</th>
                                            <th>View</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${favouriteCars}" var="car">

                                            <tr id="${car.getListing()}">
                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getListing()}' target="_blank">
                                                        <img class="car-thumbnail" src="<%= getImageUrl%>${car.getThumbnailID()}"  alt="Car Img">
                                                    </a>
                                                </td>
                                                <td>${car.getListing()}</td>
                                                <td>${car.getReg()}</td>
                                                <td>${car.getMake()}</td>
                                                <td>${car.getModel()}</td>
                                                <td>${car.getColor()}</td>
                                                <td>${car.getListPrice()}</td>
                                                <td>
                                                    <span class="color-primary" onclick="removeFavListingModal('${car.getListing()}')">
                                                        <i class="las la-times icon-medium"></i>
                                                    </span>
                                                </td>
                                                <td>
                                                    <a href='<% out.println("car-details.jsp?listing=");%>${car.getListing()}' target="_blank">
                                                        <span class="color-success">
                                                            <i class="la la-eye icon-medium">

                                                            </i>
                                                        </span>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ends: .tab-pane -->

                <div class="tab-pane fade p-bottom-30" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-3 col-md-4 mb-5 mb-lg-0">
                                <div class="user_pro_img_area">
                                    <img src="img/author-profile.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-lg-9 col-md-8">
                                <div class="atbd_author_module">
                                    <div class="atbd_content_module">
                                        <div class="atbd_content_module__tittle_area">
                                            <div class="atbd_area_title">
                                                <h4><span class="la la-user"></span>My Profile</h4>
                                            </div>
                                        </div>
                                        <div class="atbdb_content_module_contents">
                                            <form action="updateUser" id="update-profile-form" method="post">
                                                <div class="user_info_wrap">
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="user_name" class="not_empty">Username</label>
                                                                <input class="form-control" name="username" id="user_name" type="text" value="<% out.println(userObj.getUsername()); %>" readonly>
                                                                <input name="updateProfile" type="hidden" value="1">
                                                                <p>(Username can not be changed)</p>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="full_name"  class="not_empty">Name</label>
                                                                <input class="form-control" name="name" type="text" placeholder="Full name" id="full_name" value="<% out.println(userObj.getName()); %>">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="last_name" class="not_empty">Email</label>
                                                                <input class="form-control" name="email" id="email" type="text" placeholder="Email" value="<% out.println(userObj.getEmail()); %>">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="phone" class="not_empty">Contact</label>
                                                                <input class="form-control" name="contact" type="number" placeholder="Phone number" id="phone" value="<% out.println(userObj.getPhone()); %>">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="address" class="not_empty">Address</label>
                                                                <input class="form-control" name="address" type="text" placeholder="Address" value="<% out.println(userObj.getAddress()); %>">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label for="address" class="not_empty">Fax</label>
                                                                <input class="form-control" name="fax" id="address" type="text" placeholder="Fax" value="<% out.println(userObj.getFax());%>">
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <!--ends social info .row-->
                                                    <button type="submit" class="btn btn-primary" id="update_user_profile">Save Changes</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- ends: .atbd_author_module -->
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col-lg-3 col-md-4 mb-5 mb-lg-0">

                            </div>
                            <div class="col-lg-9 col-md-8">
                                <div class="atbd_author_module">
                                    <div class="atbd_content_module">
                                        <div class="atbd_content_module__tittle_area">
                                            <div class="atbd_area_title">
                                                <h4><span class="la la-password"></span>Change Password</h4>
                                            </div>
                                        </div>
                                        <div class="atbdb_content_module_contents">
                                            <div class="user_info_wrap">
                                                <form action="changePassword" id="change-password-form" method="POST">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="form-group">
                                                                <label>Current Password</label>
                                                                <input class="form-control" id="currentPassword" type="password" name="currentPassword" required>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label>New Password</label>
                                                                <input class="form-control" id="changePassword" type="password" name="newPassword" required>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label>Confirm New Password</label>
                                                                <input class="form-control" id="changeConfirmPassword" type="password" required>
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <!--ends social info .row-->
                                                    <button type="submit" class="btn btn-primary" id="changePassBtn">Change Passowrd</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- ends: .atbd_author_module -->
                            </div>
                        </div>
                    </div>
                </div>


            </div>
            <!-- Modal -->
            <div class="modal fade" id="remove-from-favourites" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-body text-center p-top-40 p-bottom-50">
                            <h1 class="display-3 m-bottom-10">Are you sure?</h1>
                            <p class="m-bottom-30">Do you really want to remove this car from favourites?</p>
                            <div class="d-flex justify-content-center">
                                <button type="button" class="btn btn-secondary m-right-15" data-dismiss="modal">Cancel</button>
                                <form action="addToFavourites" class="addFavForm" method="POST">
                                    <input type="hidden" name="removeOrAdd" value="0">
                                    <input type="hidden" name="listing" value="" id="removeFavlisting">
                                    <button type="submit" class="btn btn-danger">Yes, Remove it!</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>



        <%@ include file ="../shared/footer.jsp" %>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0C5etf1GVmL_ldVAichWwFFVcDfa1y_c"></script>
        <!-- inject:js-->
        <script src="vendor_assets/js/jquery/jquery-1.12.3.js"></script>
        <script src="vendor_assets/js/bootstrap/popper.js"></script>
        <script src="vendor_assets/js/bootstrap/bootstrap.min.js"></script>
        <script src="vendor_assets/js/jquery-ui.min.js"></script>
        <script src="vendor_assets/js/jquery.barrating.min.js"></script>
        <script src="vendor_assets/js/jquery.counterup.min.js"></script>
        <script src="vendor_assets/js/jquery.magnific-popup.min.js"></script>
        <script src="vendor_assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="vendor_assets/js/jquery.waypoints.min.js"></script>
        <script src="vendor_assets/js/masonry.pkgd.min.js"></script>
        <script src="vendor_assets/js/owl.carousel.min.js"></script>
        <script src="vendor_assets/js/select2.full.min.js"></script>
        <script src="vendor_assets/js/slick.min.js"></script>
        <script src="theme_assets/js/locator.js"></script>
        <script src="theme_assets/js/main.js"></script>
        <script src="theme_assets/js/map.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script src="theme_assets/js/userDashboard.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
        <script src="theme_assets/js/addToFavourite.js"></script>
        <script>

        </script>

    </body>

</html>