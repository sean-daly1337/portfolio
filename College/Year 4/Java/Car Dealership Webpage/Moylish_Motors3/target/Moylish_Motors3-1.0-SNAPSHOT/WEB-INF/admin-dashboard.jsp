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
        } else if (userObj.getRoleId() != 1) {
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
    <section class="header-breadcrumb bgimage overlay overlay--dark">
        <div class="bg_image_holder"><img src="img/breadcrumb1.jpg" alt=""></div>
            <%@ include file ="../shared/navbarLoggedIn.jsp" %>
        <!-- ends: .mainmenu-wrapper -->
        <div class="breadcrumb-wrapper content_above">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h1 class="page-title">Admin Dashboard</h1>
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
                                    <a class="nav-link active" id="all-cars" data-toggle="tab" href="#cars" role="tab" aria-controls="Cars" aria-selected="true">All Cars</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="sold-car" data-toggle="tab" href="#sold-cars" role="tab" aria-controls="Cars" aria-selected="true">Sold Cars</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="traded-car" data-toggle="tab" href="#traded-cars" role="tab" aria-controls="Cars" aria-selected="true">Traded Cars</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="user" data-toggle="tab" href="#users" role="tab" aria-controls="user" aria-selected="false">Users</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">My Profile</a>
                                </li>
                            </ul>
                            <div class="nav_button">
                                <a href="logout" class="btn btn-secondary">Log Out</a>
                            </div>
                        </div>
                    </div>
                    <!-- ends: .col-lg-12 -->
                </div>
            </div>
        </div>
        <!-- ends: .dashboard-nav -->
        <div class="tab-content p-top-100" id="dashboard-tabs-content">
            <div class="tab-pane fade show active" id="cars" role="tabpanel" aria-labelledby="all-cars">
                <div class="container">
                    <div class="col-lg-12">
                        <div class="atbd_author_module">
                            <div class="atbd_content_module">
                                <div class="atbd_content_module__tittle_area">
                                    <div class="atbd_area_title">
                                        <h3><span class="la la-car"></span>&nbsp; All Cars</h2>
                                            <a href='<% out.println("add-car.jsp");%>'>
                                                <button class="btn btn-primary">
                                                    Add New Car
                                                </button>
                                            </a>
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
                                        <th>Buy Price</th>
                                        <th>List Price</th>
                                        <th>Sale</th>
                                        <th>Trade</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${AllCars}" var="car">

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
                                            <td>${car.getBuyPrice()}</td>
                                            <td>${car.getListPrice()}</td>
                                            <td>
                                                <span class="color-success" onclick="saleCarModal('${car.getListing()}', '${car.getListPrice()}')">
                                                    <i class="las la-money-bill icon-medium"></i>

                                                </span>
                                            </td>
                                            <td>
                                                <span class="color-warning" onclick="tradeCarModal('${car.getListing()}', '${car.getListPrice()}')">
                                                    <i class="las la-exchange-alt icon-medium"></i>
                                                </span>
                                            </td>
                                            <td>
                                                <a href='<% out.println("car-details.jsp?listing=");%>${car.getListing()}' target="_blank">
                                                    <span class="color-success">
                                                        <i class="la la-eye icon-medium">

                                                        </i>
                                                    </span>
                                                </a>
                                                <a href='<% out.println("update-car.jsp?listing=");%>${car.getListing()}'>
                                                    <span class="color-primary">
                                                        <i class="la la-edit icon-medium"></i>
                                                    </span>
                                                </a>
                                                <span class="color-info" onclick="deleteCarModal(${car.getListing()})">
                                                    <i class="la la-trash icon-medium"></i>
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
            <div class="tab-pane fade" id="sold-cars" role="tabpanel" aria-labelledby="all-cars">
                <div class="container">
                    <div class="col-lg-12">
                        <div class="atbd_author_module">
                            <div class="atbd_content_module">
                                <div class="atbd_content_module__tittle_area">
                                    <div class="atbd_area_title">
                                        <h3><span class="la la-car"></span>&nbsp; Sold Cars</h2>   
                                            <!--                                            <button class="btn btn-primary">
                                                                                            Add New Car
                                                                                        </button>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cars-table">
                            <table id="sold-cars-table" class="display  text-center">
                                <thead>
                                    <tr>
                                        <th>Car</th>
                                        <th>Listing</th>
                                        <th>Reg</th>
                                        <th>Make</th>
                                        <th>Model</th>
                                        <th>Color</th>
                                        <th>Buy Price</th>
                                        <th>List Price</th>
                                        <th>Sold Price</th>
                                        <th>Sold To</th>
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
                                            <td>${car.getBuyPrice()}</td>
                                            <td>${car.getListPrice()}</td>
                                            <td>${car.getSoldPrice()}</td>
                                            <td>
                                                <span class="color-success">
                                                    ${car.getSoldToUsername()}
                                                    <i class="las la-user icon-medium"></i>
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
            <div class="tab-pane fade" id="traded-cars" role="tabpanel" aria-labelledby="all-cars">
                <div class="container">
                    <div class="col-lg-12">
                        <div class="atbd_author_module">
                            <div class="atbd_content_module">
                                <div class="atbd_content_module__tittle_area">
                                    <!--                                    <div class="atbd_area_title">
                                                                            <h3><span class="la la-car"></span>&nbsp; Traded Cars</h2>
                                                                                <button class="btn btn-primary">
                                                                                    Add New Car
                                                                                </button>
                                                                        </div>-->
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
                                        <form action="updateProfile" id="update-profile-form" method="post">
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
                                                            <input class="form-control" name="name" type="text" placeholder="Full name" id="full_name" value="<% out.println(userObj.getName()); %>" required>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="last_name" class="not_empty">Email</label>
                                                            <input class="form-control" name="email" id="email" type="text" placeholder="Email" value="<% out.println(userObj.getEmail()); %>" required>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="phone" class="not_empty">Contact</label>
                                                            <input class="form-control" name="contact" type="number" placeholder="Phone number" id="phone" value="<%out.print(userObj.getPhone()); %>" required>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="address" class="not_empty">Address</label>
                                                            <input class="form-control" name="address" type="text" placeholder="Address" value="<% out.println(userObj.getAddress()); %>" required>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label for="address" class="not_empty">Fax</label>
                                                            <input class="form-control" name="fax" id="address" type="text" placeholder="Fax" value="<% out.println(userObj.getFax());%>" required>
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
            <!-- ends: .tab-pane -->
            <div class="tab-pane fade p-bottom-30" id="users" role="tabpanel" aria-labelledby="user">
                <div class="container">

                    <div class="col-lg-12">
                        <div class="atbd_author_module">
                            <div class="atbd_content_module">
                                <div class="atbd_content_module__tittle_area">
                                    <div class="atbd_area_title">
                                        <h3><span class="la la-car"></span>&nbsp; All Users</h2>
                                            <button class="btn btn-primary" data-toggle="modal" data-target="#add_new_user_modal">Add New User</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cars-table">


                            <table id="usersTable" class="display  text-center">
                                <thead>
                                    <tr>
                                        <th>Img</th>
                                        <th>Username</th>
                                        <th>Name</th>
                                        <th>Role ID</th>
                                        <th>Email</th>
                                        <th>Contact</th>
                                        <th>Address</th>
                                        <th>Fax</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${AllUsers}" var="user">

                                        <tr id="${user.getUsername()}">
                                            <td><img class="car-thumbnail" src="./img/auth1.png" alt=""></td>
                                            <td>${user.getUsername()}</td>
                                            <td>${user.getName()}</td>
                                            <td>${user.getRoleId()}</td>
                                            <td>${user.getEmail()}</td>
                                            <td>${user.getPhone()}</td>
                                            <td>${user.getAddress()}</td>
                                            <td>${user.getFax()}</td>
                                            <td>
                                                <span class="color-primary" onclick="updateUserModal('${user.getUsername()}', '${user.getName()}', '${user.getEmail()}', '${user.getPhone()}', '${user.getAddress()}', '${user.getFax()}')">
                                                    <i class="la la-edit icon-medium"></i>
                                                </span>
                                                <span class="color-warning" onclick="deleteUserModal('${user.getUsername()}')">
                                                    <i class="la la-trash icon-medium"></i>
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
        </div>
        <!-- Modal -->
        <div class="modal fade" id="delete_user_modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-body text-center p-top-40 p-bottom-50">
                        <h1 class="display-3 m-bottom-10">Are you sure?</h1>
                        <p class="m-bottom-30">Do you really want to delete this User?</p>
                        <div class="d-flex justify-content-center">
                            <form action="deleteUser" id="delete-user-form" method="post">
                                <input type="hidden" id="usernameDeleteForm" name="username" class="form-control" placeholder="Username" readonly>
                                <button type="button" class="btn btn-secondary m-right-15" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-danger">Yes, Delete it!</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <div class="modal fade" id="update_user_modal" tabindex="-1" role="dialog" aria-labelledby="update_user_modal" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"><i class="la la-lock"></i> Update User</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="updateUser" id="update-user-form" method="post">
                        <div class="form-group">
                            <input type="text" id="usernameUpdateForm" name="username" class="form-control" placeholder="Username" readonly>
                            <input name="updateProfile" type="hidden" value="0">
                        </div>
                        <div class="form-group">
                            <input type="text" id="nameUpdateForm" name="name" class="form-control" placeholder="Name" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="emailUpdateForm" name="email" class="form-control" placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <input type="number" id="phoneUpdateForm" name="contact" maxlength="9" class="form-control" placeholder="Contact" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="addressUpdateForm" name="address" class="form-control" placeholder="Address" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="faxUpdateForm" name="fax" class="form-control" placeholder="Fax" required>
                        </div>

                        <button type="submit" class="btn btn-block btn-lg btn-gradient btn-gradient-two" id="">Update User</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="add_new_user_modal" tabindex="-1" role="dialog" aria-labelledby="signup_modal_label" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="signup_modal_label"><i class="la la-lock"></i> Add New User</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="signup" id="signup-form" method="post">
                        <div class="form-group">
                            <input  type="text" name="username" class="form-control" placeholder="Username" required>
                        </div> 
                        <div class="form-group">
                            <input type="text" name="name" class="form-control" placeholder="Name" required>
                        </div> 
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" placeholder="Email" required>
                        </div> 
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
                        </div> 
                        <div class="form-group">
                            <input type="password" class="form-control" id="confirm_password" placeholder="Confirm Password" required>
                        </div> 
                        <div>
                            <span id='message'></span>
                        </div>
                        <button type="submit" class="btn btn-block btn-lg btn-gradient btn-gradient-two" id="submitBtn">Sign Up</button>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <!--Delete car modal-->
    <div class="modal fade" id="delete_car_modal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-body text-center p-top-40 p-bottom-50">
                    <h1 class="display-3 m-bottom-10">Are you sure?</h1>
                    <p class="m-bottom-30">Do you really want to delete this Car?</p>
                    <div class="d-flex justify-content-center">
                        <form action="deleteCar" id="delete-car-form" method="post">
                            <input type="hidden" id="deleteCarListingInputField" name="listing" class="form-control" readonly>
                            <button type="button" class="btn btn-secondary m-right-15" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-danger">Yes, Delete it!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- sale car modal-->
    <div class="modal fade" id="sale_car_modal" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"><i class="la la-lock"></i> Sale Car</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="saleCar" id="sale-car-form" method="post">
                        <div class="form-group">
                            <label for="title" class="form-label">Selected Car Listing</label>
                            <input  type="text" name="listing" id="listingNumber" class="form-control" value="" readonly>
                        </div> 
                        <label for="title" class="form-label">Select User</label>
                        <div class="select-basic form-group">
                            <select class="form-control" name="username"  required>
                                <option>Select User</option>
                                <c:forEach items="${users}" var="user">
                                    <option value="${user.getUsername()}">${user.getUsername()} - ${user.getName()} - ${user.getPhone()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="title" class="form-label">Confirm Final Sale Price</label>
                            <input type="number" name="listPrice" id="listingPrice" class="form-control" value="" placeholder="Final Sale Price" required>
                        </div> 
                        <div>
                            <span id='message'></span>
                        </div>
                        <button type="submit" class="btn btn-block btn-lg btn-gradient btn-gradient-two">Sale Car</button>
                    </form>

                </div>
            </div>
        </div>
    </div>



    <!-- trade car modal-->
    <div class="modal fade" id="trade_car_modal" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"><i class="la la-lock"></i> Trade Car</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="tradeCar" id="trade-car-form" method="post">
                        <div class="form-group">
                            <label for="title" class="form-label">Selected Car Listing</label>
                            <input type="number" name="ourCarListing" id="selectedCarListingForTrade" class="form-control" value="" placeholder="Selected Car Listing" readonly>
                        </div> 
                        <div class="form-group">
                            <label for="title" class="form-label">User Car for trade (Trading Cost: Selected Car List Price - This car buy price)  <a href="add-car.jsp">Add User car</a> </label> 
                            <select class="form-control" name="userCar" id="userCarDropdown" required>
                                <option>Select User Car</option>
                                <c:forEach items="${AllCars2}" var="car">
                                    <option value="${car.getListing()},${car.getBuyPrice()}">${car.getListing()} - ${car.getModel()} - ${car.getBuyPrice()}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="userCarListing" id="userCarListingForTrade" class="form-control" value="" placeholder="User Car Listing" required>
                        </div> 
                        <label for="title" class="form-label">Trading Cost (Our Car List Price - User Car Buy Price)</label>
                        <div class="form-group">
                            <input type="number" name="tradingCost" id="tradingCost" class="form-control" value="" placeholder="Trading Cost" required>
                        </div>
                        <div>
                            <span id='message'></span>
                        </div>
                        <button type="submit" class="btn btn-block btn-lg btn-gradient btn-gradient-two" id="trade-car-btn">Trade Car</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
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
    <script src="theme_assets/js/adminDashboard.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
    <script>
    </script>
</html>